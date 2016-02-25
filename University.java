import java.util.ArrayList;
import java.util.List;

public class University {
	
private static List<Building> lb = new ArrayList<>();
	
	public static void addBat(Building b){
		for(Building bat: lb){
			if(bat.compBat(b)){
				lb.add(b);
			}
		}
	}
	public static List<Classroom> getSalles(){
		List<Classroom> ls = new ArrayList<>();
		for(Building b: lb){
			ls.addAll(b.getClassrooms());
		}
		return ls;
	}
	public static List<Floor> getEtage(){
		List<Floor> le = new ArrayList<>();
		for(Building b: lb){
			le.addAll(b.getFloors());
		}
		return le;
	}
}
