package com.br.trentor.TheButler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.br.trentor.TheButler.model.entities.*;


@Repository
public interface CardapioRepositories extends JpaRepository<Cardapio, Long> {

}
