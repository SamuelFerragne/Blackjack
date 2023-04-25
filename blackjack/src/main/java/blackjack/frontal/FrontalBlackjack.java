package blackjack.frontal;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.FrontendFx;

import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import blackjack.frontal.evenements.EvtAfficherAccueil;
import blackjack.frontal.evenements.EvtAfficherBlackjack;
import blackjack.frontal.taches.AfficherBlackjack;
import blackjack.frontal.taches.Initialisation;
import blackjack.frontal.taches.Navigation;
import blackjack.frontal.vues.VueAccueil;
import blackjack.frontal.vues.VueBlackjack;
import blackjack.frontal.vues.VueRacine;

public class FrontalBlackjack implements FrontendFx {
    
    @Override
    public void createTasks(FrontendTasks tasks) {

    	Initialisation.creerTaches(tasks);
    	Navigation.creerTaches(tasks);
    	AfficherBlackjack.creerTaches(tasks);

    }

    @Override
    public void registerEvents(EventRegistrar registrar) {
    	registrar.registerEvent(EvtAfficherAccueil.class);
    	registrar.registerEvent(EvtAfficherBlackjack.class);
    }

    @Override
    public void registerViews(ViewRegistrarFx registrar) {
		registrar.registerView(VueRacine.class, "/racine.xml");
		registrar.registerView(VueBlackjack.class, "/blackjack.xml");
		registrar.registerView(VueAccueil.class, "/accueil.xml");

		registrar.registerDefaultResources("/chaines_fr.properties");
		registrar.registerResources(NtroApp.locale("en"), "/chaines_en.properties");
		
		//registrar.registerStylesheet("/dev.css");
		registrar.registerStylesheet("/prod.css");
    }

    @Override
    public void execute() {

    }

}
