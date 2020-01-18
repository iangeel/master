import java.util.List;

public class Spaceship {

    private static final int CAPACITY = 5;

    private String name;
    private List<String> passangers;

    public Spaceship(String name, List<String> passangers) throws Exception {
        this.name = name;
        this.passangers = passangers;
        if(passangers.size() > CAPACITY) {
            throw new Exception("There are enough resources only for " + CAPACITY + " people.");
        }
    }

    public static int getCAPACITY() {
        return CAPACITY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPassangers() {
        return passangers;
    }

    public void setPassangers(List<String> passangers) {
        this.passangers = passangers;
    }
}
