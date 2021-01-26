package com.example.AssuranceVie.ws.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.AssuranceVie.bean.Formule;
import com.example.AssuranceVie.service.util.StringUtil;
import com.example.AssuranceVie.ws.provided.dto.FormuleDto;


@Component
	
public class FormuleConverter extends AbstractConverter<Formule,FormuleDto> {

	private boolean Produit;
	@Autowired
	ProduitConverter produitConverter ;
	@Override
	public Formule toBean(FormuleDto vo) {
		// TODO Auto-generated method stub
		Formule formule = new Formule();
		if(StringUtil.isNotEmpty(vo.getId())){
			formule.setId(StringUtil.toLong(vo.getId()));
	        }
		if(StringUtil.isNotEmpty(vo.getReference())){
			formule.setReference(vo.getReference());
	        }
		if(StringUtil.isNotEmpty(vo.getLibelle())){
			formule.setLibelle(vo.getLibelle());
	        }
		if(StringUtil.isNotEmpty(vo.getPrix())){
			formule.setPrix(StringUtil.toDouble(vo.getPrix()));
	        }
		if(vo.getProduitFinancier()!=null && Produit){
			formule.setProduitFinancier(produitConverter.toBean(vo.getProduitFinancier()));
        }
		return formule;
	}

	@Override
	public FormuleDto toVo(Formule bean) {
		// TODO Auto-generated method stub
		FormuleDto formule = new FormuleDto();
		if(StringUtil.isNotEmpty(StringUtil.toString(bean.getId()))){
			formule.setId(StringUtil.toString(bean.getId()));
	        }
		if(StringUtil.isNotEmpty(bean.getReference())){
			formule.setReference(bean.getReference());
	        }
		if(StringUtil.isNotEmpty(bean.getLibelle())){
			formule.setLibelle(bean.getLibelle());
	        }
		if(StringUtil.isNotEmpty(StringUtil.toString(bean.getPrix()))){
			formule.setPrix(StringUtil.toString(bean.getPrix()));
	        }
		if(bean.getProduitFinancier()!=null && Produit){
			formule.setProduitFinancier(produitConverter.toVo(bean.getProduitFinancier()));
        }
		return formule;
	}

}
