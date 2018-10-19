package ch.tbmelabs.serverconstants.security;

public enum ClientUserRoleEnum {

  EUREKA_ENDPOINT(Long.valueOf(9), "EUREKA", "Eureka-Endpoint-User"),
  ACTUATOR_ENDPOINT(Long.valueOf(10), "ACTUATOR", "Actuator-Endpoint-User");

  Long id;
  String authority;
  String name;

  ClientUserRoleEnum(Long id, String authority, String name) {
    this.id = id;
    this.authority = authority;
    this.name = name;
  }

  public Long getId() {
    return this.id;
  }

  public String getAuthority() {
    return this.authority;
  }

  public String getName() {
    return this.name;
  }
}
