package td2;

public class Article {
    private String nom;
    private double pu;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPu() {
        return pu;
    }

    public void setPu(double pu) {
        this.pu = pu;
    }

    @Override
    public String toString() {
        return "Article{" +
                "nom='" + nom + '\'' +
                ", pu=" + pu +
                '}';
    }

    public Article(String nom, double pu) {
        this.nom = nom;
        this.pu = pu;
    }
}
