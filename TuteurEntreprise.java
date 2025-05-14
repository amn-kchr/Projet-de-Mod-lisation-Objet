import java.util.*;

public class TuteurEntreprise extends Personne {
    private String entreprise;
    private List<TuteurUniversitaire> tuteurUs;

    public TuteurEntreprise(int idPers, String nom, String email, String login, String motDePasse, String entreprise) {
        super(idPers, nom, email, login, motDePasse);
        this.entreprise = entreprise;
        this.tuteurUs = new ArrayList<>();
    }

    public void ajouterTuteurUniversitaire(TuteurUniversitaire tuteurU) {
        tuteurUs.add(tuteurU);
    }

        // Fonction qui permet au tuteur entreprise de valider les comptes rendus des tuteurs universitaires 
    public void validerComptesRendusVisite() {
        Scanner scanner = new Scanner(System.in);
        for (TuteurUniversitaire tuteurU : tuteurUs) {
            List<CompteRendu> comptesV = tuteurU.getCompteRenduVisite();
            for (CompteRendu crV : comptesV) {
                System.out.println("\nCompte rendu de visite de " + tuteurU.getNom());
                System.out.println("Contenu : " + crV.getContenu());
                System.out.println("Date : " + crV.getSoumis());
                System.out.println("État : " + crV.getEtat());

                System.out.print("Validez ce compte rendu ? (oui/non) : ");
                String reponse = scanner.nextLine().toLowerCase();
                if (reponse.equals("oui")) {
                    crV.valider();
                    System.out.println("Compte rendu validé !");
                } else {
                    System.out.println("Modifier le compte rendu de visite soumis par " + tuteurU.getNom() + " (appuyez sur Entrée pour terminer) :");
                    String contenuModifier = scanner.nextLine();
                    crV.setContenu(contenuModifier);
                    crV.valider();
                    System.out.println("Modification de compte rendu de visite de  " + tuteurU.getNom() + " effectuée !");
                }
            }
        }
    }
}
