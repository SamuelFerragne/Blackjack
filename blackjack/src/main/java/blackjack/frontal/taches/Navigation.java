package blackjack.frontal.taches;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import blackjack.frontal.evenements.EvtAfficherAccueil;
import blackjack.frontal.evenements.EvtAfficherBlackjack;
import blackjack.frontal.vues.VueAccueil;
import blackjack.frontal.vues.VueBlackjack;
import blackjack.frontal.vues.VueRacine;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;


public class Navigation {
	
	public static void creerTaches(FrontendTasks tasks) {

		tasks.taskGroup("Navigation")
		
		     .waitsFor("Initialisation")

		     .andContains(subTasks -> {

			     afficherVueBlackjack(subTasks);

			     afficherVueAcceuil(subTasks);

		     });
	}


	private static void afficherVueAcceuil(FrontendTasks tasks) {

		tasks.task("afficherVueAcceuil")
		
		     .waitsFor(created(VueAccueil.class))
		
		     .waitsFor(event(EvtAfficherAccueil.class))
		      
		     .thenExecutes(inputs -> {

		    	 VueRacine  vueRacine = inputs.get(created(VueRacine.class));
		    	 VueAccueil vueAcceuil = inputs.get(created(VueAccueil.class));
		    	  
		    	 vueRacine.afficherSousVue(vueAcceuil);
		     });
	}

	private static void afficherVueBlackjack(FrontendTasks tasks) {

		tasks.task("afficherVueBlackjack")
		
		      .waitsFor(event(EvtAfficherBlackjack.class))
		      
		      .thenExecutes(inputs -> {
		    	  
		    	  VueRacine vueRacine  = inputs.get(created(VueRacine.class));
		    	  VueBlackjack  vueBlackjack = inputs.get(created(VueBlackjack.class));
		    	  
		    	  vueRacine.afficherSousVue(vueBlackjack);
		      });
	}
}