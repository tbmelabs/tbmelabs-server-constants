package ch.tbmelabs.serverconstants.test.security;

import static org.assertj.core.api.Assertions.assertThat;

import ch.tbmelabs.serverconstants.security.UserRoleConstants;
import ch.tbmelabs.serverconstants.security.UserRoleEnum;
import org.junit.Test;

public class UserRoleConstantsTest {

  @Test
  public void gandalfShouldEqualEnumAuthority() {
    assertThat(UserRoleConstants.GANDALF).isEqualTo(UserRoleEnum.GANDALF.getAuthority());
  }

  @Test
  public void serverAdminShouldEqualEnumAuthority() {
    assertThat(UserRoleConstants.SERVER_ADMIN).isEqualTo(UserRoleEnum.SERVER_ADMIN.getAuthority());
  }

  @Test
  public void serverSupportShouldEqualEnumAuthority() {
    assertThat(UserRoleConstants.SERVER_SUPPORT)
        .isEqualTo(UserRoleEnum.SERVER_SUPPORT.getAuthority());
  }

  @Test
  public void contentAdminShouldEqualEnumAuthority() {
    assertThat(UserRoleConstants.CONTENT_ADMIN)
        .isEqualTo(UserRoleEnum.CONTENT_ADMIN.getAuthority());
  }

  @Test
  public void contentSupportShouldEqualEnumAuthority() {
    assertThat(UserRoleConstants.CONTENT_SUPPORT)
        .isEqualTo(UserRoleEnum.CONTENT_SUPPORT.getAuthority());
  }

  @Test
  public void premiumUserShouldEqualEnumAuthority() {
    assertThat(UserRoleConstants.PREMIUM_USER).isEqualTo(UserRoleEnum.PREMIUM_USER.getAuthority());
  }

  @Test
  public void userShouldEqualEnumAuthority() {
    assertThat(UserRoleConstants.USER).isEqualTo(UserRoleEnum.USER.getAuthority());
  }

  @Test
  public void guestShouldEqualEnumAuthority() {
    assertThat(UserRoleConstants.GUEST).isEqualTo(UserRoleEnum.GUEST.getAuthority());
  }

  @Test
  public void anonymousShouldEqualEnumAuthority() {
    assertThat(UserRoleConstants.ANONYMOUS).isEqualTo(UserRoleEnum.ANONYMOUS.getAuthority());
  }
}
