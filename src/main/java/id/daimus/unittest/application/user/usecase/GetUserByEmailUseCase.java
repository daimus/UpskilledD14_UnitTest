package id.daimus.unittest.application.user.usecase;

import id.daimus.unittest.application.user.entity.User;

import java.util.Optional;

public interface GetUserByEmailUseCase {
    Optional<User> getUserByEmail(String email);
}
