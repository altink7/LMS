package LMS.provided;

/**
 * A driver in the LMS.<br>
 * <br>
 * 
 * Skeleton implementation - no argument checking.
 */
public class Driver {
	private String name;
	private String phone;

	/**
	 * 
	 * Constructs a new driver with specified name and phone number.<br>
	 * <br>
	 * 
	 * @param name
	 *              the name to set
	 * @param phone
	 *              the phone number to set
	 */
	public Driver(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name
	 *             the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phone
	 */
	public final String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *              the phone to set
	 */
	public final void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return String.format("%s %s", name, phone);
	}

}
