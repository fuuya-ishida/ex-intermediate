package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Clothes;
import com.example.repository.ClothesRepository;

/**
* 衣類情報についての各処理を実施
* 
* @author ishida fuya
*/

@Service
@Transactional
public class ClothesService {
	
	@Autowired
	private ClothesRepository clothesRepository;
	
	/**
	 * 衣類検索結果一覧の取得処理
	 * 
	 * @return 衣類検索結果一覧
	 * 
	 */
	public List<Clothes> searchByColorAndGender(Integer gender,String color){
		return clothesRepository.searchByColorAndGender(gender, color);
	}

}
