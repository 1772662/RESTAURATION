package gestion_restauration;

import exceptions.CommandeException;

public class Commande {

	private Client client;
	private String nomPlat;
	private int quantite;

	public Commande() {

	}

	public Commande(Client client, String  nomPlat, int quantite) throws CommandeException {
		this.client = client;
		this.nomPlat = nomPlat;
		this.quantite = quantite;
		
		if (quantite < 0) {
			throw new CommandeException("La quantité du plat ne peut pas être négative.");
		}
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
	
