package action;

import static org.junit.Assert.*;

import org.junit.Test;

public class SwimTest extends ActionTest{

	protected Action createAction() {
		return new Swim(2);
	}
	
	@Test
	public void testIsReady() {
		assertTrue(super.a.isReady());
		super.a.doStep();
		assertFalse(super.a.isReady());
	}
	
	@Test
	public void testIsInProgress() {
		assertFalse(super.a.isInProgress());
		super.a.doStep();
		assertTrue(super.a.isInProgress());
		super.a.doStep();
		assertFalse(super.a.isInProgress());
	}
	
	@Test
	public void testIsFinished() {
		assertFalse(super.a.isFinished());
		super.a.doStep();
		super.a.doStep();
		assertTrue(super.a.isFinished());
	}

}
