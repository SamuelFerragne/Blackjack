package blackjack.commun.monde2d.zonebet;

import blackjack.commun.monde2d.ObjetBlackjack2d;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import javafx.scene.canvas.GraphicsContext;

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
       setWidth(40);
       setHeight(60);
       setTopLeftX(200);
       setTopLeftY(200);
   }

	@Override
	public void drawOnWorld(GraphicsContext gc) {
		//gc.fillRect(getTopLeftX(), getTopLeftY(), getWidth(), getHeight());
		gc.strokeText(""+bet, getTopLeftX()-10, getTopLeftY()-10);
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
