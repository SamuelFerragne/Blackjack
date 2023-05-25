package blackjack.commun.monde2d;

import java.awt.Rectangle;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;


public class Carte2d extends ObjetBlackjack2d {
	
	private static Image BACK = new Image("/imagesCartes/back.png");
	private Image image;
	
	private int numero;
	private String sorte;
	
	private boolean afficher = false;
	
	private double destinationX = 0;
	private double destinationY = 0;
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isAfficher() {
		return afficher;
	}

	public void setAfficher(boolean afficher) {
		this.afficher = afficher;
	}

	public double getVelocity() {
		return velocity;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	private double velocity = 1500; 
	
    private static final double DUREE_ANIMATION = 2;
    private double secondesRestantesRotation = 2;

    
	public Carte2d(int numero, String sorte) {
		super();
		this.numero = numero;
		this.sorte = sorte;
		this.image = new Image("/imagesCartes/" + numero+sorte +".png");
		
		this.setTopLeftX(1100);
		this.setTopLeftY(30);
		
		this.setWidth(100);
	    this.setHeight(this.getWidth() * 1.4);
		
	}
	
	public Carte2d(int numero, String sorte, double x, double y) {
		super();
		this.numero = numero;
		this.sorte = sorte;
		this.image = new Image("/imagesCartes/" + numero+sorte +".png");
		
		this.setTopLeftX(x);
		this.setTopLeftY(y);
		
		this.setWidth(100);
	    this.setHeight(this.getWidth() * 1.4);
	}

	
	public String getSorte() {
		return this.sorte;
	}
	
	@Override
	 public void initialize() {
		setTopLeftX(1100);
		setTopLeftY(30);
		setWidth(100);
		setHeight(this.getWidth() * 1.4); //carte de poker 1.4x plus grande que large
   }

	@Override
	public void drawOnWorld(GraphicsContext gc) {
		gc.save();
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
		
		//debug
		//gc.fillText("X :" +Double.toString(this.getTopLeftX()), getTopLeftX(), getTopLeftY()-10);
    	//gc.fillText("Y :" +Double.toString(this.getTopLeftY()), getTopLeftX(), getTopLeftY());
     	
    	gc.restore();
	    }

	@Override
	public String id() {
		// TODO Auto-generated method stub
		return numero + " " + sorte;
	}


	@Override
	protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
		afficher = true;
		return false;
	}
	
	@Override
	public void onTimePasses(double secondsElapsed) {
	    super.onTimePasses(secondsElapsed);

	    if(secondesRestantesRotation > 0) {
	    	secondesRestantesRotation -= secondsElapsed;
	    }
	    
	    if((getSpeedX() > 0
	    		&& getTopLeftX() >= destinationX)) {

	    	atteindreDestinationX();

	    }else if(getSpeedX() < 0
	    		&& getTopLeftX() <= destinationX) {
	    	
	    	atteindreDestinationX();
	    }

	    if((getSpeedY() > 0
	    		&& getTopLeftY() >= destinationY)) {

	    	atteindreDestinationY();

	    }else if(getSpeedY() < 0
	    		&& getTopLeftY() <= destinationY) {
	    	
	    	atteindreDestinationY();
	    }

	}

	private void atteindreDestinationX() {
		setTopLeftX(destinationX);
		setSpeedX(0);
	}

	private void atteindreDestinationY() {
		setTopLeftY(destinationY);
		setSpeedY(0);
	}
	
	public void animationRotation() {
		secondesRestantesRotation = DUREE_ANIMATION;
	}
	
	public void moveTo (double x, double y) {
		destinationX = x;
		destinationY = y;
		
		double distanceRestanteX = (x - this.getTopLeftX());
		double distanceRestanteY = (y - this.getTopLeftY());

		double velocityX = distanceRestanteX / getWorld2d().getWidth() * velocity;
		double velocityY = distanceRestanteY / getWorld2d().getHeight() * velocity;
		
		this.setSpeedX(velocityX);
		this.setSpeedY(velocityY);
		
		if(Math.abs(distanceRestanteX) < 0.2) {
			atteindreDestinationX();
		}

		if(Math.abs(distanceRestanteY) < 0.2) {
			atteindreDestinationY();
		}
	}
}
