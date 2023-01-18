package id.daimus.cleanarchitecture.application.user.usecase;

import id.daimus.cleanarchitecture.application.user.entity.User;

import java.util.Optional;

public interface GetUserByEmailUseCase {
    Optional<User> getUserByEmail(String email);
}
