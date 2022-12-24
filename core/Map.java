package core;

import java.util.ArrayList;

public class Map {
    private Zone zone; // Liste des zones
    private ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>(); // Etudiants dans la zone

    // Constructeur
    public Map(Zone zone) {
        this.zone = zone;
        this.etudiants = new ArrayList<Etudiant>();
    }

    // Getters et setters
    public Zone getZone() {
        return this.zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public ArrayList<Etudiant> getEtudiants() {
        return this.etudiants;
    }

    public void setEtudiants(ArrayList<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }
}
