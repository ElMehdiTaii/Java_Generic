import java.io.Serializable;

public class Produit implements Serializable {
    private int id;
    private String nom;
    private String marque;
    private double prix;
    private String description;
    private int nombreEnStock;

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNombreEnStock(int nombreEnStock) {
        this.nombreEnStock = nombreEnStock;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getMarque() {
        return marque;
    }

    public double getPrix() {
        return prix;
    }

    public String getDescription() {
        return description;
    }

    public int getNombreEnStock() {
        return nombreEnStock;
    }

    public Produit(int id, String nom, String marque, double prix, String description, int nombreEnStock) {
        this.id = id;
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nombreEnStock = nombreEnStock;
    }


}
