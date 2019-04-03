package springapp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import springapp.command.PetCommand;
import springapp.dao.PetDao;
import springapp.domain.Client;
import springapp.domain.Pet;


@Service
public class PetService {

	private Logger logger = LoggerFactory.getLogger(PetService.class);
	
	@Autowired 
	PetDao petDao;
	
	public List<Pet> getPets(){
		return petDao.list();
		
	}

	public void deletePet(String id) {
		petDao.delete(Integer.parseInt(id));
	}

	public Pet getPet(String id) {
		return petDao.get(Integer.parseInt(id));
	}
	
	public Pet savePet(PetCommand command) {
		 logger.info("Pet Service: Entering savePet method");
		Pet newPet = new Pet(command.getId(), command.getName(), command.getGender(), command.isAltered(), command.getClientId(), command.getAge());
		logger.info("Pet Service: Exiting save Pet method");
		return petDao.save(newPet);
	}
}
