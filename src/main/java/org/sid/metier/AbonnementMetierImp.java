package org.sid.metier;

import java.util.Date;
import java.util.List;

import org.sid.dao.IAbonnementDao;
import org.sid.entites.Abonement;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Service
public class AbonnementMetierImp  implements IAbonnementMetier {

	
	private IAbonnementDao dao;
	
	public void setDao(IAbonnementDao dao) {
		this.dao = dao;
	}

	@Override
	public void addAbonnement(Abonement ab) {
		dao.addAbonnement(ab);
		
	}

	@Override
	public List<Abonement> listAbonnements(boolean actif) {
		return dao.listAbonnements(actif);
	}

	@Override
	public List<Abonement> listAbonnements(Date d1, Date d2) {
		// TODO Auto-generated method stub
		return dao.listAbonnements(d1, d2);
	}

	@Override
	public Abonement getAbonement(Long id) {
		// TODO Auto-generated method stub
		return dao.getAbonement(id);
	}

	@Override
	public void updateAbonement(Abonement ab) {
		dao.updateAbonement(ab);
		
	}

	@Override
	public void deleteAbonement(Long id) {
		dao.deleteAbonement(id);
		
	}

	@Override
	public void consommer(Long id, double mt) {
		dao.consommer(id, mt);
		
	}

}
