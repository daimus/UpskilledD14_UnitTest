package id.daimus.cleanarchitecture.application.user.service;

import id.daimus.cleanarchitecture.application.user.entity.User;
import id.daimus.cleanarchitecture.application.user.repository.UserRepository;
import id.daimus.cleanarchitecture.application.user.usecase.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {
    private final UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.createUser(user);
    }
}
