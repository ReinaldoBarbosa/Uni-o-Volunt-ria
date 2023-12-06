package com.itb.tcc.uniaovoluntaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.itb.tcc.uniaovoluntaria.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long>{

	@Transactional
	void deleteById(long id);
}
