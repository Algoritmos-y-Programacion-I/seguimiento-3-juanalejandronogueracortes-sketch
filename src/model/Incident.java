package model;

import java.time.LocalDate;

/**
 * Clase que representa un incidente reportado en un computador.
 */
public class Incident {

    // Atributos
    private LocalDate dateReport;
    private String description;
    private String solution;
    private double solutionHours;

    /**
     * Constructor del incidente.
     * @param dateReport Fecha del reporte.
     * @param description Descripción del incidente.
     */
    public Incident(LocalDate dateReport, String description) {
        this.dateReport = dateReport;
        this.description = description;
        this.solution = "";
        this.solutionHours = 0;
    }

    // Métodos de acceso
    public LocalDate getDateReport() {
        return dateReport;
    }

    public String getDescription() {
        return description;
    }

    public String getSolution() {
        return solution;
    }

    public double getSolutionHours() {
        return solutionHours;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public void setSolutionHours(double solutionHours) {
        this.solutionHours = solutionHours;
    }

    @Override
    public String toString() {
        return "Fecha: " + dateReport + " | Descripción: " + description +
                (solution.isEmpty() ? "" : " | Solución: " + solution + " (" + solutionHours + "h)");
    }
}
