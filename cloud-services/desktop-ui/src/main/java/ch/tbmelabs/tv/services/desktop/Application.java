package ch.tbmelabs.tv.services.desktop;

import ch.tbmelabs.tv.shared.constants.spring.SpringApplicationProfile;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.WebApplicationInitializer;

@SpringCloudApplication
public class Application extends SpringBootServletInitializer implements WebApplicationInitializer {

  private static final Class<Application> APPLICATION_SOURCE_CLASS = Application.class;

  @Autowired
  private Environment environment;

  public static void main(String[] args) {
    SpringApplication.run(APPLICATION_SOURCE_CLASS, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
    return applicationBuilder.sources(APPLICATION_SOURCE_CLASS);
  }

  @PostConstruct
  public void initBean() {
    if (environment.acceptsProfiles(SpringApplicationProfile.PROD)
        && environment.acceptsProfiles(SpringApplicationProfile.DEV)) {
      throw new IllegalArgumentException(
          "Do not attempt to run an application in productive and development environment at the same time!");
    }
  }
}