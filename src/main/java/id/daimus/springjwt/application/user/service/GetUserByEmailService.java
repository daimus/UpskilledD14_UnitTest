package id.daimus.springjwt.application.user.service;

import id.daimus.springjwt.application.user.entity.User;
import id.daimus.springjwt.application.user.repository.UserRepository;
import id.daimus.springjwt.application.user.usecase.GetUserByEmailUseCase;
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
