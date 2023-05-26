package de.ait.services;

import de.ait.models.User;
import de.ait.repositories.UsersRepository;

import java.util.*;

public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<String> getNames() {
        List<User> users = usersRepository.findAll();
        List<String> names = new ArrayList<>();

        for (User user : users) {
            names.add(user.getFirstName());
        }

        return names;
    }

    @Override
    public String getLastNameOfMostAging() {


        List<User> users = usersRepository.findAll();
        Map<Integer, String> userAge = new HashMap<>();

        for (User user : users) {
            userAge.put(user.getAge(), user.getLastName());
        }

        int maxAge = Collections.max(userAge.keySet());

        return userAge.get(maxAge);
    }


    @Override
    public void addNewUser(String firstName, String lastName, String age, String height) {
        User newUser = new User(firstName, lastName, Integer.parseInt(age), Double.parseDouble(height));
        usersRepository.saveNewUser(newUser);


    }

    @Override
    public int getAverageAgeOfUsers() {
        List<User> users = usersRepository.findAll();
        int sum = 0;
        for (User user : users) {
            sum += user.getAge();

        }
        return sum / users.size();
    }

    public void getNameOfShortest() {
        double minHeight = usersRepository.findAll().get(0).getHeight();
        String firstName = "";
        String lastName = "";
        for (User user : usersRepository.findAll()) {
            if (minHeight > user.getHeight()) {
                firstName = user.getFirstName();
                lastName = user.getLastName();
                minHeight = user.getHeight();
            }
        }
        System.out.println(firstName + " " + lastName);
    }

    @Override
    public void getNameOfHighest() {

    }

    public int getAgeOfHeighest() {
        double maxHeight = usersRepository.findAll().get(0).getHeight();
        int age = 0;
        for (User user : usersRepository.findAll()) {
            if (maxHeight > user.getHeight()) {
                age = user.getAge();
                maxHeight = user.getHeight();
            }
            System.out.println(age);
        }
        return age;
    }

}



