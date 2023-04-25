package blackjack.maquettes;

import ca.ntro.core.initialization.Ntro;
import blackjack.commun.valeurs.MaValeur;

public class MaquetteValeurs {
	
	public static MaValeur valeurBidon() {
		MaValeur valeur = new MaValeur();
		
		valeur.setUnChiffre(Ntro.random().nextInt(20));
		valeur.setUneChaine(Ntro.random().nextId(4));

		return valeur;
	}

}
