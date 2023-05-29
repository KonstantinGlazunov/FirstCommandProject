package de.ait.services;

import de.ait.models.User;
import de.ait.repositories.UsersRepository;
import de.ait.repositories.UsersRepositoryListImpl;
import de.ait.repositories.UsersRepositoryTextFileImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersServiceImplTest {
    private UsersServiceImpl usersService;
    private UsersRepositoryTextFileImpl usersRepositoryTextFile;


    @BeforeEach
    void setUp() {
        this.usersService = new UsersServiceImpl(new UsersRepositoryListImpl());
        this.usersRepositoryTextFile = new UsersRepositoryTextFileImpl("users.txt");
    }

    @Test
    void getNames() {
        List<String> actual = usersService.getNames();
        List<String> expected = Arrays.asList("User1", "User2", "User3");
        assertEquals(expected, actual);
    }

    @Test
    void getAverageAgeOfUsers_test() {
        double actual = usersService.getAverageAgeOfUsers();
        double expected = 25;
        assertEquals(expected, actual);
    }


    @ParameterizedTest
    @CsvSource({"'Mark', 'Fradkin', '250', '250'",
            "'Mark1', 'Fradkin2', '100', '50'"
            //тест принимает значения из ЦСВ и подставляет их в метод
            /*,"'Mark', 'Fradkin', 'sto', 'dvesti'"*/})
    void addNewUser(String firstName, String lastName, String age, String height) {
        //  List<User> listBeforAddNewUser =  usersRepositoryTextFile.findAll();  //    лист юзеров из файла он теперь не нужен
        usersService.addNewUser();  //вызов метода
        // формируем строку из добавляемого пользователя
        String actual = firstName + "|" +
                lastName + "|" +
                age + "|" +
                height;
        //получаем последнюю (добавленную) строку из файла
        List<User> listAfterAddNewUser = usersRepositoryTextFile.findAll();  //    лист юзеров из файла после применения метода
        String expected = listAfterAddNewUser.get(listAfterAddNewUser.size() - 1).toString(); // последняя строка из файла

        // сейчас нужно сравнить
        assertEquals(expected, actual);
    }




    @Test
    void getNameOfShortest() {
        String actual = usersService.getNameOfShortest();
        String expected = "User1 User1";
        assertEquals(expected, actual);
    }

    @Test
    void getAgeOfHighest() {
        int actual = usersService.getAgeOfHighest();
        int expected = 25;
        assertEquals(expected, actual);
    }


}