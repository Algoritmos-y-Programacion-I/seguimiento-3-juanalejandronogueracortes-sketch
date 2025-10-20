package ui;

import model.SchoolController;
import java.util.Scanner;
import java.time.LocalDate;

/**
 * Interfaz de usuario por consola para manejar el sistema de computadores.
 */
public class SchoolApp {

    private Scanner sc;
    private SchoolController controller;

    public SchoolApp() {
        sc = new Scanner(System.in);
        controller = new SchoolController();
    }

    public static void main(String[] args) {
        SchoolApp app = new SchoolApp();
        app.menu();
    }

    public void menu() {
        int option = -1;
        while (option != 0) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Agregar computador");
            System.out.println("2. Reportar incidente");
            System.out.println("3. Consultar computador con más incidentes");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> agregarComputador();
                case 2 -> agregarIncidente();
                case 3 -> consultarComputadorConMasIncidentes();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private void agregarComputador() {
        System.out.print("Ingrese el serial del computador: ");
        String serial = sc.nextLine();
        System.out.print("Ingrese el piso (1-5): ");
        int floor = sc.nextInt();
        sc.nextLine();

        boolean agregado = controller.agregarComputador(serial, floor);
        if (agregado)
            System.out.println("Computador agregado correctamente.");
        else
            System.out.println("Error: el piso está lleno o el serial ya existe.");
    }

    private void agregarIncidente() {
        System.out.print("Ingrese el serial del computador: ");
        String serial = sc.nextLine();
        System.out.print("Ingrese la fecha (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(sc.nextLine());
        System.out.print("Ingrese la descripción del incidente: ");
        String desc = sc.nextLine();

        boolean agregado = controller.agregarIncidenteEnComputador(serial, date, desc);
        if (agregado)
            System.out.println("Incidente registrado correctamente.");
        else
            System.out.println("Error: no se encontró el computador.");
    }

    private void consultarComputadorConMasIncidentes() {
        var comp = controller.consultarComputadorConMasIncidentes();
        if (comp == null)
            System.out.println("No hay computadores registrados.");
        else
            System.out.println("Computador con más incidentes:\n" + comp);
    }
}
