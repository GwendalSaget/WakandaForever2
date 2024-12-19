package org.example.wakandaforever;

import java.util.Scanner;

public class TecnologiaLevelService{
    public void LevelUp(Wakanda wakanda){
        if (wakanda.nivel == 1 && wakanda.vibranium.vibranium >= 150000L && wakanda.energie.energy >= 30000L){
            System.out.println ("Bienvenido en el Conjunto de Desarollo de Tecnologia del Wakanda !\nEl nivel de tecnologia actual es el nivel 1, se puede subir de nivel al pagando 150 000 vibranium y 30 000 energía !\n Si quieres subir de nivel, pulsa N ! Si no hay que pulsar Q !");
            Scanner scanner = new Scanner(System.in);
            String nivel = scanner.nextLine().toUpperCase();
            if (nivel.equals("N")){
                wakanda.vibranium.vibranium -= 150000L;
                wakanda.energie.energy -= 30000L;
                wakanda.nivel = 2;
                System.out.println("Felicidades, has subido de nivel ! El nivel actual es el 2 !");
            }
            else if (nivel.equals("Q")){
                return;
            }
            else {
                System.out.println("Opcion no valida !");
                LevelUp(wakanda);
            }
        }
        else if (wakanda.nivel == 2 && wakanda.vibranium.vibranium >= 1000000L && wakanda.energie.energy >= 100000L){
            System.out.println ("Bienvenido en el Conjunto de Desarollo de Tecnologia del Wakanda !\nEl nivel de tecnologia actual es el nivel 1, se puede subir de nivel al pagando 1 000 000 vibranium y 100 000 energía !\n Si quieres subir de nivel, pulsa N ! Si no hay que pulsar Q !");
            Scanner scanner = new Scanner(System.in);
            String nivel = scanner.nextLine().toUpperCase();
            if (nivel.equals("N")){
                wakanda.vibranium.vibranium -= 150000L;
                wakanda.energie.energy -= 30000L;
                wakanda.nivel = 3;
                System.out.println("Felicidades, has subido de nivel ! El nivel actual es el 3 ! Has ganado el juego !");
            }
            else if (nivel.equals("Q")){
                return;
            }
            else {
                System.out.println("Opcion no valida !");
                LevelUp(wakanda);
            }
        }
        else{
            if (wakanda.nivel == 1){
                System.out.println("Bienvenido en el Conjunto de Desarollo de Tecnologia del Wakanda !\n No se puede subir de nivel por el momento ! Necesitas 150 000 vibranium y 30 000 energía !");
            }
            else if (wakanda.nivel == 2){
                System.out.println("Bienvenido en el Conjunto de Desarollo de Tecnologia del Wakanda !\nNo se puede subir de nivel por el momento ! Necesitas 1 000 000 vibranium y 100 000 energía !");
            }
            else {
                System.out.println("Bienvenido en el Conjunto de Desarollo de Tecnologia del Wakanda !\nFelicidades, ya has ganado el juego !");
            }
        }
    }
}