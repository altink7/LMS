package LMS.provided;

/**
 * A vehicle in the LMS.<br>
 * <br>
 * 
 * Skeleton implementation - no argument checking.
 *
 */
public class Vehicle {
	private String registration;
	private int maxLoad;
	private Driver driver;

	public Vehicle(String registration, int maxLoad, Driver driver) {
		super();
		this.registration = registration;
		this.maxLoad = maxLoad;
		this.driver = driver;
	}

	public int getMaxLoad() {
		return maxLoad;
	}
	
	
	@Override
	public String toString() {
		return String.format("%s %s %s", registration, maxLoad, driver);
	}

}
