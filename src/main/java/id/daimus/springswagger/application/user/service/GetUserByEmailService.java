package id.daimus.springswagger.application.user.service;

import id.daimus.springswagger.application.user.entity.User;
import id.daimus.springswagger.application.user.repository.UserRepository;
import id.daimus.springswagger.application.user.usecase.GetUserByEmailUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetUserByEmailService implements GetUserByEmailUseCase {
    private final UserRepository userRepository;
    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }
}
