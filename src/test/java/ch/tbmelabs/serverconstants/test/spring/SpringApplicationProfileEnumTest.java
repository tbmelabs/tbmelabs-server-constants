package ch.tbmelabs.serverconstants.test.spring;

import static org.assertj.core.api.Assertions.assertThat;

import ch.tbmelabs.serverconstants.spring.SpringApplicationProfileEnum;
import org.junit.Test;

public class SpringApplicationProfileEnumTest {

  private static final String NAME_PROPERTY_NAME = "name";

  @Test
  public void springApplicationProfileProd() {
    final String name = "prod";

    assertThat(SpringApplicationProfileEnum.PROD).hasFieldOrPropertyWithValue(NAME_PROPERTY_NAME,
        name);

    assertThat(SpringApplicationProfileEnum.PROD.getName()).isEqualTo(name);
  }

  @Test
  public void springApplicationProfileDev() {
    final String name = "dev";

    assertThat(SpringApplicationProfileEnum.DEV).hasFieldOrPropertyWithValue(NAME_PROPERTY_NAME,
        name);

    assertThat(SpringApplicationProfileEnum.DEV.getName()).isEqualTo(name);
  }

  @Test
  public void springApplicationProfileTest() {
    final String name = "test";

    assertThat(SpringApplicationProfileEnum.TEST).hasFieldOrPropertyWithValue(NAME_PROPERTY_NAME,
        name);

    assertThat(SpringApplicationProfileEnum.TEST.getName()).isEqualTo(name);
  }

  @Test
  public void springApplicationProfileNoRedis() {
    final String name = "no-redis";

    assertThat(SpringApplicationProfileEnum.NO_REDIS)
        .hasFieldOrPropertyWithValue(NAME_PROPERTY_NAME, name);

    assertThat(SpringApplicationProfileEnum.NO_REDIS.getName()).isEqualTo(name);
  }

  @Test
  public void springApplicationProfileNoMail() {
    final String name = "no-mail";

    assertThat(SpringApplicationProfileEnum.NO_MAIL).hasFieldOrPropertyWithValue(NAME_PROPERTY_NAME,
        name);

    assertThat(SpringApplicationProfileEnum.NO_MAIL.getName()).isEqualTo(name);
  }
}
