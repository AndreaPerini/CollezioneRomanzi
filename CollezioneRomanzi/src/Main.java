import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean fine = false;
		Collezione c = new Collezione();
		do {
			System.out.println("Seleziona l'opzione da eseguire");
			System.out.println(
					"1. Aggiungi un nuovo romanzo\n2. Cancella un romanzo\n3. Ricerca per titolo\n4. Ricerca per autore\n5. Ricerca per data pubblicazione\n6. Filtra");
			System.out.println("Termina con 0");
			switch (sc.nextInt()) {
			case 0:
				fine = true;
				break;
			case 1:
				boolean scelta = false;
				System.out.println("Vuoi aggiungere un romanzo cartaceo?");
				if (sc.next().equalsIgnoreCase("si")) {
					sc.nextLine();
					Cartaceo ca = new Cartaceo();
					System.out.println("Inserisci il titolo");
					ca.setTitolo(sc.next());
					sc.nextLine();
					System.out.println("Inserisci l'autore");
					ca.setAutore(sc.next());
					sc.nextLine();
					System.out.println("Inserisci l'anno di pubblicazione");
					ca.setAnnoPubblicazione(sc.nextInt());
					sc.nextLine();
					System.out.println("Inserisci l'editore");
					ca.setEditore(sc.next());
					sc.nextLine();
					System.out.println("La copertina è rigida o molle?");
					do {
						String cop = sc.next();
						sc.nextLine();
						if (cop.equalsIgnoreCase("molle")) {
							ca.setCopertina(Cartaceo.Copertina.MOLLE);
							scelta = true;
						} else {
							if (cop.equalsIgnoreCase("rigida")) {
								ca.setCopertina(Cartaceo.Copertina.RIGIDA);
								scelta = true;
							} else {
								System.out.println("Inserimento errato");
							}
						}
					} while (!scelta);
					System.out.println("Inserisci lo stato di conservazione");
					ca.setStatoConservazione(sc.next());
					sc.nextLine();
					System.out.println("Inserisci il numero delle pagine");
					ca.setNumeroPagine(sc.nextInt());
					sc.nextLine();
					c.aggiungiRomanzo(ca);
				} else {
					Digitale d = new Digitale();
					System.out.println("Inserisci il titolo");
					d.setTitolo(sc.next());
					sc.nextLine();
					System.out.println("Inserisci l'autore");
					d.setAutore(sc.next());
					sc.nextLine();
					System.out.println("Inserisci l'anno di pubblicazione");
					d.setAnnoPubblicazione(sc.nextInt());
					sc.nextLine();
					System.out.println("Inserisci l'editore");
					d.setEditore(sc.next());
					sc.nextLine();
					System.out.println("Seleziona il formato tra epub, modi, pdf e azw");
					do {
						String form = sc.next();
						sc.nextLine();
						if (form.equalsIgnoreCase("epub")) {
							d.setFormato(Digitale.Formato.epub);
							scelta = true;
						} else {
							if (form.equalsIgnoreCase("modi")) {
								d.setFormato(Digitale.Formato.modi);
								scelta = true;
							} else {
								if (form.equalsIgnoreCase("pdf")) {
									d.setFormato(Digitale.Formato.pdf);
									scelta = true;
								} else {
									if (form.equalsIgnoreCase("azw")) {
										d.setFormato(Digitale.Formato.azw);
										scelta = true;
									} else {
										System.out.println("Inserimento errato");
									}
								}
							}

						}
					} while (!scelta);
					System.out.println("Inserisci la dimensione in megabyte");
					d.setDimensione(sc.nextInt());
					sc.nextLine();
					System.out.println("Inserisci il supporto tra cdrom e storage");
					scelta = false;
					do {
						String sup = sc.next();
						sc.nextLine();
						if (sup.equalsIgnoreCase("cdrom")) {
							d.setSupporto(Digitale.Supporto.cdrom);
							scelta = true;
						} else {
							if (sup.equalsIgnoreCase("storage")) {
								d.setSupporto(Digitale.Supporto.storage);
								scelta = true;
							} else {
								System.out.println("Inserimento errato");
							}
						}
					} while (!scelta);
					c.aggiungiRomanzo(d);
				}
				break;
			case 2:
				System.out.println("Inserisci il titolo del romanzo da eliminare");
				c.rimuoviRomanzo(sc.next());
				break;
			case 3:
				System.out.println("Inserisci il titolo del romanzo da ricercare");
				c.cercaTitolo(sc.next());
				break;
			case 4:
				System.out.println("Inserisci l'autore del romanzo da ricercare");
				c.ricercaAutore(sc.next());
				break;
			case 5:
				System.out.println("Inserisci la data di pubblicazione del romanzo da ricercare");
				c.pubblicatiData(sc.nextInt());
				break;
			case 6:
				break;
			default:
				System.out.println("Inserimento errato");
			}
		} while (!fine);
		sc.close();
	}

}