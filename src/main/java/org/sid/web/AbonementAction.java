package org.sid.web;

import java.util.Date;
import java.util.List;

import org.sid.entites.Abonement;
import org.sid.entites.AbonnementGSM;
import org.sid.entites.AbonnementInternet;
import org.sid.metier.IAbonnementMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

@Component
public class AbonementAction extends ActionSupport {
	@Autowired
	public IAbonnementMetier metier;
	public Long idAbonement;
	public Date dateAbonnement;
	public double solde;
	public boolean actif;
	public String type;
	public int fidelio;
	public int debit;
	public String[] typeAB = new String[] { "", "GSM", "INT" };
	public List<Abonement> abonnements;

	public String index() {
		abonnements = metier.listAbonnements(true);
		
		 for(Abonement ab:abonnements){
	            System.out.println(
	                    ab.getIdAbonement());
	            System.out.println("zineb");
	        }
		
		
		return SUCCESS;
	}

	public String getSubForm() {
		return SUCCESS;
	}

	public String save() {
		Abonement aa;
		if (type.equals("GSM")) {
			aa = new AbonnementGSM(dateAbonnement, solde, actif, fidelio);
		} else 
			aa = new AbonnementInternet(dateAbonnement, solde, actif, debit);

		metier.addAbonnement(aa);
		abonnements = metier.listAbonnements(true);

	return SUCCESS;
	}

}
