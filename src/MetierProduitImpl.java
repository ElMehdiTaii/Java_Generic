import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class MetierProduitImpl implements IMetier<Produit, Integer>
{
    private List<Produit> produits;
    private String nomFichier;

    public MetierProduitImpl(String nomFichier) {
        this.nomFichier = nomFichier;
        produits = new ArrayList<>();
    }
    @Override
    public Produit add(Produit produit) {
        produits.add(produit);
        return produit;
    }

    @Override
    public List<Produit> getAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomFichier))) {
            produits = (List<Produit>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return produits;
    }

    @Override
    public Produit findById(Integer id) {
        for (Produit produit : produits) {
            if (produit.getId() == id) {
                return produit;
            }
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
            produits.removeIf(p -> p.getId() == id);
    }

    @Override
    public void saveAll() throws IOException {
        File file = new File("produits.dat");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.reset();
        objectOutputStream.writeObject(produits);
    }
}