import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;

public class Cours extends Classroom {
	private String nam;
	private String professor;
	private int cpt;
	private boolean option;
    private String gr;
	private Professor responsible;
	private List<Classroom> classrooms;
	private String modul;
	private Slot slot;//créneau horraire
    private List<Student> studentList;

    public Cours(int num_floor, List<Classroom> classroom) {
        super(num_floor, classroom);
    }
    //contructeur de Classroom.java

    public List<Classroom> getClassrooms() {
		return classrooms;
	}
	public void setClassroom(String classroom) {
		this.classrooms = classrooms;
	}
	public String getModul() {
		return modul;
	}
	public void setModule(String modul) {
		this.modul = modul;
	}
	public Slot getSlot() {
		return slot;
	}
	public void setSlot(Slot slot) {
		this.slot = slot;
	}
	public Professor getResponsible() {
		return responsible;
	}
	public boolean isOption() {
		return option;
	}
//ajout d'un cour dans la DB
    public static void addCours(String nam,String professor,String building,int floor,String classroom,String formation,boolean opt,Boolean res){
        try{
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            PreparedStatement sql = cnx.prepareStatement("INSERT INTO cours(nam,professor,building,num_floor,classroom,formation,opt,res) VALUES (?,?,?,?,?,?,?,?)");
            sql.setString(1, nam);
            sql.setString(2, professor);
            sql.setString(3, building);
            sql.setInt(4, floor);
            sql.setString(5, classroom);
            sql.setString(6, formation);
            sql.setBoolean(7, opt);
            sql.setBoolean(8, res);
            sql.executeUpdate();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }
//supression d'un cours de la DB
    public static void removeCours(int idc){

        try{
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            PreparedStatement sql = cnx.prepareStatement("DELETE FROM cours where idc=?");
            sql.setInt(1, idc);
            sql.executeUpdate();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    public static void updateCours(int idc,Date dt, Date dt_end,String building,int num_floor,String classroom,String professor,String formation,Boolean opt,int gr){
        try{
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            PreparedStatement sql = cnx.prepareStatement("UPDATE cours SET idc=?,dt=?,dt_end=?,building=?, num_floor=?,classroom=?,professor=?,formation=?,opt=?,gr=? WHERE idc=?");
            sql.setInt(1, idc);
            sql.setTimestamp(2, new java.sql.Timestamp(dt.getTime()));
            sql.setTimestamp(3, new java.sql.Timestamp(dt_end.getTime()));
            sql.setString(4,building);
            sql.setInt(5, num_floor);
            sql.setString(6,classroom);
            sql.setString(7,professor);
            sql.setString(8,formation);
            sql.setBoolean(9, opt);
            sql.setInt(10,gr);
            sql.setInt(11, idc);


            sql.executeUpdate();
        }catch (Exception e ){
            System.out.println("Error to update"+e);
        }
    }

    public static void ReservedClassroomToCours(String nam,Date dt, Date dt_end,String building,int num_floor,String classroom,String professor,String formation,Boolean opt,int gr,Boolean res){
        try{
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            PreparedStatement sql = cnx.prepareStatement("INSERT INTO cours(nam,dt,dt_end,building, num_floor,classroom,professor,formation,opt,gr,res) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            sql.setString(1, nam);
            sql.setTimestamp(2, new java.sql.Timestamp(dt.getTime()));
            sql.setTimestamp(3, new java.sql.Timestamp(dt_end.getTime()));
            sql.setString(4,building);
            sql.setInt(5, num_floor);
            sql.setString(6,classroom);
            sql.setString(7,professor);
            sql.setString(8,formation);
            sql.setBoolean(9, opt);
            sql.setInt(10,gr);
            sql.setBoolean(11, res);


            sql.executeUpdate();
        }catch (Exception e ){
            System.out.println("Error to update"+e);
        }
    }

}
