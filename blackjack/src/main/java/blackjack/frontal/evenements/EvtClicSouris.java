package blackjack.frontal.evenements;

import blackjack.frontal.donnees.DonneesVueBlackjack;
import ca.ntro.app.frontend.events.EventNtro;
import ca.ntro.app.fx.controls.World2dMouseEventFx;

public class EvtClicSouris extends EventNtro {

    private World2dMouseEventFx mouseEvent;

    public World2dMouseEventFx getMouseEvent() {
        return mouseEvent;
    }

    public void setMouseEvent(World2dMouseEventFx mouseEvent) {
        this.mouseEvent = mouseEvent;
    }

    public EvtClicSouris() {

    }

    public void appliquerA(DonneesVueBlackjack donneesVueBlackjack) {
        donneesVueBlackjack.reagirClicSouris(mouseEvent);
    }
}
