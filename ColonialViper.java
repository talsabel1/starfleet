package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends myAbstractFighterShip {

	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);

	}

	@Override
	public int getAnnualMaintenanceCost(){
		int crewMembersCost = 0;
		for (CrewMember crewWoman : crewMembers)
			crewMembersCost += 500;
		return (super.getAnnualMaintenanceCost() + 4000 + crewMembersCost + (int)(500*getMaximalSpeed()));
	}

}
