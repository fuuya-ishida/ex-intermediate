package com.example.domain;


/**
 * 野球チーム情報を表すドメイン
 * 
 * @author ishida fuya
 */

public class Teams {
	/** ID */
	private Integer id;
	
	/** リーグ名 */
	private String leagueName;
	
	/** 球団名 */
	private String teamName;
	
	/** 本拠地 */
	private String headquarters;
	
	/** 発足日 */
	private String inauguration;
	
	/** 歴史 */
	private String hitory;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLeagueName() {
		return leagueName;
	}
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getHeadquarters() {
		return headquarters;
	}
	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}
	public String getInauguration() {
		return inauguration;
	}
	public void setInauguration(String inauguration) {
		this.inauguration = inauguration;
	}
	public String getHitory() {
		return hitory;
	}
	public void setHitory(String hitory) {
		this.hitory = hitory;
	}
	@Override
	public String toString() {
		return "Teams [id=" + id + ", leagueName=" + leagueName + ", teamName=" + teamName + ", headquarters="
				+ headquarters + ", inauguration=" + inauguration + ", hitory=" + hitory + "]";
	}
	

}
