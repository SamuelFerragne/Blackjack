package blackjack.frontal.taches;


import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.reflection.observer.Modified;
import blackjack.commun.modeles.ModeleBlackjack;
import blackjack.frontal.donnees.DonneesVueBlackjack;
import blackjack.frontal.evenements.EvtClicSouris;
import blackjack.frontal.vues.VueBlackjack;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;


public class AfficherBlackjack {
	
	public static void creerTaches(FrontendTasks tasks) {

		tasks.taskGroup("AfficherBlackjack")
		
		     .waitsFor("Initialisation")

		     .andContains(subTasks -> {
		    	 
		    	 afficherBlackjack(subTasks);
		    	 reagirClicSouris(subTasks);
 
		     });
	}
	
	private static void reagirClicSouris(FrontendTasks tasks) {

		tasks.task("reagirClicSouris")

		        .waitsFor(event(EvtClicSouris.class))

		        .thenExecutes(inputs -> {

		        	DonneesVueBlackjack donneesVueBlackjack = inputs.get(created(DonneesVueBlackjack.class));
		        	EvtClicSouris    evtClicSouris    = inputs.get(event(EvtClicSouris.class));

		        	evtClicSouris.appliquerA(donneesVueBlackjack);

		        });
	}

	private static void afficherBlackjack(FrontendTasks tasks) {

		tasks.task("afficherBlackjack")
		
			 .waitsFor(modified(ModeleBlackjack.class))

		     .executes(inputs -> {
		    	 
		    	 VueBlackjack              vueBlackjack = inputs.get(created(VueBlackjack.class));
		    	 Modified<ModeleBlackjack> blackjack    = inputs.get(modified(ModeleBlackjack.class));
		    	 
		    	 
		    	 blackjack.currentValue().afficherSur(vueBlackjack);

		     });
	}
}