package blackjack.commun.monde2d;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import blackjack.commun.monde2d.boutons.BoutonDoubleDown2d;
import blackjack.commun.monde2d.boutons.BoutonHit2d;
import blackjack.commun.monde2d.boutons.BoutonSplit2d;
import blackjack.commun.monde2d.boutons.BoutonStand2d;
import blackjack.commun.monde2d.zonebet.BoutonAjoutBet;
import blackjack.commun.monde2d.zonebet.BoutonBet;
import blackjack.commun.monde2d.zonebet.BoutonReduireBet;
import blackjack.commun.monde2d.zonebet.LabelArgent;
import blackjack.commun.monde2d.zonebet.ZoneBet2d;
import blackjack.commun.valeurs.Main;
import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.app.fx.world2d.Object2dFx;
import ca.ntro.app.fx.world2d.World2dFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


public class MondeBlackjack2d extends World2dFx {

	public static final double LARGEUR_MONDE = 1280;
    public static final double HAUTEUR_MONDE = 720;
    public static final double MAIN_JOUEUR_POSX = 600;
    public static final double MAIN_JOUEUR_POSY = 550;
    public static final double MAIN_DEALER_POSX = 500;
    public static final double MAIN_DEALER_POSY = 180;

    public static final Image OFF = new Image("imagesBoutons/off.png");

    public double argentJoueur = 2000;
    private BoutonDoubleDown2d boutonDD;
    private BoutonHit2d boutonHit;
    private BoutonStand2d boutonStand;
    public List<Main> mainsJoueur;
    public int mainJouant;
    private Main mainDealer;
    public ZoneBet2d zoneBet2d;
    private BoutonAjoutBet boutonAjoutBet;
    private BoutonReduireBet boutonReduireBet;
    public BoutonBet boutonBet;
    public BoutonSplit2d boutonSplit2d;
    public LabelArgent labelArgent;
    ResizableWorld2dCanvasFx canvas;
    
    

    @Override
    protected void initialize() {
        setWidth(LARGEUR_MONDE);
        setHeight(HAUTEUR_MONDE);

        mainJouant = 0;
		Carte2d[] tabCartes = {new Carte2d(13, "Trefle")};
		List<Carte2d> cartes = new ArrayList<>(Arrays.asList(tabCartes));
        mainsJoueur = new ArrayList<Main>();
        mainsJoueur.add(new Main(cartes,100,false));
        
        mainDealer = new Main(cartes, 0, false);
        
        //mainsJoueur.add(new Main());
        boutonDD = new BoutonDoubleDown2d();
        boutonHit = new BoutonHit2d();
        boutonStand = new BoutonStand2d();
        boutonReduireBet = new BoutonReduireBet();
        boutonAjoutBet = new BoutonAjoutBet();
        zoneBet2d =  new ZoneBet2d(0);
        boutonBet = new BoutonBet();
        boutonSplit2d = new BoutonSplit2d();
        labelArgent = new LabelArgent();
        
        
        //boutons d'action
        addObject2d(boutonDD);
        addObject2d(boutonHit);
        addObject2d(boutonStand);
        addObject2d(boutonSplit2d);
        
        //boutons de bet
        addObject2d(zoneBet2d);
        addObject2d(boutonReduireBet);
        addObject2d(boutonAjoutBet);
        addObject2d(boutonBet);
        
        addObject2d(labelArgent);
        
        //Juste pour afficher un paquet de carte pour faire beau
        addObject2d(new Carte2d(1, "Pique", 1100, 30));
        
    }

    @Override
    public void drawOn(ResizableWorld2dCanvasFx canvas) {
        canvas.drawOnWorld(gc -> {
            dessinerTerrain(gc);  
        });
        afficherMainsJoueur();
        afficherMainDealer();
        super.drawOn(canvas);
        this.canvas = canvas;
    }

    private void dessinerTerrain(GraphicsContext gc) {
        gc.save();
        gc.setStroke(Color.LIGHTGREY);
        gc.setLineWidth(1);

        gc.strokeRect(0, 0, getWidth(), getHeight());
        

        gc.restore();
    }

	@Override
	protected void onMouseEventNotConsumed(World2dMouseEventFx mouseEvent) {
		
	}

	public void afficherMainsJoueur() {
		int decalageMain = 0;
    	for(Main main : mainsJoueur) {
    		main.moveTo(MAIN_JOUEUR_POSX + decalageMain, MAIN_JOUEUR_POSY);
    		for(Carte2d carte : main.getCartes()) {
    			carte.setAfficher(true);
    		}
    		addObject2d(main);
    		decalageMain += 300;
        }
	}
	
	public void afficherMainDealer() {
		if(mainDealer != null) {
			mainDealer.moveTo(MAIN_DEALER_POSX, MAIN_DEALER_POSY);
			mainDealer.afficherCarteByIndex(0);
			addObject2d(mainDealer);
		}
		
	}
	
	public void Jeu() {
		mainDealer.clear();
		mainDealer.setPlaying(true);
		for(int i = 0; i <= 1; i++) {
			for(Main main : mainsJoueur) {
				main.hit();
			}
			mainDealer.hit();
			//checkForWinOrBust();
		}

	}
	
	public void dealerPlay() {
		while(mainDealer.getScore()<17) {
			mainDealer.hit();
		}
		if(mainDealer.getScore() > 21) {
			mainDealer.busted = true;
		}
		checkForWinOrBust();
	}
	
	public void checkForWinOrBust() {
		if(mainDealer.getCartes().size() == 2) {
			for(Main main : mainsJoueur) {
				
				if(main.getScore() == 21) {
					if(mainDealer.getScore() != 21) {
						main.win();
					}
					else {
						main.draw();
					}
				}else if(main.getScore() > 21) {
					main.lose();
				}
			}
		}
		
		if(!mainDealer.isBusted()) {
			for(Main main : mainsJoueur) {
				if(!main.isBusted() && !main.isPlaying()) {
					main.win();
				}
			}
			return;
		}
		
		if(!mainDealer.isPlaying()) {
			for(Main main: mainsJoueur) {
				if(!main.isBusted()) {
					if(main.getScore() > mainDealer.getScore()) {
						main.win();
					}else if(main.getScore() == mainDealer.getScore()) {
						main.draw();
					}else {
						main.lose();
					}
					
				}
			}
		}
	}
}
