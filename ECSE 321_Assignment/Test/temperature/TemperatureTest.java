package temperature;

import org.junit.* ;
import static org.junit.Assert.* ;

public class TemperatureTest {

  // Add multiple tests to check all functions of
  // {@Code Temperature} class.

//getValue() function test
// Test three different cases; different value with three different units.
	@Test
	public void testgetValue1(){
		Temperature data = new Temperature (500, Temperature.Units.KELVIN);
		assertTrue(data.getValue() == 500);
	}
	@Test
	public void testgetValue2(){
		Temperature data = new Temperature (1000, Temperature.Units.CELCIUS);
		assertTrue(data.getValue() == 1000);
	}
	@Test
	public void testgetValue3(){
		Temperature data = new Temperature (90, Temperature.Units.FAHRENHEIT);
		assertTrue(data.getValue() == 90);
	}

//getUnits() function test
// Test three different cases; different value with three different units.
	@Test
	public void testgetUnits1(){
		Temperature data = new Temperature (400, Temperature.Units.FAHRENHEIT);
		assertEquals(data.getUnits() , Temperature.Units.FAHRENHEIT);
	}
	@Test
	public void testgetUnits2(){
		Temperature data = new Temperature (7, Temperature.Units.CELCIUS);
		assertEquals(data.getUnits() , Temperature.Units.CELCIUS);
	}
	@Test
	public void testgetUnits3(){
		Temperature data = new Temperature (1000, Temperature.Units.KELVIN);
		assertEquals(data.getUnits() , Temperature.Units.KELVIN);
	}

//changeUnits() function test for all six possible conversions among three different units.
	@Test
	public void testchangeUnits1(){		//Celcius to Kelvin
		Temperature data = new Temperature (0, Temperature.Units.CELCIUS);
		data.changeUnits(Temperature.Units.KELVIN);
		assertEquals(data.getUnits() , Temperature.Units.KELVIN);
		assertTrue(data.getValue() == 273.15);
	}
	@Test
	public void testchangeUnits2(){		//Celcius to Fahrenheit
		Temperature data = new Temperature (0, Temperature.Units.CELCIUS);
		data.changeUnits(Temperature.Units.FAHRENHEIT);
		assertEquals(data.getUnits() , Temperature.Units.FAHRENHEIT);
		assertTrue(data.getValue() == 32);
	}
	@Test
	public void testchangeUnits3(){		//Kelvin to Celcius
		Temperature data = new Temperature (0, Temperature.Units.KELVIN);
		data.changeUnits(Temperature.Units.CELCIUS);
		assertEquals(data.getUnits() , Temperature.Units.CELCIUS);
		assertTrue(data.getValue() == -273.15);
	}
	@Test
	public void testchangeUnits4(){		//Kelvin to Fahrenheit
		Temperature data = new Temperature (1, Temperature.Units.KELVIN);
		data.changeUnits(Temperature.Units.FAHRENHEIT);
		assertEquals(data.getUnits() , Temperature.Units.FAHRENHEIT);
		assertTrue(data.getValue() == -457.87);
	}
	@Test
	public void testchangeUnits5(){		//Fahrenheit to Celcius
		Temperature data = new Temperature (5, Temperature.Units.FAHRENHEIT);
		data.changeUnits(Temperature.Units.CELCIUS);
		assertEquals(data.getUnits() , Temperature.Units.CELCIUS);
		assertTrue(data.getValue() == -15);
	}
	@Test
	public void testchangeUnits6(){		//Fahrenheit to Kelvin
		Temperature data = new Temperature (5, Temperature.Units.FAHRENHEIT);
		data.changeUnits(Temperature.Units.KELVIN);
		assertEquals(data.getUnits() , Temperature.Units.KELVIN);
		assertTrue(data.getValue() == 258.15);
	}

//equals() function test
	@Test
	public void testEquals1(){
		Temperature data1 = new Temperature (0, Temperature.Units.CELCIUS);
		Temperature data2 = new Temperature (273.15, Temperature.Units.KELVIN);
		assertEquals(data1.equals(data2), true);	//Comparing '0 celcius' and '273.14 kelvin', which are the same temperature value, should return true. This checks whether unit conversion works correctly
		assertTrue(data1.getValue() == 0);			//equals() function should not affect return value of getValue() function and should return the original value
		assertTrue(data2.getValue() == 273.15);		//equals() function should not affect return value of getValue() function and should return the original value
	}
	
	@Test
	public void testEquals2(){
		Temperature data1 = new Temperature (273.15, Temperature.Units.KELVIN);
		Temperature data2 = new Temperature (32, Temperature.Units.FAHRENHEIT);
		assertEquals(data1.equals(data2), true);	//Comparing '273.15 kelvin' and '32 fahrenheit', which are the same temperature value, should return true. This checks whether unit conversion works correctly
		assertTrue(data1.getValue() == 273.15);		//equals() function should not affect return value of getValue() function and should return the original value
		assertTrue(data2.getValue() == 32);			//equals() function should not affect return value of getValue() function and should return the original value
	}
	
	@Test
	public void testEquals3(){
		Temperature data1 = new Temperature (32, Temperature.Units.FAHRENHEIT);
		Temperature data2 = new Temperature (0, Temperature.Units.CELCIUS);
		assertEquals(data1.equals(data2), true);	//Comparing '32 fahrenheit' and '0 celcius', which are the same temperature value, should return true. This checks whether unit conversion works correctly
		assertTrue(data1.getValue() == 32);			//equals() function should not affect return value of getValue() function and should return the original value
		assertTrue(data2.getValue() == 0);			//equals() function should not affect return value of getValue() function and should return the original value
	}
	
	@Test
	public void testEquals4(){ 					//This test data is to check for the two temperature value of same values and same units.
		Temperature data1 = new Temperature (0, Temperature.Units.CELCIUS);
		Temperature data2 = new Temperature (0, Temperature.Units.CELCIUS);
		assertEquals(data1.equals(data2), true);
		assertTrue(data1.getValue() == 0);		//getValue() should be the same because the unit conversion is not used
		assertTrue(data2.getValue() == 0);		//getValue() should be the same because the unit conversion is not used

	}
	
	@Test
	public void testEquals5(){ 						//This test data is to check whether equals() function returns false for two temperatures with the same unit but the different values
		Temperature data1 = new Temperature (0, Temperature.Units.CELCIUS);
		Temperature data2 = new Temperature (10, Temperature.Units.CELCIUS);
		assertEquals(data1.equals(data2), false);	//Since '0 celcius' and '10 celcius' are different, equals() function should return false
		assertTrue(data1.getValue() == 0);			//getValue() should be the same because the unit conversion is not used
		assertTrue(data2.getValue() == 10);			//getValue() should be the same because the unit conversion is not used

	}
	
	@Test
	public void testEquals6(){ 						//This test data is to check whether equals() function returns false for the two temperatures with the same values but the different units
		Temperature data1 = new Temperature (100, Temperature.Units.KELVIN);
		Temperature data2 = new Temperature (100, Temperature.Units.CELCIUS);
		assertEquals(data1.equals(data2), false);	//Since '100 kelvin' and '100 celcius' are different, equals() function should return false 
		assertTrue(data1.getValue() == 100);		//equals() function should not affect return value of getValue() function and should return the original value
		assertTrue(data2.getValue() == 100);		//equals() function should not affect return value of getValue() function and should return the original value	
	}
	
	//First three test data are to check whether equals() function properly convert the unit and 
	//returns the true for two same temperature values, represented in different units.	
	//Also, it checks if the unit conversion works properly and if equals() function does not
	//affect the return value of getValue() function
	//Fourth test data is to check if equals() function returns true for two identically represented temperature values
	//Fifth test data is to check if equals() function returns false for two temperatures with same units but different values
	//Last test data is to check whether equals() function returns false for two temperatures with same values but different units
	//Also, it checks if the unit conversion works properly and if equals() function does not
	//affect the return value of getValue() function
}