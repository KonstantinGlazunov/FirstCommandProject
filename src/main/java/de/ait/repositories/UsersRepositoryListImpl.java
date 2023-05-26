package de.ait.repositories;

import de.ait.models.User;

import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryListImpl implements UsersRepository {
    private List<User> users = new ArrayList<>(List.of(
            new User("User1", "User1", 20, 1.81),
            new User("User2", "User2", 25, 1.85),
            new User("User3", "User3", 30, 1.90)
    ));

    @Override
    public List<User> findAll() {

        return users;
    }

    @Override
    public void saveNewUser(User newUser) {

        users.add(newUser);

    }


}
