package Repositories;

import java.io.IOException;

/*
  Использование github API
 */
public interface GitHubRepository {

  String findUser(String username) throws IOException;

  String loadUserRepos(String username) throws IOException;

  String loadUserOrgs(final String username) throws IOException;

  String findOrg(final String organization) throws IOException;
}
