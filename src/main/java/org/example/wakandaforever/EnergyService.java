package org.example.wakandaforever;

import java.util.Scanner;

public class EnergyService{
    public void construir (Wakanda wakanda, Energy energy){
        System.out.println ("Hoy dia hay este numero de fabricas de energia :\nEnergia Shuri : "+energy.FabricaShuri+"\nEnergia Killmonger : "+energy.FabricaKillmonger+ " y tienes "+wakanda.vibranium.vibranium+" vibranium");
        System.out.println ("\nQue quieres construir ?\n Pulsa S para fabricas de Shuri (+3000 energia al dia, -100 000 vibranium) \n Pulsa K para fabricas de Killmonger (+100 energia al dia, -5000 vibranium) \n Pulsa Q si no quieres construir nada");
        Scanner scanner = new Scanner(System.in);
        String superHero = scanner.nextLine().toUpperCase();
        if (superHero.equals("Q")) {
        }
        else if (superHero.equals("S")) {
            System.out.println ("Cuantas fabricas de Shuri quieres construir ?\n");
            int shuri = scanner.nextInt();
            if (wakanda.vibranium.vibranium >= shuri*100000L){
                long depense = shuri*100000L;
                wakanda.vibranium.vibranium -= depense;
                energy.FabricaShuri+=shuri;
                System.out.println ("Felicidades, has construido "+shuri+" fabricas Shuri por "+depense+" vibranium !\n");
            }
            else{
                System.out.println("No tienes el Vibranium necesario...");
            }
        }
        else if (superHero.equals("K")) {
            System.out.println ("Cuantas fabricas de Killmonger quieres construir ?\n");
            int killmonger = scanner.nextInt();
            if (wakanda.vibranium.vibranium >= killmonger*5000L){
                long depense2 = killmonger*5000L;
                wakanda.vibranium.vibranium -= depense2;
                energy.FabricaKillmonger+=killmonger;
                System.out.println ("Felicidades, has construido "+killmonger+" fabricas Killmonger por "+depense2+" vibranium !\n");
            }
            else{
                System.out.println("No tienes el Vibranium necesario...");
            }
        }
        else {
            System.out.println("Opcion no valida !");
            //scanner.close();
            construir(wakanda, energy);
        }
        //scanner.close();
    }
    public void updateEnergy(Wakanda wakanda){
        if (wakanda.vibranium.vibranium >= 5000L){
            construir(wakanda, wakanda.energie);
        }
        new WakandaService().FoodWakanda(wakanda);
        wakanda.energie.energy += wakanda.energie.FabricaKillmonger*100L + wakanda.energie.FabricaShuri*3000L;
        System.out.println ("Hoy has producido "+wakanda.energie.energy+" de energia hoy con "+wakanda.energie.FabricaKillmonger+" fabricas de Killmonger y "+wakanda.energie.FabricaShuri+" fabricas de Shuri");
    }

    public Energy InitEnergy() {
        Energy energy = new Energy();
        energy.FabricaKillmonger = 0;
        energy.FabricaShuri = 0;
        energy.energy = 10000L;
        return energy;
    }

}
