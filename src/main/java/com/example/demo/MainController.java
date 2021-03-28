package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@Autowired
	UserDBRepository user;
	
	@Autowired
	UserDataRepository repository;
	
	@Autowired
	AnonymousRepository input;
	
	@Autowired
	LibraryDbRepository sent;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView indexGet(ModelAndView mv) {
		mv.addObject("math", "偶数・奇数の計算をします。");

		mv.setViewName("index");
		return mv;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView indexPost(ModelAndView mv, @RequestParam("mathVal") int math) {

		if (math % 2 == 0) {
			mv.addObject("math", math + "は偶数");
		} else {
			mv.addObject("math", math + "は奇数");
		}
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping(value = "/if", method = RequestMethod.GET)
	public ModelAndView ifGet(ModelAndView mv) {
		mv.addObject("suzuki", false);
		mv.setViewName("if");
		return mv;
	}

	@RequestMapping(value = "/if", method = RequestMethod.POST)
	public ModelAndView ifPost(ModelAndView mv, @RequestParam("nameVal") String math) {
		mv.addObject("suzuki", math); // GETで入力した文字を
		mv.setViewName("if");
		return mv;
	}

	@RequestMapping(value = "/dic", method = RequestMethod.GET)
	public ModelAndView dicGet(ModelAndView mv) {
		mv.addObject("dicretion", "偶数・奇数の判別をします。");

		mv.setViewName("dic");
		return mv;
	}

	@RequestMapping(value = "/dic", method = RequestMethod.POST)
	public ModelAndView dicPost(ModelAndView mv, @RequestParam("dicVal") int math) {

		if (math % 2 == 0) {
			mv.addObject("dicretion", math + "は偶数");
		} else {
			mv.addObject("dicretion", math + "は奇数");
		}
		mv.setViewName("dic");
		return mv;

	}

	@RequestMapping("/{num}")
	public ModelAndView index(@PathVariable int num, ModelAndView mv) {

		if (num == 1) {
			mv.addObject("math", num + "は素数ではありません");

		} else if (num <= 0) {
			mv.addObject("math", num + "は正の整数ではないので素数ではありません");

		}
		for (int i = 2; i < num; i++) {

			if (num % i == 0) {
				mv.addObject("math", num + "は素数ではない");
				break;
			}

			mv.addObject("math", num + "は素数");
		}

		mv.setViewName("index");
		return mv;
	}

	@RequestMapping(value = "/list")
	public ModelAndView indexPost(ModelAndView mv) {
		ArrayList<String[]> customers = new ArrayList<String[]>();
		customers.add(new String[] { "佐藤HTML太郎", "35歳", "男性", "東京都" });
		customers.add(new String[] { "鈴木Java五郎", "24歳", "男性", "北海道" });
		customers.add(new String[] { "高橋CSS子", "29歳", "女性", "沖縄県" });
		mv.addObject("customers", customers);
		mv.setViewName("list");
		return mv;
	}

	@RequestMapping(value = "/work", method = RequestMethod.GET)
	public ModelAndView homeworkGet(ModelAndView mv) {
		mv.addObject("name", "数量");
		mv.setViewName("homework");
		return mv;
	}

	@RequestMapping(value = "/work", method = RequestMethod.POST)
	public ModelAndView homeworkPost(ModelAndView mv, @RequestParam("nameVal") String name) {
		mv.addObject("name", "数量" + name);
		mv.setViewName("homework");
		return mv;
	}

	@RequestMapping(value = "/top", method = RequestMethod.GET)
	public ModelAndView sampleGet(ModelAndView mv) {

		mv.addObject("name");
		mv.setViewName("sample");
		return mv;
	}

	@RequestMapping(value = "/top", method = RequestMethod.POST)
	public ModelAndView samplePost(ModelAndView mv, @RequestParam("timeVal") String time,
			@RequestParam("nameVal") String name) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		mv.addObject("time", timestamp);
		mv.addObject("name", name);
		mv.setViewName("sample");
		return mv;
	}

	

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView formGet(ModelAndView mv) {
		List<UserData> customers = repository.findAll();
		mv.addObject("customers", customers);
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public ModelAndView formPost(@ModelAttribute("formModel") UserData userData, ModelAndView mv) {
		repository.saveAndFlush(userData);
		return new ModelAndView("redirect:/form");
	}

	

	@RequestMapping(value = "/desk", method = RequestMethod.GET)
	public ModelAndView deskGet(ModelAndView mv) {
		List<Anonymous> customers = input.findAll();

		mv.addObject("customers", customers);
		mv.setViewName("anonymous");
		return mv;
	}

	@RequestMapping(value = "/desk", method = RequestMethod.POST)
	public ModelAndView deskPost(@ModelAttribute("formModel") Anonymous anonyMous, ModelAndView mv) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat daytime = new SimpleDateFormat("yyyy/MM/dd/HH:MM:ss");
		String str = daytime.format(timestamp);
		anonyMous.setTime(str);
		input.saveAndFlush(anonyMous);

		return new ModelAndView("redirect:/desk");
	}

	

	@RequestMapping(value = "/library", method = RequestMethod.GET)
	public ModelAndView libraryGet(ModelAndView mv) {
		List<LIbraryDB> customers = sent.findAll();
		mv.addObject("customers", customers);
		mv.setViewName("libraryDb");
		return mv;
	}

	@RequestMapping(value = "/library", method = RequestMethod.POST)
	public ModelAndView libraryPost(@ModelAttribute("formModel") LIbraryDB libraryDB, ModelAndView mv) {
		sent.saveAndFlush(libraryDB);
		return new ModelAndView("redirect:/library");
	}


	@RequestMapping(value = "/userdb", method = RequestMethod.GET)
	public ModelAndView userdbGet(ModelAndView mv) {
		List<UserDB> customers = user.findAll();
		mv.addObject("customers", customers);
		mv.setViewName("UserDB");
		return mv;
	}

	@RequestMapping(value = "/userdb", method = RequestMethod.POST)
	public ModelAndView userdbPost(@ModelAttribute("formModel") UserDB userDB, ModelAndView mv) {
		userDB.setLibraryDB(sent.findById((long)1).get());
		user.saveAndFlush(userDB);
		return new ModelAndView("redirect:/userdb");
	}

	
	

	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public String dataGet(ModelAndView mv) {
		List<UserDB> userDBList = user.findAll();
		mv.addObject("userDBList", userDBList);
		return "bbs/data";
	}

	// @RequestMapping(value = "/data",method = RequestMethod.POST)
	// public String dataPOST(ModelAndView mv,@RequestParam("text")String
	// text,LIbraryDB libraryDB) {

	// }

}
//}
