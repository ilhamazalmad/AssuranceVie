package com.example.AssuranceVie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.AssuranceVie.bean.Client;

@Repository
public interface ClientDao extends JpaRepository<Client,Long> {

	public Client findByCin(String cin);
	public Client findByTelephone(Long telephone);
	public Client findByPwd(String pwd);
}
