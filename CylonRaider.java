package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends myAbstractFighterShip {

	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}

	@Override
	public int getAnnualMaintenanceCost(){
		int crewMembersCost = 0;
		for (CrewMember cylon : crewMembers)
			crewMembersCost += 500;
		return (super.getAnnualMaintenanceCost() + 3500 + crewMembersCost + (int)(1200*getMaximalSpeed()));
	}
	

}
