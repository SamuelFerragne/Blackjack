package blackjack.dorsal;

import ca.ntro.app.backend.LocalBackendNtro;
import ca.ntro.app.tasks.backend.BackendTasks;
import blackjack.dorsal.taches.ModifierModeleBlackjack;

public class DorsalBlackjack extends LocalBackendNtro {

	@Override
	public void createTasks(BackendTasks tasks) {
		ModifierModeleBlackjack.creerTaches(tasks);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
