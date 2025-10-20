package model;

import java.util.ArrayList;

/**
 * Clase que representa un computador de la escuela.
 */
public class Computer {

    private String serial;
    private int floor;
    private int column;
    private ArrayList<Incident> incidents;

    /**
     * Constructor del computador.
     * @param serial Serial del computador.
     * @param floor Piso donde se encuentra.
     * @param column Columna donde se encuentra.
     */
    public Computer(String serial, int floor, int column) {
        this.serial = serial;
        this.floor = floor;
        this.column = column;
        this.incidents = new ArrayList<>();
    }

    public String getSerial() {
        return serial;
    }

    public int getFloor() {
        return floor;
    }

    public int getColumn() {
        return column;
    }

    public ArrayList<Incident> getIncidents() {
        return incidents;
    }

    public void addIncident(Incident incident) {
        incidents.add(incident);
    }

    public int getIncidentCount() {
        return incidents.size();
    }

    @Override
    public String toString() {
        return "Computador [Serial=" + serial + ", Piso=" + floor + ", Columna=" + column +
                ", Incidentes=" + incidents.size() + "]";
    }
}
