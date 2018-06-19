package ch.tbmelabs.tv.core.authorizationserver.web.oauth2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oauth/public")
public class AuthorizationEndpointPublicResourcesController {

  @Autowired
  private ResourceLoader resourceLoader;

  @GetMapping("/{filename:.+}")
  public void getPublicResource(@PathVariable String filename,
      HttpServletResponse httpServletResponse) throws FileNotFoundException, IOException {
    StreamUtils.copy(
        new FileInputStream(
            resourceLoader.getResource("classpath:static/public/" + filename).getFile()),
        httpServletResponse.getOutputStream());
  }
}