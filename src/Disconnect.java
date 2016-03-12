import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.Scanner;

public class Disconnect {
    //besoin d'une connexion pour faire la methode de deconnexion
    static Connection cnx;

    //methode de deconnexion de l'ADMIN
    public static Connection Exit() {
        try {
            cnx.close();
        } catch (Exception e) {
            System.out.println("You are disconnected");
        }
        return cnx;
    }
}