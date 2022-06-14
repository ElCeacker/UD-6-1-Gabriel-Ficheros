import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);

        Plane F18 = null;
        boolean entradaWhile = true;

        String fileName = "data/plane.dat";
        FileInputStream inputFile = null;
        BufferedInputStream bufferedInput = null;
        ObjectInputStream objectInput = null;

        try {
            inputFile = new FileInputStream(fileName);
            bufferedInput = new BufferedInputStream(inputFile);
            objectInput = new ObjectInputStream(bufferedInput);

            try {
                Plane archivito = (Plane) objectInput.readObject();
                F18 = archivito;
                while (true) {
                    System.out.println(archivito);
                    archivito = (Plane) objectInput.readObject();
                }
            } catch (EOFException e) {
                System.out.println("FIN");
            }catch (ClassNotFoundException e) {
                System.out.println("Error al leer el archivo");
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encuentra o no existe");
        } catch (IOException e) {
            System.out.println("Error de E/S");
        }

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
                    System.out.print("Introduzca el número de litros de combustible cargados: ");
                    int nivelCombustible = teclado.nextInt();

                    System.out.print("Introduzca apodo del piloto: ");
                    String apodoPiloto = teclado.next();

                    System.out.print("Introduzca número de escuadrón: ");
                    String nEscuadron = teclado.next();

                    F18 = new Plane(nivelCombustible, apodoPiloto, nEscuadron);
                    F18.toggleFlaps();
                    F18.setSeatOccupation(true);
                    System.out.println(F18);

                    break;

                case "2":
                    F18.toggleFlaps();
                    System.out.println(F18);
                    break;

                case "3":
                    F18.toggleLandingGear();
                    System.out.println(F18);
                    break;

                case "4":
                    F18.ejectionSystem();
                    System.out.println(F18);
                    break;

                case "5":
                    if (F18.isEjectionSystem()) {
                        F18.setSeatOccupation(false);
                    } else {
                        System.out.println("El sistema de eyección no está activado");
                    }

                    System.out.println(F18);
                    break;

                case "Q":
                    String fileNames = "data/plane.dat";

                    FileOutputStream outputFile = null;
                    BufferedOutputStream bufferedOutput = null;
                    ObjectOutputStream objectOutput = null;
                    try {
                        outputFile = new FileOutputStream(fileNames);
                        bufferedOutput = new BufferedOutputStream(outputFile);
                        objectOutput = new ObjectOutputStream(bufferedOutput);

                        objectOutput.writeObject(F18);
                    } catch (FileNotFoundException e) {
                        System.out.println("El archivo no se encuentra");
                    } catch (IOException e) {
                        System.out.println(e);
                    } finally {
                        try {
                            if (objectOutput != null) objectOutput.close();
                            if (bufferedOutput != null) bufferedOutput.close();
                            if (outputFile != null) outputFile.close();
                        } catch (IOException e) {
                            System.out.println("Error al cerrar los Streams");
                        }
                    }

                    entradaWhile = false;
                    break;
            }
        }
    }
}
