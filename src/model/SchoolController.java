package model;

import java.time.LocalDate;

/**
 * Clase controladora que administra los computadores y sus incidentes.
 */
public class SchoolController {

    private Computer[][] computers;
    private final int FLOORS = 5;
    private final int COLUMNS = 10;

    /**
     * Constructor: inicializa la matriz de computadores.
     */
    public SchoolController() {
        computers = new Computer[FLOORS][COLUMNS];
    }

    /**
     * Método modificador.
     * Precondición: floor entre 1 y 5, serial único.
     * Postcondición: agrega un computador en la primera columna disponible del piso.
     */
    public boolean agregarComputador(String serial, int floor) {
        if (floor < 1 || floor > FLOORS) return false;
        if (buscarComputador(serial) != null) return false;

        for (int c = 0; c < COLUMNS; c++) {
            if (computers[floor - 1][c] == null) {
                computers[floor - 1][c] = new Computer(serial, floor, c + 1);
                return true;
            }
        }
        return false; // Piso lleno
    }

    /**
     * Método modificador.
     * Precondición: serial existente.
     * Postcondición: agrega un incidente al computador con ese serial.
     */
    public boolean agregarIncidenteEnComputador(String serial, LocalDate date, String description) {
        Computer comp = buscarComputador(serial);
        if (comp == null) return false;

        Incident inc = new Incident(date, description);
        comp.addIncident(inc);
        return true;
    }

    /**
     * Método analizador.
     * Retorna el computador con más incidentes registrados.
     */
    public Computer consultarComputadorConMasIncidentes() {
        Computer max = null;
        int maxIncidentes = -1;

        for (int i = 0; i < FLOORS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                Computer comp = computers[i][j];
                if (comp != null && comp.getIncidentCount() > maxIncidentes) {
                    max = comp;
                    maxIncidentes = comp.getIncidentCount();
                }
            }
        }
        return max;
    }

    /**
     * Busca un computador por su serial.
     */
    public Computer buscarComputador(String serial) {
        for (int i = 0; i < FLOORS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (computers[i][j] != null && computers[i][j].getSerial().equals(serial)) {
                    return computers[i][j];
                }
            }
        }
        return null;
    }

    /**
     * Retorna la ubicación de un computador por su serial.
     */
    public String getUbicacionComputador(String serial) {
        Computer c = buscarComputador(serial);
        if (c == null) return "Computador no encontrado.";
        return "Piso: " + c.getFloor() + " | Columna: " + c.getColumn();
    }
}
