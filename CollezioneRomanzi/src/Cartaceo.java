
public class Cartaceo extends Romanzo {

	public enum Copertina {
		RIGIDA, MOLLE
	}

	private Copertina copertina;
	private String statoConservazione;
	private int numeroPagine;

	public Cartaceo() {

	}

	public Copertina getCopertina() {
		return copertina;
	}

	public void setCopertina(Copertina copertina) {
		this.copertina = copertina;
	}

	public String getStatoConservazione() {
		return statoConservazione;
	}

	public void setStatoConservazione(String statoConservazione) {
		this.statoConservazione = statoConservazione;
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

}
