package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Clothes;


@Repository
public class ClothesRepository {
	
	private static final RowMapper<Clothes> CLOTHES_ROW_MAPPER = (rs, i) -> {
		Clothes clothes = new Clothes();
		clothes.setId(rs.getInt("id"));
		clothes.setCategory(rs.getString("category"));
		clothes.setGenre(rs.getString("genre"));
		clothes.setGender(rs.getInt("gender"));
		clothes.setColor(rs.getString("color"));
		clothes.setPrice(rs.getInt("price"));
		clothes.setSize(rs.getString("size"));
		return clothes;
	};
	
	/** template */
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	
	/**
	 * 衣類情報の取得
	 * 
	 * @param gender,color
	 * @return 衣類情報一覧
	 */
	public List<Clothes> searchByColorAndGender(Integer gender,String color){
		
		String sql = "SELECT id,category,genre,gender,color,price,size FROM clothes "
				+ "WHERE gender =:gender AND color =:color";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("gender", gender)
				.addValue("color", color);
		
		return template.query(sql, param, CLOTHES_ROW_MAPPER);
		
	}

}
