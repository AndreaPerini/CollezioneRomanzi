import java.util.*;

public class Collezione {

	private List<Romanzo> collezione = new ArrayList<>();

	public Collezione() {
	}

	public void aggiungiRomanzo(Romanzo r) {
		collezione.add(r);
		System.out.println("Romanzo aggiunto!");
	}

	public boolean rimuoviRomanzo(String nome) {
		for (int i = 0; i < collezione.size(); i++) {
			if (collezione.get(i).getTitolo().equalsIgnoreCase(nome)) {
				collezione.remove(i);
				System.out.println("Romanzo eliminato!");
				return true;
			}
		}
		return false;
	}

	public void cercaTitolo(String titolo) {
		for (int i = 0; i < collezione.size(); i++) {
			if (collezione.get(i).getTitolo().equalsIgnoreCase(titolo)) {
				System.out.println("Il romanzo " + collezione.get(i).getTitolo() + ", l'autore è "
						+ collezione.get(i).getAutore() + ", è stato pubblicato nel "
						+ collezione.get(i).getAnnoPubblicazione() + ", l'editore è " + collezione.get(i).getEditore());
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

//	public void filtraCollezione() {
//		boolean fine = false;
//		List<Romanzo> filtro = new ArrayList<>();
//		Scanner sc = new Scanner(System.in);
//		for (int i = 0; i < collezione.size(); i++) {
//			filtro.add(collezione.get(i));
//		}
//		do {
//			System.out.println(
//					"Seleziona cosa vuoi filtrare: titolo, autore, anno, editore, tipo\nsolo per i digitali puoi selezionare anche: formato, dimensione, supporto\nsolo per i cartacei puoi selezionare: copertina, stato, pagine\nPer stampare l'elenco filtrato scrivi fine");
//			switch (sc.next()) {
//			case "titolo":
//				break;
//			case "autore":
//				break;
//			case "anno":
//				break;
//			case "editore":
//				break;
//			case "tipo":
//				break;
//			case "formato":
//				break;
//			case "dimensione":
//				break;
//			case "supporto":
//				break;
//			case "copertina":
//				break;
//			case "stato":
//				break;
//			case "pagine":
//				break;
//			case "fine":
//				break;
//			default:
//				System.out.println("Inserimento non valido");
//			}
//		} while (fine);
//	}

}