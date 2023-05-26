package de.ait.services;

import de.ait.repositories.UsersRepositoryListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersServiceImplTest {
private UsersServiceImpl usersService;
 @BeforeEach
    void setUp() {
this.usersService = new UsersServiceImpl(new UsersRepositoryListImpl());

    }
    @Test
    void getNames(){
        List<String > actual = usersService.getNames();
        List<String> expected = Arrays.asList("User1", "User2", "User3");
        assertEquals(expected, actual);
    }
    @Test
    void getAverageAgeOfUsers_test(){
     int actual = usersService.getAverageAgeOfUsers();
     int expected = 25;
     assertEquals(expected, actual);

    }


}