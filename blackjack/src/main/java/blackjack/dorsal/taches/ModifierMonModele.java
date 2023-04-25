package blackjack.dorsal.taches;

import ca.ntro.app.tasks.backend.BackendTasks;
import blackjack.commun.messages.MsgAjouterValeurBidon;
import blackjack.commun.modeles.ModeleBlackjack;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

public class ModifierMonModele {

	public static void creerTaches(BackendTasks tasks) {
		
		tasks.taskGroup("ModifierMonModele")

		     .waitsFor(model(ModeleBlackjack.class))

		
		     .contains(subTasks -> {
		    	 
		    	 ajouterValeurBidon(subTasks);
		    	 
		    	 
		     });
	}

	private static void ajouterValeurBidon(BackendTasks subTasks) {
		subTasks.task("ajouterValeurBidon")


		         .waitsFor(message(MsgAjouterValeurBidon.class))
		        
		        .thenExecutes(inputs -> {
		        	
		        	ModeleBlackjack          modeleMaPage          = inputs.get(model(ModeleBlackjack.class));
		        	MsgAjouterValeurBidon msgAjouterValeurBidon = inputs.get(message(MsgAjouterValeurBidon.class));
		        	
		        	msgAjouterValeurBidon.ajouterA(modeleMaPage);

		        });
	}

}
