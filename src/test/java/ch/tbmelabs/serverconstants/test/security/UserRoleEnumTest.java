package ch.tbmelabs.serverconstants.test.security;

import static org.assertj.core.api.Assertions.assertThat;

import ch.tbmelabs.serverconstants.security.UserRoleEnum;
import org.junit.Test;

public class UserRoleEnumTest {

  private static final String ID_PROPERTY_NAME = "id";
  private static final String AUTHORITY_PROPERTY_NAME = "authority";
  private static final String NAME_PROPERTY_NAME = "name";

  @Test
  public void userRoleGandalf() {
    final Long id = Long.valueOf(1);
    final String authority = "GANDALF";
    final String name = "Gandalf";

    assertThat(UserRoleEnum.GANDALF).hasFieldOrPropertyWithValue(ID_PROPERTY_NAME, id)
        .hasFieldOrPropertyWithValue(AUTHORITY_PROPERTY_NAME, authority)
        .hasFieldOrPropertyWithValue(NAME_PROPERTY_NAME, name);

    assertThat(UserRoleEnum.GANDALF.getId()).isEqualTo(id);
    assertThat(UserRoleEnum.GANDALF.getAuthority()).isEqualTo(authority);
    assertThat(UserRoleEnum.GANDALF.getName()).isEqualTo(name);
  }

  @Test
  public void userRoleServerAdmin() {
    final Long id = Long.valueOf(2);
    final String authority = "SERVER_ADMIN";
    final String name = "Server-Admin";

    assertThat(UserRoleEnum.SERVER_ADMIN).hasFieldOrPropertyWithValue(ID_PROPERTY_NAME, id)
        .hasFieldOrPropertyWithValue(AUTHORITY_PROPERTY_NAME, authority)
        .hasFieldOrPropertyWithValue(NAME_PROPERTY_NAME, name);

    assertThat(UserRoleEnum.SERVER_ADMIN.getId()).isEqualTo(id);
    assertThat(UserRoleEnum.SERVER_ADMIN.getAuthority()).isEqualTo(authority);
    assertThat(UserRoleEnum.SERVER_ADMIN.getName()).isEqualTo(name);
  }

  @Test
  public void userRoleServerSupport() {
    final Long id = Long.valueOf(3);
    final String authority = "SERVER_SUPPORT";
    final String name = "Server-Support";

    assertThat(UserRoleEnum.SERVER_SUPPORT).hasFieldOrPropertyWithValue(ID_PROPERTY_NAME, id)
        .hasFieldOrPropertyWithValue(AUTHORITY_PROPERTY_NAME, authority)
        .hasFieldOrPropertyWithValue(NAME_PROPERTY_NAME, name);

    assertThat(UserRoleEnum.SERVER_SUPPORT.getId()).isEqualTo(id);
    assertThat(UserRoleEnum.SERVER_SUPPORT.getAuthority()).isEqualTo(authority);
    assertThat(UserRoleEnum.SERVER_SUPPORT.getName()).isEqualTo(name);
  }

  @Test
  public void userRoleContentAdmin() {
    final Long id = Long.valueOf(4);
    final String authority = "CONTENT_ADMIN";
    final String name = "Content-Admin";

    assertThat(UserRoleEnum.CONTENT_ADMIN).hasFieldOrPropertyWithValue(ID_PROPERTY_NAME, id)
        .hasFieldOrPropertyWithValue(AUTHORITY_PROPERTY_NAME, authority)
        .hasFieldOrPropertyWithValue(NAME_PROPERTY_NAME, name);

    assertThat(UserRoleEnum.CONTENT_ADMIN.getId()).isEqualTo(id);
    assertThat(UserRoleEnum.CONTENT_ADMIN.getAuthority()).isEqualTo(authority);
    assertThat(UserRoleEnum.CONTENT_ADMIN.getName()).isEqualTo(name);
  }

  @Test
  public void userRoleContentSupport() {
    final Long id = Long.valueOf(5);
    final String authority = "CONTENT_SUPPORT";
    final String name = "Content-Support";

    assertThat(UserRoleEnum.CONTENT_SUPPORT).hasFieldOrPropertyWithValue(ID_PROPERTY_NAME, id)
        .hasFieldOrPropertyWithValue(AUTHORITY_PROPERTY_NAME, authority)
        .hasFieldOrPropertyWithValue(NAME_PROPERTY_NAME, name);

    assertThat(UserRoleEnum.CONTENT_SUPPORT.getId()).isEqualTo(id);
    assertThat(UserRoleEnum.CONTENT_SUPPORT.getAuthority()).isEqualTo(authority);
    assertThat(UserRoleEnum.CONTENT_SUPPORT.getName()).isEqualTo(name);
  }

  @Test
  public void userRolePremiumUser() {
    final Long id = Long.valueOf(6);
    final String authority = "PREMIUM_USER";
    final String name = "Premium-User";

    assertThat(UserRoleEnum.PREMIUM_USER).hasFieldOrPropertyWithValue(ID_PROPERTY_NAME, id)
        .hasFieldOrPropertyWithValue(AUTHORITY_PROPERTY_NAME, authority)
        .hasFieldOrPropertyWithValue(NAME_PROPERTY_NAME, name);

    assertThat(UserRoleEnum.PREMIUM_USER.getId()).isEqualTo(id);
    assertThat(UserRoleEnum.PREMIUM_USER.getAuthority()).isEqualTo(authority);
    assertThat(UserRoleEnum.PREMIUM_USER.getName()).isEqualTo(name);
  }

  @Test
  public void userRoleUser() {
    final Long id = Long.valueOf(7);
    final String authority = "USER";
    final String name = "User";

    assertThat(UserRoleEnum.USER).hasFieldOrPropertyWithValue(ID_PROPERTY_NAME, id)
        .hasFieldOrPropertyWithValue(AUTHORITY_PROPERTY_NAME, authority)
        .hasFieldOrPropertyWithValue(NAME_PROPERTY_NAME, name);

    assertThat(UserRoleEnum.USER.getId()).isEqualTo(id);
    assertThat(UserRoleEnum.USER.getAuthority()).isEqualTo(authority);
    assertThat(UserRoleEnum.USER.getName()).isEqualTo(name);
  }

  @Test
  public void userRoleGuest() {
    final Long id = Long.valueOf(8);
    final String authority = "GUEST";
    final String name = "Guest";

    assertThat(UserRoleEnum.GUEST).hasFieldOrPropertyWithValue(ID_PROPERTY_NAME, id)
        .hasFieldOrPropertyWithValue(AUTHORITY_PROPERTY_NAME, authority)
        .hasFieldOrPropertyWithValue(NAME_PROPERTY_NAME, name);

    assertThat(UserRoleEnum.GUEST.getId()).isEqualTo(id);
    assertThat(UserRoleEnum.GUEST.getAuthority()).isEqualTo(authority);
    assertThat(UserRoleEnum.GUEST.getName()).isEqualTo(name);
  }


  @Test
  public void userRoleAnonymous() {
    final Long id = null;
    final String authority = "ANONYMOUS";
    final String name = "Anonymous";

    assertThat(UserRoleEnum.ANONYMOUS).hasFieldOrPropertyWithValue(ID_PROPERTY_NAME, id)
        .hasFieldOrPropertyWithValue(AUTHORITY_PROPERTY_NAME, authority)
        .hasFieldOrPropertyWithValue(NAME_PROPERTY_NAME, name);

    assertThat(UserRoleEnum.ANONYMOUS.getId()).isNull();
    assertThat(UserRoleEnum.ANONYMOUS.getAuthority()).isEqualTo(authority);
    assertThat(UserRoleEnum.ANONYMOUS.getName()).isEqualTo(name);
  }
}
