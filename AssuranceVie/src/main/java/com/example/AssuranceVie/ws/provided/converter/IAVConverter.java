package com.example.AssuranceVie.ws.provided.converter;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.AssuranceVie.bean.InscriptionAssuranceVie;
import com.example.AssuranceVie.service.util.StringUtil;
import com.example.AssuranceVie.ws.provided.dto.InscriptionAssuranceVieDto;


@Component
	
public class IAVConverter extends AbstractConverter<InscriptionAssuranceVie,InscriptionAssuranceVieDto>  {

	private boolean client;
	private boolean iAVPF;
	@Autowired
	ClientConverter clientConverter; 
	@Autowired
	IAVPFConverter iAVPFConverter;
	@Override
	public InscriptionAssuranceVie toBean(InscriptionAssuranceVieDto vo) {
		// TODO Auto-generated method stub
		InscriptionAssuranceVie iAV = new InscriptionAssuranceVie();
		if(StringUtil.isNotEmpty(vo.getId())){
			iAV.setId(StringUtil.toLong(vo.getId()));
	        }
		if(StringUtil.isNotEmpty(vo.getReference())){
			iAV.setReference(vo.getReference());
	        }
		if(StringUtil.isNotEmpty(vo.getPrix())){
			iAV.setPrix(StringUtil.toDouble(vo.getPrix()));
	        }
		if(StringUtil.isNotEmpty(vo.getDateInscription())){
			try {
				iAV.setDateInscription(StringUtil.toDate(vo.getDateInscription()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        }
		if(vo.getClient()!=null && client){
			iAV.setClient(clientConverter.toBean(vo.getClient()));
        }
		if(vo.getiAVPF()!=null && iAVPF){
			iAV.setiAVPF(iAVPFConverter.toBean(vo.getiAVPF()));
        }
		return iAV;
	}

	@Override
	public InscriptionAssuranceVieDto toVo(InscriptionAssuranceVie bean) {
		// TODO Auto-generated method stub
		InscriptionAssuranceVieDto iAV = new InscriptionAssuranceVieDto();
		if(StringUtil.isNotEmpty(StringUtil.toString(bean.getId()))){
			iAV.setId(StringUtil.toString(bean.getId()));
	        }
		if(StringUtil.isNotEmpty(bean.getReference())){
			iAV.setReference(bean.getReference());
	        }
		if(StringUtil.isNotEmpty(StringUtil.toString(bean.getPrix()))){
			iAV.setPrix(StringUtil.toString(bean.getPrix()));
	        }
		if(StringUtil.isNotEmpty(StringUtil.toString(bean.getDateInscription()))){
			iAV.setDateInscription(StringUtil.toString(bean.getDateInscription()));
	        }
		if(bean.getClient()!=null && client){
			iAV.setClient(clientConverter.toVo(bean.getClient()));
        }
		if(bean.getiAVPF()!=null && iAVPF){
			iAV.setiAVPF(iAVPFConverter.toVo(bean.getiAVPF()));
        }
		return iAV;
	}

}
