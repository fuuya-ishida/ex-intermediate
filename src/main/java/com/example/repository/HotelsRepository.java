package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Hotels;

/**
 * ホテル情報の操作をするリポジトリ
 * 
 * @author ishida fuya
 *
 */
@Repository
public class HotelsRepository {

	/** RowMapperの定義 */
	private static final RowMapper<Hotels> HOTELS_ROW_MAPPER = (rs, i) -> {
		Hotels hotels = new Hotels();
		hotels.setId(rs.getInt("id"));
		hotels.setAreaName(rs.getString("area_name"));
		hotels.setHotelName(rs.getString("hotel_name"));
		hotels.setAddress(rs.getString("address"));
		hotels.setNearestStation(rs.getString("nearest_station"));
		;
		hotels.setPrice(rs.getInt("price"));
		hotels.setParking(rs.getString("parking"));
		return hotels;

	};

	/** template */
	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * ホテル情報の取得
	 * 
	 * @param price
	 * @return ホテル情報一覧
	 */
	public List<Hotels> searchByLessThanPrice(Integer price) {
		//金額入力欄が空白の場合は全件取得する
		if (price == null) {
			String sql = "SELECT id,area_name,hotel_name,address,nearest_station,price,parking FROM hotels "
					+ " ORDER BY price";

			List<Hotels> hotellist = template.query(sql, HOTELS_ROW_MAPPER);

			return hotellist;
		}
		String sql = "SELECT id,area_name,hotel_name,address,nearest_station,price,parking FROM hotels "
				+ "WHERE price <= :price";

		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);

		List<Hotels> hotellist = template.query(sql, HOTELS_ROW_MAPPER);
		return hotellist;
	}

}
