package blackjack.commun.monde2d;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;

public class BoutonDoubleDown2d extends ObjetBlackjack2d {

	public BoutonDoubleDown2d() {
        super();
    }

    @Override
    public void initialize() {
        setWidth(10);
        setHeight(10);
        setTopLeftX(100);
        setTopLeftY(10);
    }

    @Override
    public void drawOn(ResizableWorld2dCanvasFx canvas) {

        canvas.drawOnWorld(gc -> {
        	
            gc.fillRect(getTopLeftX(), getTopLeftY(), getWidth(), getHeight());
        });
    }

    @Override
    protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
    	
        return true;
    }

    @Override
    public String id() {
        return "boutonDoubleDown";
    }

}
