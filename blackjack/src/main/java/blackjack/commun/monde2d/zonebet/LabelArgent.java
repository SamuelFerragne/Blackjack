package blackjack.commun.monde2d.zonebet;

import blackjack.commun.monde2d.ObjetBlackjack2d;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import javafx.scene.canvas.GraphicsContext;

public class LabelArgent extends ObjetBlackjack2d{

	@Override
	public void drawOnWorld(GraphicsContext gc) {
		gc.fillText("Argent: "+this.getWorld2d().argentJoueur, 20, 20);
		
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
