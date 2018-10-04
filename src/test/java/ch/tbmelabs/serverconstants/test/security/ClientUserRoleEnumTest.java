package ch.tbmelabs.serverconstants.test.security;

import static org.assertj.core.api.Assertions.assertThat;

import ch.tbmelabs.serverconstants.security.ClientUserRoleEnum;
import org.junit.jupiter.api.Test;

public class ClientUserRoleEnumTest {

  private static final String ID_PROPERTY_NAME = "id";
  private static final String AUTHORITY_PROPERTY_NAME = "authority";
  private static final String NAME_PROPERTY_NAME = "name";

  @Test
  public void clientUserRoleEurekaEndpoint() {
    final Long id = Long.valueOf(9);
    final String authority = "EUREKA";
    final String name = "Eureka-Endpoint-User";

    assertThat(ClientUserRoleEnum.EUREKA_ENDPOINT).hasFieldOrPropertyWithValue(ID_PROPERTY_NAME, id)
        .hasFieldOrPropertyWithValue(AUTHORITY_PROPERTY_NAME, authority)
        .hasFieldOrPropertyWithValue(NAME_PROPERTY_NAME, name);

    assertThat(ClientUserRoleEnum.EUREKA_ENDPOINT.getId()).isEqualTo(id);
    assertThat(ClientUserRoleEnum.EUREKA_ENDPOINT.getAuthority()).isEqualTo(authority);
    assertThat(ClientUserRoleEnum.EUREKA_ENDPOINT.getName()).isEqualTo(name);
  }

  @Test
  public void clientUserRoleActuatorEndpoint() {
    final Long id = Long.valueOf(10);
    final String authority = "ACTUATOR";
    final String name = "Actuator-Endpoint-User";

    assertThat(ClientUserRoleEnum.ACTUATOR_ENDPOINT)
        .hasFieldOrPropertyWithValue(ID_PROPERTY_NAME, id)
        .hasFieldOrPropertyWithValue(AUTHORITY_PROPERTY_NAME, authority)
        .hasFieldOrPropertyWithValue(NAME_PROPERTY_NAME, name);

    assertThat(ClientUserRoleEnum.ACTUATOR_ENDPOINT.getId()).isEqualTo(id);
    assertThat(ClientUserRoleEnum.ACTUATOR_ENDPOINT.getAuthority()).isEqualTo(authority);
    assertThat(ClientUserRoleEnum.ACTUATOR_ENDPOINT.getName()).isEqualTo(name);
  }
}
