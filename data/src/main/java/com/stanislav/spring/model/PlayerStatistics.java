package com.stanislav.spring.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(query = "SELECT ps FROM PlayerStatistics ps WHERE ps.player.id = :PLAYER_ID", name="PlayerStatistics.findAllForPlayer")
})


@Entity
@Table(name="PLAYER_STATISTICS")
public class PlayerStatistics implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4887123564231595970L;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PS_ID")
	private Long id;
	@ManyToOne
	@JoinColumn(name="PLAYER_ID",nullable=false)
	private Player player;
	@Column(name="YEAR")
	private Integer year;
	@Column(name="PLAYOFF_STATISTICS")
	private boolean playoffStatistics;
	@Column(name="GAMES_PLAYED")
	private Integer gamesPlayed;
	@Column(name="GOALS")
	private Integer goals;
	@Column(name="ASSISTS")
	private Integer assists;
	@Column(name="POINTS")
	private Integer points;
	@Column(name="PLUS_MINUS")
	private Integer plusminus;
	@Column(name="PENALTY_IN_MINUTES")
	private Integer penaltyInMinutes;
	@Column(name="POWERPLAY_GOALS")
	private Integer powerPlayGoals;
	@Column(name="POWERPLAY_POINTS")
	private Integer powerPlayPoints;
	@Column(name="SHORTHANDED_GOALS")
	private Integer shortHandedGoals;
	@Column(name="SHORTHANDED_POINTS")
	private Integer shortHandedPoints;
	@Column(name="GAME_WINNING_GOALS")
	private Integer gameWinningGoals;
	@Column(name="OVERTIME_GOALS")
	private Integer overtimeGoals;
	@Column(name="SHOTS")
	private Integer shots;
	@Column(name="SHOT_PERCENTAGE", columnDefinition="decimal", precision=18, scale=2)
	private BigDecimal shotPercentage;
	@Column(name="FACEOFF_WIN_PERCENTAGE", columnDefinition="decimal", precision=18, scale=2)
	private BigDecimal faceoffWinPercentage;
	
	@ManyToOne
	@JoinColumn(name="TEAM_ID",nullable=false)
	private Team team;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public Integer getYear() {
		return year;
	}
	
	public void setYear(Integer year) {
		this.year = year;
	}
	
	public boolean isPlayoffStatistics() {
		return playoffStatistics;
	}
	
	public void setPlayoffStatistics(boolean playoffStatistics) {
		this.playoffStatistics = playoffStatistics;
	}

	public Integer getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(Integer gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public Integer getGoals() {
		return goals;
	}

	public void setGoals(Integer goals) {
		this.goals = goals;
	}

	public Integer getAssists() {
		return assists;
	}

	public void setAssists(Integer assists) {
		this.assists = assists;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}
	
	public Integer getPlusminus() {
		return plusminus;
	}

	public void setPlusminus(Integer plusminus) {
		this.plusminus = plusminus;
	}

	public Integer getPenaltyInMinutes() {
		return penaltyInMinutes;
	}

	public void setPenaltyInMinutes(Integer penaltyInMinutes) {
		this.penaltyInMinutes = penaltyInMinutes;
	}

	public Integer getPowerPlayGoals() {
		return powerPlayGoals;
	}

	public void setPowerPlayGoals(Integer powerPlayGoals) {
		this.powerPlayGoals = powerPlayGoals;
	}

	public Integer getPowerPlayPoints() {
		return powerPlayPoints;
	}

	public void setPowerPlayPoints(Integer powerPlayPoints) {
		this.powerPlayPoints = powerPlayPoints;
	}

	public Integer getShortHandedGoals() {
		return shortHandedGoals;
	}

	public void setShortHandedGoals(Integer shortHandedGoals) {
		this.shortHandedGoals = shortHandedGoals;
	}

	public Integer getShortHandedPoints() {
		return shortHandedPoints;
	}

	public void setShortHandedPoints(Integer shortHandedPoints) {
		this.shortHandedPoints = shortHandedPoints;
	}

	public Integer getGameWinningGoals() {
		return gameWinningGoals;
	}

	public void setGameWinningGoals(Integer gameWinningGoals) {
		this.gameWinningGoals = gameWinningGoals;
	}

	public Integer getOvertimeGoals() {
		return overtimeGoals;
	}

	public void setOvertimeGoals(Integer overtimeGoals) {
		this.overtimeGoals = overtimeGoals;
	}

	public Integer getShots() {
		return shots;
	}

	public void setShots(Integer shots) {
		this.shots = shots;
	}

	public BigDecimal getShotPercentage() {
		return shotPercentage;
	}

	public void setShotPercentage(BigDecimal shotPercentage) {
		this.shotPercentage = shotPercentage;
	}

	public BigDecimal getFaceoffWinPercentage() {
		return faceoffWinPercentage;
	}

	public void setFaceoffWinPercentage(BigDecimal faceoffWinPercentage) {
		this.faceoffWinPercentage = faceoffWinPercentage;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
}
