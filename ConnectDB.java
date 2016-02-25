import java.sql.Connection;
import java.sql.DriverManager;


/**
 * Created by slima_000 on 27/08/2015.
 */
public class ConnectDB {

    public static Connection ConnectBase() {
       try {
           //chargement du driver de postgresql s'il n'est pas deja charger
            Class.forName("org.postgresql.Driver");
            //System.out.println("Driver O.K.");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/prj"/*nom de la base de donne*/
                    ,/* Login du serveur*/ "postgres",/*mdp*/ "alim");
            if(con != null){
                //System.out.println("Authentification OK ");
                return con;
            }else{
                System.out.println("Acces denied!!!");
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return ConnectBase();
    }
}


