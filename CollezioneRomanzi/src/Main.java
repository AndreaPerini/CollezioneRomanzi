import java.util.*;
import java.io.FileReader;
import java.io.BufferedReader;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean fine = false;
		boolean giusto = false;
		String sce;
		Collezione c = new Collezione();
		try {
			BufferedReader in = new BufferedReader(new FileReader("C:\\Andrea\\Scuola\\File\\Romanzi.txt"));
			String s = new String();
			String[] riga;
			Cartaceo cartaceo = new Cartaceo();
			Digitale digitale = new Digitale();
			do {
				s = in.readLine();
				if (s != null) {
					riga = s.split("\\|");
					if (riga[0].equalsIgnoreCase("cartaceo")) {
						cartaceo.setTitolo(riga[1]);
						cartaceo.setAutore(riga[2]);
						cartaceo.setAnnoPubblicazione(Integer.parseInt(riga[3]));
						cartaceo.setEditore(riga[4]);
						if (riga[5].equalsIgnoreCase("rigida"))
							cartaceo.setCopertina(Cartaceo.Copertina.RIGIDA);
						if (riga[5].equalsIgnoreCase("molle"))
							cartaceo.setCopertina(Cartaceo.Copertina.MOLLE);
						cartaceo.setStatoConservazione(riga[6]);
						cartaceo.setNumeroPagine(Integer.parseInt(riga[7]));
						c.aggiungiRomanzo(cartaceo);
					} else {
						digitale.setTitolo(riga[1]);
						digitale.setAutore(riga[2]);
						digitale.setAnnoPubblicazione(Integer.parseInt(riga[3]));
						digitale.setEditore(riga[4]);
						if (riga[5].equalsIgnoreCase("epub"))
							digitale.setFormato(Digitale.Formato.epub);
						if (riga[5].equalsIgnoreCase("modi"))
							digitale.setFormato(Digitale.Formato.modi);
						if (riga[5].equalsIgnoreCase("pdf"))
							digitale.setFormato(Digitale.Formato.pdf);
						if (riga[5].equalsIgnoreCase("azw"))
							digitale.setFormato(Digitale.Formato.azw);
						digitale.setDimensione(Integer.parseInt(riga[6]));
						if (riga[7].equalsIgnoreCase("cdrom"))
							digitale.setSupporto(Digitale.Supporto.cdrom);
						if (riga[7].equalsIgnoreCase("storage"))
							digitale.setSupporto(Digitale.Supporto.storage);
						c.aggiungiRomanzo(digitale);
					}
				}
			} while (s != null);

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

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
				sce = sc.next();
				if (sce.equalsIgnoreCase("si")) {
					sc.nextLine();
					Cartaceo ca = new Cartaceo();
					System.out.println("Inserisci il titolo");
					ca.setTitolo(sc.next());
					sc.nextLine();
					System.out.println("Inserisci l'autore");
					ca.setAutore(sc.next());
					sc.nextLine();
					System.out.println("Inserisci l'anno di pubblicazione");
					do {
						try {
							sc.nextLine();
							ca.setAnnoPubblicazione(sc.nextInt());
							giusto = true;
						} catch (InputMismatchException e) {
							System.out.println("Reinserisci solo numeri");
						}
					} while (!giusto);
					giusto = false;
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
					do {
						try {
							ca.setNumeroPagine(sc.nextInt());
							giusto = true;
						} catch (InputMismatchException e) {
							System.out.println("Reinserisci solo numeri");
						}
					} while (!giusto);
					giusto = false;
					sc.nextLine();
					c.aggiungiRomanzo(ca);
				} else {
					if (sce.equalsIgnoreCase("no")) {
						Digitale d = new Digitale();
						System.out.println("Inserisci il titolo");
						d.setTitolo(sc.next());
						sc.nextLine();
						System.out.println("Inserisci l'autore");
						d.setAutore(sc.next());
						sc.nextLine();
						System.out.println("Inserisci l'anno di pubblicazione");
						do {
							try {
								d.setAnnoPubblicazione(sc.nextInt());
								giusto = true;
							} catch (InputMismatchException e) {
								System.out.println("Reinserisci solo numeri");
							}
						} while (!giusto);
						giusto = false;
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
						do {
							try {
								d.setDimensione(sc.nextInt());
								giusto = true;
							} catch (InputMismatchException e) {
								System.out.println("Reinserisci solo numeri");
							}
						} while (!giusto);
						giusto = false;
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
					} else
						System.out.println("Inserimento errato");
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