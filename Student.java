import java.sql.PreparedStatement;
import java.util.List;

public class Student extends Person {

	public Student(String id, String name, String first_name) {
		super(id, name, first_name);
	}

	//private Hall hall;
	private List<Cours> options;
	
	/*public Hall getHall() {
		return hall;
	}*/
	/*public void setHall(Hall hall) {
		this.hall = hall;
	}*/
	public List<Cours> getOptions() {
		return options;
	}

	public void setOptions(List<Cours> options) {
		this.options = options;
	}

	public static void addStudent(String nam,String first_nam,String login,String mdp,int tel,String email,int num_student,String formation,int gr){
		try{
			cnx = ConnectDB.ConnectBase();
			st = cnx.createStatement();
			PreparedStatement sql = cnx.prepareStatement("INSERT INTO student(nom,prenom,login,mdp,tel,email,num_student,formation,gr) VALUES (?,?,?,?,?,?,?,?,?)");
			sql.setString(1, nam);
			sql.setString(2, first_nam);
			sql.setString(3, login);
			sql.setString(4, mdp);
			sql.setInt(5, tel);
			sql.setString(6, email);
            sql.setInt(7, num_student);
            sql.setString(8, formation);
			sql.setInt(9, gr);
			sql.executeUpdate();
		}catch (Exception e ){
			e.printStackTrace();
		}
	}

    public static void removeStudent(int ids){

        try{
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            PreparedStatement sql = cnx.prepareStatement("DELETE FROM student where ids=?");
            sql.setInt(1, ids);
            sql.executeUpdate();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }
}