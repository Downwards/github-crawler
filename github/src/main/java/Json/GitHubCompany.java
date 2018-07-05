package Json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GitHubCompany {
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
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("company")
  @Expose
  private Object company;
  @SerializedName("blog")
  @Expose
  private String blog;
  @SerializedName("location")
  @Expose
  private String location;
  @SerializedName("email")
  @Expose
  private String email;
  @SerializedName("has_organization_projects")
  @Expose
  private Boolean hasOrganizationProjects;
  @SerializedName("has_repository_projects")
  @Expose
  private Boolean hasRepositoryProjects;
  @SerializedName("public_repos")
  @Expose
  private Integer publicRepos;
  @SerializedName("public_gists")
  @Expose
  private Integer publicGists;
  @SerializedName("followers")
  @Expose
  private Integer followers;
  @SerializedName("following")
  @Expose
  private Integer following;
  @SerializedName("html_url")
  @Expose
  private String htmlUrl;
  @SerializedName("created_at")
  @Expose
  private String createdAt;
  @SerializedName("updated_at")
  @Expose
  private String updatedAt;
  @SerializedName("type")
  @Expose
  private String type;

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Object getCompany() {
    return company;
  }

  public void setCompany(Object company) {
    this.company = company;
  }

  public String getBlog() {
    return blog;
  }

  public void setBlog(String blog) {
    this.blog = blog;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Boolean getHasOrganizationProjects() {
    return hasOrganizationProjects;
  }

  public void setHasOrganizationProjects(Boolean hasOrganizationProjects) {
    this.hasOrganizationProjects = hasOrganizationProjects;
  }

  public Boolean getHasRepositoryProjects() {
    return hasRepositoryProjects;
  }

  public void setHasRepositoryProjects(Boolean hasRepositoryProjects) {
    this.hasRepositoryProjects = hasRepositoryProjects;
  }

  public Integer getPublicRepos() {
    return publicRepos;
  }

  public void setPublicRepos(Integer publicRepos) {
    this.publicRepos = publicRepos;
  }

  public Integer getPublicGists() {
    return publicGists;
  }

  public void setPublicGists(Integer publicGists) {
    this.publicGists = publicGists;
  }

  public Integer getFollowers() {
    return followers;
  }

  public void setFollowers(Integer followers) {
    this.followers = followers;
  }

  public Integer getFollowing() {
    return following;
  }

  public void setFollowing(Integer following) {
    this.following = following;
  }

  public String getHtmlUrl() {
    return htmlUrl;
  }

  public void setHtmlUrl(String htmlUrl) {
    this.htmlUrl = htmlUrl;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
