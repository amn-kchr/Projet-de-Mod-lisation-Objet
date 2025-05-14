import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Création des rôles
        ListeRole listeRole = new ListeRole();
        listeRole.ajouterRole(new Role(1, "Étudiant"));
        listeRole.ajouterRole(new Role(2, "Tuteur Universitaire"));
        listeRole.ajouterRole(new Role(3, "Tuteur Entreprise"));

        // Afficher les rôles disponibles
        listeRole.afficherRoles();

        // Création des utilisateurs
        Etudiant etudiant = new Etudiant(1, "amine", "amine.kechir@etud-u.picardie.fr", "amine.kechir", "k22203848");
        TuteurUniversitaire tuteurU = new TuteurUniversitaire(2, "barry", "barry@etud-u.picardie.fr", "barry", "barry20");
        TuteurEntreprise tuteurE = new TuteurEntreprise(3, "yacine", "yacine@maison-confiance.fr", "yacine", "yacine20", "Maisonconfiance");

        // Établir les relations
        tuteurU.ajouterEtudiant(etudiant);
        tuteurE.ajouterTuteurUniversitaire(tuteurU);

        System.out.println("=== Système de gestion des stages et alternances ===");

        try {
            while (true) {
                // Authentification
                System.out.print("Identifiant : ");
                String login = scanner.nextLine();
                System.out.print("Mot de passe: ");
                String mdp = scanner.nextLine();

                // Vérification des identifiants
                Personne utilisateur = null;
                if (etudiant.seConnecter(login, mdp)) utilisateur = etudiant;
                if (tuteurU.seConnecter(login, mdp)) utilisateur = tuteurU;
                if (tuteurE.seConnecter(login, mdp)) utilisateur = tuteurE;

                if (utilisateur == null) {
                    System.out.println("Identifiants incorrects. Veuillez réessayer !");
                    continue;
                }

                System.out.println("Connecté en tant que " + utilisateur.nom);

                // Gestion des menus selon le type d'utilisateur
                if (utilisateur instanceof Etudiant) {
                    Etudiant et = (Etudiant) utilisateur;
                    System.out.println("Rôle: Étudiant");
                    while (true) {
                        System.out.println("\n1. Rédiger un compte rendu");
                        System.out.println("2. Se déconnecter");
                        System.out.print("Choix: ");

                        try {
                            int choix = Integer.parseInt(scanner.nextLine());
                            if (choix == 1) {
                                et.redigerCompteRendu();
                            } else if (choix == 2) {
                                System.out.println("Déconnexion réussie.");
                                break;
                            } else {
                                System.out.println("Option invalide.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Veuillez entrer un nombre valide.");
                        }
                    }
                } else if (utilisateur instanceof TuteurUniversitaire) {
                    TuteurUniversitaire tu = (TuteurUniversitaire) utilisateur;
                    System.out.println("Rôle: Tuteur Universitaire");
                    while (true) {
                        System.out.println("\n1. Afficher les comptes rendus");
                        System.out.println("2. Valider les comptes rendus");
                        System.out.println("3. Ajouter une visite");
                        System.out.println("4. Rédiger compte rendu de visite");
                        System.out.println("5. Se déconnecter");
                        System.out.print("Choix: ");

                        try {
                            int choix = Integer.parseInt(scanner.nextLine());
                            switch (choix) {
                                case 1:
                                    tu.afficherComptesRendus();
                                    break;
                                case 2:
                                    tu.validerComptesRendus();
                                    break;
                                case 3:
                                    tu.ajouterVisite();
                                    break;
                                case 4:
                                    tu.redigerCompteRenduVisite();
                                    break;
                                case 5:
                                    System.out.println("Déconnexion réussie.");
                                    break;
                                default:
                                    System.out.println("Option invalide.");
                            }
                            if (choix == 5) break;
                        } catch (NumberFormatException e) {
                            System.out.println("Veuillez entrer un nombre valide.");
                        }
                    }
                } else if (utilisateur instanceof TuteurEntreprise) {
                    TuteurEntreprise te = (TuteurEntreprise) utilisateur;
                    System.out.println("Rôle: Tuteur Entreprise");

                    while (true) {
                        System.out.println("\n1. Valider les comptes rendus de visite");
                        System.out.println("2. Se déconnecter");
                        System.out.print("Choix: ");

                        try {
                            int choix = Integer.parseInt(scanner.nextLine());
                            if (choix == 1) {
                                te.validerComptesRendusVisite();
                            } else if (choix == 2) {
                                System.out.println("Déconnexion réussie.");
                                break;
                            } else {
                                System.out.println("Option invalide.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Veuillez entrer un nombre valide.");
                        }
                    }
                }
            }
        } finally {
            scanner.close();
        }
    }
}