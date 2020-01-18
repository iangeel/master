import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;

public class SpaceshipTest {

    List<String> EXCEEDED_CAPACITY_LIST;

    @Before
    public void init() {
        EXCEEDED_CAPACITY_LIST = new ArrayList<String>();
        EXCEEDED_CAPACITY_LIST.add("Dummy");
        EXCEEDED_CAPACITY_LIST.add("Dummy");
        EXCEEDED_CAPACITY_LIST.add("Dummy");
        EXCEEDED_CAPACITY_LIST.add("Dummy");
        EXCEEDED_CAPACITY_LIST.add("Dummy");
        EXCEEDED_CAPACITY_LIST.add("Dummy");
    }

    @Category(InitializingTests.class)
    @Test
    public void constructorTest() throws Exception {
        String expectedName = "Apolo";
        List<String> expectedPassangers = new ArrayList<String>();
        String expectedPassanger = "John";
        expectedPassangers.add(expectedPassanger);

        Spaceship spaceship = new Spaceship(expectedName, expectedPassangers);

        Assert.assertNotNull("Spaceship should be initialized", spaceship);
        Assert.assertEquals("Name should match", expectedName, spaceship.getName());
        Assert.assertNotNull("Passanger list should not be null", expectedPassanger);
        Assert.assertEquals("Passanger name should be John", expectedPassanger, spaceship.getPassangers().get(0));
    }

    @Category(InitializingTests.class)
    @Test
    public void setPassangers() throws Exception {
        List<String> expectedPassangers = new ArrayList<String>();
        String expectedPassanger1 = "John";
        String expectedPassanger2 = "Zoro";
        String expectedPassanger3 = "Ilan";
        String expectedPassanger4 = "Alen";
        String expectedPassanger5 = "Cora";

        expectedPassangers.add(expectedPassanger1);
        expectedPassangers.add(expectedPassanger2);
        expectedPassangers.add(expectedPassanger3);
        expectedPassangers.add(expectedPassanger4);
        expectedPassangers.add(expectedPassanger5);

        Spaceship spaceship = new Spaceship("Apolo", new ArrayList<String>());
        spaceship.setPassangers(expectedPassangers);

        Assert.assertEquals("Pasangers size should be 5 and equal", expectedPassangers.size(), spaceship.getPassangers().size());
        Assert.assertEquals("Second passenger should be named Zoro", "Zoro", spaceship.getPassangers().get(1));
        Assert.assertEquals("Last passenger name should be equal", expectedPassanger5, spaceship.getPassangers().get(4));
    }

    @Category(ExceptionTests.class)
    @Test(expected = Exception.class)
    public void whenCapacityIsTooLargeExceptionWillBeThrownInConstructor() throws Exception {
        Spaceship errorSpaceShip = new Spaceship("Error", EXCEEDED_CAPACITY_LIST);
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Category(ExceptionTests.class)
    @Test
    public void whenSetTooLargeListOfPassangersAnExceptionWillBeThrown() throws Exception {
        Spaceship spaceship = new Spaceship("Apolo", new ArrayList<String>());

        int CAPACITY = 5;
        String expectedErrorMessage = "There are enough resources only for " + CAPACITY + " people.";

        exceptionRule.expectMessage(expectedErrorMessage);
        spaceship.setPassangers(EXCEEDED_CAPACITY_LIST);
    }
}
