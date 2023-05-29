package de.ait.services;

import de.ait.models.User;

import java.util.List;

public interface UsersService {
    List<String> getNames();

    String getLastNameOfMostAging();

    public void addNewUser();

    double getAverageAgeOfUsers();

    int getAgeOfHighest();

    String getNameOfShortest();

}