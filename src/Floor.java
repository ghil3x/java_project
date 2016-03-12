import java.sql.PreparedStatement;
import java.util.List;

public class Floor extends Building {

    private final int num_floor;
    private final List<Classroom> classrooms;

    public Floor(int num_floor, List<Classroom> classrooms) {

        this.num_floor = num_floor;
        this.classrooms = classrooms;
    }
//ajout d'un floor dans la DB
    public static void addFloor(int fl){
        try{
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            PreparedStatement sql = cnx.prepareStatement("INSERT INTO floor(num_floor) VALUES (?)");
            sql.setInt(1, fl);
            sql.executeUpdate();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }
//suppresion d'un floor de la DB
    //pas besoin de cette methode sauf dans le cas, ou il y aura des traveaux ou bien changement de salle en bureaux
    public static void removeFloor(int idf){

        try{
            cnx = ConnectDB.ConnectBase();
            st = cnx.createStatement();
            PreparedStatement sql = cnx.prepareStatement("DELETE FROM floor where idf=?");
            sql.setInt(1, idf);
            sql.executeUpdate();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }


}
