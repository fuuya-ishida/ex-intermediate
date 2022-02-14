package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.TeamsService;

@Controller
@RequestMapping("/Ex01")
public class TeamsController {

	@Autowired
	private TeamsService teamsService;

	@Autowired
	private HttpSession session;

	/**
	 * 野球チーム一覧の表示処理
	 * 
	 * @return 野球チーム一覧
	 *
	 */
	@RequestMapping("/teamList")
	public String showList() {
		// 一件も検索されなかった場合はnullを返す。
		try {
			session.setAttribute("teamsList", teamsService.showList());
		} catch (Exception e) {
			return null;
		}
		return "/teams/list";
	}

	/**
	 * 野球チーム詳細情報の表示処理
	 * 
	 * @return 野球チーム詳細情報
	 *
	 */
	@RequestMapping("/showDetail")
	public String showDetail(Integer id, Model model) {
		// 一件も検索されなかった場合はnullを返す。
		try {
			model.addAttribute("teamDetail", teamsService.showDetail(id));
		} catch (Exception e) {
			return null;
		}
		return "/teams/detail";
	}

}
