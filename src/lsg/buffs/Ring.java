package lsg.buffs;

public class Ring extends BuffItem {

	public Ring(String name, float buff) {
		this.name = name;
		this.buff = buff;
	}
	
	@Override
	public float computeBuffValue() {
		return this.getBuff();
	}

}
