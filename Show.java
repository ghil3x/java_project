import java.sql.*;

/**
 * Created by slima_000 on 09/01/2016.
 */
public class Show {
    static Connection cnx;
    static Statement st;
    static ResultSet rst;
//liste des creneau
    public static Connection showListSlot() throws SQLException {
        try {
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            //utilisation de PreparedStatement afin d'eviter les injection SQL
            //pour securiser ll'acces aux donnees
            PreparedStatement sql = cnx.prepareStatement("select * from slot order by idsl");
            //Execution de la requete
            rst = sql.executeQuery();

            while(rst.next()) {
                System.out.print("->");
                System.out.print(rst.getString("idsl") + " | ");
                System.out.print(rst.getString("cm") + " | ");
                System.out.print(rst.getString("dt") + " | ");
                System.out.println(rst.getString("dt_end") + " | ");
                //System.out.println(rst.getString("mdp")+" ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cnx;
    }
//liste des professeur
    public static Connection showListProfessor() throws SQLException {
        try {
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            //utilisation de PreparedStatement afin d'eviter les injection SQL
            //pour securiser ll'acces aux donnees
            PreparedStatement sql = cnx.prepareStatement("select * from professor order by idp");

            //Execution de la requete
            rst = sql.executeQuery();
            //Affichage de tous les Prof
            while(rst.next()) {
                System.out.print("->");
                System.out.print(rst.getString("idp") + " | ");
                System.out.print(rst.getString("nam") + " | ");
                System.out.print(rst.getString("first_nam") + " | ");
                System.out.print(rst.getString("tel") + " | ");
                System.out.print(rst.getString("email") + " | ");
                System.out.println(rst.getString("cm") + " | ");
                //System.out.println(rst.getString("mdp")+" ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cnx;
    }
    //Afrfichage d'un professor en particulier
    public static Connection showProfessor(String nam) throws SQLException {
        try {
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            //utilisation de PreparedStatement afin d'eviter les injection SQL
            //pour securiser ll'acces aux donnees
            PreparedStatement sql = cnx.prepareStatement("select * from professor where nam=? order by idp");
            //Execution de la requete
            rst = sql.executeQuery();
            //Affichage de tous les Prof
            while(rst.next()) {
                System.out.print("->");
                System.out.print(rst.getString("idp") + " | ");
                System.out.print(rst.getString("nam") + " | ");
                System.out.print(rst.getString("first_nam") + " | ");
                System.out.print(rst.getString("tel") + " | ");
                System.out.print(rst.getString("email") + " | ");
                System.out.println(rst.getString("cm") + " | ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cnx;
    }
//affiche la lsite de tous les cours
    public static Connection showListCours() throws SQLException {
        try {
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            //utilisation de PreparedStatement afin d'eviter les injection SQL
            //pour securiser ll'acces aux donnees
            PreparedStatement sql = cnx.prepareStatement("select * from cours order by idc");

            //sql.setString(2, mdp);
            //String sql = ("select login,mdp from admin where login='"+auth+"' AND mdp='"+mdp+"'");
            //Execution de la requete
            rst = sql.executeQuery();
            while(rst.next()) {
                System.out.print("->");
                System.out.print(rst.getInt("idc") + " | ");
                System.out.print(rst.getString("nam") + " | ");
                System.out.print(rst.getTimestamp("dt") + " | ");
                System.out.print(rst.getTimestamp("dt_end") + " | ");
                System.out.print(rst.getString("building") + " | ");
                System.out.print(rst.getInt("num_floor") + " | ");
                System.out.print(rst.getString("classroom") + " | ");
                System.out.print(rst.getString("professor") + " | ");
                System.out.print(rst.getString("formation") + " | ");
                System.out.print(rst.getString("opt") + " | ");
                System.out.println(rst.getInt("gr") + " | ");
                //System.out.println(rst.getString("mdp")+" ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cnx;
    }
//liste de les etages
    public static Connection showListFloor() throws SQLException {
        try {
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            //utilisation de PreparedStatement afin d'eviter les injection SQL
            //pour securiser ll'acces aux donnees
            PreparedStatement sql = cnx.prepareStatement("select * from floor order by idf");

            //sql.setString(2, mdp);
            //String sql = ("select login,mdp from admin where login='"+auth+"' AND mdp='"+mdp+"'");
            //Execution de la requete
            rst = sql.executeQuery();

            while(rst.next()) {
                System.out.print("->");
                System.out.print(rst.getString("idf") + " | ");
                System.out.println(rst.getString("num_floor") + " | ");
                //System.out.println(rst.getString("mdp")+" ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cnx;
    }
//Liste des classes
    public static Connection showListClassroom() throws SQLException {
        try {
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            //utilisation de PreparedStatement afin d'eviter les injection SQL
            //pour securiser ll'acces aux donnees
            PreparedStatement sql = cnx.prepareStatement("select * from classroom order by idcl");

            //sql.setString(2, mdp);
            //String sql = ("select login,mdp from admin where login='"+auth+"' AND mdp='"+mdp+"'");
            //Execution de la requete
            rst = sql.executeQuery();

            while(rst.next()) {
                System.out.print("->");
                System.out.print(rst.getString("idcl") + " | ");
                System.out.print(rst.getString("building") + " | ");
                System.out.println(rst.getString("floor") + " | ");
                //System.out.println(rst.getString("mdp")+" ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cnx;
    }
//liste des formation
    public static Connection showListFormation() throws SQLException {
        try {
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            //utilisation de PreparedStatement afin d'eviter les injection SQL
            //pour securiser ll'acces aux donnees
            PreparedStatement sql = cnx.prepareStatement("select * from formation order by idf");

            //sql.setString(2, mdp);
            //String sql = ("select login,mdp from admin where login='"+auth+"' AND mdp='"+mdp+"'");
            //Execution de la requete
            rst = sql.executeQuery();

            while(rst.next()) {
                System.out.print("->");
                System.out.print(rst.getString("idf") + " | ");
                System.out.println(rst.getString("nam") + " | ");
                //System.out.println(rst.getString("mdp")+" ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cnx;
    }
//List de batiments de l'universite
    public static Connection showListBuilding() throws SQLException {
        try {
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            //utilisation de PreparedStatement afin d'eviter les injection SQL
            //pour securiser ll'acces aux donnees
            PreparedStatement sql = cnx.prepareStatement("select * from building order by idb");
            //Execution de la requete
            rst = sql.executeQuery();

            while(rst.next()) {
                System.out.print("->");
                System.out.print(rst.getString("idb") + " | ");
                System.out.println(rst.getString("nam") + " | ");
                //System.out.println(rst.getString("mdp")+" ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cnx;
    }
 //List des université
    public static Connection showListUniversity() throws SQLException {
        try {
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            //utilisation de PreparedStatement afin d'eviter les injection SQL
            //pour securiser ll'acces aux donnees
            PreparedStatement sql = cnx.prepareStatement("select * from universite order by idu");
            //Execution de la requete
            rst = sql.executeQuery();

            while(rst.next()) {
                System.out.print("->");
                System.out.print(rst.getString("idu") + " | ");
                System.out.println(rst.getString("nam") + " | ");
                //System.out.println(rst.getString("mdp")+" ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cnx;
    }
//liste des students
    public static Connection showListStudent() throws SQLException {
        try {
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            //utilisation de PreparedStatement afin d'eviter les injection SQL
            //pour securiser ll'acces aux donnees
            PreparedStatement sql = cnx.prepareStatement("select * from student where nam=? order by ids");
            //Execution de la requete
            rst = sql.executeQuery();
            //Affichage de tous les students

            while(rst.next()) {
                System.out.print("->");
                System.out.print(rst.getString("ids") + " | ");
                System.out.print(rst.getString("nom") + " | ");
                System.out.print(rst.getString("prenom") + " | ");
                System.out.print(rst.getString("tel") + " | ");
                System.out.print(rst.getString("email") + " | ");
                System.out.print(rst.getString("num_student") + " | ");
                System.out.print(rst.getString("formation") + " | ");
                System.out.println(rst.getString("gr") + " | ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cnx;
    }

    public static Connection showListClassroomLibr() throws SQLException {
        try {
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            //utilisation de PreparedStatement afin d'eviter les injection SQL
            //pour securiser ll'acces aux donnees
            PreparedStatement sql = cnx.prepareStatement("select classroom from cours where res="+false+"");
            //Execution de la requete
            rst = sql.executeQuery();
            //Affichage de tous les students

            while(rst.next()) {
                System.out.print("->");
                //System.out.print(rst.getString("idc") + " | ");
                System.out.println(rst.getString("classroom") + " | ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cnx;
    }

    public static Connection showListClassroomusedByGr(String gr) throws SQLException {
        try {
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            //utilisation de PreparedStatement afin d'eviter les injection SQL
            //pour securiser ll'acces aux donnees
            PreparedStatement sql = cnx.prepareStatement("select classroom from cours where gr=?");
            //Execution de la requete
            sql.setString(1,gr);
            rst = sql.executeQuery();
            //Affichage de tous les students

            while(rst.next()) {
                System.out.print("->");
                //System.out.print(rst.getString("idc") + " | ");
                System.out.println(rst.getString("classroom") + " | ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cnx;
    }

    public static Connection showListClassroomusedByProf(String Pro) throws SQLException {
        try {
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            //utilisation de PreparedStatement afin d'eviter les injection SQL
            //pour securiser ll'acces aux donnees
            PreparedStatement sql = cnx.prepareStatement("select classroom from cours where professor=?");
            //Execution de la requete
            sql.setString(1,Pro);
            rst = sql.executeQuery();
            //Affichage de tous les students

            while(rst.next()) {
                System.out.print("->");
                System.out.println(rst.getString("classroom") + " | ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cnx;
    }




}


