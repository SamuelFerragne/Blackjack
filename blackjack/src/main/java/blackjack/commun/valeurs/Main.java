package blackjack.commun.valeurs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import blackjack.commun.monde2d.Carte2d;
import blackjack.commun.monde2d.MondeBlackjack2d;
import ca.ntro.app.models.ModelValue;
import ca.ntro.core.initialization.Ntro;

public class Main implements ModelValue{

	private List<Carte2d> cartes;
	private int score;
	private int wager;
	private boolean isPlaying;
	
	public Main() {
		Carte2d[] tabCartes = {};
		List<Carte2d> cartes = new ArrayList<>(Arrays.asList(tabCartes));
		setCartes(cartes);
		setPlaying(false);
	}
	
	public Main(List<Carte2d> cartes, int wager, boolean isPlaying) {
		setCartes(cartes);
		calculerScore(cartes);
		setWager(wager);
		setPlaying(isPlaying);
	}

	public boolean isPlaying() {
		return isPlaying;
	}

	public void setPlaying(boolean isPlaying) {
		this.isPlaying = isPlaying;
	}

	public List<Carte2d> getCartes() {
		return cartes;
	}

	public void setCartes(List<Carte2d> cartes) {
		this.cartes = cartes;
		if(cartes.size() > 0) {
			calculerScore(cartes);
		}
	}

	public int getScore() {
		return score;
	}

	public void calculerScore(List<Carte2d> cartes) {
		int score = 0;
		
		for (Carte2d carte : cartes){
			score += carte.getNumero();
		}
		
		this.score = score;
	}

	public int getWager() {
		return wager;
	}

	public void setWager(int wager) {
		this.wager = wager;
	}
	
	public void hit() {
		int valeur = Ntro.random().nextInt(13)+1;
		String sorte;
		
		switch(Ntro.random().nextInt(4)) {
			case 0:
				sorte = "Coeur";
				break;
			case 1:
				sorte = "Pique";
				break;
			case 2:
				sorte = "Carreau";
				break;
			case 3:
				sorte = "Trefle";
				break;
			default:
				sorte="ERREUR";
				break;
		}
		
		this.cartes.add(new Carte2d(valeur,sorte));
		calculerScore(this.cartes);
	}

	public void stand() {
		this.isPlaying = false;
	}
	
	public void doubleDown() {
		this.wager*=2;
		this.hit();
		calculerScore(this.cartes);
		this.stand();
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		
		for (Carte2d carte : cartes){
			str.append(carte.getNumero()+":"+carte.getSorte()+ " ");
		}
		
		return str.toString() + " " + this.wager;
		
	}
	
	public void clear() {
		Carte2d[] tabCartes = {};
		List<Carte2d> cartes = new ArrayList<>(Arrays.asList(tabCartes));
		setCartes(cartes);
		setWager(0);
	}
	
	public void split(MondeBlackjack2d mondeBlackjack2d) {
		if(cartes.size() == 2) {
			if(cartes.get(0).getNumero() == cartes.get(1).getNumero()) {
				Carte2d[] tabCartes = {cartes.get(1)};
				List<Carte2d> cartes = new ArrayList<>(Arrays.asList(tabCartes));
				mondeBlackjack2d.mainsJoueur.add(new Main(cartes,wager,true));
				this.cartes.remove(1);
			}
		}
	}
}
