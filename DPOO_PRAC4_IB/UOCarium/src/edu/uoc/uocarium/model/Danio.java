package edu.uoc.uocarium.model;

public class Danio extends Fish{

	public Danio(double xCoord, double yCoord, Gender gender, int age, int energy, Tank tank) 
			throws AnimalException, ItemException, MovableException {
		super(xCoord, yCoord, "./images/danio/danio", 64, 64, gender, age, 1, 0.2, 0.002, Color.BRONZE,
				energy, tank);
	}

	@Override
	public int getOxygenConsumption() {
		return 12;
	}

	@Override
	public void breathe() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder(super.toString());
		string.append(" : Danio\n");
		return string.toString();
	}
}
