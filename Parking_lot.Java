package misc;

import java.util.ArrayList;

public class Parking_lot {
	
	private static class level{
		
		private final int spots;
		private final int id;
		
		private static ArrayList<Vehicle> v_list = new ArrayList<>();
		private static int num_v;
		
		public level(int spt,int id) {
			spots = spt;
			this.id = id;
			for(int i = 0;i < spots;i++) {
				v_list.add(null);
			}
		}
		
		public boolean full() {
			if(num_v == spots){
				return true;
			}
			return false;
		}
		
		public ArrayList<Vehicle> get_vlist(){
			return v_list;
		}
		
		public boolean payd(Vehicle v) {
			//Just to simulate payment
			v.set_pay(true);
			return v.get_pay();
		}
		
		public void add_vehicle(String type){
			
			if(this.full()){
				System.out.print("No space");
			}
			else {
				//search first null spot
				for(int i = 0;i < v_list.size();i++) {
					Vehicle x = v_list.get(i);
					if(x == null) {
						Vehicle v = new Vehicle(type,i,id);
						if(this.payd(v)){
							v_list.remove(i);
							v_list.add(i,v);
							num_v++;
							break;
						}
						else {
							System.out.println("Cant add this vehicle.");
							break;
						}
					}
				}
				
			}
		}	
		public void remove_vehicle(int id){
			
			//I will just change the spot to null
			v_list.remove(id);
			v_list.add(id,null);
			num_v--;
		}
		
	}
	
	private final int num_lvl;
	private final int spots_in_lvl;
	private static ArrayList<level> lvl_list = new ArrayList<>();
	
	public Parking_lot(int n,int m) {
		num_lvl = n;
		spots_in_lvl = m;
		
		//Creating the levels
		for(int i = 0;i < n;i++){
			level l = new level(m,i);
			lvl_list.add(l);
		}
	}
	
	public boolean add(String type){
		
		boolean added = false;
		
		//Search for the first level with spots 
		for(int i = 0;i < num_lvl;i++){
			level x = lvl_list.get(i);			
			if(!x.full()){
				x.add_vehicle(type);
				added = true;
			}
		}
		return added;
	}
	
	public boolean remove(Vehicle v){
		
		boolean removed = false;
		
		for(int i = 0;i < num_lvl;i++){
			level x = lvl_list.get(i);
			for(int j = 0;j <x.get_vlist().size();j++){
				Vehicle y = x.get_vlist().get(j);
				if(y == v){
					x.remove_vehicle(j);
					removed = true;
				}
			}
		}
		return removed;
		
	}
	
	

}
