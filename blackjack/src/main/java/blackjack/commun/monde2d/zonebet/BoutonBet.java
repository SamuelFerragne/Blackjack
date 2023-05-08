package blackjack.commun.monde2d.zonebet;

import blackjack.commun.monde2d.ObjetBlackjack2d;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import javafx.scene.canvas.GraphicsContext;

public class BoutonBet extends ObjetBlackjack2d {
	
	public BoutonBet() {
        super();
    }

    @Override
    public void initialize() {
        setWidth(60);
        setHeight(40);
        setTopLeftX(225);
        setTopLeftY(225);
    }

    @Override
    public void drawOnWorld(GraphicsContext gc) {
        	gc.fillRect(getTopLeftX(), getTopLeftY(), getWidth(), getHeight());
    }

    @Override
    protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
    	if(!this.getWorld2d().mainJoueur.isPlaying()) {
    		this.getWorld2d().mainJoueur.clear();
        	this.getWorld2d().mainJoueur.setWager(this.getWorld2d().zoneBet2d.getBet());
        	this.getWorld2d().mainJoueur.setPlaying(true);
    	}
        return true;
    }

    @Override
    public String id() {
        return "boutonBet";
    }
}
