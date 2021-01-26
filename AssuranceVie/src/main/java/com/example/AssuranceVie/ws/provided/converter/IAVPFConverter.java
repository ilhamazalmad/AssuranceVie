package com.example.AssuranceVie.ws.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.AssuranceVie.bean.InscriptionAssuranceVieProduitFinancier;
import com.example.AssuranceVie.service.util.StringUtil;
import com.example.AssuranceVie.ws.provided.dto.InscriptionAssuranceVieProduitFinancierDto;

@Component
public class IAVPFConverter extends AbstractConverter<InscriptionAssuranceVieProduitFinancier,InscriptionAssuranceVieProduitFinancierDto>{
	
	private boolean iAV;
	private boolean produit;
	private boolean distributeur;
	private boolean formule ;
	private boolean etatInscription;
	@Autowired
	IAVConverter iAVConverter; 
	@Autowired
	ProduitConverter produitConverter ;
	@Autowired
	DistributeurConverter distributeurConverter; 
	@Autowired
	FormuleConverter formuleConverter;
	@Autowired
	EtatConverter etatConverter ;
	@Override
	public InscriptionAssuranceVieProduitFinancier toBean(InscriptionAssuranceVieProduitFinancierDto vo) {
		// TODO Auto-generated method stub
		InscriptionAssuranceVieProduitFinancier iAVPF = new InscriptionAssuranceVieProduitFinancier();
		if(StringUtil.isNotEmpty(vo.getId())){
			iAVPF.setId(StringUtil.toLong(vo.getId()));
	        }
		if(StringUtil.isNotEmpty(vo.getPoliceAssurance())){
			iAVPF.setPoliceAssurance(vo.getPoliceAssurance());
	        }
		if(StringUtil.isNotEmpty(vo.getPrix())){
			iAVPF.setPrix(StringUtil.toDouble(vo.getPrix()));
	        }
		if(vo.getiAV()!=null && iAV){
			iAVPF.setiAV(iAVConverter.toBean(vo.getiAV()));
        }
		if(vo.getProduit()!=null && produit){
			iAVPF.setProduit(produitConverter.toBean(vo.getProduit()));
        }
		if(vo.getDistributeur()!=null && distributeur){
			iAVPF.setDistributeur(distributeurConverter.toBean(vo.getDistributeur()));
        }
		if(vo.getFormule()!=null && formule){
			iAVPF.setFormule(formuleConverter.toBean(vo.getFormule()));
        }
		if(vo.getEtatInscription()!=null && etatInscription){
			iAVPF.setEtatInscription(etatConverter.toBean(vo.getEtatInscription()));
        }
		
		return iAVPF;
	}

	@Override
	public InscriptionAssuranceVieProduitFinancierDto toVo(InscriptionAssuranceVieProduitFinancier bean) {
		// TODO Auto-generated method stub
		InscriptionAssuranceVieProduitFinancierDto iAVPF = new InscriptionAssuranceVieProduitFinancierDto();
		if(StringUtil.isNotEmpty(StringUtil.toString(bean.getId()))){
			iAVPF.setId(StringUtil.toString(bean.getId()));
	        }
		if(StringUtil.isNotEmpty(bean.getPoliceAssurance())){
			iAVPF.setPoliceAssurance(bean.getPoliceAssurance());
	        }
		if(StringUtil.isNotEmpty(StringUtil.toString(bean.getPrix()))){
			iAVPF.setPrix(StringUtil.toString(bean.getPrix()));
	        }
		if(bean.getiAV()!=null && iAV){
			iAVPF.setiAV(iAVConverter.toVo(bean.getiAV()));
        }
		if(bean.getProduit()!=null && produit){
			iAVPF.setProduit(produitConverter.toVo(bean.getProduit()));
        }
		if(bean.getDistributeur()!=null && distributeur){
			iAVPF.setDistributeur(distributeurConverter.toVo(bean.getDistributeur()));
        }
		if(bean.getFormule()!=null && formule){
			iAVPF.setFormule(formuleConverter.toVo(bean.getFormule()));
        }
		if(bean.getEtatInscription()!=null && etatInscription){
			iAVPF.setEtatInscription(etatConverter.toVo(bean.getEtatInscription()));
        }
		return iAVPF;
	}
	

}
