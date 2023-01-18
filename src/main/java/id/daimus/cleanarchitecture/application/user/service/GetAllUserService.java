package id.daimus.cleanarchitecture.application.user.service;

import id.daimus.cleanarchitecture.application.user.entity.User;
import id.daimus.cleanarchitecture.application.user.repository.UserRepository;
import id.daimus.cleanarchitecture.application.user.usecase.GetAllUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllUserService implements GetAllUserUseCase {
    private final UserRepository userRepository;
    @Override
    public List<User> getAllUser() {
        return userRepository.getAllUsers();
    }
}
