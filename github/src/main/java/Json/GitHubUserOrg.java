package Json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GitHubUserOrg {
  @SerializedName("login")
  @Expose
  private String login;
  @SerializedName("id")
  @Expose
  private Integer id;
  @SerializedName("node_id")
  @Expose
  private String nodeId;
  @SerializedName("url")
  @Expose
  private String url;
  @SerializedName("repos_url")
  @Expose
  private String reposUrl;
  @SerializedName("events_url")
  @Expose
  private String eventsUrl;
  @SerializedName("hooks_url")
  @Expose
  private String hooksUrl;
  @SerializedName("issues_url")
  @Expose
  private String issuesUrl;
  @SerializedName("members_url")
  @Expose
  private String membersUrl;
  @SerializedName("public_members_url")
  @Expose
  private String publicMembersUrl;
  @SerializedName("avatar_url")
  @Expose
  private String avatarUrl;
  @SerializedName("description")
  @Expose
  private String description;

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNodeId() {
    return nodeId;
  }

  public void setNodeId(String nodeId) {
    this.nodeId = nodeId;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getReposUrl() {
    return reposUrl;
  }

  public void setReposUrl(String reposUrl) {
    this.reposUrl = reposUrl;
  }

  public String getEventsUrl() {
    return eventsUrl;
  }

  public void setEventsUrl(String eventsUrl) {
    this.eventsUrl = eventsUrl;
  }

  public String getHooksUrl() {
    return hooksUrl;
  }

  public void setHooksUrl(String hooksUrl) {
    this.hooksUrl = hooksUrl;
  }

  public String getIssuesUrl() {
    return issuesUrl;
  }

  public void setIssuesUrl(String issuesUrl) {
    this.issuesUrl = issuesUrl;
  }

  public String getMembersUrl() {
    return membersUrl;
  }

  public void setMembersUrl(String membersUrl) {
    this.membersUrl = membersUrl;
  }

  public String getPublicMembersUrl() {
    return publicMembersUrl;
  }

  public void setPublicMembersUrl(String publicMembersUrl) {
    this.publicMembersUrl = publicMembersUrl;
  }

  public String getAvatarUrl() {
    return avatarUrl;
  }

  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
