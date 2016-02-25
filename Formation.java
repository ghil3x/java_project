import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Formation {
    private String nam;
    private int idf;
    private List<Cours> cm;
    static Connection cnx;
    static Statement st;
    static ResultSet rst;

    public Formation(String nam, int idf, List<Cours> cm) {
        this.nam = nam;
        this.idf = idf;
        this.cm = cm;
    }

    public String getNam() {
        return nam;
    }

    public int getIdf() {
        return idf;
    }

    public List<Cours> getCm() {
        return cm;
    }

    public static void addFormation(String nam){
        try{
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            PreparedStatement sql = cnx.prepareStatement("INSERT INTO formation(nam) VALUES (?)");
            sql.setString(1, nam);
            sql.executeUpdate();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    public static void removeFormation(int idf){

        try{
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            PreparedStatement sql = cnx.prepareStatement("DELETE FROM formation where idf=?");
            sql.setInt(1, idf);
            sql.executeUpdate();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }

}
