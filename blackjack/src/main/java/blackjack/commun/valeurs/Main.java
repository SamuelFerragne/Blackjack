package blackjack.commun.valeurs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import blackjack.commun.monde2d.Carte2d;
import blackjack.commun.monde2d.MondeBlackjack2d;
import blackjack.commun.monde2d.ObjetBlackjack2d;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.app.models.ModelValue;
import ca.ntro.core.initialization.Ntro;
import javafx.scene.canvas.GraphicsContext;

public class Main extends ObjetBlackjack2d implements ModelValue {

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
	

	public Main(int wager) {
		setCartes(new ArrayList<>());
		calculerScore(cartes);
		setWager(wager);
		setPlaying(true);
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
		
		Carte2d nouvelleCarte = new Carte2d(valeur,sorte);
		
		this.cartes.add(nouvelleCarte);
		
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
		if(canSplit()) {
			Carte2d[] tabCartes = {cartes.get(1)};
			List<Carte2d> cartes = new ArrayList<>(Arrays.asList(tabCartes));
			mondeBlackjack2d.mainsJoueur.add(new Main(cartes,wager,true));
			this.cartes.remove(1);
		}
	}
	public boolean canSplit() {
		boolean canSplit = false;
		
		if(cartes.size() == 2) {
			if(cartes.get(0).getNumero() == cartes.get(1).getNumero()) {
				canSplit = true;
			}
		}
		
		return canSplit;
	}

	@Override
	public void drawOnWorld(GraphicsContext gc) {
		
		int decalage = 0;
    	for(Carte2d carte : getCartes()) {
    		carte.drawOnWorld(gc);
    		carte.moveTo(650 + decalage, 550);
    		carte.setAfficher(true);
    		decalage += 50;
    	}

		gc.fillText(this.getWorld2d().mainsJoueur.get(this.getWorld2d().mainJouant).toString(), 100, 100);
		
	}

	@Override
	public String id() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
