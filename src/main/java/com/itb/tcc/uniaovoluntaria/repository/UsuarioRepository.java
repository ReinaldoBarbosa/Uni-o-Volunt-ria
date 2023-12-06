package com.itb.tcc.uniaovoluntaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.itb.tcc.uniaovoluntaria.model.Evento;
import com.itb.tcc.uniaovoluntaria.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Query(value="SELECT * from usuario u  where u.nome=?", nativeQuery = true)
	public Usuario Login(String nome, String senha);
}
