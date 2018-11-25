package pl.sda;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class UserBDTest {

    private UserDB userDB;

    @Before
    public void setUp() {
        userDB = new UserDB();
        // final int expectedUserCount = 3;
        User user1 = new User("Jan", "Kowalski", 38, "Poznań", Position.CFO);
        User user2 = new User("Adam", "Nowak", 56, "Poznań", Position.CEO);
        User user3 = new User("Piotr", "Dawidowski", 25, "Poznań", Position.MISERABLE_SLAVE_OF_SYSTEM);
        userDB.addUser(user1);
        userDB.addUser(user2);
        userDB.addUser(user3);
    }

    @Test
    public void shouldCount3Employees() {
        //given
        final int expectedUserCount = 3;

        //when
        int employeeCount = userDB.getUsersCount();

        //then
        Assert.assertEquals(expectedUserCount, employeeCount);
    }

    @Test
    public void shouldReturn1CFOAnd1CEOAnd1MSOS() {
        //given
        final Integer cfoCount = 1;
        final Integer ceoCount = 1;
        final Integer msosCount = 1;

        //when
        Map<Position, Integer> result = userDB.countPositions();

        //then
        Assert.assertEquals(cfoCount, result.get(Position.CFO));
        Assert.assertEquals(ceoCount, result.get(Position.CEO));
        Assert.assertEquals(msosCount, result.get(Position.MISERABLE_SLAVE_OF_SYSTEM));
    }

    @Test
    public void shouldReturnAverageAge() {
        //given
        final Double expectAverageAge = 39.666666666666664;

        //when
        Double result = userDB.countAverageAge();

        //then
        Assert.assertEquals(expectAverageAge, result);
    }

    @Test
    public void shouldCountHowManyTimesNameAppear() {
        //given
        final Integer jan = 1;
        final Integer adam = 1;
        final Integer piotr = 1;

        //when
        Map<String, Integer> result = userDB.countNames();

        //then
        Assert.assertEquals(jan, result.get("Jan"));
        Assert.assertEquals(adam, result.get("Adam"));
        Assert.assertEquals(piotr, result.get("Piotr"));
    }
}
