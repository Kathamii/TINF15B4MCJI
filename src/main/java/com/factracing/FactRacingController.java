package com.factracing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FactRacingController
{
	@Autowired
	GameRoom gameRoom;

	@RequestMapping(value = {"/"})
	public ModelAndView startPage()
	{
		return new ModelAndView("index");
	}

	@RequestMapping(value = {"/buttonsMain"})
	public ModelAndView buttonsMain(@RequestParam(value = "create", required = false) String create,
		@RequestParam(value = "join", required = false) String join, @RequestParam(value = "read", required = false) String read)
	{
		if (create != null)
			return new ModelAndView("createNewGameroom");
		if (join != null)
			return new ModelAndView("joinRandomGame");
		if (read != null)
			return new ModelAndView("readManual");
		return new ModelAndView("index");
	}

	@RequestMapping(value = {"/gameroom"})
	public ModelAndView gameroom(@RequestParam(value = "minP") String minP, @RequestParam(value = "maxP") String maxP)
	{
		ModelAndView gameroom = new ModelAndView("gameroom");
		gameroom.addObject("minP", minP);
		gameroom.addObject("maxP", maxP);
		return gameroom;
	}
}
