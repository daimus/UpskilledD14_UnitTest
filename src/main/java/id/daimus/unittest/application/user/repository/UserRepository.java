package id.daimus.unittest.application.user.repository;

import id.daimus.unittest.application.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    Optional<User> getUserByEmail(String email);
    Optional<User> getUserByPhone(String phone);
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}
