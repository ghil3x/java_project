import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Building {
	private String name;
	private List<Classroom> classrooms;
	private List<Floor> floors;
    static Connection cnx;
    static Statement st;
    static ResultSet rst;

	public Building() {
		this.classrooms = new ArrayList<>();
	}
	public List<Classroom> getClassrooms() {
		return classrooms;
	}

	public List<Floor> getFloors() {
		return floors;
	}
	public String getName() {
		return name;
	}

	public void addClassroom(List<Classroom> s){
		classrooms.addAll(s);
	}

	public void addFloor(List<Floor> e){
		floors.addAll(e);
	}

	public boolean compBat(Building b){
		return name.equals(b.getName());
	}

	public static void print(Building b){
		System.out.println();
	}
//Ajout de batiment dans DB
    public static void addBuilding(String building){
        try{
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            PreparedStatement sql = cnx.prepareStatement("INSERT INTO building(nam) VALUES (?)");
            sql.setString(1, building);
            sql.executeUpdate();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }
    //supression d'un batiement donner de la DB
    public static void removeBuilding(int idb){
        try{
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            PreparedStatement sql = cnx.prepareStatement("DELETE FROM building where idb=?");
            sql.setInt(1, idb);
            sql.executeUpdate();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    public static void updateBuilding(int idb,String nam,String mdp,String cm){
        try{
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            PreparedStatement sql = cnx.prepareStatement("UPDATE building SET idb=?, name=? WHERE idp=?");
            sql.setInt(1, idb);
            sql.setString(2,nam);
            sql.setInt(3,idb);
            sql.executeUpdate();
        }catch (Exception e ){
            System.out.println("Error to update"+e);
        }
    }
}
