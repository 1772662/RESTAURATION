package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;

public class MainPartie2 {

	private static final int NB_MAX = 30; 
	

	public static void main(String[] args) {

		Client[] clients = new Client[NB_MAX];
		Plat[] plats = new Plat[NB_MAX];
		Commande[] commandes = new Commande[NB_MAX];
		
		PrintWriter  writer = null;
 
	
		byte[] bytes = null ;
		try {
			
			
		
			File file = new File("Test.txt");
			FileInputStream fis = new FileInputStream(file);
			bytes = new byte[(int) file.length()]; 
			fis.read(bytes);
			fis.close();
			
			writer = new PrintWriter("Facture-du-date-heure.txt");
		
		
		} catch (Exception e) 
		{
			System.out.println("Erreur de lecture du fichier");
			
		}
		
			clients = liresClients(bytes,NB_MAX);
	
			try {
			plats = liresPlats(bytes,NB_MAX, writer);
			} catch (NumberFormatException e)
			{
				//
				
			}	
try {			
			commandes = liresCommandes(bytes,NB_MAX);
	} catch (NumberFormatException e)
	{
		//
		
	}

			
			
			// si il n ya pas de commandes 
			if (commandes != null ) {
				
				String nomClient ="";
				String nomPlat ="";
	 	double prix=0.0;
				// Afficher dans le terminal et ecrire les erreurs dans le fichier 
				for (int l = 0; l < commandes.length && commandes[l] != null; l++) {
					
					nomClient = commandes[l].getClient() ;
					nomPlat   = commandes[l].getPlat() ;
					prix      = getPrixduPlat(nomPlat, plats); 
					
					if (!clientExist(clients, nomClient)) 
					{
						System.out.println("Commande incorrecte\n\nLe client "+nomClient +" n'existe pas.");
						writer.println("Commande incorrecte\n\nLe client "+nomClient +" n'existe pas.");
					}
					
				
					if (!platExist(plats, nomPlat) ) 
					{
						System.out.println("Commande incorrecte\n\nLe Plat "+nomPlat +" n'exit pas.");
						writer.println("Commande incorrecte\n\nLe Plat "+nomPlat +" n'exit pas.");
					}
				}
				
				
				
				
				
				
				
				
				
				
				
				
					writer.close();

			
			} else { // message d'erreur dans les commandes
				System.out.println("Le fichier ne respecte pas le format demandé !");
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
	public static Client[] liresClients(byte[] bytes, int j) {
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
	public static Plat[] liresPlats(byte[] bytes, int j, PrintWriter f) {

		Plat[] platsList = new Plat[NB_MAX];
		
			String text = new String(bytes);
			String plats = text.substring(text.indexOf("Plats :"), text.lastIndexOf("Commandes :"));
			String[] listesPlats = plats.split("\r\n");
		     int k=0;
			for (int i = 1; i < listesPlats.length; i++) {
				String plat = listesPlats[i].split(" ")[0];
				String prix = listesPlats[i].split(" ")[1];
				double d =0.0;
				try {
				d=Double.parseDouble(prix) ;
				Plat p = new Plat(plat, (Double.parseDouble(prix)));
				platsList[k] = p;
				k++;
				} catch (Exception e) 
				{
					System.out.println("Erreur dans la list des plats "+ e.getMessage() );
					f.println("Erreur dans la list des plats "+ e.getMessage());
				}
			   }
		
		return platsList;
	}
	
	
	

	// get les commandes du fichier text
	public static Commande[] liresCommandes(byte[] bytes, int j) {

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
	
	/////////////////////////////////////////////////////////////////////////////////////
	
	// verifier que un Plat de la commande exist dans la list des
	// Plats
	
	
	
	
	
	
	
	/////////////////////////////////////////////////////////////
	//Moiiiii
	
	public static boolean platExist(Plat[] plt, String nomPlat) {
		boolean trouve = false;
		for (int l = 0; l < plt.length && plt[l] != null; l++) {
		    if (nomPlat.equals(plt[l].getNomPlat())) {
		   		trouve = true;
				break;
				}
		}
		return trouve;
	}
	
	
	public static  byte[] lireficher(String nomficher)
	{
	byte[] bytes = null ;
	try{
	File file = new File(nomficher);
	FileInputStream fis = new FileInputStream(file);
	bytes = new byte[(int) file.length()];
	fis.read(bytes);
	fis.close();
	} catch (Exception e)
	{
		bytes = null ;
	}
	return bytes ;
	}
	
	public static boolean clientExist(Client[] cli, String nomClient) {
		boolean trouve = false;
		for (int l = 0; l < cli.length && cli[l] != null; l++) {
		    if (nomClient.equals(cli[l].getNom())) {
		   		trouve = true;
				break;
				}
		}
		return trouve;
	}
}