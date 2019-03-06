import java.util.*;

public class Collezione {

	private List <Romanzo> collezione = new ArrayList<>();

	public Collezione() {
	}
	
	public void aggiungiRomanzo(Romanzo r) {
		collezione.add(r);
	}
	
	public boolean rimuoviRomanzo(String nome) {
		for(int i=0; i<collezione.size(); i++) {
			if(collezione.get(i).getTitolo().equalsIgnoreCase(nome)) {
				collezione.remove(i);
				return true;
			}
		}
		return false;
	}
	
	
	
	
}
