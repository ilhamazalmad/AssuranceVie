package com.example.AssuranceVie.ws.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.AssuranceVie.bean.Distributeur;
import com.example.AssuranceVie.service.util.StringUtil;
import com.example.AssuranceVie.ws.provided.dto.DistributeurDto;


@Component	
public class DistributeurConverter extends AbstractConverter<Distributeur,DistributeurDto>{
	
	private boolean iAVPF;
	@Autowired
	IAVPFConverter iAVPFConverter ;

	@Override
	public Distributeur toBean(DistributeurDto vo) {
		// TODO Auto-generated method stub
		Distributeur distributeur =new Distributeur();
		
		if(StringUtil.isNotEmpty(vo.getId())){
			distributeur.setId(StringUtil.toLong(vo.getId()));
	        }
		if(StringUtil.isNotEmpty(vo.getReference())){
			distributeur.setReference(vo.getReference());
	        }
		if(StringUtil.isNotEmpty(vo.getLibelle())){
			distributeur.setLibelle(vo.getLibelle());
	        }

		if(StringUtil.isNotEmpty(vo.getPwd())){
			distributeur.setPwd(vo.getPwd());
		}
		if(vo.getiAVPF()!=null && iAVPF){
			distributeur.setiAVPF(iAVPFConverter.toBean(vo.getiAVPF()));
        }
		return distributeur;
	}

	@Override
	public DistributeurDto toVo(Distributeur bean) {
		// TODO Auto-generated method stub
		DistributeurDto distributeur =new DistributeurDto();
		if(StringUtil.isNotEmpty(StringUtil.toString(bean.getId()))){
			distributeur.setId(StringUtil.toString(bean.getId()));
	        }
		if(StringUtil.isNotEmpty(bean.getReference())){
			distributeur.setReference(bean.getReference());
	        }
		if(StringUtil.isNotEmpty(bean.getLibelle())){
			distributeur.setLibelle(bean.getLibelle());
	        }
		if(StringUtil.isNotEmpty(bean.getPwd())){
			distributeur.setPwd(bean.getPwd());
	        }
		if(bean.getiAVPF()!=null && iAVPF){
			distributeur.setiAVPF(iAVPFConverter.toVo(bean.getiAVPF()));
        }
		return distributeur;
	}

	public boolean isiAVPF() {
		return iAVPF;
	}

	public void setiAVPF(boolean iAVPF) {
		this.iAVPF = iAVPF;
	}
	

}
