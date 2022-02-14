package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Teams;
import com.example.repository.TeamsRepository;

@Service
@Transactional
public class TeamsService {
	
	@Autowired
	private TeamsRepository teamsRepository;
	
	/**
	 * 野球チーム一覧の取得処理
	 * 
	 * @return 野球チーム一覧
	 *
	 */
	public List<Teams> showList(){
		return teamsRepository.showList();
	}
	/**
	 * 野球チーム詳細情報の取得処理
	 * @param id
	 * @return 野球チーム詳細情報
	 *
	 */
	public Teams showDetail(Integer id){
		return teamsRepository.showDetail(id);
	}

}
