package com.factracing;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class FactRacingController
{

	@RequestMapping(value = { "/" })
	public ModelAndView startPage()
	{
		return new ModelAndView("index");
	}

	@RequestMapping(value = { "/creategameroom" })
	public ModelAndView getCreateNewGameRoomMAV()
	{
		return new ModelAndView("createNewGameroom");
	}
	
	@RequestMapping(value = { "/randomgame" })
	public ModelAndView getRandomGameRoomMAV()
	{
		return new ModelAndView("joinRandomGame");
	}
	
	@RequestMapping(value = { "/manual" })
	public ModelAndView getManualMAV()
	{
		return new ModelAndView("readManual");
	}

	@RequestMapping(value = { "/gameroom" })
	public ModelAndView getGameRoomMAV(@RequestParam(value = "minP") String minP, @RequestParam(value = "maxP") String maxP)
	{
		ModelAndView gameroom = new ModelAndView("gameRoom");
		gameroom.addObject("minP", minP);
		gameroom.addObject("maxP", maxP);
		return gameroom;
	}
}
