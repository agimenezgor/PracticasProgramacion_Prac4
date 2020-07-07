package edu.uoc.uocarium.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import edu.uoc.uocarium.model.Animal;
import edu.uoc.uocarium.model.AnimalException;
import edu.uoc.uocarium.model.AnimalStatus;
import edu.uoc.uocarium.model.Corydoras;
import edu.uoc.uocarium.model.Danio;
import edu.uoc.uocarium.model.Fish;
import edu.uoc.uocarium.model.Food;
import edu.uoc.uocarium.model.Gender;
import edu.uoc.uocarium.model.Item;
import edu.uoc.uocarium.model.ItemException;
import edu.uoc.uocarium.model.Keeper;
import edu.uoc.uocarium.model.Movable;
import edu.uoc.uocarium.model.MovableException;
import edu.uoc.uocarium.model.SubmarineToy;
import edu.uoc.uocarium.model.Tank;
import edu.uoc.uocarium.model.TankException;
import edu.uoc.uocarium.model.Tetra;

public class UOCariumController {

	Database database;
	String tankSelected;
	
	public UOCariumController(String folderName) throws ItemException {
		database = new Database(folderName);
		tankSelected = (database.getTanks().size()!=0)? database.getTanks().get(0).getId():null;
	}
		
	public String getTankSelected() {
		return tankSelected;
	}
	
	public void setTankSelected(String tankSelected) {
		this.tankSelected = tankSelected;
	}

	public List<Tank> getTanks(){
		List<Tank> tanks = database.getTanks();
		//TODO
		for(int i = 0; i < tanks.size(); i++) {
			for( int j = 1; j < tanks.size(); j++) {
				if(tanks.get(i).compareTo(tanks.get(j)) > 0){
					Tank tankAux = tanks.get(i);
					tanks.add(i, tanks.get(j));
					tanks.add(j, tankAux);
				}
			}
		}
		
		return tanks;
	}
	
	public Tank getTank(String id) {
		return database.getTank(id);
	}
	
	public List<Item> getMovableItems(){
		//TODO
		List<Item> returnedItems = new ArrayList<Item>();
		for(Item movableItem : getTank(getTankSelected()).getItems()) {
			if(movableItem instanceof Movable) {
				returnedItems.add(movableItem);
			}
		}
		return returnedItems;			
	}
	
	public List<Item> getItems(){		
		return database.getTank(getTankSelected()).getItems();
	}
	
	public void addFish() throws TankException, ItemException, AnimalException, MovableException{
		//TODO
		int fishType = (new Random()).nextInt(11); 
		
		double randomXCoord = (new Random()).nextDouble()*301;
		double randomYCoord = (new Random()).nextDouble()*301;
		
		boolean genderBoolean = (new Random()).nextBoolean();
		Gender gender = Gender.FEMALE;
		if(genderBoolean) gender = Gender.MALE;
		
		if(fishType < 3) {
			//danio
			Danio danio = new Danio(randomXCoord, randomYCoord, gender, 0, 100, null);	
			database.getTank(getTankSelected()).addItem(danio);
		}
		else if(fishType >= 3 && fishType < 6) {
			//tetra
			Tetra tetra = new Tetra(randomXCoord, randomYCoord, gender, 0, 100, null);
			database.getTank(getTankSelected()).addItem(tetra);
		}
		else {
			//corydoras
			Corydoras corydoras = new Corydoras(randomXCoord, randomYCoord, gender, 0, 100, null);
			database.getTank(getTankSelected()).addItem(corydoras);
		}
	}
	
	public SubmarineToy getSubmarineToy() {
		
		Optional<Item> op = database.getTank(getTankSelected()).getItems().stream().filter(p -> p instanceof SubmarineToy).findFirst();
		
		return op.isEmpty()?null:(SubmarineToy) op.get();			
				
	}
	
	public boolean isSubmarineToy() {
		return getSubmarineToy() != null;
	}
	
	public void toggleSubmarineToy() throws TankException, ItemException, MovableException{
		//TODO
		Tank tank = new Tank();
		tank.setId(getTankSelected());
		
		if(isSubmarineToy()) {
			database.getTank(getTankSelected()).removeItem(getSubmarineToy());
		}else {
			SubmarineToy submarineToy = new SubmarineToy(50, 50, 100, 50, null);
			database.getTank(getTankSelected()).addItem(submarineToy);
		}
	}
	
	public String getTankInfo() {
		return getTank(getTankSelected()).toString();
	}
	
	public List<Item> removeDeadItems() throws TankException{
		//TODO
		List<Item> deadItems = new ArrayList<Item>();
		
		// Guardamos en una lista auxiliar los items a borrar
		for(Item item : getItems()) {
			if(item instanceof Animal && ((Animal)item).getStatus() == AnimalStatus.DEAD) {
				deadItems.add(item);
			}
		}
		
		// Borramos los items con "removeItem"
		for(var deadItem : deadItems) {
			try {
				database.getTank(getTankSelected()).removeItem(deadItem);
			} catch (TankException e) {
				e.printStackTrace();
			}
		}		
		return deadItems;
	}
	
	public void feed() throws Exception {
		new Food((new Random()).nextInt(Movable.TANK_PANE_WIDTH-10),0,1,1,5,getTank(getTankSelected()));	
		
	}
	
	public List<Keeper> getKeepers(){
		return database.getKeepers();
	}
}
