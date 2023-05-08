package blackjack.commun.monde2d;

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
    	if(this.getWorld2d().mainJoueur.isPlaying()) {
    		this.getWorld2d().mainJoueur.stand();
    	}
        return true;
    }

    @Override
    public String id() {
        return "boutonStand";
    }

}
