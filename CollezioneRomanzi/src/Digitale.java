
public class Digitale extends Romanzo {

	public enum Formato{
		epub,
		modi,
		pdf,
		azw
	}
	
	public enum Supporto{
		cdrom,
		storage
	}
	
	private Formato formato;
	private int dimensione;
	private Supporto supporto;
	
	public Digitale() {
		
	}

	public Formato getFormato() {
		return formato;
	}

	public void setFormato(Formato formato) {
		this.formato = formato;
	}

	public int getDimensione() {
		return dimensione;
	}

	public void setDimensione(int dimensione) {
		this.dimensione = dimensione;
	}

	public Supporto getSupporto() {
		return supporto;
	}

	public void setSupporto(Supporto supporto) {
		this.supporto = supporto;
	}
	
	
	
	
	
}
