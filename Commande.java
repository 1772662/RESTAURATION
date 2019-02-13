
public class Commande {
	private Client client;
	private String nomPlat;
	private int quantite;

	public Commande() {

	}

	public Commande(Client client, String  nomPlat, int quantite) {
			this.client = client;
			this.nomPlat = nomPlat;
			this.quantite = quantite;

	}

	public String getnomClient () {
			return  this.client.getNom() ;
	}
	public String getnomPlat () {
			return  this.nomPlat ;
		}
	public int getQte () {
			return  this.quantite ;
		}
		
}
	
