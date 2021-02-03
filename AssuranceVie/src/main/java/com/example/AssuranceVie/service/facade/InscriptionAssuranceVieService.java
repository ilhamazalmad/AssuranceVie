package com.example.AssuranceVie.service.facade;

import com.example.AssuranceVie.bean.Distributeur;
import com.example.AssuranceVie.bean.EtatInscription;
import com.example.AssuranceVie.bean.Formule;
import com.example.AssuranceVie.bean.InscriptionAssuranceVie;
import com.example.AssuranceVie.bean.InscriptionAssuranceVieProduitFinancier;
import com.example.AssuranceVie.bean.ProduitFinancier;
import com.example.AssuranceVie.dao.InscriptionAssuranceVieProduitFinancierDao;
import com.example.AssuranceVie.dao.ProduitFinancierDao;
import com.example.AssuranceVie.ws.provided.dto.InscriptionDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AssuranceVie.dao.DistributeurDao;
import com.example.AssuranceVie.dao.EtatInscriptionDao;
import com.example.AssuranceVie.dao.FormuleDao;
import com.example.AssuranceVie.dao.InscriptionAssuranceVieDao;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Service
public class InscriptionAssuranceVieService {

	@Autowired
	InscriptionAssuranceVieDao iAVDao;
	@Autowired
	InscriptionAssuranceVieProduitFinancierDao iAVPFDao;
	@Autowired
	EtatInscriptionDao etatInscriptionDao;
	@Autowired
	DistributeurDao distributeurDao;
	@Autowired
	ProduitFinancierDao produitFinancierDao;
	@Autowired
	FormuleDao formuleDao;
	@Autowired
	ClientService clientService;


	public int save(InscriptionAssuranceVie ins) {
		try {
			
		TimeZone tz = TimeZone.getTimeZone("UTC");
		//"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
		SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		df.setTimeZone(tz);
	    String dateString = df.format( new Date());
		Date date=df.parse(dateString);
		ins.setDateInscription(date);
		if(clientService.findById(ins.getClient().getId()).getNom() !=null)
		{
			ins.setClient(clientService.findById(ins.getClient().getId()));
			ins.setReference(ins.getClient().getNom()+"-"+ins.getClient().getPrenom()+":"+date);
			InscriptionAssuranceVie inscription = iAVDao.save(ins);
			Double total=0.0;
			for(InscriptionAssuranceVieProduitFinancier iProduit : ins.getiAVPF()) {
				iProduit.setiAV(inscription);
				if(iProduit.getEtatInscription()==null) {
					iProduit.setEtatInscription(etatInscriptionDao.findById(Long.valueOf(1)).get());
				}
				
				iProduit.setPrix(formuleDao.findById(iProduit.getFormule().getId()).get().getPrix());
				total+=iProduit.getPrix();
				iAVPFDao.save(iProduit);
			}
			inscription.setPrix(total);
			iAVDao.save(inscription);
			//iAVDao.save(ins);
			return 1;
		}
		else 
			return -2;
		}
		catch (Exception e) {
			System.out.println(e);
			return -1;
		}
		
	}

	@Transactional
	public int update(Long id, List<InscriptionAssuranceVieProduitFinancier> produits) {
		try {
			InscriptionAssuranceVie inscription = iAVDao.findById(id).get();
			for(InscriptionAssuranceVieProduitFinancier produitDB: iAVPFDao.findByiAV_Id(id)) {
				int find =0;
				for(InscriptionAssuranceVieProduitFinancier iProduit : produits) {
					if(produitDB.getId()==iProduit.getId()) {
						find=1; break;
					}				
				}
				if(find ==0)iAVPFDao.deleteById(produitDB.getId());
			}
			for(InscriptionAssuranceVieProduitFinancier iProduit : produits) {
				iProduit.setiAV(inscription);
				iProduit.setPrix(formuleDao.findById(iProduit.getFormule().getId()).get().getPrix());
				iAVPFDao.save(iProduit);
				
			}
			inscription.setPrix(iAVDao.total(id));
			 iAVDao.save(inscription);
			 return 1;
		}
		catch (Exception e) {
			System.out.println(e);
			return -1;
		}
}

	public Double total(Long id) {
		return iAVDao.total(id);
	}
	public Double totalConfirme(Long id) {
		return iAVDao.totalConfirme(id);
	}
	public Double totalAttente(Long id) {
		return iAVDao.totalAttente(id);
	}

	public InscriptionAssuranceVie findById(Long id){
		return iAVDao.findById(id).get();
	}

	@Transactional
	public void deleteById(Long id) {
			iAVPFDao.deleteByiAV_Id(id);
			iAVDao.deleteById(id);
	}
	public List<InscriptionAssuranceVie> findByDateInscription(Date Dins){
		return iAVDao.findByDateInscription(Dins);

}
   public  List<InscriptionAssuranceVie> findByReference(String ref){
		return iAVDao.findByReference(ref);
	 }
	public  InscriptionAssuranceVie findByPrix(Double pr){
		return iAVDao.findInscriptionAssuranceVieByPrix(pr);
	 }
	public  List<InscriptionAssuranceVie> findAll(){
		return (List<InscriptionAssuranceVie>) iAVDao.findAll();
}



}
