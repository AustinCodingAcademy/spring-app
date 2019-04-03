package springapp.domain;

public class Pet {
	private final Integer id;
	private final String name;
	private final Gender gender;
	private final boolean altered;
	private final Integer clientId;
	private final Integer age;
	
	public Pet(Integer id, String name, Gender gender, boolean altered, Integer clientId, Integer age ){
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.altered = altered;
		this.clientId = clientId;
		this.age = age;
	}
	
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Gender getGender() {
		return gender;
	}

	public boolean isAltered() {
		return altered;
	}

	public Integer getClientId() {
		return clientId;
	}
	
	public Integer getAge() {
		return age;
	}

	
}

