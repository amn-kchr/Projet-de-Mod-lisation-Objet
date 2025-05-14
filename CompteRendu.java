import java.util.*;

public class CompteRendu {
    private int idCr;
    private String contenu;
    private Date soumis;
    private String etat;

    public CompteRendu(int idCr, String contenu, Date soumis, String etat) {
        this.idCr = idCr;
        this.contenu = contenu;
        this.soumis = soumis;
        this.etat = etat;
    }

    public void valider() {
        this.etat = "validé";
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getSoumis() {
        return soumis;
    }

    public String getEtat() {
        return etat;
    }
}
