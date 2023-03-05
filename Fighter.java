package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends myAbstractFighterShip{

	public Fighter(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}


	@Override
	public int getAnnualMaintenanceCost() {
		return (super.getAnnualMaintenanceCost() + 2500 + (int)Math.floor(1000*maxSpeed));
	}

}
