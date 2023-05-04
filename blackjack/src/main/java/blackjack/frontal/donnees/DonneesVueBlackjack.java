package blackjack.frontal.donnees;

import blackjack.commun.monde2d.MondeBlackjack2d;
import blackjack.frontal.vues.VueBlackjack;
import ca.ntro.app.frontend.ViewData;
import ca.ntro.app.fx.controls.World2dMouseEventFx;

public class DonneesVueBlackjack implements ViewData{

	private MondeBlackjack2d mondeBlackjack2d = new MondeBlackjack2d();
	private String fpsCourant = "0";
	
	
	public void afficherSur(VueBlackjack vueBlackjack) {
		
		vueBlackjack.viderCanvas();
		vueBlackjack.afficherImagesParSeconde("FPS " + fpsCourant);
		vueBlackjack.afficherPong2d(mondeBlackjack2d);
	}


	public void reagirClicSouris(World2dMouseEventFx mouseEvent) {
		// TODO Auto-generated method stub
		
	}
}
