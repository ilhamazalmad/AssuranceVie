package com.example.AssuranceVie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AssuranceVie.bean.Client;

@Repository
public interface ClientDao extends JpaRepository<Client,Long> {

}
