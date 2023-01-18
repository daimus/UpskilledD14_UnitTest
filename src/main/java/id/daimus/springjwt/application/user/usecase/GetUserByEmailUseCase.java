package id.daimus.springjwt.application.user.usecase;

import id.daimus.springjwt.application.user.entity.User;

import java.util.Optional;

public interface GetUserByEmailUseCase {
    Optional<User> getUserByEmail(String email);
}
