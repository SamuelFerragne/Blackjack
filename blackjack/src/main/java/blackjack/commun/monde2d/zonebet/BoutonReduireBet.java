package blackjack.commun.monde2d.zonebet;

import blackjack.commun.monde2d.ObjetBlackjack2d;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import javafx.scene.canvas.GraphicsContext;

public class BoutonReduireBet extends ObjetBlackjack2d {
	
	
	public BoutonReduireBet() {
	}
	
	
	
	@Override
	 public void initialize() {
       setWidth(10);
       setHeight(10);
       setTopLeftX(241);
       setTopLeftY(200);
   }

	@Override
	public void drawOnWorld(GraphicsContext gc) {
		gc.fillRect(getTopLeftX(), getTopLeftY(), getWidth(), getHeight());
	}


	@Override
	protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
		if(this.getWorld2d().zoneBet2d.getBet() <= 250) {
			this.getWorld2d().zoneBet2d.setBet(this.getWorld2d().zoneBet2d.getBet()-50);
		}else if(this.getWorld2d().zoneBet2d.getBet() <= 1000) {
			this.getWorld2d().zoneBet2d.setBet(this.getWorld2d().zoneBet2d.getBet()-250);
		}else {
			this.getWorld2d().zoneBet2d.setBet(this.getWorld2d().zoneBet2d.getBet()-500);
		}
		return true;
	}

	@Override
	public String id() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
