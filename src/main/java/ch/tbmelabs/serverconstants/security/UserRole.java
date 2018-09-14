package ch.tbmelabs.serverconstants.security;

public enum UserRole {

  GANDALF(Long.valueOf(1), "GANDALF", "Gandalf"),
  SERVER_ADMIN(Long.valueOf(2), "SERVER_ADMIN", "Server-Admin"),
  SERVER_SUPPORT(Long.valueOf(3), "SERVER_SUPPORT", "Server-Support"),
  CONTENT_ADMIN(Long.valueOf(4), "CONTENT_ADMIN", "Content-Admin"),
  CONTENT_SUPPORT(Long.valueOf(5), "CONTENT_SUPPORT", "Content-Admin"),
  PREMIUM_USER(Long.valueOf(6), "PREMIUM_USER", "Premium-User"),
  USER(Long.valueOf(7), "USER", "User"),
  GUEST(Long.valueOf(8), "GUEST", "Guest"),
  ANONYMOUS(null, "ANONYMOUS", "Anonymous");

  Long id;
  String constant;
  String name;

  UserRole(Long id, String constant, String name) {
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
