package ch.tbmelabs.tv.core.authorizationserver.test.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.tbmelabs.tv.core.authorizationserver.domain.Client;
import ch.tbmelabs.tv.core.authorizationserver.domain.dto.ClientDTO;
import ch.tbmelabs.tv.core.authorizationserver.domain.dto.mapper.ClientDTOMapper;
import ch.tbmelabs.tv.core.authorizationserver.domain.repository.ClientCRUDRepository;
import ch.tbmelabs.tv.core.authorizationserver.web.rest.ClientController;
import ch.tbmelabs.tv.shared.constants.security.UserAuthority;

public class ClientControllerTest {
  @Mock
  private ClientCRUDRepository mockClientRepository;

  @Mock
  private ClientDTOMapper mockClientMapper;

  @Spy
  @InjectMocks
  private ClientController fixture;

  private Client testClient;
  private ClientDTO testClientDTO;

  @Before
  public void beforeTestSetUp() {
    initMocks(this);

    testClient = new Client();
    testClientDTO = new ClientDTO(testClient, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

    doReturn(testClient).when(mockClientRepository).findOne(Mockito.anyLong());
    doReturn(new PageImpl<>(Arrays.asList(testClient))).when(mockClientRepository).findAll(Mockito.any(Pageable.class));

    doReturn(testClientDTO).when(mockClientMapper).toClientDTO(Mockito.any(Client.class));
    doReturn(testClient).when(mockClientMapper).toClient(Mockito.any(ClientDTO.class));
  }

  @Test
  public void clientControllerShouldBeAnnotated() {
    assertThat(ClientController.class).hasAnnotation(RestController.class).hasAnnotation(RequestMapping.class)
        .hasAnnotation(PreAuthorize.class);
    assertThat(ClientController.class.getDeclaredAnnotation(RequestMapping.class).value())
        .containsExactly("${spring.data.rest.base-path}/clients");
    assertThat(ClientController.class.getDeclaredAnnotation(PreAuthorize.class).value())
        .isEqualTo("hasAuthority('" + UserAuthority.SERVER_ADMIN + "')");
  }

  @Test
  public void clientControllerShouldHavePublicConstructor() {
    assertThat(new ClientController()).isNotNull();
  }

  @Test
  public void createClientShouldBeAnnotated() throws NoSuchMethodException, SecurityException {
    Method method = ClientController.class.getDeclaredMethod("createClient", new Class<?>[] { ClientDTO.class });
    assertThat(method.getDeclaredAnnotation(PostMapping.class).value()).isEmpty();
  }

  @Test
  public void createClientShouldPersistMappedDTO() {
    fixture.createClient(testClientDTO);

    verify(mockClientRepository, times(1)).save(testClient);
  }

  @Test
  public void createClientsShouldThrowErrorIfClientHasAlreadyAnId() {
    testClientDTO.setId(new Random().nextLong());

    assertThatThrownBy(() -> fixture.createClient(testClientDTO)).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("You can only create a new client without an id!");
  }

  @Test
  public void getAllClientShouldBeAnnotated() throws NoSuchMethodException, SecurityException {
    Method method = ClientController.class.getDeclaredMethod("getAllClients", new Class<?>[] { Pageable.class });
    assertThat(method.getDeclaredAnnotation(GetMapping.class).value()).isEmpty();
  }

  @Test
  public void getAllClientsShouldReturnPageWithAllClients() {
    assertThat(fixture.getAllClients(Mockito.mock(Pageable.class)).getContent()).hasSize(1)
        .containsExactly(testClientDTO);
    verify(mockClientRepository, times(1)).findAll(Mockito.any(Pageable.class));
  }

  @Test
  public void updateClientShouldBeAnnotated() throws NoSuchMethodException, SecurityException {
    Method method = ClientController.class.getDeclaredMethod("updateClient", new Class<?>[] { ClientDTO.class });
    assertThat(method.getDeclaredAnnotation(PutMapping.class).value()).isEmpty();
  }

  @Test
  public void updateClientShouldPersistMappedDTO() {
    testClientDTO.setId(new Random().nextLong());

    fixture.updateClient(testClientDTO);

    verify(mockClientRepository, times(1)).save(testClient);
  }

  @Test
  public void updateClientShouldThrowErrorIfClientHasNoId() {
    assertThatThrownBy(() -> fixture.updateClient(testClientDTO)).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("You can only update an existing client!");
  }

  @Test
  public void deleteClientShouldBeAnnotated() throws NoSuchMethodException, SecurityException {
    Method method = ClientController.class.getDeclaredMethod("deleteClient", new Class<?>[] { ClientDTO.class });
    assertThat(method.getDeclaredAnnotation(DeleteMapping.class).value()).isEmpty();
  }

  @Test
  public void deleteClientShouldDeleteMappedDTO() {
    testClientDTO.setId(new Random().nextLong());

    fixture.deleteClient(testClientDTO);

    verify(mockClientRepository, times(1)).delete(testClient);
  }

  @Test
  public void deleteClientShouldThrowErrorIfClientHasNoId() {
    assertThatThrownBy(() -> fixture.deleteClient(testClientDTO)).isInstanceOf(IllegalArgumentException.class)
        .hasMessage("You can only delete an existing client!");
  }
}