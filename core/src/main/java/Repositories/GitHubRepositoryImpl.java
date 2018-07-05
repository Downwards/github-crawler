package Repositories;

import Utils.HTTPUtils;

import java.io.IOException;
import java.net.URL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GitHubRepositoryImpl implements GitHubRepository {

  private static final String JSON_USER = "https://api.github.com/users/";
  private static final String JSON_USER_REPOS = "https://api.github.com/users/%s/repos";
  private static final String JSON_USER_ORGS = "https://api.github.com/users/%s/orgs";
  private static final String JSON_ORG = "https://api.github.com/orgs/%s";
  private static final int REQUEST_TIMEOUT = 5000;

  private final Logger log = LogManager.getLogger(GitHubRepository.class);

  public String findUser(final String username) throws IOException {
    log.info("Looking for user - {}.", username);
    return HTTPUtils.getRequest(new URL(JSON_USER + username), REQUEST_TIMEOUT);
  }

  public String loadUserRepos(final String username) throws IOException {
    log.info("Looking for user  {} repositories.", username);
    return HTTPUtils.getRequest(new URL(String.format(JSON_USER_REPOS, username)), REQUEST_TIMEOUT);
  }

  public String loadUserOrgs(final String username) throws IOException {
    log.info("Looking for user  {} organizations.", username);
    return HTTPUtils.getRequest(new URL(String.format(JSON_USER_ORGS, username)), REQUEST_TIMEOUT);
  }

  public String findOrg(final String organization) throws IOException {
    log.info("Looking for organization - {} .", organization);
    return HTTPUtils.getRequest(new URL(String.format(JSON_ORG, organization)), REQUEST_TIMEOUT);
  }
}
