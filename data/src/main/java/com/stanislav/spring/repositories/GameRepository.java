package com.stanislav.spring.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stanislav.spring.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>, JpaSpecificationExecutor<Game> {
	
	public List<Game> findByGameDateBetween(Date start, Date end);

	@Query(value = "select g from Game g where g.id = :id")
	public Game eager(@Param(value= "id") long id);
	
}
