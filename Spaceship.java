package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public interface Spaceship {
    public String getName();

    public int getCommissionYear();

    public float getMaximalSpeed();

    public default int getFirePower(){
        return 10;
    }

    public Set<? extends CrewMember> getCrewMembers();

    public int getAnnualMaintenanceCost();

}
