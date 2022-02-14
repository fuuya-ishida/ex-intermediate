package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Hotels;
import com.example.repository.HotelsRepository;


/**
 * ホテル情報についての各処理を実施
 * 
 * @author ishida fuya
 */
@Service
@Transactional
public class HotelsService {
	
	@Autowired
	private HotelsRepository hotelsRepository;
	/**
	 * 野球チーム一覧の取得処理
	 * 
	 * @return ホテル情報一覧
	 * 金額入力欄の値以下の金額のホテル情報を取得
	 */
	public List<Hotels> searchByLessThanPrice(Integer price){
		return hotelsRepository.searchByLessThanPrice(price);
		
	}
}
