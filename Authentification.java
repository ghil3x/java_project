import java.sql.*;

public class Authentification {

    static Connection cnx;
    static Statement st;
    static ResultSet rst;

    //methode pour authentifier l'Admin
    public static Connection AuthA(String auth, String mdp) throws SQLException {
        try {
            //Appel la methode ConnectBase de ConnectDB pour faire la requete si le login et le MDP exite
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            //utilisation de PreparedStatement afin d'eviter les injection SQL pour securiser ll'acces aux donnees
            PreparedStatement sql = cnx.prepareStatement("select login,mdp from admin where login=? AND mdp=?");
            //Les champs de la methode qui se remplissent lors de la saisie
            sql.setString(1, auth);
            sql.setString(2, mdp);

            //Execution de la requete
            rst = sql.executeQuery();
            if (rst.next()) {
                System.out.print("->");
                System.out.println(rst.getString("login") + " ");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return cnx;
    }
    //methode pour authentifier le professor
    public static Connection AuthP(String login, String mdp){
        try {
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            //utilisation de PreparedStatement afin d'eviter les injection SQL pour securiser l'acces aux donnees
            PreparedStatement sql = cnx.prepareStatement("select login,mdp from professor where login=? AND mdp=?");
            sql.setString(1, login);
            sql.setString(2, mdp);
            //Execution de la requete
            rst = sql.executeQuery();
            if (rst.next()) {
                System.out.print("->");
                System.out.print(rst.getString("login") + " ");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return cnx;
    }

    public static Connection AuthS(String auth, String mdp) throws SQLException {
        try {
            //Appel la methode ConnectBase de ConnectDB pour faire la requete si le login et le MDP exite
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            //utilisation de PreparedStatement afin d'eviter les injection SQL
            //pour securiser ll'acces aux donnees
            PreparedStatement sql = cnx.prepareStatement("select login,mdp from student where login=? AND mdp=?");
            //Les champs de la methode qui se remplissent lors de la saisie
            sql.setString(1, auth);
            sql.setString(2, mdp);

            //Execution de la requete
            rst = sql.executeQuery();
            if (rst.next()) {
                System.out.print("->");
                System.out.println(rst.getString("login") + " ");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return cnx;
    }
}