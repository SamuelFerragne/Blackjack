package blackjack.commun.messages;

import ca.ntro.app.messages.MessageNtro;
import blackjack.commun.modeles.ModeleBlackjack;
import blackjack.commun.valeurs.MaValeur;

public class MsgAjouterValeurBidon extends MessageNtro {
	
	private MaValeur valeur;

	public MaValeur getValeur() {
		return valeur;
	}

	public void setValeur(MaValeur valeur) {
		this.valeur = valeur;
	}

	public void ajouterA(ModeleBlackjack modeleMaPage) {
		modeleMaPage.ajouterValeur(valeur);
	}
	


}
