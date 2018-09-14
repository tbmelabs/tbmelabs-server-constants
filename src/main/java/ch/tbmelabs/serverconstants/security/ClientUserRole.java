package ch.tbmelabs.serverconstants.security;

public enum ClientUserRole {

  EUREKA_ENDPOINT(Long.valueOf(9), "EUREKA", "Eureka-Endpoint-User"),
  ACTUATOR_ENDPOINT(Long.valueOf(10), "ACTUATOR", "Actuator-Endpoint-User");

  Long id;
  String constant;
  String name;

  ClientUserRole(Long id, String constant, String name) {
    this.id = id;
    this.constant = constant;
    this.name = name;
  }

  public Long getId() {
    return this.id;
  }

  public String getConstant() {
    return this.constant;
  }

  public String getName() {
    return this.name();
  }
}
