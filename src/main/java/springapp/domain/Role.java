package springapp.domain;

import static springapp.domain.Permission.*;
import java.util.ArrayList;
import java.util.List;


public enum Role {

	SUPER_ADMIN(Permission.values()),
	READ_ONLY(LIST_PETS, LIST_CLIENTS),
	PETS_ONLY(LIST_PETS, SAVE_PET, GET_PET); 
	
	
	private final Permission[] permissions;
	
	Role(Permission ... permissions) {
		this.permissions = permissions;
	}
	
	public List<Permission> getPermissions(){
		List<Permission> list = new ArrayList<>();
		for(Permission p: permissions) {
			list.add(p);
		}
		return list;
	}
	
}
