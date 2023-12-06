package com.itb.tcc.uniaovoluntaria.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.itb.tcc.uniaovoluntaria.model.ONG;

@Repository
public interface OngRepository extends JpaRepository<ONG, Long> {
	
	@Query(value="SELECT * from  ong u  where u.nome=? and u.senha=? ", nativeQuery = true)
	public ONG Login(String nome, String senha);
	
}
