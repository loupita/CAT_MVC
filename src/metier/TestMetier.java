package metier;

import java.util.List;

public class TestMetier {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	ICatalogue metier= new CatalogueMetierImpl();
	/*metier.addProduit(new Produit("REF05", "AA", 870, 3));
	metier.addProduit(new Produit("REF06", "BB", 345, 3));
	metier.addProduit(new Produit("REF07", "CC", 65, 3));*/
	
	System.out.println("-----------------------------");
	List<Produit> prods = metier.listProduits();
	for(Produit p:prods) System.out.println(p.getDestination());
	}

}
