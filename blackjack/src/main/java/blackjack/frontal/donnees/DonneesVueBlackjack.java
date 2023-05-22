package blackjack.frontal.donnees;

import blackjack.commun.monde2d.MondeBlackjack2d;
import blackjack.frontal.vues.VueBlackjack;
import ca.ntro.app.frontend.ViewData;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import javafx.scene.input.MouseEvent;

public class DonneesVueBlackjack implements ViewData{

	private MondeBlackjack2d mondeBlackjack2d = new MondeBlackjack2d();
	
	
	public void afficherSur(VueBlackjack vueBlackjack) {
		
		vueBlackjack.viderCanvas();
		vueBlackjack.afficherPong2d(mondeBlackjack2d);
		vueBlackjack.afficherMains(mondeBlackjack2d);
		
	}

	
	public void reagirClicSouris(World2dMouseEventFx mouseEvent) {
		
		mondeBlackjack2d.dispatchMouseEvent(mouseEvent);
	
	}
	
	 public void reagirTempsQuiPasse(double secondesEcoulees) {
	        mondeBlackjack2d.onTimePasses(secondesEcoulees);
	        
	 }
	 
	 

}
