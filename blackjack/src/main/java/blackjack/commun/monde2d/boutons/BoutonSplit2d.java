package blackjack.commun.monde2d.boutons;

import blackjack.commun.monde2d.ObjetBlackjack2d;
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
        setTopLeftX(0);
        setTopLeftY(10);
    }

    @Override
    public void drawOnWorld(GraphicsContext gc) {

        	gc.fillText(this.getWorld2d().mainsJoueur.get(this.getWorld2d().mainJouant).toString(), 100, 100);
        	
            gc.fillRect(getTopLeftX(), getTopLeftY(), getWidth(), getHeight());
    }

    @Override
    protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
    	if(this.getWorld2d().mainsJoueur.get(this.getWorld2d().mainJouant).isPlaying()) {
        	this.getWorld2d().mainsJoueur.get(this.getWorld2d().mainJouant).hit();
    	}
        return true;
    }

    @Override
    public String id() {
        return "boutonHit";
    }

}
