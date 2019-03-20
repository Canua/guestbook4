package com.douzone.guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.douzone.guestbook.dao.GuestbookDao;
import com.douzone.guestbook.vo.GuestbookVo;


@Controller
public class GuestbookController {
	@Autowired
	private GuestbookDao guestbookDao;
	
	@RequestMapping({"", "/list"})
	public String list(Model model) {
		model.addAttribute("list", guestbookDao.getList());
		return "list";
	}	
	
	@RequestMapping(value="/deleteform", method=RequestMethod.GET)
	public String form(
			@RequestParam (value="no" , required=false) Long no, Model model) {
		model.addAttribute("no", no);
		return "deleteform";
	}	
	/*
	@RequestMapping(value="/deleteform/{no}", method=RequestMethod.GET)
	public String form(
			@PathVariable ("no") Long no, Model model) {
		model.addAttribute("no", no);
		return "/WEB-INF/views/deleteform.jsp";
	}	
	*/
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(GuestbookVo guestbookVo) {
		guestbookDao.insert(guestbookVo);	
		// redirect
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(GuestbookVo guestbookVo) {
		guestbookDao.delete(guestbookVo);
		// redirect
		return "redirect:/";
	}	
}
