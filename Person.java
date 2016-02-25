import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Person {

	private final String id;
	private final String name;
	private final String first_name;
	static Connection cnx;
	static Statement st;
	static ResultSet rst;

	public Person(String id, String name, String first_name) {
		this.id = id;
		this.name = name;
		this.first_name = first_name;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getFirst_name() {
		return first_name;
	}

	public static void SentMsgToAdmin(String msg){
		try{
			cnx = ConnectDB.ConnectBase();
			st = cnx.createStatement();
			PreparedStatement sql = cnx.prepareStatement("INSERT INTO admin(msg) VALUES (?) where nom="+"aslimani"+"");
			sql.setString(1, msg);
			sql.executeUpdate();
		}catch (Exception e ){
			System.out.println("Error to update"+e);
		}
	}
	
}
