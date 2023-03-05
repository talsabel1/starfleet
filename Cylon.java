package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Objects;

public class Cylon extends CrewWoman{

	protected int modelNumber;
	public Cylon(String name, int age, int yearsInService, int modelNumber) {
		super(age, yearsInService, name);
		this.modelNumber = modelNumber;
	}

	/* @pre 1 <= modelNumber <= 12*/
	public int getModelNumber() {
		return modelNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Cylon cylon = (Cylon) o;
		return modelNumber == cylon.modelNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), modelNumber);
	}
}
