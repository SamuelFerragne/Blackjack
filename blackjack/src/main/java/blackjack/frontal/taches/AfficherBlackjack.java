package blackjack.frontal.taches;


import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.reflection.observer.Modified;
import blackjack.commun.modeles.ModeleBlackjack;
import blackjack.frontal.vues.VueBlackjack;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;


public class AfficherBlackjack {
	
	public static void creerTaches(FrontendTasks tasks) {

		tasks.taskGroup("AfficherBlackjack")
		
		     .waitsFor("Initialisation")

		     .andContains(subTasks -> {
		    	 
		    	 afficherBlackjack(subTasks);
 
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