
package test;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import main.Client;
import main.Commande;
import main.MainPartie2;
import main.Plat;

import java.io.PrintWriter; 

public class MainTest {
 


	@Test
	public void testClientString() {
	
	
	   Client cli = new Client("Amina") ;
       assertEquals( "Amina",  cli.getNom()  );
		
	}

	@Test
	public void testSetNom() {
		
		Client cli = new Client() ;
		cli.setNom("Amina"); 
		assertEquals("le nom ne match pas", "Amina",  cli.getNom()  );
	
		cli.setNom("Atmane"); 
		assertEquals("le nom ne match pas", "Atmane",  cli.getNom()  );
	
		cli.setNom("Toto"); 
		assertEquals("le nom ne match pas", "Toto",  cli.getNom()  );
		
	}

	@Test
	public void testGetNom() {
	
		Client cli = new Client() ;
		cli.setNom("Amina"); 
		assertEquals( "Amina",  cli.getNom()  );
	
		cli.setNom("Roger"); 
		assertEquals( "Roger",  cli.getNom()  );
		
		
	}
	
	@Test
	public void testCommande() {
	
		Client cli = new Client("Céline") ;
	    Commande c = new Commande(cli, "Frites", 2) ;
	 	assertEquals( "Céline", c.getClient());

	}

	@Test
	public void testCommandeClientStringInt() {

	Client cli = new Client("Roger") ;
    Commande c = new Commande(cli, "Poutine", 2) ;
 	assertEquals( "Roger", c.getClient());
	assertEquals( "Poutine", c.getPlat());
	assertEquals( 2, c.getQte());

	Client cli2 = new Client("Céline") ;
    Commande c2 = new Commande(cli, "Poutine", 5) ;
	assertEquals( "Céline", cli2.getNom());
	assertEquals( "Poutine", c2.getPlat());
	assertEquals( 5, c2.getQte());

	Client cli3 = new Client("Steeve") ;
    Commande c3 = new Commande(cli, "Poutine", 6) ;
	assertEquals( "Steeve", cli3.getNom());
	assertEquals( "Poutine", c3.getPlat());
	assertEquals( 6, c3.getQte());
	
	Client cli4 = new Client("Amina") ;
    Commande c4 = new Commande(cli, "Patate", 7) ;
	assertEquals( "Amina", cli4.getNom());
	assertEquals( "Patate", c4.getPlat());
	assertEquals( 7, c4.getQte());
	
	}
	
	@Test
	public void testGetnomClient() {
		
		Client cli = new Client("Roger") ;
	    Commande c = new Commande(cli, "Poutine", 2) ;
		assertEquals( "Roger", c.getClient());
	}

	@Test
	public void testGetnomPlat() {

		Client cli = new Client("Roger") ;
	    Commande c = new Commande(cli, "Poutine", 2) ;
		assertEquals( "Poutine", c.getPlat());
	}

	@Test
	public void testGetQte() {
		Client cli = new Client("Roger") ;
	    Commande c = new Commande(cli, "Poutine", 2) ;
		assertEquals( 2, c.getQte());
	}

	@Test
	public void testPlatStringDouble() {
    
	Plat p = new Plat("Poutine",3.0);
    assertEquals( "Poutine", p.getNomPlat());
    assertEquals( 3, p.getPrix(),0);
    
    Plat p1 = new Plat("Frites",6.0);
    assertEquals( "Frites", p1.getNomPlat());
    assertEquals( 6.0, p1.getPrix(),0);
   
    Plat p2 = new Plat("Frites",3.4);
    assertEquals( "Frites", p2.getNomPlat());
    assertEquals( 3.4, p2.getPrix(),0);
   
    Plat p3 = new Plat("Frites",1.5);
    assertEquals( "Frites", p3.getNomPlat());
    assertEquals( 1.5, p3.getPrix(),0);
  
    Plat p4 = new Plat("Frites",7.5);
    assertEquals( "Frites", p4.getNomPlat());
    assertEquals( 7.5, p4.getPrix(),0);
  
    Plat p5 = new Plat("Frites",9.3);
    assertEquals( "Frites", p5.getNomPlat());
    assertEquals(9.3, p5.getPrix(),0);
   }
	
	@Test
	public void testSetNomPlat() {
	Plat p = new Plat();
	p.setNomPlat("Poutine");
	assertEquals( "Poutine", p.getNomPlat());
	}

	@Test
	public void testSetPrix() {
	Plat p = new Plat();
	p.setPrix(12.5);
	assertEquals( 12.5, p.getPrix(),0);
		
	}

	@Test
	public void testGetNomPlat() {
		Plat p = new Plat();
		p.setNomPlat("Poutine");
		assertEquals( "Poutine", p.getNomPlat());
		
	}

	@Test
	public void testGetPrix() {

		Plat p = new Plat();
		p.setPrix(12.5);
		assertEquals( 12.5, p.getPrix(),0);
	
	}	
	
	@Test
	public void testClient() {
		Client cli = new Client() ;
	  cli.setNom("Roger");
		assertEquals( "Roger", cli.getNom());
	}
	
}
