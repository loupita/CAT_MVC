package web;

import java.util.ArrayList;
import java.util.List;

import metier.Produit;

public class ProduitModel {
	private Produit produit=new Produit();
	private String errors;
	private String mode="ajout";
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	private String motCle;
	private List<Produit> produits = new ArrayList<Produit>();
	public String getMotCle() {
		return motCle;
	}
	public String getErrors() {
		return errors;
	}
	public void setErrors(String errors) {
		this.errors = errors;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
}
