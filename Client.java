package gestion_restauration;

import exceptions.ClientException;

public class Client {

	private String nomClient;

	public Client() {

	}
	// Constreur avec param�tre complet

	public Client(String nomClient) throws ClientException {
		this.nomClient = nomClient;
		
		if (this.nomClient.isEmpty()) {
			throw new ClientException("Le nom du client n'existe pas.\n");
		} else if (nomClient.length() >= 20) {
			throw new ClientException("Le nom du client ne doit pas d�passer 20 caract�res.\n");
		}
//		else if (!this.nomClient.matches("[a-zA-Z]")) {
//			throw new ClientException("Le format du nom du client n�est pas respect�.\n");
//		}
	}

	// Methode accesseur

	public void setNom(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getNom() {
		return this.nomClient;
	}

}

