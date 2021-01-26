package com.example.AssuranceVie.ws.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.AssuranceVie.bean.ProduitFinancier;
import com.example.AssuranceVie.service.util.StringUtil;
import com.example.AssuranceVie.ws.provided.dto.ProduitFinancierDto;

@Component
public class ProduitConverter extends AbstractConverter<ProduitFinancier,ProduitFinancierDto> {

	private boolean formules;
	private boolean iAVPF;
	@Autowired
	FormuleConverter formuleConverter; 
	@Autowired
	IAVPFConverter iAVPFConverter;
	
	@Override
	public ProduitFinancier toBean(ProduitFinancierDto vo) {
		// TODO Auto-generated method stub 
		ProduitFinancier produitFinancier = new ProduitFinancier();
		if(StringUtil.isNotEmpty(vo.getId())){
			produitFinancier.setId(StringUtil.toLong(vo.getId()));
	        }
		if(StringUtil.isNotEmpty(vo.getLibelle())){
			produitFinancier.setLibelle(vo.getLibelle());
	        }
		if(StringUtil.isNotEmpty(vo.getCode())){
			produitFinancier.setCode(vo.getCode());
	        }
		if(vo.getFormules()!=null && formules){
			produitFinancier.setFormules(formuleConverter.toBean(vo.getFormules()));
        }
		if(vo.getiAVPF()!=null && iAVPF){
			produitFinancier.setiAVPF(iAVPFConverter.toBean(vo.getiAVPF()));
        }
		return produitFinancier;
	}

	@Override
	public ProduitFinancierDto toVo(ProduitFinancier bean) {
		// TODO Auto-generated method stub
		ProduitFinancierDto produitFinancier = new ProduitFinancierDto();
		if(StringUtil.isNotEmpty(StringUtil.toString(bean.getId()))){
			produitFinancier.setId(StringUtil.toString(bean.getId()));
	        }
		if(StringUtil.isNotEmpty(bean.getLibelle())){
			produitFinancier.setLibelle(bean.getLibelle());
	        }
		if(StringUtil.isNotEmpty(bean.getCode())){
			produitFinancier.setCode(bean.getCode());
	        }
		if(bean.getFormules()!=null && formules){
			produitFinancier.setFormules(formuleConverter.toVo(bean.getFormules()));
        }
		if(bean.getiAVPF()!=null && iAVPF){
			produitFinancier.setiAVPF(iAVPFConverter.toVo(bean.getiAVPF()));
        }
		return produitFinancier;
	}

}
