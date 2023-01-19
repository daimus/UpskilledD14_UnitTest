package id.daimus.springswagger.service.user;

import id.daimus.springswagger.application.user.entity.User;
import id.daimus.springswagger.application.user.repository.UserRepository;
import id.daimus.springswagger.application.user.service.CreateUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateUserServiceTest {
    private CreateUserService createUserService;
    @Mock
    private UserRepository userRepository;
    @BeforeEach
    void setup(){
        createUserService = new CreateUserService(userRepository);
    }
    @Nested
    class CreateUser {
        @Test
        void CreateUser_ValidInput_True() {
            int id = 1;
            // Given
            User user = new User((long) id, "budi@mail.com", "password");
            when(userRepository.createUser(user)).thenReturn(user);
            // When
            User expectedUser = createUserService.createUser(user);
            // Then
            assertThat(expectedUser).isEqualTo(user);
        }
    }
}
