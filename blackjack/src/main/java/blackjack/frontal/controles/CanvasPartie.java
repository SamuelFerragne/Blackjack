package blackjack.frontal.controles;

import blackjack.commun.monde2d.MondeBlackjack2d;
import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;

public class CanvasPartie extends ResizableWorld2dCanvasFx {

	@Override
	protected void initialize() {
		setInitialWorldSize(MondeBlackjack2d.LARGEUR_MONDE, MondeBlackjack2d.HAUTEUR_MONDE);
		
	}

}
