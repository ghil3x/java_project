import java.util.ArrayList;
import java.util.List;

public class Group {

    private final String nom;
    //private final TypeGroupe type;
    private List<Cours> cours;
    private List<Student> students;
    private List<Professor> professors;

    public Group(String nom) {
        this.nom = nom;
        this.cours = new ArrayList<>();
        this.students = new ArrayList<>();
        this.professors = new ArrayList<>();
    }

    public List<Cours> getCours() {
        return cours;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public String getNom() {
        return nom;
    }

    /*public TypeGroupe getType() {
        return type;
    }*/

    public void addStudents(List<Student> l) {
        students.addAll(l);
    }

    public void addProfessor(List<Professor> l1) {
        professors.addAll(l1);
    }

    public void addCours(List<Cours> l) {
        for (Cours c : l) {
            for (Classroom s : University.getSalles()) {
                //if (s.getName().equals(c.getClassroom())) {
                    //if (s.addSlot(c.getSlot()))
                        cours.add(c);
                }
            }
        }

    public void ShowListCours() {

        System.out.print("[ ");
        for (Cours c : cours) {
            System.out.print(c.getModul() + " ");
        }
        System.out.println("]");
    }

    public void ShowListEtu() {

            System.out.print("[ ");
            for (Student e : students) {
                System.out.print(e.getName() + " -> " + e.getId() + " ; ");
            }
            System.out.println(" ]");
        }

}