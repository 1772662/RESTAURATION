package main;
public class Commande {

	private Client client;
	private String plat;
	private int qte;

	public Commande() {

	}

	public Commande(Client client, String  plat, int qte) {
		this.client = client;
		this.nomPlat = plat;
		this.qte = qte;
		
	}

	public String getClient () {
	return  this.client.getNom() ;
	}
	public String getPlat () {
		return  this.nomPlat ;
		}
	public int getQte () {
		return  this.qte ;
		}
}
	
