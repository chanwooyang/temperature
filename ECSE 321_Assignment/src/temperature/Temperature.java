package temperature;
// Name: Justin ChanWoo Yang.  ID: 260368098

/**
 * We want to use the Java collections library to sort 
 * a collection of temperatures. Therefore, the {@code Temperature} 
 * class implements the {@code Comparable} interface by overriding 
 * {@code compareTo} method.
 */

public class Temperature implements Comparable<Temperature> {
	
	private double value;
	private Temperature.Units units;
	
  /** Enumerator for different temperature units */
  public static enum Units { FAHRENHEIT, CELCIUS, KELVIN }

  /**
   * Create a new {@code Temperature} with given attributes
   * @param value numerical value of {@code Temperature}
   * @param units {@code Units} of {@code Temperature}
   */
  public Temperature (double value, Temperature.Units units) {
	  // stores current temperature value and unit
	  this.value = value;
	  this.units = units;
  }
  
  /**
    * Get the value of the {@code Temperature}
    * @return numerical value of the {@code Temperature} in the current {@code Units}
    */
  public double getValue() { 
    // return the current temperature value
	return this.value;
	  
  }

  /**
   * Get the current {@code Units} of the {@code Temperature}
   * @return current {@code Units} of {@code Temperature}
   */
  public Units getUnits() {
    // return the current temperature unit
	return this.units;
	
  }

  /**
   * Change the current {@code Units} of the {@code Temperature}. 
   * Changing the {@code Units} also changes the numerical value 
   * in a consistent manner.
   * @param units the new {@code Units} 
   */
  public void changeUnits(Units units) {
    // Compare the stored temperature values and units with current temperature values and unit
	// If units are different, change the stored unit into current unit in consistent manner
	// and then do the unit conversion for the temperature value
	double temp;
	temp = this.value;
	
	if (units == Temperature.Units.FAHRENHEIT){
		if (this.units == Temperature.Units.CELCIUS){
			this.units = Temperature.Units.FAHRENHEIT;
			this.value = temp * 9 / 5 + 32;
		}
		else if (this.units == Temperature.Units.KELVIN){
			this.units = Temperature.Units.FAHRENHEIT;
			this.value = (temp - 273.15) * 9 / 5 +32;
		}
	}	
	else if (units == Temperature.Units.KELVIN){
		if (this.units == Temperature.Units.CELCIUS){
			this.units = Temperature.Units.KELVIN;
			this.value = temp +273.15;
		}
		else if (this.units == Temperature.Units.FAHRENHEIT){
			this.units = Temperature.Units.KELVIN;
			this.value = (temp - 32) * 5 / 9 + 273.15;
		}
	}
	else {
		if (this.units == Temperature.Units.KELVIN){
			this.units = Temperature.Units.CELCIUS;
			this.value = temp - 273.15;
		}
		else if (this.units == Temperature.Units.FAHRENHEIT){
			this.units = Temperature.Units.CELCIUS;
			this.value = (temp - 32) * 5 / 9;
		}
	}
}

  /** 
   * Convert the {@code Temperature} to {@code String}. The output is
   * as follows
   * <pre><code>
   *    Temperature temperature = new Temperature(0, Units.CELCIUS);
   *    System.out.println(temperature.toString()); // prints "0 ¡C"
   *    temperature.changeUnits(Units.FAHRENHEIT);
   *    System.out.println(temperature.toString()); // prints "32 ¡F"
   *    temperature.changeUnits(Units.KELVIN);
   *    System.out.println(temperature.toString()); // prints "273.15 K"
   * </code></pre>
   */
  public String toString() {
    // Store the both temperature value and unit symbol in the String variable, 'temper'
	// return the stored temperature value and appropriate unit symbol in String variable
	String temper;
	
	if (this.units == Temperature.Units.FAHRENHEIT){
		temper = this.value + " ¡F";
	}
	else if (this.units == Temperature.Units.CELCIUS){
		temper = this.value + " ¡C";
	}
	else {
		temper = this.value + " K";
	}
	
	return temper;
  }

  /**
   * In order to implement {@code Comparable}, we need to override
   * the {@code compareTo} method. 
   * @param temperature The {@code Temperature} to compare against
   * @return -1 if current object is less than {@code temperature}
   *          0 if both are equal
   *          1 if current object is greater than {@code temperature}
   */
  @Override
  public int compareTo (Temperature temperature) {
    // First, if current temperature unit and stored units are different,
	// then convert the unit by using 'changeUnits()' function
	// After units are made the same, compare the temperature values
	// and return the appropriate integer
	int i = 0;
	
	if (this.units == temperature.getUnits()){
		if (this.value == temperature.getValue()){
			i = 0;
		}
		else if (this.value < temperature.getValue()){
			i = 1;
		}
		else {
			i = -1;
		}
	}
	else if (this.units != temperature.getUnits()){
		changeUnits(getUnits());
		
		if (this.value == temperature.getValue()){
			i = 0;
		}
		else if (this.value < temperature.getValue()){
			i = 1;
		}
		else {
			i = -1;
		}
	}
	return i;
  }

  /**
   * Indicates whether some object is "equal" to this one.
   * To maintain consistency, whenever a class overrides 
   * {@code compareTo}, it must override {@code equals} so 
   * that
   * <pre>
   *   <code>o1.compareTo(o2) == 0</code> implies <code>o1.equals(o2) == true</code>
   * </pre>
   * See the API documentation of {@code Object} class for more details.
   */
  @Override
  public boolean equals (Object o) {
    // ...
	boolean eq = true;
	
	if (this == o){
		eq = true;
	}
	if ((o == null) || (o.getClass() != this.getClass())){
		eq = false;
	}
	return eq;
  }
// refer from http://www.technofundo.com/tech/java/equalhash.html
  
  /**
   * Return a hash code of the object. To maintain consistency,
   * whenever a class overrides {@code equals} it mush also override
   * {@code hashCode} in such a manner that 
   * <pre>
   *   <code>o1.equals(o2) == true</code> implies <code>o1.hashCode() == o2.hashCode()</code>
   * </pre>
   * See the API documentation of {@code Object} class for more details.
   */
  @Override
  public int hashCode() {
    // Convert the double variable value to the Double and then
	// use the 'hashCode()' function to generate unique hashcode
	// return the result of the 'hashCode()' function
	Double DoubleVar = new Double(getValue());
	return DoubleVar.hashCode();
  }
}