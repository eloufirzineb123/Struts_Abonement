package org.sid.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.Query;
import org.sid.entites.Abonement;


public class AbonnementDaoImpl implements IAbonnementDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void addAbonnement(Abonement ab) {
		em.persist(ab);

	}

	@Override
	public List<Abonement> listAbonnements(boolean actif) {
		Query req = em.createQuery("select ab from Abonement ab where ab.actif=:x");
		req.setParameter("x", actif);
		return req.getResultList();
	}

	@Override
	public List<Abonement> listAbonnements(Date d1, Date d2) {
		Query req = em.createQuery("select ab from Abonement ab where ab.dateAbonnement between :x and :y");
		req.setParameter("x", d1);
		req.setParameter("y", d2);

		return req.getResultList();
	}

	@Override
	public Abonement getAbonement(Long id) {
		return em.find(Abonement.class, id);
	}

	@Override
	public void updateAbonement(Abonement ab) {
		em.merge(ab);

	}

	@Override
	public void deleteAbonement(Long id) {
		Abonement ab = getAbonement(id);
		em.remove(ab);

	}

	@Override
	public void consommer(Long id, double mt) {
		Abonement ab=getAbonement(id);
		ab.setSolde(ab.getSolde()-mt);
		em.persist(ab);

	}

}
