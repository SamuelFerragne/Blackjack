package blackjack.commun.monde2d;

import java.awt.Rectangle;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.*;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.util.Duration;


public class Carte2d extends ObjetBlackjack2d {
	
	private static Image BACK = new Image("/imagesCartes/back.png");
	private Image image;
	
	private int numero;
	private String sorte;
	
	private boolean afficher = true;
	
	private double velocity = 5; 
	
    private static final double DUREE_ANIMATION = 2;
    private double secondesRestantesRotation = 2;

	public Carte2d(int numero, String sorte) {
		super();
		this.numero = numero;
		this.sorte = sorte;
		this.image = new Image("/imagesCartes/" + numero+sorte +".png");
		
	}
	
	public Carte2d(int numero, String sorte, double x, double y) {
		super();
		this.numero = numero;
		this.sorte = sorte;
		this.image = new Image("/imagesCartes/" + numero+sorte +".png");
		
		this.setTopLeftX(x);
		this.setTopLeftY(y);
	}
	
	@Override
	 public void initialize() {
       setWidth(100);
       setHeight(this.getWidth() * 1.4); //carte de poker 1.4x plus grande que large
   }

	@Override
	public void drawOn(ResizableWorld2dCanvasFx canvas) {
	        canvas.drawOnWorld(gc -> {
	        	
	        	
	        	if (afficher) {
	        		gc.drawImage(image, 
		            		getTopLeftX(),
	                        getTopLeftY(),
	                        getWidth(),
	                        getHeight());
	        	}else {
	        		gc.drawImage(BACK, 
		            		getTopLeftX(),
	                        getTopLeftY(),
	                        getWidth(),
	                        getHeight());
	        	}
	        	if(secondesRestantesRotation > 0) {
	        		
	        	}
	        	
	            
	        });
	    }

	@Override
	public String id() {
		// TODO Auto-generated method stub
		return numero + " " + sorte;
	}


	@Override
	protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void onTimePasses(double secondsElapsed) {
	    super.onTimePasses(secondsElapsed);

	    if(secondesRestantesRotation > 0) {
	    	secondesRestantesRotation -= secondsElapsed;
	    }

	}
	
	public void animationRotation() {
		secondesRestantesRotation = DUREE_ANIMATION;
	}
}
