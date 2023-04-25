package blackjack.frontal.vues;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import blackjack.frontal.controles.CanvasPartie;
import blackjack.frontal.evenements.EvtAfficherAccueil;


public class VueBlackjack extends ViewFx {
	
	@FXML
	private Button boutonQuitterPartie;
	 @FXML
	 private CanvasPartie canvasPartie;

	@Override
	public void initialiser() {

		Ntro.assertNotNull(boutonQuitterPartie);
		 Ntro.assertNotNull(canvasPartie);
		
		installerEvtAfficherAccueil();
	}


	private void installerEvtAfficherAccueil() {
		
		EvtAfficherAccueil evtNtro = NtroApp.newEvent(EvtAfficherAccueil.class);

		boutonQuitterPartie.setOnAction(evtFx -> {
			
			evtNtro.trigger();
		});
	}

}
