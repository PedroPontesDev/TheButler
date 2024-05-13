package com.br.trentor.TheButler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.trentor.TheButler.model.entities.Usuario;


@Repository
public interface UsuarioRepositories extends JpaRepository<Usuario, Long> {

	Object findByUserName(@Param("userName") String userName);

	
}
