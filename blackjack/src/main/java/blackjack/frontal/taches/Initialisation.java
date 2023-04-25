package blackjack.frontal.taches;

import ca.ntro.app.services.Window;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import blackjack.frontal.vues.VueAccueil;
import blackjack.frontal.vues.VueBlackjack;
import blackjack.frontal.vues.VueRacine;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.frontend.ViewLoader;

public class Initialisation {
    
    public static void creerTaches(FrontendTasks tasks) {
        
        tasks.taskGroup("Initialisation")
        
             .andContains(subTasks -> {
                 
                creerVueRacine(subTasks);
                creerVueBlackjack(subTasks);
                creerVueAccueil(subTasks);

                installerVueRacine(subTasks);
                installerVueBlackjack(subTasks);

                afficherFenetre(subTasks);
             });
    }

    private static void creerVueAccueil(FrontendTasks tasks) {

        tasks.task(create(VueAccueil.class))

             .waitsFor(viewLoader(VueAccueil.class))

             .thenExecutesAndReturnsValue(inputs -> {
                 
                 ViewLoader<VueAccueil> viewLoader = inputs.get(viewLoader(VueAccueil.class));
                 
                 VueAccueil vueAcceuil = viewLoader.createView();

                 return vueAcceuil;
             });
    }

    private static void creerVueRacine(FrontendTasks tasks) {

        tasks.task(create(VueRacine.class))

             .waitsFor(viewLoader(VueRacine.class))
             
             .thenExecutesAndReturnsValue(inputs -> {

                 ViewLoader<VueRacine> viewLoader = inputs.get(viewLoader(VueRacine.class));
                 
                 VueRacine vueRacine = viewLoader.createView();
                 
                 return vueRacine;
             });
    }

    private static void creerVueBlackjack(FrontendTasks tasks) {

        tasks.task(create(VueBlackjack.class))

             .waitsFor(viewLoader(VueBlackjack.class))

             .thenExecutesAndReturnsValue(inputs -> {
                 
                 ViewLoader<VueBlackjack> viewLoader = inputs.get(viewLoader(VueBlackjack.class));
                 
                 VueBlackjack vueBlackjack = viewLoader.createView();

                 return vueBlackjack;
             });
    }

    private static void installerVueRacine(FrontendTasks tasks) {

        tasks.task("installerVueRacine")
        
              .waitsFor(window())
              
              .waitsFor(created(VueRacine.class))
              
              .thenExecutes(inputs -> {
                  
                  VueRacine vueRacine = inputs.get(created(VueRacine.class));
                  Window    window    = inputs.get(window());

                  window.installRootView(vueRacine);
              });
    }


    private static void installerVueBlackjack(FrontendTasks tasks) {

        tasks.task("installerVueBlackjack")

              .waitsFor(created(VueRacine.class))
        
              .waitsFor(created(VueBlackjack.class))

              .thenExecutes(inputs -> {
                  
                  VueRacine      vueRacine      = inputs.get(created(VueRacine.class));
                  VueBlackjack      vueBlackjack = inputs.get(created(VueBlackjack.class));
                  
                  vueRacine.afficherSousVue(vueBlackjack);
                  
              });
    }


    private static void afficherFenetre(FrontendTasks tasks) {
        tasks.task("afficherFenetre")

             .waitsFor(window())

             .thenExecutes(inputs -> {

                 Window window = (Window) inputs.get(window());

                 window.resize(600, 900);

                 window.show();

             });
    }
}
