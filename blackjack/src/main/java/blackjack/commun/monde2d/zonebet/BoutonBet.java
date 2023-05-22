package blackjack.commun.monde2d.zonebet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import blackjack.commun.monde2d.Carte2d;
import blackjack.commun.monde2d.ObjetBlackjack2d;
import blackjack.commun.valeurs.Main;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;

public class BoutonBet extends ObjetBlackjack2d {
	
	private Image image = new Image("imagesBoutons/bet.png");
	private Image off = this.getWorld2d().OFF;
	
	
	public BoutonBet() {
        super();
    }

    @Override
    public void initialize() {
        setWidth(100);
        setHeight(40);
        setTopLeftX(420);
        setTopLeftY(630);
    }

    @Override
    public void drawOnWorld(GraphicsContext gc) {
    		gc.save();
    		if(this.getWorld2d().mainsJoueur.get(this.getWorld2d().mainJouant).isPlaying()) {
    			gc.drawImage(off, getTopLeftX(), getTopLeftY());
    		} else {
    			gc.drawImage(image, getTopLeftX(), getTopLeftY());
    		}
    		
    		gc.restore();
    }

    @Override
    protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
    	int mainEnJeux = this.getWorld2d().mainJouant;
    	List<Main> mainsJoueur = this.getWorld2d().mainsJoueur;
    	
    	if(!mainsJoueur.get(mainEnJeux).isPlaying()) {
    		this.getWorld2d().mainsJoueur.clear();
    		
    		Carte2d[] tabCartes = {};
    		List<Carte2d> cartes = new ArrayList<>(Arrays.asList(tabCartes));
    		
    		this.getWorld2d().mainsJoueur.add(new Main(cartes,this.getWorld2d().zoneBet2d.getBet(), true));
    		
        	this.getWorld2d().argentJoueur -= this.getWorld2d().zoneBet2d.getBet();
        	this.getWorld2d().Jeu();
    	}
        return true;
    }

    @Override
    public String id() {
        return "boutonBet";
    }
}
