package com.example.AssuranceVie.ws.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.AssuranceVie.bean.Distributeur;
import com.example.AssuranceVie.bean.EtatInscription;
import com.example.AssuranceVie.service.util.StringUtil;
import com.example.AssuranceVie.ws.provided.dto.EtatInscriptionDto;

@Component
	
public class EtatConverter extends AbstractConverter<EtatInscription,EtatInscriptionDto>{

	private boolean iAVPF;
	@Autowired
	IAVPFConverter iAVPFConverter ;

	@Override
	public EtatInscription toBean(EtatInscriptionDto vo) {
		// TODO Auto-generated method stub
		EtatInscription etatInscription =new EtatInscription();
		
		if(StringUtil.isNotEmpty(vo.getId())){
			etatInscription.setId(StringUtil.toLong(vo.getId()));
	        }
		if(StringUtil.isNotEmpty(vo.getReference())){
			etatInscription.setReference(vo.getReference());
	        }
		if(StringUtil.isNotEmpty(vo.getLibelle())){
			etatInscription.setLibelle(vo.getLibelle());
	        }
		if(vo.getiAVPF()!=null && iAVPF){
			etatInscription.setiAVPF(iAVPFConverter.toBean(vo.getiAVPF()));
        }
		return etatInscription;
	}

	@Override
	public EtatInscriptionDto toVo(EtatInscription bean) {
		// TODO Auto-generated method stub
		EtatInscriptionDto etatInscription =new EtatInscriptionDto();
		
		if(StringUtil.isNotEmpty(StringUtil.toString(bean.getId()))){
			etatInscription.setId(StringUtil.toString(bean.getId()));
	        }
		if(StringUtil.isNotEmpty(bean.getReference())){
			etatInscription.setReference(bean.getReference());
	        }
		if(StringUtil.isNotEmpty(bean.getLibelle())){
			etatInscription.setLibelle(bean.getLibelle());
	        }
		if(bean.getiAVPF()!=null && iAVPF){
			etatInscription.setiAVPF(iAVPFConverter.toVo(bean.getiAVPF()));
        }
		return etatInscription;
	}

	public boolean isiAVPF() {
		return iAVPF;
	}

	public void setiAVPF(boolean iAVPF) {
		this.iAVPF = iAVPF;
	}
	

}
