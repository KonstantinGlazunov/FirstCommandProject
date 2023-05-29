package de.ait.repositories;

import de.ait.models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryTextFileImpl implements UsersRepository {

    private String fileName;

    public UsersRepositoryTextFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();


        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line = bufferedReader.readLine();

            while (line != null) {
                User user = parseLine(line);
                users.add(user);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Произошла ошибка");
        }

        return users;
    }

    @Override
    public boolean saveNewUser(User newUser) {
        try (FileWriter fileWriter = new FileWriter(fileName, true); // try with recyrses  файл будет точно закрыт
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            String line = newUser.toString();
            bufferedWriter.newLine();
            bufferedWriter.write(line);

            return true;

        } catch (IOException e) {
            System.err.println("Произошла ошибка записи в файл");
        }
        return false;


    }


    private static User parseLine(String line) {             // Как это работает!?
        String[] parsed = line.split("\\|");
        String firstName = parsed[0];
        String lastName = parsed[1];
        int age = Integer.parseInt(parsed[2]);
        double height = Double.parseDouble(parsed[3]);

        return new User(
                firstName, lastName, age, height
        );
    }


}
