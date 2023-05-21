package blackjack.commun.monde2d.zonebet;

import blackjack.commun.monde2d.ObjetBlackjack2d;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class ZoneBet2d extends ObjetBlackjack2d {
	
	private int bet;
	
	public ZoneBet2d() {
	}
	
	public ZoneBet2d(int bet) {
		setBet(bet);
	}
	
	public int getBet() {
		return this.bet;
	}
	
	public void setBet(int bet) {
		this.bet = bet;
	}
	
	
	@Override
	 public void initialize() {
       setWidth(70);
       setHeight(10);
       setTopLeftX(340);
       setTopLeftY(625);
   }

	@Override
	public void drawOnWorld(GraphicsContext gc) {
		gc.save();
		gc.setStroke(Paint.valueOf("FFFFFF"));
		gc.strokeText(String.format("Pari: %8s$", bet), getTopLeftX(), getTopLeftY());
		gc.restore();
	}


	@Override
	protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String id() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
