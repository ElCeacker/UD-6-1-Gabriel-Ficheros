import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);

        Plane F18 = null;
        boolean entradaWhile = true;

        while (entradaWhile) {

            System.out.println("***********************");
            System.out.println("\t PROGRAMA F18");
            System.out.println("***********************");
            System.out.println("\t 1 - Inicializar F18");
            System.out.println("\t 2 - Alternar estado de los flaps");
            System.out.println("\t 3 - Alternar estado del tren de aterrizaje");
            System.out.println("\t 4 - Armar sistema de eyección");
            System.out.println("\t 5 - Eyectar piloto");
            System.out.println("\t Q - Salir");

            String opcion = teclado.next();


            switch (opcion) {
                case "1":

                    break;

                case "2":

                    break;

                case "3":

                    break;

                case "4":

                    break;

                case "5":

                    break;

                case "Q":
                    entradaWhile = false;
                    break;
            }
        }
    }
}
