package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public abstract class myAbstractSpaceship implements Spaceship {

    protected String name;
    protected int commissionYear;
    protected float maxSpeed;
    protected Set<? extends CrewMember> crewMembers;

    public myAbstractSpaceship(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers){
        this.name = name;
        this.commissionYear = commissionYear;
        this.maxSpeed = maximalSpeed;
        this.crewMembers = crewMembers;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public int getCommissionYear(){
        return commissionYear;
    }

    @Override
    public float getMaximalSpeed(){
        return maxSpeed;
    }

    @Override
    public Set<? extends CrewMember> getCrewMembers(){
        return crewMembers;
    }

    @Override
    public String toString(){
        int numOfMembers = 0;
        for (CrewMember crewMember : crewMembers) {
            numOfMembers++;
        }
        String string = this.getClass().getSimpleName() +
                "\n\t" + "Name=" + getName() +
                "\n\t" + "CommissionYear=" + getCommissionYear() +
                "\n\t" + "MaximalSpeed=" + getMaximalSpeed() +
                "\n\t" + "FirePower=" + getFirePower() +
                "\n\t" + "CrewMembers=" + numOfMembers +
                "\n\t" + "AnnualMaintenanceCost=" + getAnnualMaintenanceCost();
        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        myAbstractSpaceship that = (myAbstractSpaceship) o;
        return commissionYear == that.commissionYear && Float.compare(that.maxSpeed, maxSpeed) == 0 && name.equals(that.name) && crewMembers.equals(that.crewMembers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, commissionYear, maxSpeed, crewMembers);
    }
}
