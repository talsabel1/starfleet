package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Objects;

public class CrewWoman implements CrewMember {

	protected String name;
	protected int age;
	protected int yearsInService;

	public CrewWoman(int age, int yearsInService, String name) {
		this.name = name;
		this.age = age;
		this.yearsInService = yearsInService;
	}

	@Override
	public String getName(){
		return name;
	}

	@Override
	public int getAge(){
		return age;
	}

	@Override
	public int getYearsInService(){
		return yearsInService;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CrewWoman crewWoman = (CrewWoman) o;
		return age == crewWoman.age && yearsInService == crewWoman.yearsInService && name.equals(crewWoman.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age, yearsInService);
	}

	@Override
	public String toString() {
		String string = this.getClass().getSimpleName() +
				"\n\t" + "Name=" + getName() +
				"\n\t" + "Age=" + getAge() +
				"\n\t" + "YearsInService=" + getYearsInService();
		return string;
	}


}
