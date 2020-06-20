package inventory;

public class SuperWeapon {

	public String wName;
	public int wDmg;
	public String wMsg;
	public String getwMsg() {
		return wMsg;
	}
	public void setwMsg(String wMsg) {
		this.wMsg = wMsg;
	}
	public String getwName() {
		return wName;
	}
	public void setwName(String name) {
		this.wName = name;
	}
	public int getwDmg() {
		return wDmg;
	}
	public void setwDmg(int wDmg) {
		this.wDmg = wDmg;
	}
	
}
