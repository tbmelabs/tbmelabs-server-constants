package ch.tbmelabs.serverconstants.oauth2;

public enum ClientScope {

  READ(Long.valueOf(1), "read"),
  WRITE(Long.valueOf(2), "write"),
  TRUST(Long.valueOf(3), "trust");

  Long id;
  String name;

  ClientScope(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name();
  }
}
