package springapp.service;


import java.util.List;
import java.util.UUID;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import springapp.command.ClientCommand;
import springapp.dao.ClientDao;
import springapp.dao.PetDao;
import springapp.domain.Client;
import springapp.domain.Pet;


@Service
public class ClientService {

	private Logger logger = LoggerFactory.getLogger(ClientService.class);
	
	@Autowired 
	ClientDao clientDao;

	@Autowired 
	PetDao petDao;

	public List<Client> getClients(){
		return clientDao.list();
		
	}

	public Client getClient(String id) {
		return clientDao.get(Integer.parseInt(id));
	}
	
	public Client getClient(Integer id) {
		return clientDao.get(id);
	}

	
	public void deleteClient(String id) {
		clientDao.delete(Integer.parseInt(id));
	}

	
	public Client saveClient(ClientCommand toSave) {
		logger.info("Client Service: Entering saveClient method");
		Client client = new Client(toSave.getId(), toSave.getName(), toSave.getPhoneNumber(), toSave.getAddress(), toSave.getEmail());
		logger.info("Client Service: Exiting save Client method");

		return clientDao.save(client);
	}
	
	public List<Pet> getPets(int clientId) {
	
		return petDao.listForClient(clientId);
	}
}
