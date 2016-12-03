package com.stanislav.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQuery(name="Game.findByDate",query="SELECT g FROM Game g WHERE g.gameDate BETWEEN :ST_DATE AND :END_DATE")

@Entity
@Table(name="GAME")
public class Game implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3510589234875463681L;
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="GAME_ID")
	private Long id;
  
	@ManyToOne
	@JoinColumn(name="HOME_TEAM_ID",nullable=false)
	private Team homeTeam;
  
	@ManyToOne
	@JoinColumn(name="AWAY_TEAM_ID",nullable=false)
	private Team awayTeam;
  
	@Column(name="HOME_TEAM_SCORE")
	private Integer homeTeamScore;
  
	@Column(name="AWAY_TEAM_SCORE")
	private Integer awayTeamScore;
  
	@Column(name="GAME_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date gameDate;
  
	@Column(name="OT")
	private boolean winInOvertime;
  
	@Column(name="SO")
	private boolean winInShootout;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Team getHomeTeam() {
		return homeTeam;
	}
	
	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}
	
	public Team getAwayTeam() {
		return awayTeam;
	}
	
	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}
	
	public Integer getHomeTeamScore() {
		return homeTeamScore;
	}
	
	public void setHomeTeamScore(Integer homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}
	
	public Integer getAwayTeamScore() {
		return awayTeamScore;
	}
	
	public void setAwayTeamScore(Integer awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}
	
	public Date getGameDate() {
		return gameDate;
	}
	
	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}
	
	public boolean isWinInOvertime() {
		return winInOvertime;
	}
	
	public void setWinInOvertime(boolean winInOvertime) {
		this.winInOvertime = winInOvertime;
	}
	
	public boolean isWinInShootout() {
		return winInShootout;
	}
	
	public void setWinInShootout(boolean winInShootout) {
		this.winInShootout = winInShootout;
	}
	
}