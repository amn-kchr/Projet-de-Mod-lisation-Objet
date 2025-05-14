public abstract class Personne {
    protected int idPers;
    protected String nom;
    protected String email;
    protected String login;
    protected String motDePasse;

 // Constructeur Personne
    public Personne(int idPers, String nom, String email, String login, String motDePasse) {
        this.idPers = idPers;
        this.nom = nom;
        this.email = email;
        this.login = login;
        this.motDePasse = motDePasse;
    }
    // authentification
    
    public boolean seConnecter(String login, String mdp) {
        return this.login.equals(login) && this.motDePasse.equals(mdp);
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }
}
