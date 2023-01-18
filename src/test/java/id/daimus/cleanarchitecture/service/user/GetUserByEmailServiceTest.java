package id.daimus.cleanarchitecture.service.user;

import id.daimus.cleanarchitecture.application.user.entity.User;
import id.daimus.cleanarchitecture.application.user.repository.UserRepository;
import id.daimus.cleanarchitecture.application.user.service.GetUserByEmailService;
import id.daimus.cleanarchitecture.application.user.usecase.GetUserByEmailUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class GetUserByEmailServiceTest {
    private GetUserByEmailService getUserByEmailService;
    @Mock
    UserRepository userRepository;
    @BeforeEach
    void setup(){
        getUserByEmailService = new GetUserByEmailService(userRepository);
    }
    @Nested
    class GetUserByEmail {
        @Test
        void GetUserByEmail_ValidInput_True(){
            // Given
            String email = "johndoe@mail.com";
            User user = new User(101L, email, "password");
            given(userRepository.getUserByEmail(email)).willReturn(Optional.of(user));
            // When
            Optional<User> actualUser = getUserByEmailService.getUserByEmail(email);
            // Then
            assertThat(actualUser).isEqualTo(Optional.of(user));
        }
    }
}
