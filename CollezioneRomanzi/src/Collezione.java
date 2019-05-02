import java.util.*;

public class Collezione {

	private List<Romanzo> collezione = new ArrayList<>();
	private Scanner sc;

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

	public boolean cercaTitolo(String titolo) {
		for (int i = 0; i < collezione.size(); i++) {
			if (collezione.get(i).getTitolo().equalsIgnoreCase(titolo)) {
				System.out.println("Il romanzo " + collezione.get(i).getTitolo() + ", l'autore è "
						+ collezione.get(i).getAutore() + ", è stato pubblicato nel "
						+ collezione.get(i).getAnnoPubblicazione() + ", l'editore è " + collezione.get(i).getEditore());
				return true;
			}
		}
		System.out.println("Romanzo non torvato");
		return false;
	}

	public boolean ricercaAutore(String autore) {
		for (int i = 0; i < collezione.size(); i++) {
			if (collezione.get(i).getAutore().equalsIgnoreCase(autore)) {
				System.out.println(collezione.get(i).getTitolo());
				return true;
			}
		}
		System.out.println("Nessun romanzo trovato");
		return false;
	}

	public boolean pubblicatiData(int anno) {
		sc = new Scanner(System.in);
		System.out.println("Vuoi cercare prima della data inserita?");
		if (sc.next().equalsIgnoreCase("no")) {
			for (int i = 0; i < collezione.size(); i++) {
				if (collezione.get(i).getAnnoPubblicazione() > anno) {
					System.out.println(collezione.get(i).getTitolo());
					return true;
				}
			}
			System.out.println("Nessun romanzo trovato");
			return false;
		} else {
			for (int i = 0; i < collezione.size(); i++) {
				if (collezione.get(i).getAnnoPubblicazione() < anno) {
					System.out.println(collezione.get(i).getTitolo());
					return true;
				}
			}
			System.out.println("Nessun romanzo trovato");
			return false;
		}
	}

	public void filtraCollezione() {
		boolean fine = false;
		List<Romanzo> filtro = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < collezione.size(); i++) {
			filtro.add(collezione.get(i));
		}
		String stringa;
		int intero;
		do {
			System.out.println(
					"Vuoi filtrare per autore, per anno di pubblicazione, per editore, per cartaceo o per digitale?");
			switch (sc.next()) {
			case "autore":
				System.out.println("Inserisci l'autore da filtrare");
				stringa = sc.next();
				for (int i = 0; i < filtro.size(); i++) {
					if (filtro.get(i).getAutore().equalsIgnoreCase(stringa))
						System.out.println(filtro.get(i).getTitolo());
				}
				break;
			case "anno di pubblicazione":
				System.out.println("Inserisci l'anno da filtrare");
				intero = sc.nextInt();
				for (int i = 0; i < filtro.size(); i++) {
					if (filtro.get(i).getAnnoPubblicazione() == intero)
						System.out.println(filtro.get(i).getTitolo());
				}
				break;
			case "editore":
				System.out.println("Inserisci l'editore da filtrare");
				stringa = sc.next();
				for (int i = 0; i < filtro.size(); i++) {
					if (filtro.get(i).getEditore().equalsIgnoreCase(stringa))
						System.out.println(filtro.get(i).getTitolo());
				}
				break;
			case "cartaceo":
				System.out.println(
						"Vuoi filtrare per autore, per anno di pubblicazione, per editore, per cartaceo, per copertina, per stato di conservazione o per numero pagine?");
				switch (sc.next()) {
				case "autore":
					System.out.println("Inserisci l'autore da filtrare");
					stringa = sc.next();
					for (int i = 0; i < filtro.size(); i++) {
						if (filtro.get(i) instanceof Cartaceo)
							if (filtro.get(i).getAutore().equalsIgnoreCase(stringa))
								System.out.println(filtro.get(i).getTitolo());
					}
					break;
				case "anno di pubblicazione":
					System.out.println("Inserisci l'anno da filtrare");
					intero = sc.nextInt();
					for (int i = 0; i < filtro.size(); i++) {
						if (filtro.get(i) instanceof Cartaceo)
							if (filtro.get(i).getAnnoPubblicazione() == intero)
								System.out.println(filtro.get(i).getTitolo());
					}
					break;
				case "editore":
					System.out.println("Inserisci l'editore da filtrare");
					stringa = sc.next();
					for (int i = 0; i < filtro.size(); i++) {
						if (filtro.get(i) instanceof Cartaceo)
							if (filtro.get(i).getEditore().equalsIgnoreCase(stringa))
								System.out.println(filtro.get(i).getTitolo());
					}
					break;
				case "copertina":
//					System.out.println("Inserisci la copertina da filtrare tra rigida e molle");
//					stringa = sc.next();
//					for (int i = 0; i < filtro.size(); i++) {
//						if (filtro.get(i) instanceof Cartaceo) {
//							if(stringa.equalsIgnoreCase("rigida")) {
//								//come comparare degli enum
//									System.out.println(filtro.get(i).getTitolo());
//							}
//							if(stringa.equalsIgnoreCase("molle")) {
//								
//							}
//						}
//					}
					break;
				case "stato di conservazione":
					// System.out.println("Inserisci l'editore da filtrare");
					// stringa = sc.next();
					// for (int i = 0; i < filtro.size(); i++) {
					// if (filtro.get(i) instanceof Cartaceo) {
					// if ((Cartaceo) filtro.get(i).getStatoConservazione.equalsIgnoreCase(stringa))
					// System.out.println(filtro.get(i).getTitolo());
					// }
					// }
					break;
				case "numero pagine":
					// System.out.println("Inserisci il numero di pagine da filtrare");
					// intero = sc.nextInt();
					// for (int i = 0; i < filtro.size(); i++) {
					// if (filtro.get(i) instanceof Cartaceo) {
					// if ((Cartaceo) filtro.get(i).getNumeroPagine() == intero)
					// System.out.println(filtro.get(i).getTitolo());
					// }
					// }
					break;
				case "cartaceo":
					for (int i = 0; i < filtro.size(); i++) {
						if (filtro.get(i) instanceof Cartaceo)
							System.out.println(filtro.get(i).getTitolo());
					}
					break;
				}
				break;
			case "digitali":
				System.out.println(
						"Vuoi filtrare per autore, per anno di pubblicazione, per editore, per digitale, per formato, per dimensione o per supporto?");
				switch (sc.next()) {
				case "autore":
					System.out.println("Inserisci l'autore da filtrare");
					stringa = sc.next();
					for (int i = 0; i < filtro.size(); i++) {
						if (filtro.get(i) instanceof Digitale) {
							if (filtro.get(i).getAutore().equalsIgnoreCase(stringa))
								System.out.println(filtro.get(i).getTitolo());
						}
					}
					break;
				case "anno di pubblicazione":
					System.out.println("Inserisci l'anno da filtrare");
					intero = sc.nextInt();
					for (int i = 0; i < filtro.size(); i++) {
						if (filtro.get(i) instanceof Digitale) {
							if (filtro.get(i).getAnnoPubblicazione() == intero)
								System.out.println(filtro.get(i).getTitolo());
						}
					}
					break;
				case "editore":
					System.out.println("Inserisci l'editore da filtrare");
					stringa = sc.next();
					for (int i = 0; i < filtro.size(); i++) {
						if (filtro.get(i) instanceof Digitale) {
							if (filtro.get(i).getEditore().equalsIgnoreCase(stringa))
								System.out.println(filtro.get(i).getTitolo());
						}
					}
					break;
				case "digitale":
					for (int i = 0; i < filtro.size(); i++) {
						if (filtro.get(i) instanceof Digitale)
							System.out.println(filtro.get(i).getTitolo());
					}
					break;
				case "formato":

					break;
				case "dimensione":
//					System.out.println("Inserisci il numero di pagine da filtrare");
//					intero = sc.nextInt();
//					for (int i = 0; i < filtro.size(); i++) {
//						if (filtro.get(i) instanceof Digitale) {
//							if ((Digitale) filtro.get(i).getDimensione() == intero)
//								System.out.println(filtro.get(i).getTitolo());
//						}
//					}
					break;
				case "supporto":

					break;
				}
				break;
			default:
				System.out.println("Vuoi terminare?");
				if (sc.next().equalsIgnoreCase("si"))
					fine = true;
			}
		} while (!fine);
		sc.close();
	}

}