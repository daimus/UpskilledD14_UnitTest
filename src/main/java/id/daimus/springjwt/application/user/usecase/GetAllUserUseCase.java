package id.daimus.springjwt.application.user.usecase;

import id.daimus.springjwt.application.user.entity.User;

import java.util.List;

public interface GetAllUserUseCase {
    List<User> getAllUser();
}
