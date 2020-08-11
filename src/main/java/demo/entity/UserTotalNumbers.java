package demo.entity;

/**
 * @author Benny
 *
 * /user post request for total numbers
 *
 */
public class UserTotalNumbers {
    private String name;
    private int totalNumbers;

    public UserTotalNumbers(String name, int totalNumbers) {
        this.name = name;
        this.totalNumbers = totalNumbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalNumbers() {
        return totalNumbers;
    }

    public void setTotalNumbers(int totalNumbers) {
        this.totalNumbers = totalNumbers;
    }
}
