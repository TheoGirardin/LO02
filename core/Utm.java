package core;

import java.util.ArrayList;

public class Utm {
    private ArrayList<Map> maps = new ArrayList<Map>();

    // Constructeur
    public Utm() {
        this.maps = creationMaps();
    }

    // Méthodes
    public ArrayList<Map> creationMaps() {
        maps.add(new Map(Zone.BIBLIOTHEQUE));
        maps.add(new Map(Zone.BUREAU_ETUDIANTS));
        maps.add(new Map(Zone.QUARTIER_ADMINISTRATIF));
        maps.add(new Map(Zone.HALLES_INDUSTRIELLES));
        maps.add(new Map(Zone.HALLE_SPORTIVE));
        maps.add(new Map(Zone.RESERVE));
        return maps;
    }

    public void listMaps() {
        // Afficher les zones
        for (int i = 0; i < maps.size(); i++) {
            float totalETCS = 0;
            for (int j = 0; j < maps.get(i).getEtudiants().size(); j++) {
                float ETCS = maps.get(i).getEtudiants().get(j).getEcts();
                totalETCS += ETCS;
            }
            System.out.println("Zone " + i + ": " + maps.get(i).getZone() + ", nombre d'etudiants dans cette zone : "
                    + maps.get(i).getEtudiants().size() + ", nombre total d'ECTS : " + totalETCS
                    + ", id :" + maps.get(i));
        }
        System.out.println();
    }

    // Afficher les etudiants dans une zone
    public void listZone(int id) {
        System.out.println("Nombre d'étudiant dans cette zone : " + maps.get(id).getEtudiants().size());
        System.out.println();
        System.out.println("Les étudiants dans cette zone sont :");
        for (int i = 0; i < maps.get(id).getEtudiants().size(); i++) {
            System.out.println("Etudiant " + i + ", ("
                    + maps.get(id).getEtudiants().get(i).getNiveauEtudiant() + ", "
                    + maps.get(id).getEtudiants().get(i).getEcts()
                    + " ECTS, " + maps.get(id).getEtudiants().get(i).getDexterite() + " dexterité, " +
                    maps.get(id).getEtudiants().get(i).getForce()
                    + " force, " + maps.get(id).getEtudiants().get(i).getResistance() + " resistance, "
                    + maps.get(id).getEtudiants().get(i).getConstitution() + " constitution, " +
                    maps.get(id).getEtudiants().get(i).getInitiative()
                    + " initiative, stratégie " + maps.get(id).getEtudiants().get(i).getStrategie() + ")");
            // System.out.println(", id :" + maps.get(id).getEtudiants().get(i) + ")");
        }
        System.out.println();
    }

    // Getters et setters
    public ArrayList<Map> getMaps() {
        return this.maps;
    }

    public void setMaps(ArrayList<Map> maps) {
        this.maps = maps;
    }
}
