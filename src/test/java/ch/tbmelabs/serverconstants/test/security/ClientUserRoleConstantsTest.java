package ch.tbmelabs.serverconstants.test.security;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import ch.tbmelabs.serverconstants.security.ClientUserRoleConstants;
import ch.tbmelabs.serverconstants.security.ClientUserRoleEnum;

public class ClientUserRoleConstantsTest {
  @Test
  public void eurekaShouldEqualEnumAuthority() {
    assertThat(ClientUserRoleConstants.EUREKA_ENDPOINT)
        .isEqualTo(ClientUserRoleEnum.EUREKA_ENDPOINT.getAuthority());
  }

  @Test
  public void actuatorShouldEqualEnumAuthority() {
    assertThat(ClientUserRoleConstants.ACTUATOR_ENDPOINT)
        .isEqualTo(ClientUserRoleEnum.ACTUATOR_ENDPOINT.getAuthority());
  }
}
