package blackjack.commun.monde2d.boutons;

import blackjack.commun.monde2d.ObjetBlackjack2d;
import blackjack.commun.valeurs.Main;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import javafx.scene.canvas.GraphicsContext;

public class BoutonSplit2d extends ObjetBlackjack2d {

	private boolean selectione;
	
	public BoutonSplit2d() {
        super();
    }

    @Override
    public void initialize() {
        setWidth(10);
        setHeight(10);
        setTopLeftX(150);
        setTopLeftY(10);
    }

    @Override
    public void drawOnWorld(GraphicsContext gc) {

    	int place = 300;
    	for(Main main:this.getWorld2d().mainsJoueur) {
    		gc.fillText(main.toString(), place, place);
    		place+=10;
    	}
    	
        gc.fillText(this.getWorld2d().mainsJoueur.get(this.getWorld2d().mainJouant).toString(), 100, 100);
        	
        gc.fillRect(getTopLeftX(), getTopLeftY(), getWidth(), getHeight());
    }

    @Override
    protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
    	if(this.getWorld2d().mainsJoueur.get(this.getWorld2d().mainJouant).isPlaying()) {
        	this.getWorld2d().mainsJoueur.get(this.getWorld2d().mainJouant).split(this.getWorld2d());
    	}
    	if(this.getWorld2d().mainsJoueur.size() > 0) {
    		if(this.getWorld2d().mainJouant == this.getWorld2d().mainsJoueur.size()-1){
    			this.getWorld2d().mainJouant = 0;
    		}else {
    			for(Main main : this.getWorld2d().mainsJoueur) {
    				if(main.isPlaying()) {
    					this.getWorld2d().mainJouant = this.getWorld2d().mainsJoueur.indexOf(main);
    				}
    			}
    		}
    	}
        return true;
    }

    @Override
    public String id() {
        return "boutonSplit";
    }

}
