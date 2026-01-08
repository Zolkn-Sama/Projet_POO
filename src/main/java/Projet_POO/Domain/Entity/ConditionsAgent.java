package Projet_POO.Domain.Entity;

public class ConditionsAgent {

    private boolean chienAutorise;
    private boolean fumerAutorise;
    private String commentaire;

    public ConditionsAgent() {
    }

    public ConditionsAgent(boolean chienAutorise, boolean fumerAutorise, String commentaire) {
        this.chienAutorise = chienAutorise;
        this.fumerAutorise = fumerAutorise;
        this.commentaire = commentaire;
    }

    public boolean isChienAutorise() {
        return chienAutorise;
    }

    public void setChienAutorise(boolean chienAutorise) {
        this.chienAutorise = chienAutorise;
    }

    public boolean isFumerAutorise() {
        return fumerAutorise;
    }

    public void setFumerAutorise(boolean fumerAutorise) {
        this.fumerAutorise = fumerAutorise;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return "ConditionsAgent{" +
                "chienAutorise=" + chienAutorise +
                ", fumerAutorise=" + fumerAutorise +
                ", commentaire='" + commentaire + '\'' +
                '}';
    }
}
