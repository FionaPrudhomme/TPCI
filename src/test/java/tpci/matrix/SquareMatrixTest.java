package tpci.matrix;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SquareMatrixTest {
	
	private double[][] m0Tab, m1Tab, m2Tab;
	private SquareMatrix m0, m1, m2;


	@Before
	public void setUp() throws Exception {
		m0Tab = new double[1][1];
		m0Tab[0][0]=0;
		m0= new SquareMatrix(m0Tab);
		
		m1Tab = new double[2][2];
		m1Tab[0][0]=1;
		m1Tab[0][1]=1;
		m1Tab[1][0]=1;
		m1Tab[1][1]=1;
		m1 = new SquareMatrix(m1Tab);
		
		m2Tab = new double[3][3];
		m2Tab[0][0]=1;
		m2Tab[0][1]=2;
		m2Tab[0][2]=3;
		m2Tab[1][0]=4;
		m2Tab[1][1]=5;
		m2Tab[1][2]=6;
		m2Tab[2][0]=7;
		m2Tab[2][1]=8;
		m2Tab[2][2]=9;
		m2 = new SquareMatrix(m2Tab);
	}


	@Test
	public void testGetSize() {
		assertEquals(m0.getSize(), 1);
		assertEquals(m1.getSize(), 2);
		assertEquals(m2.getSize(), 3);
	}

	@Test
	public void testGetValues() {
		assertArrayEquals(m0Tab, m0.getValues());
		assertArrayEquals(m1Tab, m1.getValues());
		assertArrayEquals(m2Tab, m2.getValues());
	}

	@Test
	public void testSetValues() {
		double[][]newM0 = {{1}};
		m0.setValues(newM0);
		assertArrayEquals(newM0, m0.getValues());
		
		double[][]newM2 = {{10,11},{12,13}};
		m2.setValues(newM2);
		assertArrayEquals(newM2, m2.getValues());
	}
	
	@Test
	public void setElementAt() {
		m0.setElementAt(0, 0, 2);
		assertEquals(m0.getElementAt(0, 0), 2, 0.0005);
		m1.setElementAt(0, 1, 5);
		assertEquals(m1.getElementAt(0, 1), 5, 0.0005);
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void getElementAtOutOfBounds() {
		m0.getElementAt(1, 2);
	}
	
	@Test
	public void getElementAt() {
		assertEquals(m0.getElementAt(0, 0), 0, 0.0005);
		assertEquals(m2.getElementAt(1, 2), 6, 0.0005);
	}

	@Test
	public void testEqualsObject() {
		double[][] tab = {{1,2,3},{4,5,6},{7,8,9}};
		SquareMatrix m = new SquareMatrix(tab);
		assertEquals(m.getSize(), m2.getSize());
		assertArrayEquals(m.getValues(), m2.getValues());
	}
	@Test
	public void testplus() {
		double[][] tab = {{1,2,3},{4,5,6},{7,8,9}};
		SquareMatrix m = new SquareMatrix(tab);
		
			double[][] res = {{1,2,3},{4,5,6},{7,8,9}};
			SquareMatrix result = new SquareMatrix(res);
			double[][] t = {{0,0,0},{0,0,0},{0,0,0}};
			SquareMatrix other = new SquareMatrix(t);
			assertEquals(result,m.plus(other));
	}
	
	

}
