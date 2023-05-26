package de.ait.services;

import java.util.List;

public interface UsersService {
    List<String> getNames();

    String getLastNameOfMostAging();



    void addNewUser(String firstName, String lastName, String age, String height);

}
