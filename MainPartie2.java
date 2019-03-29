package main;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;

public class MainPartie2 {

	private static final int NB_MAX = 10; //PEUT CHANGER

	public static void main(String[] args) {

		Client[] clients = new Client[NB_MAX];
		Plat[] plats = new Plat[NB_MAX];
		Commande[] commandes = new Commande[NB_MAX];

		try {
			File file = new File("Test.txt");
			FileInputStream fis = new FileInputStream(file);
			byte[] bytes = new byte[(int) file.length()]; // WHAT?
			fis.read(bytes);
			fis.close();

			clients = liresClients(bytes);
			plats = liresPlats(bytes);
			commandes = liresCommandes(bytes);
			
			PrintWriter writer = new PrintWriter("Facture-du-date-heure.txt");
			
			String nomPlat = null;
			
			// si il n ya pas de commandes ou des erruers dans les commandes
			if (commandes != null && Erreur(commandes, clients)) {
				for (int i = 0; i < clients.length && clients[i] != null; i++) {
					double totalFacture = 0.0;
					String nomClient = clients[i].getNom();

					for (int l = 0; l < commandes.length && commandes[l] != null; l++) {
						if (commandes[l].getClient().equals(nomClient)) {
							int qte = commandes[l].getQte();
							nomPlat = commandes[l].getPlat();
							double prix = getPrixduPlat(nomPlat, plats); //CHANGER
							totalFacture += (qte * prix);
							
							if (getPrixduPlat(nomPlat, plats) != 0) {
								System.out.println(nomClient + " " + totalFacture + "$");
								
								writer.println(nomClient + " " + totalFacture + "$");
								
							}
						}
					}
					
				}
				writer.close();

			} else { // message d'erreur dans les commandes
				System.out.println("Le fichier ne respecte pas le format demandé !");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	// get le prix du plan dans la list des plats
	public static double getPrixduPlat(String nomPlat, Plat[] plats) {
		double prix = 0;
		for (int i = 0; i < plats.length && plats[i] != null; i++) {
			if (plats[i].getNomPlat().equals(nomPlat)) {
				prix = plats[i].getPrix();
				break;
			}
		}
		return prix;
	}

	// get les clients a partir du fichier text
	public static Client[] liresClients(byte[] bytes) {
		Client[] clients = new Client[NB_MAX];
		try {
			String text = new String(bytes);
			String client = text.substring(text.indexOf("Clients :"), text.lastIndexOf("Plats :"));

			String[] listesClients = client.split("\r\n");

			for (int i = 1; i < listesClients.length; i++) {

				clients[i - 1] = new Client(listesClients[i]);
			}

		} catch (Exception e) {
			System.out.print(e.toString());
		}
		return clients;
	}

	// get Plats du fichier text
	public static Plat[] liresPlats(byte[] bytes) {

		Plat[] platsList = new Plat[NB_MAX];

		try {
			String text = new String(bytes);
			String plats = text.substring(text.indexOf("Plats :"), text.lastIndexOf("Commandes :"));
			String[] listesPlats = plats.split("\r\n");
			for (int i = 1; i < listesPlats.length; i++) {
				String plat = listesPlats[i].split(" ")[0];
				String prix = listesPlats[i].split(" ")[1];
				Plat p = new Plat(plat, (Double.parseDouble(prix)));
				platsList[i - 1] = p;
			}

		} catch (Exception e) {
			System.out.print(e.toString());
		}
		return platsList;
	}

	// get les commandes du fichier text
	public static Commande[] liresCommandes(byte[] bytes) {

		Commande[] CommandesList = new Commande[NB_MAX];

		try {
			String text = new String(bytes);
			String com = text.substring(text.indexOf("Commandes :"), text.lastIndexOf("Fin"));
			String[] listesCommandes = com.split("\r\n");

			for (int i = 1; i < listesCommandes.length; i++) {

				String cli = listesCommandes[i].split(" ")[0];
				String nomPlat = listesCommandes[i].split(" ")[1];
				String qte = listesCommandes[i].split(" ")[2];

				Client cliobj = new Client(cli);
				Commande cmd = new Commande(cliobj, nomPlat, Integer.parseInt(qte));

				CommandesList[i - 1] = cmd;

			}

		} catch (Exception e) {

			return null;
		}
		return CommandesList;
	}

	// verifier que toutes les clients de la commande exist dans la list des
	// clients
	public static boolean Erreur(Commande[] commande, Client[] client) {
		boolean trouve = false;
		
		for (int i = 0; i < commande.length && commande[i] != null; i++) {
			String nomClient = commande[i].getClient();
			
			for (int j = 0; j < client.length && client[j] != null; j++) {
				
				if (nomClient.equals(client[j].getNom())) {
					trouve = true;
					break;
				}
			}
			if (!trouve) {
				break;
			}
		}
		return trouve;
	}
}
