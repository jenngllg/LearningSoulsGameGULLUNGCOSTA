package lsg.buffs;

import lsg.bags.Collectible;

public abstract class BuffItem implements Collectible {

	protected float buff;
	protected String name;
	
	public float getBuff() {
		return buff;
	}

	protected void setBuff(int buff) {
		this.buff = buff;
	}
	
	public abstract float computeBuffValue();
	
	@Override
	public int getWeight() {
		return 1;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "(" + this.getBuff() + ")";
	}
	
	
}
