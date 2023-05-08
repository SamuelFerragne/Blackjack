package blackjack.frontal.vues;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import blackjack.commun.monde2d.MondeBlackjack2d;
import blackjack.frontal.controles.CanvasPartie;
import blackjack.frontal.evenements.EvtAfficherAccueil;
import blackjack.frontal.evenements.EvtClicSouris;


public class VueBlackjack extends ViewFx {
	
	@FXML
	private Button boutonQuitterPartie;
	@FXML
	private CanvasPartie canvasPartie;
	@FXML
	private Button boutonHit;

	@Override
	public void initialiser() {

		Ntro.assertNotNull(boutonQuitterPartie);
		Ntro.assertNotNull(canvasPartie);
		
		installerEvtAfficherAccueil();
		installerEvtClicSouris();
	}


	private void installerEvtAfficherAccueil() {
		
		EvtAfficherAccueil evtNtro = NtroApp.newEvent(EvtAfficherAccueil.class);

		boutonQuitterPartie.setOnAction(evtFx -> {
			
			evtNtro.trigger();
		});
		
	}
	
    @SuppressWarnings("unchecked")
    private void installerEvtClicSouris() {

        EvtClicSouris evtClicSouris = NtroApp.newEvent(EvtClicSouris.class);

        canvasPartie.onMouseEvent(mouseEventNtro -> {

            if(mouseEventNtro.mouseEventFx().getEventType().equals(MouseEvent.MOUSE_CLICKED)) {

                evtClicSouris.setMouseEvent(mouseEventNtro);
                evtClicSouris.trigger();
            }
        });
    }


	public void viderCanvas() {
		canvasPartie.clearCanvas();
		
	}
	
	public void afficherImagesParSeconde(String fps) {
		canvasPartie.afficherFps(fps);
	}

	public void afficherPong2d(MondeBlackjack2d mondeBlackjack2d) {
		mondeBlackjack2d.drawOn(canvasPartie);
	}

}
