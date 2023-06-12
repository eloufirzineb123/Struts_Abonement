package org.sid.metier;

import java.util.Date;
import java.util.List;

import org.sid.entites.Abonement;

public interface IAbonnementMetier {
	
	public void addAbonnement (Abonement ab);
	List <Abonement> listAbonnements(boolean actif);
    List <Abonement> listAbonnements(Date d1, Date  d2);
    public Abonement getAbonement(Long id);
    public void updateAbonement (Abonement ab);
    public void deleteAbonement (Long id);
    public void consommer(Long id, double mt);

}
