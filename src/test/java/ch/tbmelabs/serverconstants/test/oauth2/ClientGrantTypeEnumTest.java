package ch.tbmelabs.serverconstants.test.oauth2;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import ch.tbmelabs.serverconstants.oauth2.ClientGrantTypeEnum;

public class ClientGrantTypeEnumTest {

  private static final String ID_PROPERTY_NAME = "id";
  private static final String NAME_PROPERTY_NAME = "name";

  @Test
  public void clientGrantTypeAuthorizationCode() {
    final Long id = Long.valueOf(1);
    final String name = "authorization_code";

    assertThat(ClientGrantTypeEnum.AUTHORIZATION_CODE).hasFieldOrPropertyWithValue(ID_PROPERTY_NAME, id)
        .hasFieldOrPropertyWithValue(NAME_PROPERTY_NAME, name);

    assertThat(ClientGrantTypeEnum.AUTHORIZATION_CODE.getId()).isEqualTo(id);
    assertThat(ClientGrantTypeEnum.AUTHORIZATION_CODE.getName()).isEqualTo(name);
  }

  @Test
  public void clientGrantTypeRefreshToken() {
    final Long id = Long.valueOf(2);
    final String name = "refresh_token";

    assertThat(ClientGrantTypeEnum.REFRESH_TOKEN).hasFieldOrPropertyWithValue(ID_PROPERTY_NAME, id)
        .hasFieldOrPropertyWithValue(NAME_PROPERTY_NAME, name);

    assertThat(ClientGrantTypeEnum.REFRESH_TOKEN.getId()).isEqualTo(id);
    assertThat(ClientGrantTypeEnum.REFRESH_TOKEN.getName()).isEqualTo(name);
  }

  @Test
  public void clientGrantTypeImplicit() {
    final Long id = Long.valueOf(3);
    final String name = "implicit";

    assertThat(ClientGrantTypeEnum.IMPLICIT).hasFieldOrPropertyWithValue(ID_PROPERTY_NAME, id)
        .hasFieldOrPropertyWithValue(NAME_PROPERTY_NAME, name);

    assertThat(ClientGrantTypeEnum.IMPLICIT.getId()).isEqualTo(id);
    assertThat(ClientGrantTypeEnum.IMPLICIT.getName()).isEqualTo(name);
  }

  @Test
  public void clientGrantTypePassword() {
    final Long id = Long.valueOf(4);
    final String name = "password";

    assertThat(ClientGrantTypeEnum.PASSWORD).hasFieldOrPropertyWithValue(ID_PROPERTY_NAME, id)
        .hasFieldOrPropertyWithValue(NAME_PROPERTY_NAME, name);

    assertThat(ClientGrantTypeEnum.PASSWORD.getId()).isEqualTo(id);
    assertThat(ClientGrantTypeEnum.PASSWORD.getName()).isEqualTo(name);
  }
}
