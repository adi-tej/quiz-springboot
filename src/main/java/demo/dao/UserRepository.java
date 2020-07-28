package demo.dao;

import demo.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> getUsers();
}