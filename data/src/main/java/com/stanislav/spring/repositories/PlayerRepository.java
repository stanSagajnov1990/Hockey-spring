package com.stanislav.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stanislav.spring.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
	
	@Query(value = "SELECT SUM(ps.gamesPlayed), SUM(ps.goals), SUM(ps.assists), SUM(ps.points), SUM(ps.plusminus), "
			+ "SUM(ps.penaltyInMinutes), SUM(ps.powerPlayGoals), SUM(ps.powerPlayPoints), SUM(ps.shortHandedGoals), "
			+ "SUM(ps.shortHandedPoints), SUM(ps.gameWinningGoals), SUM(ps.overtimeGoals), SUM(ps.shots), AVG(ps.shotPercentage), "
			+ "AVG(ps.faceoffWinPercentage) FROM PlayerStatistics ps WHERE ps.player = :PLAYER AND ps.playoffStatistics = :ONLYPLAYOFFS")
	public Object getSumOfPlayerStatistics(@Param("PLAYER")Player p, @Param("ONLYPLAYOFFS") boolean onlyPlayoffs);
	
}
