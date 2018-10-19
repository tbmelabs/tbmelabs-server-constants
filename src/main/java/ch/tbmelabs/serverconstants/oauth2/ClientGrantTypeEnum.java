package ch.tbmelabs.serverconstants.oauth2;

public enum ClientGrantTypeEnum {

  AUTHORIZATION_CODE(Long.valueOf(1), "authorization_code"),
  REFRESH_TOKEN(Long.valueOf(2), "refresh_token"),
  IMPLICIT(Long.valueOf(3), "implicit"),
  PASSWORD(Long.valueOf(4), "password");

  Long id;
  String name;

  ClientGrantTypeEnum(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }
}
