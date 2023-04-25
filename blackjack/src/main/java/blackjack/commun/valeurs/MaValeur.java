package blackjack.commun.valeurs;

import ca.ntro.app.models.ModelValue;

public class MaValeur implements ModelValue {
	
	private String uneChaine = "";
	private int unChiffre = 10;

	public String getUneChaine() {
		return uneChaine;
	}

	public void setUneChaine(String uneChaine) {
		this.uneChaine = uneChaine;
	}

	public int getUnChiffre() {
		return unChiffre;
	}

	public void setUnChiffre(int unChiffre) {
		this.unChiffre = unChiffre;
	}
	
	@Override
	public String toString() {
		return uneChaine + " (" + unChiffre + ")";
	}
	

}
