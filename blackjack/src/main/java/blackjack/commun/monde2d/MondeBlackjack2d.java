package blackjack.commun.monde2d;


import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
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

    @Override
    protected void initialize() {
        setWidth(LARGEUR_MONDE);
        setHeight(HAUTEUR_MONDE);

        carte = new Carte2d();
        boutonDD = new BoutonDoubleDown2d();
        boutonHit = new BoutonHit2d();
        boutonStand = new BoutonStand2d();

        addObject2d(carte);
        addObject2d(boutonDD);
        addObject2d(boutonHit);
        addObject2d(boutonStand);
    }

    @Override
    public void drawOn(ResizableWorld2dCanvasFx canvas) {
        canvas.drawOnWorld(gc -> {
            dessinerTerrain(gc);
        });

        super.drawOn(canvas);
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

	public void dispatchMouseEvent(World2dMouseEventFx mouseEvent, double x, double y) {
		// TODO Auto-generated method stub
		
	}
	

}
