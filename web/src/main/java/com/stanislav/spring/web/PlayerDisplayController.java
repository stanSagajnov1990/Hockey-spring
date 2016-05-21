package com.stanislav.spring.web;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.stanislav.spring.model.Game;
import com.stanislav.spring.model.Player;
import com.stanislav.spring.model.PlayerStatistics;
import com.stanislav.spring.services.GameService;
import com.stanislav.spring.services.PlayerService;

@Controller
public class PlayerDisplayController {
	
	Logger logger = LoggerFactory.getLogger(PlayerDisplayController.class);
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private GameService gameService;
	
	//@PathVariable("playerId") Long playerId
	@RequestMapping(value="player.htm")
	public ModelAndView displayPlayer(@RequestParam("id") Long playerId){
		System.out.println();
		ModelAndView model = new ModelAndView("PlayerDisplay");
		logger.info("show User with id: "+playerId);
		Player player = playerService.findById(playerId);
		
		model.addObject("player", player);
		List<PlayerStatistics> playerStatistics = player.getPlayerStatistics();
		for(PlayerStatistics statistic : playerStatistics){
			if (statistic.getYear() == 2015 && !statistic.isPlayoffStatistics()){
				model.addObject("seasonStatistics", statistic);
			}
			if(statistic.getYear() == 2015 && statistic.isPlayoffStatistics()){
				model.addObject("playoffStatistics", statistic);
			} 
		}
		
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("y/MM/dd", java.util.Locale.ENGLISH);
		List<Game> games = null;
		try {
			games = gameService.getGamesByDate(sdf.parse("2016/02/02"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		model.addObject("games", games);

		return model;
	}
	
	@RequestMapping(value="all_players.htm")
	public ModelAndView displayAllPlayers(){
		ModelAndView model = new ModelAndView("PlayerList");
		
		List<Player> players = playerService.getAllPlayers();
		model.addObject("players", players);
		
		return model;
	}
	
}
