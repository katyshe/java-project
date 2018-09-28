package model;
/*
 * admin class
 */
public class Admin extends user {
	private String TeamName;
	
	public Admin(String username, String password,String TeamName) {
		super(username, password);
		this.TeamName= TeamName;
	}

	public String getTeamName() {
		return TeamName;
	}

	public void setTeamName(String teamName) {
		TeamName = teamName;
	}

	
	
	
}
