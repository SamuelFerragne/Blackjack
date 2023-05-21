package blackjack.dorsal.taches;

import ca.ntro.app.tasks.backend.BackendTasks;
import blackjack.commun.messages.MsgAjouterValeurBidon;
import blackjack.commun.modeles.ModeleBlackjack;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

public class ModifierModeleBlackjack {

	public static void creerTaches(BackendTasks tasks) {
		
		tasks.taskGroup("ModifierModeleBlackjack")

		     .waitsFor(model(ModeleBlackjack.class))

		
		     .contains(subTasks -> {
		    	 
		    	 
		    	 
		    	 
		     });
	}

}
