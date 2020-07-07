package edu.uoc.uocarium.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KeeperTest {

	@Test
	void testSetId1() throws NullPointerException, KeeperException {
		Keeper instance = new Keeper("G2345", "Name", "Surname");
		// id = null
		Exception exception = assertThrows(Exception.class, () -> instance.setId(null));
		assertEquals(null, exception.getMessage());
		
	}
	
	@Test
	void testSetId2() throws NullPointerException, KeeperException {
		Keeper instance = new Keeper("G2345", "Name", "Surname");
		// id de 4 caracteres
		Exception exception = assertThrows(KeeperException.class, () -> instance.setId("G234"));
		assertEquals("[ERROR] A kepper's id must have 5 characters!!", exception.getMessage());
	}

	@Test
	void testSetId3() throws NullPointerException, KeeperException {
		Keeper instance = new Keeper("G2345", "Name", "Surname");
		// id de 5 caracteres
		assertEquals("G2345", instance.getId());
	}
	
	@Test
	void testSetId4() throws NullPointerException, KeeperException {
		Keeper instance = new Keeper("G2345", "Name", "Surname");
		// id de 6 caracteres
		Exception exception = assertThrows(KeeperException.class, () -> instance.setId("G23456"));
		assertEquals("[ERROR] A kepper's id must have 5 characters!!", exception.getMessage());
	}
	
	@Test
	void testSetId5() throws NullPointerException, KeeperException {
		Keeper instance = new Keeper("G2345", "Name", "Surname");
		// id no empieza por G
		Exception exception = assertThrows(KeeperException.class, () -> instance.setId("C2345"));
		assertEquals("[ERROR] A keeper's id must start with letter 'G'!!", exception.getMessage());
	}

	@Test
	void testAddTank1() throws TankException, KeeperException {
		Keeper instance = new Keeper("G2345", "Name", "Surname");
		Tank tank1 = new Tank("D1","Tank1", "Tank Default", 50.25, 10.55, 100.232, "./", 15, 7);
		instance.addTank(tank1);
		assertEquals("[G2345]Surname,Name:\n\tTank1", instance.toString());
	}
	
	@Test
	void testAddTank2() throws TankException, KeeperException {
		Keeper instance = new Keeper("G2345", "Name", "Surname");
		Tank tank1 = new Tank("D1","Tank1", "Tank Default", 50.25, 10.55, 100.232, "./", 15, 7);
		Tank tank2 = new Tank("D2","Tank2", "Tank Default", 50.25, 10.55, 100.232, "./", 15, 7);
		instance.addTank(tank1);
		instance.addTank(tank2);
		assertEquals("[G2345]Surname,Name:\n\tTank1\n\tTank2", instance.toString());
	}
	
	@Test
	void testAddTank3() throws TankException, KeeperException {
		Keeper instance = new Keeper("G2345", "Name", "Surname");
		Tank tank1 = new Tank("D1","Tank1", "Tank Default", 50.25, 10.55, 100.232, "./", 15, 7);
		Tank tank2 = new Tank("D2","Tank2", "Tank Default", 50.25, 10.55, 100.232, "./", 15, 7);
		Tank tank3 = new Tank("D3","Tank3", "Tank Default", 50.25, 10.55, 100.232, "./", 15, 7);
		instance.addTank(tank1);
		instance.addTank(tank2);
		instance.addTank(tank3);
		assertEquals("[G2345]Surname,Name:\n\tTank1\n\tTank2\n\tTank3", instance.toString());
	}
	
	@Test
	void testAddTank4() throws TankException, KeeperException {
		Keeper instance = new Keeper("G2345", "Name", "Surname");
		Tank tank1 = new Tank("D1","Tank1", "Tank Default", 50.25, 10.55, 100.232, "./", 15, 7);
		Tank tank2 = new Tank("D2","Tank2", "Tank Default", 50.25, 10.55, 100.232, "./", 15, 7);
		Tank tank3 = new Tank("D3","Tank3", "Tank Default", 50.25, 10.55, 100.232, "./", 15, 7);
		Tank tank4 = new Tank("D4","Tank4", "Tank Default", 50.25, 10.55, 100.232, "./", 15, 7);
		instance.addTank(tank1);
		instance.addTank(tank2);
		instance.addTank(tank3);
		instance.addTank(tank4);
		assertEquals("[G2345]Surname,Name:\n\tTank1\n\tTank2\n\tTank3\n\tTank4", instance.toString());
	}
	
	@Test
	void testAddTank5() throws TankException, KeeperException {
		Keeper instance = new Keeper("G2345", "Name", "Surname");
		Tank tank1 = new Tank("D1","Tank1", "Tank Default", 50.25, 10.55, 100.232, "./", 15, 7);
		Tank tank2 = new Tank("D2","Tank2", "Tank Default", 50.25, 10.55, 100.232, "./", 15, 7);
		Tank tank3 = new Tank("D3","Tank3", "Tank Default", 50.25, 10.55, 100.232, "./", 15, 7);
		Tank tank4 = new Tank("D4","Tank4", "Tank Default", 50.25, 10.55, 100.232, "./", 15, 7);
		Tank tank5 = new Tank("D5","Tank5", "Tank Default", 50.25, 10.55, 100.232, "./", 15, 7);
		instance.addTank(tank1);
		instance.addTank(tank2);
		instance.addTank(tank3);
		instance.addTank(tank4);
		instance.addTank(tank5);
		assertEquals("[G2345]Surname,Name:\n\tTank1\n\tTank2\n\tTank3\n\tTank4\n\tTank5", instance.toString());
	}

	@Test
	void testAddTank6() throws TankException, KeeperException {
		Keeper instance = new Keeper("G2345", "Name", "Surname");
		Tank tank1 = new Tank("D1","Tank1", "Tank Default", 50.25, 10.55, 100.232, "./", 15, 7);
		Tank tank2 = new Tank("D2","Tank2", "Tank Default", 50.25, 10.55, 100.232, "./", 15, 7);
		Tank tank3 = new Tank("D3","Tank3", "Tank Default", 50.25, 10.55, 100.232, "./", 15, 7);
		Tank tank4 = new Tank("D4","Tank4", "Tank Default", 50.25, 10.55, 100.232, "./", 15, 7);
		Tank tank5 = new Tank("D5","Tank5", "Tank Default", 50.25, 10.55, 100.232, "./", 15, 7);
		Tank tank6 = new Tank("D6","Tank6", "Tank Default", 50.25, 10.55, 100.232, "./", 15, 7);
		instance.addTank(tank1);
		instance.addTank(tank2);
		instance.addTank(tank3);
		instance.addTank(tank4);
		instance.addTank(tank5);
		Exception exception = assertThrows(KeeperException.class, () -> instance.addTank(tank6));
		assertEquals("[ERROR] A keeper cannot take care of more than 5 tanks!!", exception.getMessage());
	}
}
