package demo.entity;

/**
 * @author Edward 
 * For return /user post request
 */
public class UserTotalNumbers {
	private String name;
	private int TotalNumbers;

	public UserTotalNumbers(String name, int totalNumbers) {
		super();
		this.name = name;
		TotalNumbers = totalNumbers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalNumbers() {
		return TotalNumbers;
	}

	public void setTotalNumbers(int totalNumbers) {
		TotalNumbers = totalNumbers;
	}

}
