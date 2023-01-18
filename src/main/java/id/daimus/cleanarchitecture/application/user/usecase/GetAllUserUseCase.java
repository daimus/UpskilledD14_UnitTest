package id.daimus.cleanarchitecture.application.user.usecase;

import id.daimus.cleanarchitecture.application.user.entity.User;

import java.util.List;

public interface GetAllUserUseCase {
    List<User> getAllUser();
}
