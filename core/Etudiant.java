package core;

import java.util.Random;

public class Etudiant {
    private Niveau niveau;
    private int id; // Identifiant de l'étudiant
    private int ects; // Point de vie de base
    private int dexterite; // Entre 0 et 10
    private int force; // Entre 0 et 10
    private int resistance; // Entre 0 et 10
    private int constitution; // Entre 0 et 30
    private int initiative; // Entre 0 et 10
    private Strategie strategie; // Stratégie de combat : defensive, offensive ou aleatoire.

    // Constructeur
    public Etudiant(Niveau niveau, int id, int ects, int dexterite, int force, int resistance,
            int constitution,
            int initiative, Strategie strategie) {
        this.niveau = niveau;
        this.id = id;
        this.ects = ects;
        this.dexterite = dexterite;
        this.force = force;
        this.resistance = resistance;
        this.constitution = constitution;
        this.initiative = initiative;
        this.strategie = strategie;
    }

    // Méthodes
    Random rnd = new Random();
    int degatRef = 10;

    public void aleatoire(Etudiant envoie, Etudiant recoit) {
        System.out.println("L'étudiant attaque ou se défend aléatoirement !");
        int randomInt = rnd.nextInt(2);
        if (randomInt == 0) {
            offensive(envoie, recoit);
        } else {
            defensive(envoie, recoit);
        }
    }

    public void offensive(Etudiant envoie, Etudiant recoit) {
        System.out.println("L'étudiant attaque avec son gobby !");
        int randomInt = rnd.nextInt(101);
        if (randomInt <= 40 + 3 * dexterite) {
            int y = rnd.nextInt(1);
            int force = envoie.getForce();
            int degat = (int) (y * (10 * force - 5 * resistance) * degatRef);
            // Etudiant.setEcts(recoit.getEcts() - degat);
            System.out.println("L'étudiant a réussi son attaque ! Il inflige " + degat + " points de dégâts !");
        } else {
            System.out.println("L'étudiant a raté son attaque !");
        }
    }

    public void defensive(Etudiant envoie, Etudiant recoit) {
        System.out.println("L'étudiant se défend !");
        int randomInt = rnd.nextInt(101);
        if (randomInt <= 20 + 6 * dexterite) {
            int y = rnd.nextInt(1);
            int soin = (int) (y * (10 * force - 5 * resistance));
            // Etudiant.setEcts(recoit.getEcts() + soin);
            System.out.println("L'étudiant a réussi son soin ! Il soigne " + soin + " ETCS !");
        } else {
            System.out.println("L'étudiant a raté son soin !");
        }
    }

    // Getters et setters
    public Niveau getNiveauEtudiant() {
        return this.niveau;
    }

    public void setTypeEtudiant(Niveau typeEtudiant) {
        this.niveau = typeEtudiant;
    }

    public int getId() {
        return this.id;
    }

    public Etudiant getEtudiant() {
        return this;
    }

    public int getEcts() {
        return this.ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public int getDexterite() {
        return this.dexterite;
    }

    public void setDexterite(int dexterite) {
        this.dexterite = dexterite;
    }

    public int getForce() {
        return this.force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getResistance() {
        return this.resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public int getConstitution() {
        return this.constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getInitiative() {
        return this.initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public Strategie getStrategie() {
        return this.strategie;
    }

    public void setStrategie(Strategie strategie) {
        this.strategie = strategie;
    }
}
