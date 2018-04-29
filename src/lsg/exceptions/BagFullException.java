package lsg.exceptions;

import lsg.bags.Bag;

/**
* If a bag is full, then a BagFullException will be thrown.
* @author jenni
*/
public class BagFullException extends Exception {
	
	private Bag bag;
	
	public BagFullException(Bag bag) {
		super(bag.getClass().getSimpleName() + " is full !");
		this.bag = bag;
	}
	
	/**
	 * @return bag sac concerne
	 */
	public Bag getBag() {
		return bag;
	}
	
}
