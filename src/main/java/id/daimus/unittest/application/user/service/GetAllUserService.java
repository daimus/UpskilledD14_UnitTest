package id.daimus.unittest.application.user.service;

import id.daimus.unittest.application.user.entity.User;
import id.daimus.unittest.application.user.repository.UserRepository;
import id.daimus.unittest.application.user.usecase.GetAllUserUseCase;
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
