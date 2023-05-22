package blackjack.commun.monde2d.zonebet;

import blackjack.commun.monde2d.ObjetBlackjack2d;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;

public class BoutonAjoutBet extends ObjetBlackjack2d {
	
	private Image image = new Image("imagesBoutons/ajout.png");
	
	public BoutonAjoutBet() {
	}
	
	
	
	@Override
	 public void initialize() {
       setWidth(70);
       setHeight(35);
       setTopLeftX(340);
       setTopLeftY(630);
   }

	@Override
	public void drawOnWorld(GraphicsContext gc) {
		gc.save();
		gc.drawImage(image, getTopLeftX(), getTopLeftY());
		gc.restore();
	}


	@Override
	protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
		if(this.getWorld2d().zoneBet2d.getBet() < 250) {
			this.getWorld2d().zoneBet2d.setBet(this.getWorld2d().zoneBet2d.getBet()+50);
		}else if(this.getWorld2d().zoneBet2d.getBet() < 1000) {
			this.getWorld2d().zoneBet2d.setBet(this.getWorld2d().zoneBet2d.getBet()+250);
		}else {
			this.getWorld2d().zoneBet2d.setBet(this.getWorld2d().zoneBet2d.getBet()+500);
		}
		return true;
	}

	@Override
	public String id() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
