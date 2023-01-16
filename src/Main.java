import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        IMetier<Produit, Integer> metier = new MetierProduitImpl("produits.dat");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Afficher la liste des produits");
            System.out.println("2. Rechercher un produit par son id");
            System.out.println("3. Ajouter un nouveau produit dans la liste");
            System.out.println("4. Supprimer un produit par id");
            System.out.println("5. Sauvegarder les produits");
            System.out.println("6. Quitter");

            int choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1:
                    List<Produit> produits = metier.getAll();
                    for (Produit produit : produits) {
                        System.out.println(produit);
                    }
                    break;
                case 2:
                    System.out.println("Entrez l'id du produit à rechercher : ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Produit produit = metier.findById(id);
                    if (produit != null) {
                        System.out.println(produit);
                    } else {
                        System.out.println("Aucun produit trouvé pour cet id");
                    }
                    break;
                case 3:
                    System.out.println("Entrez les informations du nouveau produit (id, nom, marque, prix, description, nombre en stock) : ");
                    int newId = sc.nextInt();
                    sc.nextLine();
                    String newNom = sc.nextLine();
                    String newMarque = sc.nextLine();
                    double newPrix = sc.nextDouble();
                    String newDescription = sc.nextLine();
                    int newNombreEnStock = sc.nextInt();
                    Produit newProduit = new Produit(newId, newNom, newMarque, newPrix, newDescription, newNombreEnStock);
                    metier.add(newProduit);
                    System.out.println("Produit ajouté avec succès");
                    break;
                case 4:
                    System.out.println("Entrez l'id du produit à supprimer : ");
                    int idToDelete = sc.nextInt();
                    sc.nextLine();
                    metier.delete(idToDelete);
                    System.out.println("Produit supprimé avec succès");
                    break;
                case 5:
                    metier.saveAll();
                    System.out.println("Produits sauvegardés avec succès");
                    break;
                case 6:
                    sc.close();

            }
        }
    }
}