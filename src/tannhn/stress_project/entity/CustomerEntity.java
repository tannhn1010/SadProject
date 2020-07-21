package tannhn.stress_project.entity;

public class CustomerEntity {
	private int id;
	private String name;
	private String address;
	private String team;
	
	public CustomerEntity() {
		
	}
	public CustomerEntity( int id, String name, String address, String team) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.team = team;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
}
