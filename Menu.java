/**
 * Created by slima_000 on 09/01/2016.
 */
public class Menu {

    public static void MenuPrincipale() {
        System.out.println("Choisissez votre status : ");
        System.out.println("1->Administrator");
        System.out.println("2->Professor");
        System.out.println("3->Student ");
        System.out.println("00->Exit ");
    }

    public static void MenuAdmin(){
        System.out.println("1-> Add Slot.");
        System.out.println("2-> Update Slot.");
        System.out.println("3-> Remove Slot.");
        System.out.println("4-> Add Building.");
        System.out.println("5-> Add floor. ");
        System.out.println("6-> Add Professor.");
        System.out.println("7-> Add Student.");
        System.out.println("8-> Add Cours. ");
        System.out.println("9-> Add Formation. ");
        System.out.println("10-> Add Classroom. ");
        System.out.println("11-> Remove Classroom. ");
        System.out.println("12-> Remove Formation. ");
        System.out.println("13-> Remove Cours. ");
        System.out.println("14-> Remove Professor. ");
        System.out.println("15-> Remove student. ");
        System.out.println("15-> Remove Building. ");
        System.out.println("16-> Update Building.");
        System.out.println("17-> Update Professor.");
        System.out.println("18-> Update Student.");
        System.out.println("19-> Update Cours.");
        System.out.println("20-> Update Classroom.");
        System.out.println("21-> Update Formation.");
        System.out.println("21-> Reserved Classrom Slot to Cours.");
        System.out.println("00->Exit. ");
    }

    public static void Interface(){
        System.out.println("Que voulez-vousd faire ?");
        System.out.println("1->Menu");
        System.out.println("0->Logout.");
        System.out.println("00->Exit.");
    }


    public static void MenuProfessor(){
        System.out.println("1->Show Classroom at DATE.");
        System.out.println("2->Show classRoom with Group.");
        System.out.println("3->Show classRoom with Professor. ");
        System.out.println("4->Ask to reserve classrom slot to Cours. ");
        System.out.println("00->Exit. ");
    }

    public static void MenuStudent(){
        System.out.println("1->Show planing week.");
        System.out.println("00->Exit. ");
    }
}
