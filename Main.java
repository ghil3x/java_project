import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.Scanner;
import java.sql.Statement;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static Connection cnx;
    static Statement st;
    static ResultSet rst;

    public static void main(String[] args) throws SQLException {

        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd hh:mm");
        System.out.println("Current Date: " + ft.format(dNow));

        boolean logout = false;

        //Ajout d'une REGEXP afin de creer le format exact a la saisie de la date par l'admin
        String p = "^(20)\\d\\d/(0[1-9]|1[012])/(0[1-9]|[12][0-9]|3[0-1])\\s([0-1][0-9]|2[0-3]):([0-5][0-9])$";
        Pattern pattern = Pattern.compile(p);
        String login;
        String mdp;
        Scanner sc1 = new Scanner(System.in);
        // choix du USER
        Menu.MenuPrincipale();
        while (!logout) {
            String status = sc1.nextLine();
            if (Objects.equals(status, "1")) {// ADMIN
                //Saisi du login
                System.out.println("Login Admin : ");
                login = sc1.nextLine();
                //Saisi du MDP
                System.out.println("Password : ");
                mdp = sc1.nextLine();
                if (!Authentification.AuthA(login, mdp).isValid(0))
                    //appel de la methode d'authentification d'admin avec login et mdp
                    System.out.println("Loged as Administrator.");
                Menu.Interface();
                String choise = sc1.nextLine();
                //ajout d'un cours

                while (Objects.equals(choise, "1")) {
                    Menu.MenuAdmin();
                    //saisi du choi de l'admin
                    String choiseM = sc1.nextLine();
                    if (Objects.equals(choiseM, "1")) {
                        System.out.println("Cours ");
                        String cm = sc1.nextLine();
                        System.out.println("Date start ");
                        String dt = sc1.nextLine();
                        //methode Pattern.matcher pour matcher les dates avec la REGEX dans le bon format
                        //pour l'insertion dans la base de donnees
                        Matcher match = pattern.matcher(dt);
                        if (match.find()) {
                            Date dt_s = new Date(match.group(0));
                            System.out.println("Date End ");
                            String dt_end = sc1.nextLine();
                            match = pattern.matcher(dt_end);
                            if (match.find()) {
                                Date dt_e = new Date(match.group(0));
                                System.out.println("Module ");
                                String modul = sc1.nextLine();
                                System.out.println("Group ");
                                String grp = sc1.nextLine();
                                Slot.addSlot(cm, dt_s, dt_e, modul, grp);
                                System.out.println("You added a slot for the course :" + cm);

                            }
                        }
                        //UPDATE slot d'un cours donner
                    } else if (Objects.equals(choiseM, "2")) {
                        System.out.println("Cours ");
                        String cm = sc1.nextLine();
                        System.out.println("Date start ");
                        String dt = sc1.nextLine();
                        Matcher match = pattern.matcher(dt);

                        if (match.find()) {
                            Date dt_s = new Date(match.group(0));
                            System.out.println("Date End ");
                            String dt_end = sc1.nextLine();
                            match = pattern.matcher(dt_end);
                            if (match.find()) {
                                Date dt_e = new Date(match.group(0));
                                System.out.println("Group ");
                                String grp = sc1.nextLine();
                                Slot.updateSlot(cm, dt_s, dt_e, grp);
                                System.out.println("You update a slot for the course :" + cm);
                            }
                        }
                        //suppression d'un slot d'un cours dooner
                    } else if (Objects.equals(choiseM, "3")) {
                        System.out.println("Chose Slot to remove :");

                        if (!Show.showListSlot().isValid(0)) {
                            Show.showListSlot();
                        }
                        String idsl = sc1.nextLine();
                            Slot.removeSlot(Integer.parseInt(idsl));
                        System.out.println("Remove success");

                    } else if (Objects.equals(choiseM, "4")) {
                        //add building
                        System.out.println("What is a name for new BUILDING");
                        String nB = sc1.nextLine();
                        Building.addBuilding(nB);
                        System.out.println("Add success");

                    } else if (Objects.equals(choiseM, "5")) {
                        //add floor
                        System.out.println("What is a num for new FlOOR");
                        String fl = sc1.nextLine();
                        Floor.addFloor(Integer.parseInt(fl));
                        System.out.println("Add success");

                    } else if (Objects.equals(choiseM, "6")) {
                        //add professor
                        System.out.println("What is a name for new Professor ?");
                        String nam = sc1.nextLine();
                        System.out.println("What is a first name for new Professor ?");
                        String first_nam = sc1.nextLine();
                        System.out.println("What is a Login for new Professor ?");
                        String loginP = sc1.nextLine();
                        System.out.println("What is a Password for new Professor ?");
                        String mdpP = sc1.nextLine();
                        System.out.println("What is a tel for new Professor ?");
                        String tel = sc1.nextLine();
                        System.out.println("What is a email for new Professor ?");
                        String email = sc1.nextLine();
                        System.out.println("What is a Cours for new Professor ?");
                        String cm = sc1.nextLine();
                        Professor.addProf(nam,first_nam,loginP,mdpP,Integer.parseInt(tel),email,cm);
                        System.out.println("Add success");

                    } else if (Objects.equals(choiseM, "7")) {
                        //add student
                        System.out.println("What is a name for new Student ?");
                        String nam = sc1.nextLine();
                        System.out.println("What is a first name for new Student ?");
                        String first_nam = sc1.nextLine();
                        System.out.println("What is a Login for new Student?");
                        String loginP = sc1.nextLine();
                        System.out.println("What is a Password for new Student ?");
                        String mdpP = sc1.nextLine();
                        System.out.println("What is a tel for new Student ?");
                        String tel = sc1.nextLine();
                        System.out.println("What is a email for new Student ?");
                        String email = sc1.nextLine();
                        System.out.println("What is a num for new Student ?");
                        String num_student = sc1.nextLine();
                        System.out.println("What is a Formation for new Student ?");
                        String fr = sc1.nextLine();
                        System.out.println("What is a group for new Student ?");
                        String gr = sc1.nextLine();
                        Student.addStudent(nam, first_nam, loginP, mdpP, Integer.parseInt(tel), email, Integer.parseInt(num_student),fr, Integer.parseInt(gr));
                        System.out.println("Add success");

                    }else if (Objects.equals(choiseM, "8")) {
                        //add cours
                        System.out.println("What is a name for Cours?");
                        String namC = sc1.nextLine();

                        System.out.println("What is a Professor ?");
                        if (!Show.showListProfessor().isValid(0)) {
                            Show.showListProfessor();
                        }
                        String Professor = sc1.nextLine();

                        System.out.println("In which building ?");
                        if (!Show.showListBuilding().isValid(0)) {
                            Show.showListBuilding();
                        }
                        String Building = sc1.nextLine();
                        System.out.println("In which Floor?");
                        if (!Show.showListFloor().isValid(0)) {
                            Show.showListFloor();
                        }
                        String Floor = sc1.nextLine();
                        System.out.println("In which Classroom?");
                        if (!Show.showListClassroom().isValid(0)) {
                            Show.showListClassroom();
                        }
                        String Classroom = sc1.nextLine();
                        System.out.println("In which Formation?");
                        if (!Show.showListFormation().isValid(0)) {
                            Show.showListFormation();
                        }
                        String Formation = sc1.nextLine();

                        System.out.println("Is it optional or Not? tape : TRUE OR FALSE");
                        String opt = sc1.nextLine();
                        System.out.println("Reserved");
                        String res = sc1.nextLine();
                        Cours.addCours(namC,Professor,Building,Integer.parseInt(Floor),Classroom,Formation,Boolean.parseBoolean(opt),Boolean.parseBoolean(res));
                        System.out.println("Add success");
                    }else if (Objects.equals(choiseM, "9")) {
                        //add formation
                        System.out.println("What is a name for new Formation");
                        String fr = sc1.nextLine();
                        Formation.addFormation(fr);
                        System.out.println("Add success");

                    }else if (Objects.equals(choiseM, "10")) {
                        //add Classroom
                        System.out.println("What is a name for new Classroom");
                        String namC = sc1.nextLine();
                        System.out.println("Whow much places have this Cassroom");
                        String cpt = sc1.nextLine();
                        Classroom.addClassroom(namC,Integer.parseInt(cpt));
                        System.out.println("Add success");

                    }else if (Objects.equals(choiseM, "11")){
                        System.out.println("Chose Classroom to remove :");
                        if (!Show.showListClassroom().isValid(0)) {
                            Show.showListClassroom();
                        }
                        String idcl = sc1.nextLine();
                        Classroom.removeClassroom(Integer.parseInt(idcl));
                        System.out.println("Remove success");

                    }else if (Objects.equals(choiseM, "12")){
                        System.out.println("Chose Formation to remove :");

                        if (!Show.showListFormation().isValid(0)) {
                            Show.showListFormation();
                        }
                        String idf = sc1.nextLine();
                        Formation.removeFormation(Integer.parseInt(idf));
                        System.out.println("Remove success");

                    }else if (Objects.equals(choiseM, "13")){
                        System.out.println("Chose Cours to remove :");

                        if (!Show.showListCours().isValid(0)) {
                            Show.showListCours();
                        }
                        String idc = sc1.nextLine();
                        Cours.removeCours(Integer.parseInt(idc));
                        System.out.println("Remove success");

                    }else if (Objects.equals(choiseM, "14")){
                        System.out.println("Chose Professor to remove :");

                        if (!Show.showListProfessor().isValid(0)) {
                            Show.showListProfessor();
                        }
                        String idp = sc1.nextLine();
                        Professor.removeProfessor(Integer.parseInt(idp));
                        System.out.println("Remove success");

                    }else if (Objects.equals(choiseM, "15")){
                        System.out.println("Chose Student to remove :");

                        if (!Show.showListStudent().isValid(0)) {
                            Show.showListStudent();
                        }
                        String ids = sc1.nextLine();
                        Student.removeStudent(Integer.parseInt(ids));
                        System.out.println("Remove success");

                    }else if (Objects.equals(choiseM, "16")){
                        System.out.println("Chose Building to remove :");

                        if (!Show.showListBuilding().isValid(0)) {
                            Show.showListBuilding();
                        }
                        String ids = sc1.nextLine();
                        Building.removeBuilding(Integer.parseInt(ids));
                        System.out.println("Remove success");

                    }else if (Objects.equals(choiseM, "17")){
                        System.out.println("Chose Professor to update :");

                        if (!Show.showListProfessor().isValid(0)) {
                            Show.showListProfessor();
                        }
                        String sPro = sc1.nextLine();
                        //Professor.SelectProfessor(Integer.parseInt(sPro));
                        System.out.println("New Login :");
                        String nLogin = sc1.nextLine();
                        System.out.println("New Password :");
                        String nMdp = sc1.nextLine();
                        System.out.println("New Cours :");
                        String nCours = sc1.nextLine();
                        Professor.updateProfessor(Integer.parseInt(sPro),nLogin,nMdp,nCours);
                        System.out.println("Update success");

                    }else if (Objects.equals(choiseM, "18")){
                        //update Student
                        System.out.println("Chose Student to update :");
                        if(Show.showListStudent().isValid(0)) {
                            Show.showListStudent();
                        }
                    }else if (Objects.equals(choiseM, "19")){
                        System.out.println("Chose Cours to update :");

                        if (!Show.showListCours().isValid(0)) {
                            Show.showListCours();
                        }
                        String idC = sc1.nextLine();
                        System.out.println("New Date and Time start :");
                        String cdt = sc1.nextLine();

                        Matcher match = pattern.matcher(cdt);
                        if (match.find()) {
                            Date dt_s = new Date(match.group(0));
                            System.out.println("New Date and Time end  :");
                            String cdt_end = sc1.nextLine();
                            match = pattern.matcher(cdt_end);
                            if (match.find()) {
                                Date dt_e = new Date(match.group(0));
                                System.out.println("New Building :");
                                String cbuil = sc1.nextLine();
                                System.out.println("New Floor :");
                                String cFloor = sc1.nextLine();
                                System.out.println("New Classroom :");
                                String cClass = sc1.nextLine();
                                System.out.println("New Professor :");
                                String cProf= sc1.nextLine();
                                System.out.println("New Formation :");
                                String cFor= sc1.nextLine();
                                System.out.println("Is this Optional : (TAPE TRUE OF FALSE)");
                                String cOpt = sc1.nextLine();
                                System.out.println("New Group :");
                                String cGr = sc1.nextLine();
                                Cours.updateCours(Integer.parseInt(idC), dt_s, dt_e, cbuil, Integer.parseInt(cFloor), cClass, cProf, cFor, Boolean.parseBoolean(cOpt), Integer.parseInt(cGr));
                                System.out.println("Update success");
                            }
                        }


                    }else if (Objects.equals(choiseM, "20")){
                        System.out.println("Chose Classroom to update :");
//pas le temps de la finir
                        if (!Show.showListClassroom().isValid(0)) {
                            Show.showListClassroom();
                        }
                    }else if (Objects.equals(choiseM, "21")){
                        System.out.println("Chose Formation to update :");
//pas le temps de la finir
                        if (!Show.showListFormation().isValid(0)) {
                            Show.showListFormation();
                        }
                    }else if (Objects.equals(choiseM, "22")){
                        System.out.println("Reserved Classrom Slot to Course :");
                        System.out.println("Name of Cour ");
                        String cm = sc1.nextLine();
                        System.out.println("Date & Time statr ");
                        String dt = sc1.nextLine();
                        Matcher match = pattern.matcher(dt);

                        if (match.find()) {
                            Date dt_s = new Date(match.group(0));
                            System.out.println("Date & Time End ");
                            String dt_end = sc1.nextLine();
                            match = pattern.matcher(dt_end);
                            if (match.find()) {
                                Date dt_e = new Date(match.group(0));
                                System.out.println("Building ");
                                String buil = sc1.nextLine();
                                System.out.println("Floor ");
                                String floor = sc1.nextLine();
                                System.out.println("Classroom ");
                                String classroom = sc1.nextLine();
                                System.out.println("Professor ");
                                String prof = sc1.nextLine();
                                System.out.println("formation ");
                                String form = sc1.nextLine();
                                System.out.println("Is this Optional? (Tape TRUE or FALSE) ");
                                String opt = sc1.nextLine();
                                System.out.println("Group ");
                                String grp = sc1.nextLine();
                                System.out.println("Reserved!. (Tape TRUE)");
                                String res = sc1.nextLine();
                                Cours.ReservedClassroomToCours(cm, dt_s, dt_e, buil, Integer.parseInt(floor), classroom, prof, form, Boolean.parseBoolean(opt), Integer.parseInt(grp), Boolean.parseBoolean(res));
                                System.out.println("You Reserved Classroom slot for a course :" + cm);
                            }
                        }



                    }

                    if (Objects.equals(choiseM, "00")) {
                        System.exit(0);
                    }

                } if (Objects.equals(choise, "0")) {
                    Disconnect.Exit();
                    Menu.MenuPrincipale();
                } if (Objects.equals(choise, "00")) {
                    System.exit(0);
                }
//Professor ----------->
            } else if (Objects.equals(status, "2")) {// Professor
                //Saisi du login
                System.out.println("Login Professor : ");
                login = sc1.nextLine();
                //Saisi du MDP
                System.out.println("Password : ");
                mdp = sc1.nextLine();
                if (!Authentification.AuthP(login, mdp).isValid(0))
                    //appel de la methode d'authentification d'admin avec login et mdp
                    System.out.println("Loged as Professor.");
                Menu.Interface();
                String choise = sc1.nextLine();
                //ajout d'un cours
                while (Objects.equals(choise, "1")) {
                    Menu.MenuProfessor();
                    //saisi du choi du Professor
                    String choiseM = sc1.nextLine();
                    if (Objects.equals(choiseM, "1")) {
                        //Show Classroom at DATE
                        System.out.println("Tape False:");
                        String reser = sc1.nextLine();
                        Show.showListClassroomLibr().isValid(0);

                    } else if (Objects.equals(choiseM, "2")) {
                        //Show classRoom with Group
                        System.out.println("Which Group ?:");
                        String reser = sc1.nextLine();
                        Show.showListClassroomusedByGr(reser);

                    } else if (Objects.equals(choiseM, "3")) {
                        //Show Classroom With Professor take
                        System.out.println("Which Professor ?:");
                        String byPr = sc1.nextLine();
                        Show.showListClassroomusedByProf(byPr);

                    }else if (Objects.equals(choiseM, "4")) {
                        //Show Classroom With Professor take
                        System.out.println("Ask to reserve classrom slot to Cours:");
                        String byPr = sc1.nextLine();
                        Person.SentMsgToAdmin(byPr);
                    }
                    if (Objects.equals(choiseM, "00")) {
                        System.exit(0);
                    }
                } if (Objects.equals(choise, "0")) {
                    Disconnect.Exit();
                    Menu.MenuPrincipale();
                } if (Objects.equals(choise, "00")) {
                    System.exit(0);
                }
//Student----------->
            } else if (Objects.equals(status, "3")) {
                System.out.println("Login Student : ");
                login = sc1.nextLine();
                //Saisi du MDP
                System.out.println("Password : ");
                mdp = sc1.nextLine();
                if (!Authentification.AuthS(login, mdp).isValid(0))
                    //appel de la methode d'authentification d'admin avec login et mdp
                    System.out.println("Loged as Student.");
                Menu.Interface();
                String choise = sc1.nextLine();
                //ajout d'un cours
                while (Objects.equals(choise, "1")) {
                    Menu.MenuStudent();
                    //saisi du choi du Professor
                    String choiseM = sc1.nextLine();
                    if (Objects.equals(choiseM, "1")) {
                        // A faire
                    }
                    if (Objects.equals(choiseM, "00")) {
                        System.exit(0);
                    }
                }
            } else if (Objects.equals(status, "00")) {
                System.out.println("GoodBye");
                System.exit(0);
            }
        }
    }
}