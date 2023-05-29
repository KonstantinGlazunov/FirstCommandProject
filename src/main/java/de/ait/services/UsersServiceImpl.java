package de.ait.services;

import de.ait.models.User;
import de.ait.repositories.UsersRepository;

import java.io.IOException;
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
    public void addNewUser() {

        User newUser;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String firstName = scanner.nextLine();

        System.out.println("Введите Фамилию: ");
        String lastName = scanner.nextLine();

        System.out.println("Введите возраст: ");
        String age = scanner.nextLine();
        int newAge;
        try {
            newAge = Integer.parseInt(age);
        } catch (RuntimeException e) {
            throw new RuntimeException("Не верный формат данных ");
        }
        System.out.println("Введите рост: ");
        String height = scanner.nextLine();

        Double newHeight;
        try {
            newHeight = Double.parseDouble(height);

        } catch (RuntimeException e) {
            throw new RuntimeException("Не верный формат данных ");
        }

        newUser = new User(firstName, lastName, newAge, newHeight);
        usersRepository.saveNewUser(newUser);

    }


    @Override
    public double getAverageAgeOfUsers() {

        List<User> users = usersRepository.findAll();
        int sum = 0;
        for (User user : users) {
            sum += user.getAge();
        }
        double average = (double) sum / users.size();
        return average;
    }


    @Override
    public int getAgeOfHighest() {

        double maxHeight = usersRepository.findAll().get(0).getHeight();
        int age = 0;
        for (User user : usersRepository.findAll()) {
            if (maxHeight < user.getHeight()) {
                age = user.getAge();
                maxHeight = user.getHeight();
            }

        }
        System.out.println(age);
        return age;
    }


    @Override
    public String getNameOfShortest() {
        List<User> users = usersRepository.findAll();
        Map<Double, String> fullName = new HashMap<>();
        for (User user : users) {
            fullName.put(user.getHeight(), user.getFirstName() + " " + user.getLastName());
        }
        double minHeight = Collections.min(fullName.keySet());
        return fullName.get(minHeight);
    }


}



