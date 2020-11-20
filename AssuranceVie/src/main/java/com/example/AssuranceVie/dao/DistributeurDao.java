package com.example.AssuranceVie.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.AssuranceVie.bean.Distributeur;


@Repository
public interface DistributeurDao extends CrudRepository<Distributeur,Long> {

	public Distributeur findByReference(String reference);
	public Distributeur findByLibelle(String libelle);
}
