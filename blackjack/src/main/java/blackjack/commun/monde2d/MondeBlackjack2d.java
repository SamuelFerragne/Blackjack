package blackjack.commun.monde2d;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import blackjack.commun.monde2d.boutons.BoutonDoubleDown2d;
import blackjack.commun.monde2d.boutons.BoutonHit2d;
import blackjack.commun.monde2d.boutons.BoutonStand2d;
import blackjack.commun.monde2d.zonebet.BoutonAjoutBet;
import blackjack.commun.monde2d.zonebet.BoutonBet;
import blackjack.commun.monde2d.zonebet.BoutonReduireBet;
import blackjack.commun.monde2d.zonebet.ZoneBet2d;
import blackjack.commun.valeurs.Main;
import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.app.fx.world2d.Object2dFx;
import ca.ntro.app.fx.world2d.World2dFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MondeBlackjack2d extends World2dFx {

	public static final double LARGEUR_MONDE = 640;
    public static final double HAUTEUR_MONDE = 360;

    private Carte2d carte ;
    private BoutonDoubleDown2d boutonDD;
    private BoutonHit2d boutonHit;
    private BoutonStand2d boutonStand;
    public Main mainJoueur;
    private Main mainDealer;
    public ZoneBet2d zoneBet2d;
    private BoutonAjoutBet boutonAjoutBet;
    private BoutonReduireBet boutonReduireBet;
    public BoutonBet boutonBet;
    ResizableWorld2dCanvasFx canvas;

    @Override
    protected void initialize() {
        setWidth(LARGEUR_MONDE);
        setHeight(HAUTEUR_MONDE);

		Carte2d[] tabCartes = {};
		List<Carte2d> cartes = new ArrayList<>(Arrays.asList(tabCartes));
        mainJoueur = new Main(cartes,100,true);
        mainJoueur.hit();
        carte = new Carte2d();
        boutonDD = new BoutonDoubleDown2d();
        boutonHit = new BoutonHit2d();
        boutonStand = new BoutonStand2d();
        boutonReduireBet = new BoutonReduireBet();
        boutonAjoutBet = new BoutonAjoutBet();
        zoneBet2d =  new ZoneBet2d(0);
        boutonBet = new BoutonBet();

        addObject2d(boutonDD);
        addObject2d(boutonHit);
        addObject2d(boutonStand);
        addObject2d(zoneBet2d);
        addObject2d(boutonReduireBet);
        addObject2d(boutonAjoutBet);
        addObject2d(boutonBet);
    }

    @Override
    public void drawOn(ResizableWorld2dCanvasFx canvas) {
        canvas.drawOnWorld(gc -> {
            dessinerTerrain(gc);
        });

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
		// TODO Auto-generated method stub
		
	}

	
}
