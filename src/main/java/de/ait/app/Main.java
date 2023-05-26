package de.ait.app;

import de.ait.repositories.UsersRepository;
import de.ait.repositories.UsersRepositoryListImpl;
import de.ait.repositories.UsersRepositoryTextFileImpl;
import de.ait.services.UsersService;
import de.ait.services.UsersServiceImpl;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsersRepository usersRepository = new UsersRepositoryTextFileImpl("users.txt");
        UsersRepository testUserRepository = new UsersRepositoryListImpl();
        UsersService usersService = new UsersServiceImpl(usersRepository);

        while (true) {
            System.out.println("1. Вывести имена всех пользователей");
            System.out.println("2. Вывести фамилию самого взрослого пользователя");
            System.out.println("3. Сохранить нового пользователя");
            System.out.println("4. Вывести средний возраст всех пользователей");
            System.out.println("5. Вывести возраст самого высокого человека");
            System.out.println("6. Вывести имя и фамилию самого низкого человека");

            System.out.println("0. Выход");



            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1:
                    System.out.println("Выводим имена пользователей...");

                    List<String> names = usersService.getNames();

                    for (String name : names) {
                        System.out.println(name);
                    }

                    break;
                case 2:
                    System.out.println("Выводим самого взрослого пользователя");
                    String lastName = usersService.getLastNameOfMostAging();
                    System.out.println(lastName);

                    break;
                case 4:
                    System.out.println("Выводим средний возраст всех пользователей");
                    int averageAge = usersService.getAverageAgeOfUsers();
                    System.out.println(averageAge);

                    break;

                case 3:
                    System.out.println("Сохраняем нового пользователя: ");
                    System.out.println("Введите имя: ");
                    String firstName = scanner.nextLine();

                    System.out.println("Введите Фамилию: ");
                    lastName = scanner.nextLine();

                    System.out.println("Введите возраст: ");
                    String age = scanner.nextLine();

                    System.out.println("Введите рост: ");
                    String height = scanner.nextLine();

                    usersService.addNewUser(firstName, lastName, age, height);


                    break;
                case 6:
                    System.out.println("Вывести имя и фамилию самого низкого человека");
                    usersService.getNameOfShortest();
                    break;
                case 0:
                    System.out.println("Выход");
                    System.exit(0);
                default:
                    System.out.println("Команда не распознана");
            }

        }
    }
}
