package org.example.wakandaforever;

import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class VibraniumService {
    public void updateDailyVirbranium(Wakanda wakanda) {
        if (wakanda.energie.energy >= 10000L)
        {
            addExtracteur(wakanda);
        }
        long newVibra = wakanda.vibranium.extracteur* 1000L;
        System.out.println("Tus extratores han producido "+newVibra+" vibranium hoy !");
        wakanda.vibranium.vibranium += newVibra;
        new AvengersCampusService().GestionLadron(wakanda.avengersCampus, wakanda);
    }

    //fonction pour ajouter un extracteur de vibranium (cout 10 000 energia)
    public void addExtracteur(Wakanda wakanda){
        System.out.println ("Hoy dia hay este numero de extratores de vibranium : "+wakanda.vibranium.extracteur+ " y tienes "+wakanda.energie.energy+" energia");
        System.out.println ("\nQuieres construir otros ?\n Pulsa E si quieres (-10 000 energia) \nPulsa Q si no quieres construir nada");
        //wakanda.energie.energy -= 10000;
        Scanner scanner = new Scanner(System.in);
        String superHero = scanner.nextLine().toUpperCase();
        if (superHero.equals("Q")) {
        }
        else if (superHero.equals("E")) {
            System.out.println ("Cuantos extratores de vibranium quieres construir ?\n");
            int total = scanner.nextInt();
            if (wakanda.vibranium.vibranium >= total*10000L){
                long depense = total*10000L;
                wakanda.vibranium.vibranium -= depense;
                wakanda.vibranium.extracteur++;
                System.out.println ("Felicidades, has construido "+total+" extactores por "+depense+" vibranium !\n");
            }
            else{
                System.out.println("No tienes la energia necesaria...");
            }
        }
        else {
            System.out.println("Opcion no valida !");
            scanner.close();
            addExtracteur(wakanda);
        }
        //scanner.close();
    }
    public Vibranium InitVibranium() {
        Vibranium vibra = new Vibranium();
        vibra.vibranium = 50000;
        vibra.extracteur = 1;
        return vibra;
    }
}