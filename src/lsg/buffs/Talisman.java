package lsg.buffs;

public class Talisman extends BuffItem {

	public Talisman(String name, float buff) {
		this.name = name;
		this.buff = buff;
	}
	
	@Override
	public float computeBuffValue() {
		return this.getBuff();
	}

}
