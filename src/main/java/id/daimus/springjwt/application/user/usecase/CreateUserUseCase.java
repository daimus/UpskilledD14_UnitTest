package id.daimus.springjwt.application.user.usecase;

import id.daimus.springjwt.application.user.entity.User;

public interface CreateUserUseCase {
    User createUser(User user);
}
