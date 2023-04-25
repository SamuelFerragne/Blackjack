package blackjack.commun.modeles;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.Model;
import ca.ntro.app.models.WatchJson;
import ca.ntro.app.models.WriteObjectGraph;
import blackjack.commun.valeurs.MaValeur;
import blackjack.frontal.vues.VueBlackjack;

public class ModeleBlackjack implements Model, WatchJson, WriteObjectGraph {
	
	
	private List<MaValeur> maListe = new ArrayList<>();


	public List<MaValeur> getMaListe() {
		return maListe;
	}

	public void setMaListe(List<MaValeur> maListe) {
		this.maListe = maListe;
	}
	
	public String toString() {

		StringBuilder builder = new StringBuilder();
		int numeroValeur = 1;
		
		builder.append("Voici les valeurs:\n\n");

		for(MaValeur valeur : maListe) {

			builder.append(numeroValeur);
			builder.append(". ");
			builder.append(valeur.toString());
			builder.append("\n");

			numeroValeur++;
		}

		return builder.toString();
	}

	public void ajouterValeur(MaValeur valeur) {
		maListe.add(valeur);
	}
	

	public void afficherSur(VueBlackjack vueBlackjack) {
		
	}

}
