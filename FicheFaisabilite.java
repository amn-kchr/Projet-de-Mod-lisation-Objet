import java.util.Date;

public class FicheFaisabilite {
    private int idF;
    private String mission;
    private String entreprise;
    private String status;
    private Date dateSoumission;

    public FicheFaisabilite(int idF, String mission, String entreprise, String status, Date dateSoumission) {
        this.idF = idF;
        this.mission = mission;
        this.entreprise = entreprise;
        this.status = status;
        this.dateSoumission = dateSoumission;
    }

    public void valider() {
        this.status = "validé";
    }

    public void modifier(String newMission) {
        this.mission = newMission;
    }
}
