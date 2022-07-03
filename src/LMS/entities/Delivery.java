package LMS.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import LMS.provided.*;

/**
 * A delivery within the Logistics Management System.<br>
 * <br>
 * 
 * A delivery collects goods at a certain time and place and after transport
 * delivers them at another time and place. A delivery is transported by a
 * specific carrier and identified by a unique id.<br>
 * <br>
 * 
 * The usual life cycle is
 * <ul>
 * <li>create a delivery with id, pick up and drop off location</li>
 * <li>add goods</li>
 * <li>assign a carrier</li>
 * <li>collect</li>
 * <li>deliver</li>
 * </ul>
 *
 */
public abstract class Delivery implements Comparable<Delivery>{

	private Vehicle carrier;
	private DateTime collected;
	private DateTime delivered;
	private String from;
	private Set<Item> goods;
	private long id;
	private String to;

	public Delivery(long id, String from, String to) {
		this.from = ensureNonNullNonEmpty(from);
		if(id>0) {
			this.id = id;
		}
		this.to = ensureNonNullNonEmpty(to);
	}


	public boolean addGoods(Iterable<Item> items){
			if(!isAssigned()&&!isCollected()&&!isDelivered()){
				goods= new HashSet<>();
			goods.addAll((Collection<? extends Item>) items);
			return true;
		}
	return false;
	}

	public boolean addGoods(Item item){
		if(!isAssigned()&&!isCollected()&&!isDelivered()){
			if(goods==null) {
				goods = new HashSet<Item>();
			}
			goods.add(item);
			return true;
		}
		return false;
	}
	public void assignCarrier(Vehicle v){
		if(v.getMaxLoad()>=totalMass()&&isAssigned()) {
			this.carrier = v;
		}
	}

	public boolean collect(DateTime toc){
		if(!isCollected()&&isAssigned()&&goods.size()>0){
			this.collected=new DateTime(toc);
			return true;
		}
		return false;
	}

	public int compareTo(Delivery arg0){
		return Long.compare(this.id,arg0.id);
	}

	public boolean deliver(DateTime tod){
		if(isCollected()&&!isDelivered()){
			this.delivered=new DateTime(tod);
			return true;
		}
		return false;
	}

	private String ensureNonNullNonEmpty(String str){
		if(str==null||str.isEmpty()){
			throw new IllegalArgumentException();
		}
		return str;
	}

	public Set<Item> getGoods(){
		return goods;
	}
	abstract int getTotal();

	private boolean isAssigned(){
		return carrier != null;
	}

	public boolean isCollected(){
		return collected!=null;
	}

	public boolean isDelivered(){
		return collected!=null;
	}

	protected float totalMass(){
		float totalWeight=-1;
		if(goods!=null) {
			for (Item good : goods) {
				totalWeight += good.totalMass();
			}
			totalWeight++;
		}
		return totalWeight;

	}


	/**
	 * creates a string representation of this delivery.<br>
	 * 
	 * @ProgrammingProblem.Hint provided
	 * 
	 */
	@Override
	public String toString() {
		return String.format(
				"%d from \"%10.10s\" to \"%10.10s\" " + "[%scollected, %sdelivered] (%.2fkg, EUR %.2f)\n" + "%s", id,
				from, to, isCollected() ? "" : "not ", isDelivered() ? "" : "not ", totalMass(), getTotal() / 100.,
				goods == null ? "no stock" : goods);
	}

}
