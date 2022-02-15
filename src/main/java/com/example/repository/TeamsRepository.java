package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Teams;



/**
 * 野球チーム情報の操作をするリポジトリ
 * 
 * @author ishida fuya
 *
 */
@Repository
public class TeamsRepository {
	
	/** RowMapperの定義 */
	private static final RowMapper<Teams> TEAMS_ROW_MAPPER = (rs,i) -> {
		Teams teams = new Teams();
		teams.setId(rs.getInt("id"));
		teams.setLeagueName(rs.getString("league_name"));
		teams.setTeamName(rs.getString("team_name"));
		teams.setHeadquarters(rs.getString("headquarters"));
		teams.setInauguration(rs.getString("inauguration"));
		teams.setHistory(rs.getString("history"));
		return teams;
		
	};
	
	/** template */
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * 野球チーム一覧の取得
	 * 
	 * @return 野球チーム一覧
	 *
	 */
	public List<Teams> showList() {
		String sql = "SELECT id,league_name,team_name,headquarters,inauguration,history FROM teams "
				+ "ORDER BY inauguration";
		
		List<Teams> teamList = template.query(sql, TEAMS_ROW_MAPPER);
		
		return teamList;
	}
	
	/**
	 * 主キーから野球チーム詳細情報の取得
	 * @param id
	 * @return 野球チーム詳細情報
	 *
	 */
	public Teams showDetail(Integer id) {
		String sql ="SELECT id,league_name,team_name,headquarters,inauguration,history FROM teams "
				+ "WHERE id = :id";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		
		Teams teamDetail = template.queryForObject(sql, param, TEAMS_ROW_MAPPER);
		
		return teamDetail;
	}
	

}
