package ch.tbmelabs.serverconstants.test.oauth2;

import static org.assertj.core.api.Assertions.assertThat;

import ch.tbmelabs.serverconstants.oauth2.ClientScopeEnum;
import org.junit.Test;

public class ClientScopeEnumTest {

  private static final String ID_PROPERTY_NAME = "id";
  private static final String NAME_PROPERTY_NAME = "name";

  @Test
  public void clientScopeRead() {
    final Long id = Long.valueOf(1);
    final String name = "read";

    assertThat(ClientScopeEnum.READ).hasFieldOrPropertyWithValue(ID_PROPERTY_NAME, id)
        .hasFieldOrPropertyWithValue(NAME_PROPERTY_NAME, name);

    assertThat(ClientScopeEnum.READ.getId()).isEqualTo(id);
    assertThat(ClientScopeEnum.READ.getName()).isEqualTo(name);
  }

  @Test
  public void clientScopeWrite() {
    final Long id = Long.valueOf(2);
    final String name = "write";

    assertThat(ClientScopeEnum.WRITE).hasFieldOrPropertyWithValue(ID_PROPERTY_NAME, id)
        .hasFieldOrPropertyWithValue(NAME_PROPERTY_NAME, name);

    assertThat(ClientScopeEnum.WRITE.getId()).isEqualTo(id);
    assertThat(ClientScopeEnum.WRITE.getName()).isEqualTo(name);
  }

  @Test
  public void clientScopeTrust() {
    final Long id = Long.valueOf(3);
    final String name = "trust";

    assertThat(ClientScopeEnum.TRUST).hasFieldOrPropertyWithValue(ID_PROPERTY_NAME, id)
        .hasFieldOrPropertyWithValue(NAME_PROPERTY_NAME, name);

    assertThat(ClientScopeEnum.TRUST.getId()).isEqualTo(id);
    assertThat(ClientScopeEnum.TRUST.getName()).isEqualTo(name);
  }
}
