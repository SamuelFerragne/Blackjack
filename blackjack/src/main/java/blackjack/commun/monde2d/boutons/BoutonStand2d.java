package blackjack.commun.monde2d.boutons;

import java.util.List;

import blackjack.commun.monde2d.ObjetBlackjack2d;
import blackjack.commun.valeurs.Main;
import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;

public class BoutonStand2d extends ObjetBlackjack2d {
	
	private Image image = new Image("imagesBoutons/stand.png");
	private Image off = this.getWorld2d().OFF;

	public BoutonStand2d() {
        super();
    }

    @Override
    public void initialize() {
    	setWidth(70);
        setHeight(70);
        setTopLeftX(20);
        setTopLeftY(630);
    }

    @Override
    public void drawOnWorld(GraphicsContext gc) {
    	gc.save();
    	if(this.getWorld2d().mainsJoueur.get(this.getWorld2d().mainJouant).isPlaying()) {
			gc.drawImage(image, getTopLeftX(), getTopLeftY());
		} else {
			gc.drawImage(off, getTopLeftX(), getTopLeftY());
		}
    	
    	gc.restore();
    }

    @Override
    protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
    	int mainEnJeux = this.getWorld2d().mainJouant;
    	List<Main> mainsJoueur = this.getWorld2d().mainsJoueur;
    	
    	if(mainsJoueur.get(mainEnJeux).isPlaying()) {
    		mainsJoueur.get(mainEnJeux).stand();
    	}
    	if(this.getWorld2d().mainsJoueur.size() > 0) {
    		if(mainEnJeux == mainsJoueur.size()-1){
    			this.getWorld2d().mainJouant = 0;
    		}else {
    			for(Main main : mainsJoueur) {
    				if(main.isPlaying()) {
    					this.getWorld2d().mainJouant = mainsJoueur.indexOf(main);
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
