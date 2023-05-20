package blackjack.commun.monde2d;


import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.app.fx.world2d.World2dFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class MondeBlackjack2d extends World2dFx {

	public static final double LARGEUR_MONDE = 640;
    public static final double HAUTEUR_MONDE = 360;

    private Carte2d carte ;

    @Override
    protected void initialize() {
        setWidth(LARGEUR_MONDE);
        setHeight(HAUTEUR_MONDE);

        carte = new Carte2d(1, "Trefle", 100, 100);

        addObject2d(carte);
        
        
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
		
	}
	
	
	

}
