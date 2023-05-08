package blackjack.commun.monde2d.boutons;

import blackjack.commun.monde2d.ObjetBlackjack2d;
import blackjack.commun.valeurs.Main;
import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import javafx.scene.canvas.GraphicsContext;

public class BoutonStand2d extends ObjetBlackjack2d {

	public BoutonStand2d() {
        super();
    }

    @Override
    public void initialize() {
        setWidth(10);
        setHeight(10);
        setTopLeftX(50);
        setTopLeftY(10);
    }

    @Override
    public void drawOnWorld(GraphicsContext gc) {

            gc.fillRect(getTopLeftX(), getTopLeftY(), getWidth(), getHeight());
    }

    @Override
    protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
    	if(this.getWorld2d().mainsJoueur.get(this.getWorld2d().mainJouant).isPlaying()) {
    		this.getWorld2d().mainsJoueur.get(this.getWorld2d().mainJouant).stand();
    	}
    	if(this.getWorld2d().mainsJoueur.size() > 0) {
    		if(this.getWorld2d().mainJouant == this.getWorld2d().mainsJoueur.size()){
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
        return "boutonStand";
    }

}
