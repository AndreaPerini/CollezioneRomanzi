import java.util.*;

public class Collezione {

	private List<Romanzo> collezione = new ArrayList<>();

	public Collezione() {
	}

	public void aggiungiRomanzo(Romanzo r) {
		collezione.add(r);
	}

	public boolean rimuoviRomanzo(String nome) {
		for (int i = 0; i < collezione.size(); i++) {
			if (collezione.get(i).getTitolo().equalsIgnoreCase(nome)) {
				collezione.remove(i);
				return true;
			}
		}
		return false;
	}

	public void cercaTitolo(String titolo) {
		for (int i = 0; i < collezione.size(); i++) {
			if (collezione.get(i).getTitolo().equalsIgnoreCase(titolo)) {
				System.out.println("Il romanzo " + collezione.get(i).getTitolo() + ", l'autore � "
						+ collezione.get(i).getAutore() + ", � stato pubblicato nel "
						+ collezione.get(i).getAnnoPubblicazione() + ", l'editore � " + collezione.get(i).getEditore()
						+ "ed � " + collezione.get(i).getTipo());
			}
		}
		System.out.println("Romanzo non torvato");
	}

	public void ricercaAutore(String autore) {
		for (int i = 0; i < collezione.size(); i++) {
			if (collezione.get(i).getAutore().equalsIgnoreCase(autore)) {
				System.out.println(collezione.get(i).getTitolo());
			}
		}
		System.out.println("Nessun romanzo torvato");
	}

	public void pubblicatiData(int anno) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Vuoi cercare prima della data inserita?");
		if (sc.next().equalsIgnoreCase("no")) {
			for (int i = 0; i < collezione.size(); i++) {
				if (collezione.get(i).getAnnoPubblicazione() > anno) {
					System.out.println(collezione.get(i).getTitolo());
				}
			}
			System.out.println("Nessun romanzo trovato");
		} else {
			for (int i = 0; i < collezione.size(); i++) {
				if (collezione.get(i).getAnnoPubblicazione() < anno) {
					System.out.println(collezione.get(i).getTitolo());
				}
			}
			System.out.println("Nessun romanzo trovato");
		}
		sc.close();
	}

	public void filtraCollezione() {
		boolean fine = false;
		List<Romanzo> filtro = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < collezione.size(); i++) {
			filtro.add(collezione.get(i));
		}
		do {
			System.out.println(
					"Seleziona cosa vuoi filtrare: titolo, autore, anno, editore, tipo\nsolo per i digitali puoi selezionare anche: formato, dimensione, supporto\nsolo per i cartacei puoi selezionare: copertina, stato, pagine");
			switch (sc.next()) {
			// mettere i case
			}

		} while (fine);
	}

}