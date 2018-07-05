import Json.GitHubCompany;
import Json.GitHubUserRepo;
import Json.GitHubUser;
import Json.GitHubUserOrg;
import Repositories.GitHubRepository;
import Repositories.GitHubRepositoryImpl;
import Utils.FileUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GitHubThread implements Runnable {

  private final Logger log = LogManager.getLogger(GitHubThread.class);
  private final GitHubRepository gitRepository = new GitHubRepositoryImpl();
  private final Gson gson = new GsonBuilder().create();

  private final ConcurrentLinkedQueue<String> usernames;
  private static final String RESPONSE_NOT_FOUND = "404";

  GitHubThread(final ConcurrentLinkedQueue<String> usernames) {
    this.usernames = usernames;
  }

  public void run() {
    for (String username = usernames.poll(); username != null; username = usernames.poll())  {
      try {
        final String response = gitRepository.findUser(username);
        if (response.equals(RESPONSE_NOT_FOUND)) {
          log.info("User {} not found", username);
          continue;
        }

        final GitHubUser currentUser = gson.fromJson(response, GitHubUser.class);
        FileUtils.writeToFile(userInfoPrint(currentUser) + "\n\n", GitHubParser.RESULT_FILE_NAME);

        log.info("Successfully parsed user {}", currentUser.getLogin());
      } catch (final IOException e) {
        log.error("Got IOException. Need to be processed...", e);
      }
    }
  }

  private String userInfoPrint(final GitHubUser user) throws IOException {
    final StringBuilder userInfo = new StringBuilder();
    userInfo.append(String.format("Nickname: %s\n", user.getLogin()));
    userInfo.append(String.format("Full Name: %s\n", user.getName()));
    userInfo.append(String.format("Company: %s\n", findOrganizations(user)));
    userInfo.append(String.format("Location: %s\n", user.getLocation()));

    final GitHubUserRepo[] userRepos = gson
        .fromJson(gitRepository.loadUserRepos(user.getLogin()), GitHubUserRepo[].class);

    userInfo.append(String.format("Most common language: %s\n", findCommonLanguage(userRepos)));

    final GitHubUserRepo popularRepo = findPopularRepo(userRepos);
    userInfo.append(String.format("Popular repository: %s\n", popularRepo.getName()));
    userInfo.append(String.format("Stars: %s\n", popularRepo.getStargazersCount()));
    userInfo.append(String.format("Language: %s\n", popularRepo.getLanguage()));

    return userInfo.toString();
  }

  private String findCommonLanguage(final GitHubUserRepo[] userRepos) {
    final HashMap<String, Integer> languages = new HashMap<>();

    for (final GitHubUserRepo repos : userRepos) {
      if (languages.containsKey(repos.getLanguage())) {
        languages.put(repos.getLanguage(), languages.get(repos.getLanguage()) + 1);
      } else {
        languages.put(repos.getLanguage(), 1);
      }
    }
    return languages.entrySet().stream().max(
        (l, k) -> l.getValue() > k.getValue() ? 1 : -1)
        .get()
        .getKey();
  }

  private GitHubUserRepo findPopularRepo(final GitHubUserRepo[] userRepos) {
    GitHubUserRepo popularRepo = userRepos[0];
    for (final GitHubUserRepo repo : userRepos) {
      if (repo.getStargazersCount() > popularRepo.getStargazersCount()) {
        popularRepo = repo;
      }
    }
    return popularRepo;
  }

  private String findOrganizations(final GitHubUser user) throws IOException {
    final GitHubUserOrg[] orgs = gson
        .fromJson(gitRepository.loadUserOrgs(user.getLogin()), GitHubUserOrg[].class);
    if (orgs.length == 0) {
      return user.getCompany();
    }

    final StringBuilder userCompanies = new StringBuilder();
    for (int i = 0; i < orgs.length; i++) {
      final GitHubCompany company = gson
          .fromJson(gitRepository.findOrg(orgs[i].getLogin()), GitHubCompany.class);
      userCompanies.append(company.getName());

      if (i != orgs.length - 1) {
        userCompanies.append(", ");
      }
    }

    return userCompanies.toString();
  }
}
