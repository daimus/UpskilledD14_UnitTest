package id.daimus.springswagger.application.user.service;

import id.daimus.springswagger.application.user.entity.User;
import id.daimus.springswagger.application.user.repository.UserRepository;
import id.daimus.springswagger.application.user.usecase.GetAllUserUseCase;
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
