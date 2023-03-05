package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Bomber extends myAbstractFighterShip{

	protected int numberOfTechnicians;

	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.numberOfTechnicians = numberOfTechnicians;
	}

	public int getNumberOfTechnicians() {
		return numberOfTechnicians;
	}
	@Override
	public int getAnnualMaintenanceCost() {
		double techniciansDiscount = (double)(10 - getNumberOfTechnicians())/10;
		return (int)(super.getAnnualMaintenanceCost()*techniciansDiscount + 5000);
	}

	@Override
	public String toString() {
		String string = super.toString() +
				"\n\t" + "NumberOfTechnicians=" + getNumberOfTechnicians();
		return string;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Bomber bomber = (Bomber) o;
		return numberOfTechnicians == bomber.numberOfTechnicians;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), numberOfTechnicians);
	}
}
