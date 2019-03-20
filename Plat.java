package gestion_restauration;

import exceptions.PlatException;

public class Plat {

	private String nomPlat;
	private double prix;

	public Plat() {

	}

	public Plat(String nomPlat, double prix) throws PlatException {
		this.nomPlat = nomPlat;
		this.prix = prix;
		
		if (prix <= 0) {
			throw new PlatException("Le prix du plat ne peut pas être de zéro ou ou négatif.");
		} else if (!this.nomPlat.matches("/[a-zA-Z]")) {
			throw new PlatException("Le format du nom du plat n’est pas respecté.");
		}

	}

	public void setNomPlat(String nomPlat) {
		this.nomPlat = nomPlat;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getNomPlat() {
		return this.nomPlat;
	}

	public double getPrix() {
		return this.prix;
	}
}
