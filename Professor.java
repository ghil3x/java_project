mport java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;

public class Professor extends Person {
	private List<Cours> classes;
    private String cm;
    private int tel;
    private String email;
    private String idp;

	public Professor(String idp, String name, String first_name,int tel,String email,String cm) {
		super(idp, name, first_name);
        this.idp=idp;
        this.tel=tel;
        this.email=email;
        this.cm=cm;
	}

	public List<Cours> getClasses() {
		return classes;
	}
	public void setClasses(List<Cours> classes) {
		this.classes = classes;
	}

    public static void addProf(String nam,String first_nam,String login,String mdp,int tel,String email,String cm){
        try{
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            PreparedStatement sql = cnx.prepareStatement("INSERT INTO professor(nam,first_nam,login,mdp,tel,email,cm) VALUES (?,?,?,?,?,?,?)");
            sql.setString(1, nam);
            sql.setString(2, first_nam);
            sql.setString(3, login);
            sql.setString(4, mdp);
            sql.setInt(5, tel);
            sql.setString(6, email);
            sql.setString(7, cm);
            sql.executeUpdate();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    public static void removeProfessor(int idp){

        try{
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            PreparedStatement sql = cnx.prepareStatement("DELETE FROM professor where idp=?");
            sql.setInt(1, idp);
            sql.executeUpdate();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    public static void updateProfessor(int idp,String login,String mdp,String cm){
        try{
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            PreparedStatement sql = cnx.prepareStatement("UPDATE professor SET idp=?, login=?, mdp=?,cm=? WHERE idp=?");
            sql.setInt(1, idp);
            sql.setString(2,login);
            sql.setString(3,mdp);
            sql.setString(4, cm);
            sql.setInt(5,idp);
            sql.executeUpdate();
        }catch (Exception e ){
            System.out.println("Error to update"+e);
        }
    }

    public static void SelectProfessor(int idp){
        try{
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            PreparedStatement sql = cnx.prepareStatement("Select idp FROM professor WHERE idp=?");
            sql.setInt(1,idp);
            sql.executeUpdate();
        }catch (Exception e ){
            System.out.println();
        }
    }
}