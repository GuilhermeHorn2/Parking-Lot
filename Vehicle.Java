package misc;

public class Vehicle {
	
	private String type;
	private int id;
	
	private boolean payment = false;
	private int lvl;
	
	public Vehicle(String t,int i,int lvl){
		type = t;
		id = i;
		this.lvl = lvl;
	}
	public String get_type() {
		return type;
	}
	public int get_id() {
		return id;
	}
	
	public boolean get_pay() {
		return payment;
	}
	
	public void set_pay(boolean p){
		payment = p;
	}
	

}
