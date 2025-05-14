import java.util.*;

public class Etudiant extends Personne {
    private List<CompteRendu> compteRendu;

    public Etudiant(int idPers, String nom, String email, String login, String motDePasse) {
        super(idPers, nom, email, login, motDePasse);
        this.compteRendu = new ArrayList<>();
    }

  //  Fonction pour rediger un compte rendu pour les activités réalisées par un etudiant
    public void redigerCompteRendu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Rédigez votre compte rendu d'activité (appuyez sur Entrée pour terminer) :");
        String contenu = scanner.nextLine();
        Date dSoumis = new Date();
        CompteRendu cr = new CompteRendu(compteRendu.size() + 1, contenu, dSoumis, "soumis");
        compteRendu.add(cr);
        System.out.println(this.nom + " a ajouté un nouveau compte rendu d'activité.");
    }
    // Fonction pour renvoyer les comptes rendus de letudiant
    public List<CompteRendu> getCompteRendu() {
        return compteRendu;
    }
}
