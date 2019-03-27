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
			throw new PlatException("Le prix du plat ne peut pas �tre de z�ro ou ou n�gatif.\n");
		} else if (prix >= 5000) {
			throw new PlatException("Le prix du plat ne peut pas d�passer 5000.\n");
		} else if (nomPlat.length() >= 20) {
			throw new PlatException("Le nom du plat ne peut d�passer 20 caract�res.\n");
		} else if (nomPlat.length() == 0) {
			throw new PlatException("Le nom du plat doit avoir plus de 0 caract�res.\n");
		}
//		else if (this.nomPlat.matches("[A-Za-z]")) {
//			throw new PlatException("Le format du nom du plat n�est pas respect�.\n");
//		}

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
