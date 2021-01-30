package com.example.AssuranceVie.ws.provided.converter;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.AssuranceVie.bean.Client;
import com.example.AssuranceVie.service.util.StringUtil;
import com.example.AssuranceVie.ws.provided.dto.ClientDto;

@Component
public class ClientConverter extends AbstractConverter<Client,ClientDto> {
	
	private boolean iAV;
	 @Autowired
	 private IAVConverter iAVConverter;

	@Override
	public Client toBean(ClientDto vo) {
		// TODO Auto-generated method stub
		Client client = new Client();
		
		if(StringUtil.isNotEmpty(vo.getId())){
			 client.setId(StringUtil.toLong(vo.getId()));
	        }
		 if(StringUtil.isNotEmpty(vo.getNom())){
			 client.setNom(vo.getNom());
	        }
		 if(StringUtil.isNotEmpty(vo.getPrenom())){
			 client.setPrenom(vo.getPrenom());
	        }
		 if(StringUtil.isNotEmpty(vo.getAdresse())){
			 client.setAdresse(vo.getAdresse());
	        }
		 if(StringUtil.isNotEmpty(vo.getTelephone())){
			 client.setTelephone(StringUtil.toLong(vo.getTelephone()));
	        }
		 if(StringUtil.isNotEmpty(vo.getCin())){
			 client.setCin(vo.getCin());
	        }
		 if(StringUtil.isNotEmpty(vo.getDateNaissance())){
			try {
				client.setDateNaissance(StringUtil.toDate(vo.getDateNaissance()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        }
		 		 if(StringUtil.isNotEmpty(vo.getPwd())){
			 client.setPwd(vo.getPwd());
	        }
		 if(vo.getiAV()!=null && iAV){
	            client.setiAV(iAVConverter.toBean(vo.getiAV()));
	        }
		return client;
	}

	@Override
	public ClientDto toVo(Client bean) {
		// TODO Auto-generated method stub
		ClientDto client = new ClientDto();
		
		if(StringUtil.isNotEmpty(StringUtil.toString(bean.getId()))){
			 client.setId(StringUtil.toString(bean.getId()));
	        }
		if(StringUtil.isNotEmpty(bean.getNom())){
			 client.setNom(bean.getNom());
	        }
		 if(StringUtil.isNotEmpty(bean.getPrenom())){
			 client.setPrenom(bean.getPrenom());
	        }
		 if(StringUtil.isNotEmpty(bean.getAdresse())){
			 client.setAdresse(bean.getAdresse());
	        }
		 if(StringUtil.isNotEmpty(StringUtil.toString(bean.getTelephone()))){
			 client.setTelephone(StringUtil.toString(bean.getTelephone()));
	        }
		 if(StringUtil.isNotEmpty(bean.getCin())){
			 client.setCin(bean.getCin());
	        }
		 if(StringUtil.isNotEmpty(StringUtil.toString(bean.getDateNaissance()))){
			client.setDateNaissance(StringUtil.toString(bean.getDateNaissance()));
	        }
		 
		 if(StringUtil.isNotEmpty(bean.getPwd())){
			 client.setPwd(bean.getPwd());
	        }
		 if(bean.getiAV()!=null && iAV){
	            client.setiAV(iAVConverter.toVo(bean.getiAV()));
	        }
		return client;
	}

	public boolean isiAV() {
		return iAV;
	}

	public void setiAV(boolean iAV) {
		this.iAV = iAV;
	}
	

	
	

}
