package web.service;

import web.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);

    void update(User user);

    void delete(int id);

    User findById(int id);

    List<User> findAll();
}
