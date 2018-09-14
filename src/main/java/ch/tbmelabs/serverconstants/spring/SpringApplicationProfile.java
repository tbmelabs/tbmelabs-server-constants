package ch.tbmelabs.serverconstants.spring;

public enum SpringApplicationProfile {

  /**
   * Productive systems.
   */
  PROD("prod"),

  /**
   * Development profile with debug logs.
   */
  DEV("dev"),

  /**
   * Used while (maven) testing is active.
   */
  TEST("test"),

  /**
   * Activates logging via Logstash and ELK stack.
   */
  ELK("elk"),

  /**
   * Disables caching via REDIS-Server.
   */
  NO_REDIS("no-redis"),

  /**
   * Disables Spring Mail configuration. For development use only.
   */
  NO_MAIL("no-mail");

  String name;

  SpringApplicationProfile(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }
}
