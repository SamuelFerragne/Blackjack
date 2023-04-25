package blackjack.frontal.vues;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import blackjack.frontal.evenements.EvtAfficherBlackjack;

public class VueAccueil extends ViewFx {
	
	@FXML
	private Button boutonAfficherMaPage;

	@Override
	public void initialiser() {

		Ntro.assertNotNull(boutonAfficherMaPage);
		
		installerEvtAfficherMaPage();
	}

	private void installerEvtAfficherMaPage() {
		
		EvtAfficherBlackjack evtNtro = NtroApp.newEvent(EvtAfficherBlackjack.class);

		boutonAfficherMaPage.setOnAction(evtFx -> {
			
			evtNtro.trigger();
		});
	}
}
