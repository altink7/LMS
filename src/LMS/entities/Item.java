package LMS.entities;

/**
 * A shipping item within the Logistics Management System.<br>
 * <br>
 * 
 * A shipping item consists one or many identical single items with a common
 * description a single item mass and value.
 * 
 *
 */
public class Item {

	private int amount;
	private String description;
	private float mass;
	private long value;

	public Item( String description,int amount, float mass, long value) {
		this.amount = amount;
		try {
			this.description = description;
			this.mass = mass;
			this.value = value;
		}catch(IllegalArgumentException e ){
			e.printStackTrace();
		}
	}


	public float totalValue(){
		return amount*value;
	}

	public float totalMass(){
		return amount*mass;
	}

	/**
	 * creates a string representation of this item.<br>
	 * 
	 * @ProgrammingProblem.Hint provided
	 * 
	 */
	@Override
	public String toString() {
		return String.format("%d x %.15s (%.1fkg EUR %d.%02d, %.1fkg EUR %d.%02d)", amount, description, mass,
				((int) value) / 100, ((int) value) % 100, totalMass(), ((int) totalValue()) / 100,
				((int) totalValue()) % 100);
	}

}
