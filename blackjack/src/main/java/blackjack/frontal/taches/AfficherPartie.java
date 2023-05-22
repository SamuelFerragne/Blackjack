package blackjack.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import blackjack.frontal.donnees.DonneesVueBlackjack;
import blackjack.frontal.evenements.EvtClicSouris;
import blackjack.frontal.vues.VueBlackjack;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.clock.Tick;

public class AfficherPartie {


    public static void creerTaches(FrontendTasks tasks) {

        creerDonneesVueBlackjack(tasks);

        tasks.taskGroup("AfficherPartie")

        .waitsFor(created(DonneesVueBlackjack.class))

        .andContains(subTasks -> {

           prochaineImagePartie(subTasks);
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

	private static void prochaineImagePartie(FrontendTasks subTasks) {

		subTasks.task("prochaineImagePartie")
		
			.waitsFor(clock().nextTick())
			
			.thenExecutes(inputs -> {
				
				Tick tick = inputs.get(clock().nextTick());
				
				DonneesVueBlackjack donneesVueBlackjack = inputs.get(created(DonneesVueBlackjack.class));
				VueBlackjack vueBlackjack = inputs.get(created(VueBlackjack.class));
								
				donneesVueBlackjack.reagirTempsQuiPasse(tick.elapsedTime());
				donneesVueBlackjack.afficherSur(vueBlackjack);
			});
		
	}

    private static void creerDonneesVueBlackjack(FrontendTasks tasks) {

        tasks.task(create(DonneesVueBlackjack.class))

             .waitsFor("Initialisation")

             .executesAndReturnsCreatedValue(inputs -> {

                 return new DonneesVueBlackjack();
             });
    }
}
