package metier;
import java.io.Serializable;

public class Produit implements Serializable{

		public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
		private String reference;
		private String destination;
		private double prix;
		private int quantite;
		public Produit(String reference, String destination, double prix, int quantité) {
			super();
			this.reference = reference;
			this.destination = destination;
			this.prix = prix;
			this.quantite = quantite;
		}
		public String getReference() {
			return reference;
		}
		public void setReference(String reference) {
			this.reference = reference;
		}
		public String getDestination() {
			return destination;
		}
		public void setDestination(String destination) {
			this.destination = destination;
		}
		public double getPrix() {
			return prix;
		}
		public void setPrix(double prix) {
			this.prix = prix;
		}
		public int getQuantite() {
			return quantite;
		}
		public void setQuantite(int quantite) {
			this.quantite = quantite;
		}
}
