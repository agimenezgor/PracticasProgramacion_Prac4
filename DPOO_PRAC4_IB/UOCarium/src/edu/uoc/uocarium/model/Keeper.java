package edu.uoc.uocarium.model;

import java.util.ArrayList;

public class Keeper {
	
	private final int MAX_KEEPED_TANKS = 5;
	
	private String id;
	private String name;
	private String surname;
	
	private ArrayList<Tank> keepedTanksList = new ArrayList<Tank>();
	
	public Keeper(String id, String name, String surname) {
		this.id = id;
		this.name = name;
		this.surname = surname;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) throws NullPointerException, KeeperException{
		if(id == null)throw new NullPointerException();
		if(!id.startsWith("G")) throw new KeeperException(KeeperException.MSG_ERR_ID_FIRST_LETTER_VALUE);
		if(id.length() != 5) throw new KeeperException(KeeperException.MSG_ERR_ID_SIZE);
		
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void addTank(Tank tank) throws KeeperException{
		if(keepedTanksList != null && keepedTanksList.size() == MAX_KEEPED_TANKS) throw new KeeperException(KeeperException.MSG_ERR_LIST_SIZE_VALUE);
		if(keepedTanksList != null) {
			if(!keepedTanksList.contains(tank)) {
				keepedTanksList.add(tank);
			}
		}else {
			keepedTanksList.add(tank);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder tanksString = new StringBuilder();
		for(Tank tank : keepedTanksList) {
			tanksString.append("\n\t" + tank.getName());
		}
		return "[" + getId() + "]" + getSurname() + "," + getName() + ":" + tanksString.toString(); 
	}
	
}
