package org.example.wakandaforever;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static final String URL = "jdbc:sqlite:C:DatabaseDias.db";

    public static String eleccion(int dia, Scanner scanner) {
        String ok = "";
        while (!ok.equals("Q") && !ok.equals("A") && !ok.equals("D")) {
            System.out.println("Si quieres seguir con el dia " + dia + " haz un clic en <<A>>\nSi quieres ver los datos de un dia particular, haz un clic en <<D>>\nSi quieres salir haz un clic en <<X>>:\n");
            String eleccion = scanner.nextLine().toUpperCase();
            if (eleccion.equals("Q")) {
                Database.clearTable();
                ok = "Q";
            } else if (eleccion.equals("A")) {
                ok = "A";
            }
            else if (eleccion.equals("D")) {
                ok = "D";
            }
        }
        //scanner.close();
        return ok;
    }

    public static void main(String[] args) throws SQLException {
        Database.clearTable();
        System.out.println("Hola Ruben y bienvenido en este simulacion de Wakanda !\nEl objectivo es muy sencillo, vas a empezar al nivel 1 y des llegar al nivel 3 !\nPor eso debes mejorar tu cantidad de Vibranium y de energia !\nAhora vamos ! Inicilizando el Wakanda...\nCreando la armadura de Black Panther...\nEntrenando las guerreras...\n");
        Wakanda wakanda = new WakandaService().InitWakanda();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String choix = eleccion(wakanda.id, scanner);
            if (choix.equals("X")) {
                System.out.println("Muchas gracias ! Hasta luego !!!");
                break;
                //gestion de la base de datos -> ver los datos de 1 dia
            } else if (choix.equals("D")){
                System.out.println("De cual dia quieres ver los datos ?\n");
                int dia = scanner.nextInt();
                Database.printDia(dia);
            }
            else{
                new WakandaService().updateWakanda(wakanda);
            }
        }
    }
}

