import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;

public class Classroom extends Floor {

	private int capacity;
	//private final TypeClassroom type;
	private List<Slot> slots;//créneau
	private String nam;
    private String building;
	private Date dt;
	private Date dt_end;
	private String Formation;
	private String gr;
    private boolean disp;

    public Classroom(int num_floor, List<Classroom> classroom) {
        super(num_floor, classroom);
    }


    public List<Slot> getSlots() {
		return slots;
	}
	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}

	public int getCapacity() {
		return capacity;
	}
	/*public TypeClassroom getType() {
		return type;
	}*/
	public void addSlot(Slot c){
		Slot.addSlot(nam,dt,dt_end,Formation,gr);
	}

    public static void addClassroom(String nam,int cpt){
        try{
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            PreparedStatement sql = cnx.prepareStatement("INSERT INTO classroom(nam,cpt) VALUES (?,?)");
            sql.setString(1, nam);
            sql.setInt(2, cpt);
            sql.executeUpdate();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    public static void removeClassroom(int idcl){

        try{
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            PreparedStatement sql = cnx.prepareStatement("DELETE FROM classroom where idcl=?");
            sql.setInt(1, idcl);
            sql.executeUpdate();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    public static void updateClassroom(int idcl,String nam,int cpt){
        try{
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            PreparedStatement sql = cnx.prepareStatement("UPDATE classroom SET idcl=?, nam=?, cpt=? WHERE idcl=?");
            sql.setInt(1, idcl);
            sql.setString(2,nam);
            sql.setInt(3,cpt);
            sql.setInt(4,idcl);
            sql.executeUpdate();
        }catch (Exception e ){
            System.out.println("Error to update"+e);
        }
    }
}
