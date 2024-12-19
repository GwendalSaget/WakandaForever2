package org.example.wakandaforever;
//eso es un servicio de seguridad y tecnologia
import java.util.Scanner;

public class AvengersCampusService {
    public AvengersCampus InitCampus(){
        AvengersCampus avengersCampus = new AvengersCampus();
        avengersCampus.ladron = 0;
        return avengersCampus;
    }

    public void GestionLadron (AvengersCampus avengersCampus, Wakanda wakanda){
        avengersCampus.ladron+=1;
        System.out.println ("Hoy dia hay este numero de ladron en tu ciudad : "+avengersCampus.ladron+" ! Estan intentando robar tu vibranium !");
        for (int i=0; i<avengersCampus.ladron; i++){
            System.out.println ("Tienes "+wakanda.vibranium.vibranium+" vibranium. ");
            System.out.println ("Que superhero quieres llamar para ayudar te a eliminar el ladron" +i+" ?\n Pulsa S para Spider-man (50% de exito, -1000 vibranium) \n Pulsa I para Iron-man (75% de exito, -5000 vibranium) \n Pulsa B para Black Panther (100% de exito, -10000 de vibranium)");
            Scanner scanner = new Scanner(System.in);
            String superHero = scanner.nextLine().toUpperCase();
            int prob = (int) (Math.random() * 4);
            if (superHero.equals("S")) {
                if (prob<=2){
                    System.out.println ("El ladron " +i+ " ha sido eliminado gracias a Spiderman !");
                    avengersCampus.ladron-=1;
                    wakanda.vibranium.vibranium-=1000;
                }
                else {
                    System.out.println("Desgradaciamente Spiderman estaba en una cita com Zendaya y no pensaba en ayudarte");
                    wakanda.vibranium.vibranium-=1000;
                }
            }
            else if (superHero.equals("I")) {
                if (prob<=3){
                    System.out.println ("El ladron " +i+ " ha sido eliminado, I am... Iron-man !");
                    avengersCampus.ladron-=1;
                    wakanda.vibranium.vibranium-=5000;
                }
                else {
                    System.out.println("Desgradaciamente Tony Stark tuvo que jugar al UNO con Captain America...");
                    wakanda.vibranium.vibranium-=5000;
                }
            }
            if (superHero.equals("B")) {
                System.out.println ("El ladron " +i+ " ha sido eliminado gracias a Black Banther ! WAKANDA FOREVER !!!");
                avengersCampus.ladron-=1;
                wakanda.vibranium.vibranium-=10000;
            }
            else{
                System.out.println ("Opcion no valida !");
                //on fait -1 car on appelle la récursivité pour recommencer or on ajoute au début un autre ladron
                avengersCampus.ladron-=1;
                GestionLadron(avengersCampus, wakanda);
            }
            //scanner.close();
        }
        // en fin de journée chaque ladron vole 3000 virbanium
        wakanda.vibranium.vibranium-=avengersCampus.ladron*3000L;
    }
}