import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Slot {

    private Date dt_s;
    private Date dt_end;
    private String Modul;
    private String Group;
    private final Cours name;

    static Connection cnx;
    static Statement st;
    static ResultSet rst;

    public Slot(Cours name, Date dt_s, Date dt_end, String modul, String group) {
        this.name = name;
        this.dt_s = dt_s;
        this.dt_end = dt_end;
        Modul = modul;
        Group = group;
    }

    public Cours getName() {
        return name;
    }

    public Date getDt_s() {
        return dt_s;
    }

    public Date getDt_end() {
        return dt_end;
    }

    public String getModul() {
        return Modul;
    }

    public String getGroup() {
        return Group;
    }

    public boolean compSlot(Slot c){
		/*if((year == c.year)&&(month == c.month)&&(day == c.day)){
			if((c.startTime >= endTime)||(c.endTime <= startTime)){
				return true;
			}
		}*/
		return false;
	}

    public static void addSlot(String name,Date dt,Date dt_end,String Modul,String Group){

        try{
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            PreparedStatement sql = cnx.prepareStatement("INSERT INTO slot(cm, dt,dt_end,modul,gr) VALUES (?,?,?,?,?)");
            sql.setString(1, name.toString());
            sql.setTimestamp(2, new java.sql.Timestamp(dt.getTime()));
            sql.setTimestamp(3, new java.sql.Timestamp(dt_end.getTime()));
            sql.setString(4,Modul);
            sql.setString(5,Group.toString());
            sql.executeUpdate();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    public static void removeSlot(int idsl){

        try{
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            PreparedStatement sql = cnx.prepareStatement("DELETE FROM slot where idsl=?");
            sql.setInt(1, idsl);
            sql.executeUpdate();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    public static void updateSlot(String cm,Date dt,Date dt_e,String Gr){

        try{
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            PreparedStatement sql = cnx.prepareStatement("UPDATE slot SET cm=?, dt=?,dt_end=?,gr=? WHERE cm=?");
            sql.setString(1,cm);
            sql.setTimestamp(2, new java.sql.Timestamp(dt.getTime()));
            sql.setTimestamp(3, new java.sql.Timestamp(dt_e.getTime()));
            sql.setString(4,Gr);
            sql.setString(5, cm);
            sql.executeUpdate();
        }catch (Exception e ){
            System.out.println("Error to update"+e);
        }
    }

}
