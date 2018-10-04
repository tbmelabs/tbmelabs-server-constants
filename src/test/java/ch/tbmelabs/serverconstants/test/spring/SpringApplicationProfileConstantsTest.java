package ch.tbmelabs.serverconstants.test.spring;

import static org.assertj.core.api.Assertions.assertThat;

import ch.tbmelabs.serverconstants.spring.SpringApplicationProfileConstants;
import ch.tbmelabs.serverconstants.spring.SpringApplicationProfileEnum;
import org.junit.jupiter.api.Test;

public class SpringApplicationProfileConstantsTest {

  @Test
  public void prodShouldEqualEnumName() {
    assertThat(SpringApplicationProfileConstants.PROD)
        .isEqualTo(SpringApplicationProfileEnum.PROD.getName());
  }

  @Test
  public void devShouldEqualEnumName() {
    assertThat(SpringApplicationProfileConstants.DEV)
        .isEqualTo(SpringApplicationProfileEnum.DEV.getName());
  }

  @Test
  public void testShouldEqualEnumName() {
    assertThat(SpringApplicationProfileConstants.TEST)
        .isEqualTo(SpringApplicationProfileEnum.TEST.getName());
  }

  @Test
  public void noRedisShouldEqualEnumName() {
    assertThat(SpringApplicationProfileConstants.NO_REDIS)
        .isEqualTo(SpringApplicationProfileEnum.NO_REDIS.getName());
  }

  @Test
  public void noMailShouldEqualEnumName() {
    assertThat(SpringApplicationProfileConstants.NO_MAIL)
        .isEqualTo(SpringApplicationProfileEnum.NO_MAIL.getName());
  }
}
