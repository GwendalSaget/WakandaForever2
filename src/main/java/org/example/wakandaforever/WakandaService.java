package org.example.wakandaforever;

import java.sql.SQLException;

public class WakandaService{
    //fonction pour initialiser le Wakanda

    Wakanda InitWakanda() throws SQLException {
        Wakanda wakanda = new Wakanda();
        wakanda.nbHabitant = 50;
        //on commence avec 50 000 unités de vibranium et 10 000 unités d'énergie
        wakanda.vibranium = new VibraniumService().InitVibranium();
        wakanda.energie = new EnergyService().InitEnergy();
        wakanda.avengersCampus = new AvengersCampusService().InitCampus();
        wakanda.nivel = 1;
        wakanda.id = 1;
        Database.initDatabase(Database.getConnection(Main.URL));
        return wakanda;
    }

    public void updateWakanda(Wakanda wakanda) throws SQLException {
        updateHabitant(wakanda);
        new VibraniumService().updateDailyVirbranium(wakanda);
        new EnergyService().updateEnergy(wakanda);
        new TecnologiaLevelService().LevelUp(wakanda);
        wakanda.id++;
        Database.InsertDia(wakanda.id, wakanda.vibranium.vibranium, wakanda.energie.energy, wakanda.nbHabitant, wakanda.nivel, wakanda.avengersCampus.ladron);
        System.out.println("Bian del dia "+wakanda.id+" :\nNivel : "+wakanda.nivel+"\nTotal de vibranium : "+wakanda.vibranium.vibranium+"\nTotal de energia : "+wakanda.energie.energy+"\nTotal de populacion : "+wakanda.nbHabitant+"\n");
    }

    //fonction pour changer le nombre d'habitants
    public void updateHabitant(Wakanda wakanda)
    {
        //chaque jour, on récupère une partie de la population actuelle en plus sachant qu'on commence avec 50 personnes
        // 50% → 2% de la population, 30% → 0% de la population, 15% 5% → 10% de la population
        int ratio = (int) (Math.random() * 100);
        int plusPers = 0;
        if (ratio < 50){
            plusPers = (2*wakanda.nbHabitant)/100;
        }
        else if (ratio < 80){
            plusPers = 0;
        }
        else if (ratio >= 95){
            plusPers = (10*wakanda.nbHabitant)/100;
        }
        else {
            plusPers = (5*wakanda.nbHabitant)/100;
        }
        wakanda.nbHabitant += plusPers;
        System.out.println("Has ganado "+plusPers+" personas en tu ciudad hoy !\n");
    }
    //on doit dépenser de l'énergie pour la nourriture → 70 par habitants, appeler dans le energie service
    public void FoodWakanda(Wakanda wakanda){
        wakanda.energie.energy -= 25L * wakanda.nbHabitant;
        System.out.println("Tienes "+wakanda.nbHabitant+" en tu ciudad, es decir que se necesita "+25L* wakanda.nbHabitant+" para alimentar toda la poblacion !\n");
    }

}