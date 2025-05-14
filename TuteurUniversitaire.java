import java.util.*;

public class TuteurUniversitaire extends Personne {
    private List<Etudiant> etudiants;
    private List<CompteRendu> compteRenduVisite;
    private List<Visite> visites;

    public TuteurUniversitaire(int idPers, String nom, String email, String login, String motDePasse) {
        super(idPers, nom, email, login, motDePasse);
        this.etudiants = new ArrayList<>();
        this.compteRenduVisite = new ArrayList<>();
        this.visites = new ArrayList<>();
    }

    public void ajouterEtudiant(Etudiant etudiant) {
        this.etudiants.add(etudiant);
    }

    public List<CompteRendu> getCompteRenduVisite() {
        return compteRenduVisite;
    }
     // Fonction pour planifier une visite avec un etudiant
    public void ajouterVisite() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nom de l'étudiant (Entrer pour terminer) : ");
        String nomEtudiant = scanner.nextLine();
        System.out.println("Rédigez le rapport de la visite (Entrer pour terminer) : ");
        String rapport = scanner.nextLine();
        Date dateVisite = new Date();
        Visite v = new Visite(visites.size() + 1, "Visite " + (visites.size() + 1), dateVisite, rapport);
        visites.add(v);
        System.out.println("Visite organisée avec " + nomEtudiant);
    }

  // Fonction pour afficher les comptes rendus des etudiants
    public void afficherComptesRendus() {
        for (Etudiant etudiant : etudiants) {
            System.out.println("Étudiant : " + etudiant.getNom());
            List<CompteRendu> comptes = etudiant.getCompteRendu();

            if (comptes.isEmpty()) {
                System.out.println(" Aucun compte rendu disponible.");
                continue;
            }

            for (CompteRendu cr : comptes) {
                System.out.println("Contenu : " + cr.getContenu());
                System.out.println("Date : " + cr.getSoumis());
                System.out.println("État : " + cr.getEtat());
            }
        }
    }

   // Fonction pour tuteur universitaire qui permet de rediger un compte apres une visite effectue a un etudiant
    public void redigerCompteRenduVisite() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Rédigez votre compte rendu de visite (appuyez sur Entrée pour terminer) :");
        String contenu = scanner.nextLine();
        Date soumis = new Date();
        CompteRendu crV = new CompteRendu(compteRenduVisite.size() + 1, contenu, soumis, "soumis");
        compteRenduVisite.add(crV);
        System.out.println(this.nom + " a ajouté un nouveau compte rendu de visite.");
    }

    // Fonction qui permet au tuteur universitaire de valider les comptes des etudiants avant deffectuer un compte pour un tuteur entreprise
    public void validerComptesRendus() {
        Scanner scanner = new Scanner(System.in);
        for (Etudiant etudiant : etudiants) {
            List<CompteRendu> comptes = etudiant.getCompteRendu();
            for (CompteRendu crV : comptes) {
                if (!crV.getEtat().equals("validé")) {
                    System.out.println("\nCompte rendu de " + etudiant.getNom());
                    System.out.println("Contenu : " + crV.getContenu());
                    System.out.println("Date : " + crV.getSoumis());
                    System.out.println("État : " + crV.getEtat());

                    System.out.print("Validez ce compte rendu ? (oui/non) : ");
                    String reponse = scanner.nextLine().toLowerCase();
                    if (reponse.equals("oui")) {
                        crV.valider();
                        System.out.println("Compte rendu validé !");
                    }
                }
            }
        }
    }
}
