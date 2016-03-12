import java.util.ArrayList;
import java.util.List;

public class Hall {

	private final String name;
	private List<Group> groups;
	private List<Cours> cm;

	public Hall(String name) {
		this.name = name;
		this.groups = new ArrayList<>();
	}

	public List<Group> getGroups() {
		return groups;
	}
	public String getName() {
		return name;
	}
	public List<Cours> getCm() {
		return cm;
	}

	public void addGroups(List<Group> g){
		groups.addAll(g);
	}

	public void addStudents(List<Student> l, String groupe){
		groups.forEach((g) -> {
			if(g.getNom().equals(groupe))
				g.addStudents(l);
			});
	}

	public void addCours(List<Cours> cm,String groupe){
		groups.forEach((g) -> {
			if (g.getCours().equals(groupe))
				g.addCours(cm);
		});
	}
}
