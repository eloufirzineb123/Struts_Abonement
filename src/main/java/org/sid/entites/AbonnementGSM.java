package org.sid.entites;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="GSM")
public class AbonnementGSM extends Abonement {
	
	private int fidelio;

	public AbonnementGSM(Date dateAbonnement, double solde, boolean actif, int fidelio) {
		super(dateAbonnement, solde, actif);
		this.fidelio = fidelio;
	}

	public AbonnementGSM() {
		super();
	}

	public int getFidelio() {
		return fidelio;
	}

	public void setFidelio(int fidelio) {
		this.fidelio = fidelio;
	}
	
	

}
