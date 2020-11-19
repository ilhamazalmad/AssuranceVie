package com.example.AssuranceVie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AssuranceVie.bean.Formule;


@Repository
public interface FormuleDao extends JpaRepository<Formule,Long>{

}
