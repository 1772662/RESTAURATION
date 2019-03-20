package gestion_restauration;

public class Taxes {

	public final double TPS = 0.05;
	public final double TVQ = 0.10;
	
	private double montantTaxes;
	
	
	public double calculerMontantTaxes(double montant) {
		return (montant * (TPS + TVQ));
	}
	
	


	public double getMontantTaxes() {
		return montantTaxes;
	}

	public void setMontantTaxes(double montantTaxes) {
		this.montantTaxes = montantTaxes;
	}
	
	
}