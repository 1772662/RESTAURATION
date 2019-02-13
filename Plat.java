
public class Plat {

	private String nomPlat;
	private double prix;

	public Plat() {

	}

	public Plat(String nomPlat, double prix) {
			this.nomPlat = nomPlat;
			this.prix = prix;

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
