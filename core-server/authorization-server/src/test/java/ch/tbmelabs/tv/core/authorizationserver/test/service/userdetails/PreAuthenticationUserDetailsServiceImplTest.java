package ch.tbmelabs.tv.core.authorizationserver.test.service.userdetails;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doReturn;
import static org.mockito.MockitoAnnotations.initMocks;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;

import ch.tbmelabs.tv.core.authorizationserver.domain.User;
import ch.tbmelabs.tv.core.authorizationserver.domain.repository.UserCRUDRepository;
import ch.tbmelabs.tv.core.authorizationserver.service.userdetails.PreAuthenticationUserDetailsServiceImpl;
import ch.tbmelabs.tv.core.authorizationserver.service.userdetails.UserDetailsImpl;

public class PreAuthenticationUserDetailsServiceImplTest {
  @Mock
  private PreAuthenticatedAuthenticationToken mockToken;

  @Mock
  private OAuth2Authentication mockAuthentication;

  @Mock
  private TokenStore tokenStoreFixture;

  @Mock
  private UserCRUDRepository userRepositoryFixture;

  @Spy
  @InjectMocks
  private PreAuthenticationUserDetailsServiceImpl fixture;

  @Before
  public void beforeTestSetUp() {
    initMocks(this);

    doReturn(RandomStringUtils.random(11)).when(mockToken).getPrincipal();
    doReturn(RandomStringUtils.random(11)).when(mockAuthentication).getName();

    doReturn(mockAuthentication).when(tokenStoreFixture).readAuthentication(Mockito.anyString());
    doReturn(new User()).when(userRepositoryFixture).findByUsername(Mockito.anyString());

    doCallRealMethod().when(fixture).loadUserDetails(Mockito.any(PreAuthenticatedAuthenticationToken.class));
  }

  @Test
  public void preAuthenticationUserDetailsServiceImplShouldBeAnnotated() {
    assertThat(PreAuthenticationUserDetailsServiceImpl.class).hasAnnotation(Service.class);
  }

  @Test
  public void preAuthenticationUserDetailsServiceImplShouldExtendAuthenticationUserDetailsService() {
    assertThat(AuthenticationUserDetailsService.class).isAssignableFrom(PreAuthenticationUserDetailsServiceImpl.class);
  }

  @Test
  public void loadUserDetailsShouldLoadCorrectUserDetailsImpl() {
    assertThat(fixture.loadUserDetails(mockToken)).isOfAnyClassIn(UserDetailsImpl.class)
        .hasFieldOrPropertyWithValue("user", userRepositoryFixture.findByUsername(""));
  }
}