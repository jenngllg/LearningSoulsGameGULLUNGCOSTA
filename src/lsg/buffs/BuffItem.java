package lsg.buffs;

public abstract class BuffItem {

	protected float buff;
	protected String name;
	
	public float getBuff() {
		return buff;
	}

	protected void setBuff(int buff) {
		this.buff = buff;
	}
	
	public abstract float computeBuffValue();
	
}
