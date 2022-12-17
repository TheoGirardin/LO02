package core;

import java.util.ArrayList;

public class Player {
    private String filiere;
    static int nbZone;
    private ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();

    // Constructeur
    public Player() {
        this.filiere = choixFiliere();
        Player.nbZone = 0;
        this.etudiants = creationEtudiant();
    }

    // Méthodes
    // Choix de la filière
    public String choixFiliere() {
        System.out.print("Choisissez votre filière : ");
        String filiere = Master.scanner.nextLine();
        return filiere;
    }

    // Création des étudiants
    public ArrayList<Etudiant> creationEtudiant() {
        System.out.println("Création des étudiants !");
        for (int i = 0; i < 15; i++) { // Création d'un étudiant
            Etudiant etudiant = new Etudiant(Niveau.ETUDIANT, i, 30, 0, 0, 0, 0, 0, Strategie.ALEATOIRE);
            etudiants.add(etudiant);
        }
        for (int i = 15; i < 19; i++) { // Création d'un étudiant élite
            Etudiant etudiantElite = new Etudiant(Niveau.ETUDIANT_ELITE, i, 30, 1, 1, 1, 5, 1, Strategie.ALEATOIRE);
            etudiants.add(etudiantElite);
        }
        for (int i = 19; i < 20; i++) { // Création d'un maître gobby
            Etudiant maitreGobby = new Etudiant(Niveau.MAITRE_GOBBY, i, 30, 2, 2, 2, 10, 2, Strategie.ALEATOIRE);
            etudiants.add(maitreGobby);
        }

        // Nombre d'étudiants par joueur
        System.out.println("La filière " + filiere + " a " + etudiants.size() + " étudiants");
        return etudiants;
    }

    int point = 400;
    boolean finPoint = false;

    public void repartitionPoint() {
        System.out.println(
                "Entrer list pour afficher la liste des étudiants ou start pour passer aux choix des zones, sinon entrer le numéro de l'étudiant auquelle vous souhaitez rajouter des points (points restant : "
                        + point + ") ou changer de stratégie (offensive, défensive ou aléatoire):");
        while (finPoint == false) {
            String choix = Master.scanner.nextLine();
            switch (choix) {
                case "list":
                    listEtudiant();
                    break;
                case "start":
                    if (point == 0) {
                        finPoint = true;
                        break;
                    } else {
                        System.out
                                .println("Vous n'avez pas réparti tous vos points ! (Points restant : " + point + ")");
                        break;
                    }
                case "0":
                    configEtudiant(choix);
                    break;
                case "1":
                    configEtudiant(choix);
                    break;
                case "2":
                    configEtudiant(choix);
                    break;
                case "3":
                    configEtudiant(choix);
                    break;
                case "4":
                    configEtudiant(choix);
                    break;
                case "5":
                    configEtudiant(choix);
                    break;
                case "6":
                    configEtudiant(choix);
                    break;
                case "7":
                    configEtudiant(choix);
                    break;
                case "8":
                    configEtudiant(choix);
                    break;
                case "9":
                    configEtudiant(choix);
                    break;
                case "10":
                    configEtudiant(choix);
                    break;
                case "11":
                    configEtudiant(choix);
                    break;
                case "12":
                    configEtudiant(choix);
                    break;
                case "13":
                    configEtudiant(choix);
                    break;
                case "14":
                    configEtudiant(choix);
                    break;
                case "15":
                    configEtudiant(choix);
                    break;
                case "16":
                    configEtudiant(choix);
                    break;
                case "17":
                    configEtudiant(choix);
                    break;
                case "18":
                    configEtudiant(choix);
                    break;
                case "19":
                    configEtudiant(choix);
                    break;
                default:
                    System.out.println(
                            "Entrer list pour afficher la liste des étudiants ou start pour passer aux choix des zones, sinon entrer le numéro de l'étudiant auquelle vous souhaitez rajouter des points (points restant : "
                                    + point + ") ou changer de stratégie (offensive, défensive ou aléatoire):");
                    break;
            }
        }
    }

    public void configEtudiant(String choix) {
        System.out.println("Vous avez choisi l'étudiant " + choix);
        System.out.println("Vous avez " + point + " points à répartir");
        System.out.println(
                "Que souhaitez-vous modifier ? 1:ECTS, 2:Dexterité, 3:Force, 4:Resistance, 5:Constitution, 6:Stratégie, 8:Fin");
        String choixPoint = Master.scanner.nextLine();
        switch (choixPoint) {
            case "1":
                System.out.println("Vous avez choisi ECTS");
                System.out.println("Combien de points souhaitez-vous rajouter ?");
                int ects = Master.scanner.nextInt();
                if (ects > point) {
                    System.out.println("Vous n'avez pas assez de points !");
                    break;
                } else {
                    int beforeECTS = etudiants.get(Integer.parseInt(choix)).getEcts();
                    int afterECTS = beforeECTS + ects;
                    etudiants.get(Integer.parseInt(choix)).setEcts(afterECTS);
                    point = point - ects;
                    System.out.println("Vous avez " + point + " points à répartir");
                    break;
                }
            case "2":
                System.out.println("Vous avez choisi Dexterité");
                System.out.println("Combien de points souhaitez-vous rajouter ?");
                int dexterite = Master.scanner.nextInt();
                if (dexterite > point) {
                    System.out.println("Vous n'avez pas assez de points !");
                    break;
                } else {
                    int beforeDexterite = etudiants.get(Integer.parseInt(choix)).getDexterite();
                    int afterDexterite = beforeDexterite + dexterite;
                    if (afterDexterite > 10) {
                        System.out.println("Vous ne pouvez pas dépassser les 10 points !");
                        break;
                    } else {
                        etudiants.get(Integer.parseInt(choix)).setDexterite(afterDexterite);
                        point = point - dexterite;
                        System.out.println("Vous avez " + point + " points à répartir");
                        break;
                    }
                }
            case "3":
                System.out.println("Vous avez choisi Force");
                System.out.println("Combien de points souhaitez-vous rajouter ?");
                int force = Master.scanner.nextInt();
                if (force > point) {
                    System.out.println("Vous n'avez pas assez de points !");
                    break;
                } else {
                    int beforeForce = etudiants.get(Integer.parseInt(choix)).getForce();
                    int afterForce = beforeForce + force;
                    if (afterForce > 10) {
                        System.out.println("Vous ne pouvez pas dépassser les 10 points !");
                        break;
                    } else {
                        etudiants.get(Integer.parseInt(choix)).setForce(afterForce);
                        point = point - force;
                        System.out.println("Vous avez " + point + " points à répartir");
                        break;
                    }
                }
            case "4":
                System.out.println("Vous avez choisi Resistance");
                System.out.println("Combien de points souhaitez-vous rajouter ?");
                int resistance = Master.scanner.nextInt();
                if (resistance > point) {
                    System.out.println("Vous n'avez pas assez de points !");
                    break;
                } else {
                    int beforeResistance = etudiants.get(Integer.parseInt(choix)).getResistance();
                    int afterResistance = beforeResistance + resistance;
                    if (afterResistance > 10) {
                        System.out.println("Vous ne pouvez pas dépassser les 10 points !");
                        break;
                    } else {
                        etudiants.get(Integer.parseInt(choix)).setResistance(afterResistance);
                        point = point - resistance;
                        System.out.println("Vous avez " + point + " points à répartir");
                        break;
                    }
                }
            case "5":
                System.out.println("Vous avez choisi Constitution");
                System.out.println("Combien de points souhaitez-vous rajouter ?");
                int constitution = Master.scanner.nextInt();
                if (constitution > point) {
                    System.out.println("Vous n'avez pas assez de points !");
                    break;
                } else {
                    int beforeConstitution = etudiants.get(Integer.parseInt(choix)).getConstitution();
                    int afterConstitution = beforeConstitution + constitution;
                    if (afterConstitution > 30) {
                        System.out.println("Vous ne pouvez pas dépassser les 30 points !");
                        break;
                    } else {
                        etudiants.get(Integer.parseInt(choix)).setConstitution(afterConstitution);
                        point = point - constitution;
                        System.out.println("Vous avez " + point + " points à répartir");
                        break;
                    }
                }
            case "6":
                Strategie change = Strategie.ALEATOIRE;
                System.out.println("Vous avez choisi Stratégie");
                System.out.println("Quelle stratégie souhaitez-vous ? (1 : Offensive, 2 : Defensive, 3 : Aleatoire)");
                String strategie = Master.scanner.nextLine();
                switch (strategie) {
                    case "1":
                        change = Strategie.OFFENSIVE;
                        break;
                    case "2":
                        change = Strategie.DEFENSIVE;
                        break;
                    case "3":
                        change = Strategie.ALEATOIRE;
                        break;
                }
                etudiants.get(Integer.parseInt(choix)).setStrategie(change);
                break;
            case "8":
                System.out.println("Vous avez choisi Fin");
                break;
        }

    }

    public void listEtudiant() {
        // Afficher les caractéristiques d'un étudiant
        for (int i = 0; i < etudiants.size(); i++) {
            System.out.printf(
                    "Etudiant " + i + ",("
                            + etudiants.get(i).getNiveauEtudiant() + ", " + etudiants.get(i).getEcts()
                            + " ECTS, " + etudiants.get(i).getDexterite() + " dexterité, " +
                            etudiants.get(i).getForce()
                            + " force, " + etudiants.get(i).getResistance() + " resistance, "
                            + etudiants.get(i).getConstitution() + " constitution, " +
                            etudiants.get(i).getInitiative()
                            + " initiative, stratégie " + etudiants.get(i).getStrategie());
            System.out.println(", id :" + etudiants.get(i) + ")");
        }
    }

    Utm maps = new Utm();

    public void startMap() {
        // Add tous les ids à la reserve
        for (int i = 0; i < etudiants.size(); i++) {
            Etudiant id = etudiants.get(i).getEtudiant();
            maps.getMaps().get(5).getEtudiants().add(id);
        }

        maps.listMaps();
        System.out.println(
                "Entrer list pour afficher la liste des zones, le nom d'une zone (bb, be, qa, hi, hs, re) pour connaître les etudiants en faisant parti ou start pour commencer, sinon entrer le numéro de l'etudiant que vous souhaitez changer de zone");

        boolean finMap = false;
        while (finMap == false) {
            String entry = Master.scanner.nextLine();
            switch (entry) {
                case "list":
                    maps.listMaps();
                    break;
                case "bb":
                    maps.listZone(0);
                    break;
                case "be":
                    maps.listZone(1);
                    break;
                case "qa":
                    maps.listZone(2);
                    break;
                case "hi":
                    maps.listZone(3);
                    break;
                case "hs":
                    maps.listZone(4);
                    break;
                case "re":
                    maps.listZone(5);
                    break;
                case "start":
                    int reserve = maps.getMaps().get(5).getEtudiants().size();
                    if (reserve == 5) {
                        finMap = true;
                        break;
                    } else if (reserve < 5) {
                        System.out.println("Il n'y a pas assez d'étudiants de déployer dans les zones");
                        break;
                    } else {
                        System.out.println("Il y a trop d'étudiants dans la réserve");
                        break;
                    }
                case "0":
                    configMap(entry);
                    break;
                case "1":
                    configMap(entry);
                    break;
                case "2":
                    configMap(entry);
                    break;
                case "3":
                    configMap(entry);
                    break;
                case "4":
                    configMap(entry);
                    break;
                case "5":
                    configMap(entry);
                    break;
                case "6":
                    configMap(entry);
                    break;
                case "7":
                    configMap(entry);
                    break;
                case "8":
                    configMap(entry);
                    break;
                case "9":
                    configMap(entry);
                    break;
                case "10":
                    configMap(entry);
                    break;
                case "11":
                    configMap(entry);
                    break;
                case "12":
                    configMap(entry);
                    break;
                case "13":
                    configMap(entry);
                    break;
                case "14":
                    configMap(entry);
                    break;
                case "15":
                    configMap(entry);
                    break;
                case "16":
                    configMap(entry);
                    break;
                case "17":
                    configMap(entry);
                    break;
                case "18":
                    configMap(entry);
                    break;
                case "19":
                    configMap(entry);
                    break;
                default:
                    System.out.println(
                            "Entrer list pour afficher la liste des zones, le nom d'une zone (bb, be, qa, hi, hs, re) pour connaître les etudiants en faisant parti ou start pour commencer, sinon entrer le numéro de l'etudiant que vous souhaitez changer de zone");
            }
        }

    }

    public void configMap(String entry) {
        int num = Integer.parseInt(entry);
        System.out.println(
                "Entrer la zone de destination (0:BIBLIOTHEQUE, 1:BUREAU_ETUDIANTS, 2:QUARTIER_ADMINISTRATIF, 3:HALLES_INDUSTRIELLES, 4:HALLE_SPORTIVE, 5:RESERVE)");
        String dest = Master.scanner.nextLine();
        switch (dest) {
            case "0":
                for (int i = 0; i < maps.getMaps().size(); i++) {
                    maps.getMaps().get(i).getEtudiants().remove(etudiants.get(num).getEtudiant());
                }
                maps.getMaps().get(0).getEtudiants().add(etudiants.get(num).getEtudiant());
                break;
            case "1":
                for (int i = 0; i < maps.getMaps().size(); i++) {
                    maps.getMaps().get(i).getEtudiants().remove(etudiants.get(num).getEtudiant());
                }
                maps.getMaps().get(1).getEtudiants().add(etudiants.get(num).getEtudiant());
                break;
            case "2":
                for (int i = 0; i < maps.getMaps().size(); i++) {
                    maps.getMaps().get(i).getEtudiants().remove(etudiants.get(num).getEtudiant());
                }
                maps.getMaps().get(2).getEtudiants().add(etudiants.get(num).getEtudiant());
                break;
            case "3":
                for (int i = 0; i < maps.getMaps().size(); i++) {
                    maps.getMaps().get(i).getEtudiants().remove(etudiants.get(num).getEtudiant());
                }
                maps.getMaps().get(3).getEtudiants().add(etudiants.get(num).getEtudiant());
                break;
            case "4":
                for (int i = 0; i < maps.getMaps().size(); i++) {
                    maps.getMaps().get(i).getEtudiants().remove(etudiants.get(num).getEtudiant());
                }
                maps.getMaps().get(4).getEtudiants().add(etudiants.get(num).getEtudiant());
                break;
            case "5":
                for (int i = 0; i < maps.getMaps().size(); i++) {
                    maps.getMaps().get(i).getEtudiants().remove(etudiants.get(num).getEtudiant());
                }
                maps.getMaps().get(5).getEtudiants().add(etudiants.get(num).getEtudiant());
                break;
            default:
                System.out.println("Entrer une zone valide");
                break;
        }

    }

    // Affichage de toute les zones et leurs étudiants respectifs
    public void startCombat(Player player) {
        for (int i = 0; i < maps.getMaps().size(); i++) {
            System.out.println(maps.getMaps().get(i).getZone());
            for (int j = 0; j < maps.getMaps().get(i).getEtudiants().size(); j++) {
                System.out.println(maps.getMaps().get(i).getEtudiants().get(j));
            }
        }

        int max = 0;
        Etudiant etudiant = null;
        for (int i = 0; i < etudiants.size(); i++) {
            if (etudiants.get(i).getInitiative() > max) {
                max = etudiants.get(i).getInitiative();
                etudiant = etudiants.get(i);

            }
        }
    }

    // Getters et Setters
    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public ArrayList<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(ArrayList<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

}
