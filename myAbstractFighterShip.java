package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public abstract class myAbstractFighterShip extends myAbstractSpaceship{

    protected List<Weapon> weapons;

    public myAbstractFighterShip(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
        super(name, commissionYear, maximalSpeed, crewMembers);
        this.weapons = weapons;
    }

    public List<Weapon> getWeapon(){
        return weapons;
    }
    @Override
    public int getFirePower() {
        int firePowerSum = 0;
        for (Weapon weapon : weapons) {
            firePowerSum += weapon.getFirePower();
        }
        return super.getFirePower() + firePowerSum;
    }

    @Override
    public int getAnnualMaintenanceCost() {
        int weaponsMaintenanceCost = 0;
        for (Weapon weapon : weapons) {
            weaponsMaintenanceCost += weapon.getAnnualMaintenanceCost();
        }
        return weaponsMaintenanceCost;
    }

    @Override
    public String toString() {
        String weaponString = "";
        for (Weapon weapon : weapons) {
            weaponString += weapon.toString() + ", ";
        }
        String wS = weaponString.substring(0,weaponString.length()-2); // remove last comma + space
        String string = super.toString() +
                "\n\t" + "WeaponArray=[" + wS + "]";
        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        myAbstractFighterShip that = (myAbstractFighterShip) o;
        return weapons.equals(that.weapons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weapons);
    }
}
