package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Objects;
import java.util.Set;

public class TransportShip extends myAbstractSpaceship{

	protected int cargoCapacity;
	protected int passengerCapacity;
	
	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		super(name, commissionYear, maximalSpeed, crewMembers);
		this.cargoCapacity = cargoCapacity;
		this.passengerCapacity = passengerCapacity;
	}

	public int getCargoCapacity(){
		return cargoCapacity;
	}

	public int getPassengerCapacity(){
		return passengerCapacity;
	}
	@Override
	public int getAnnualMaintenanceCost() {
		return (3000 + 5*getCargoCapacity() + 3*getPassengerCapacity());
	}

	@Override
	public String toString() {
		String string = super.toString() +
				"\n\t" + "CargoCapacity=" + getCargoCapacity() +
				"\n\t" + "PassengerCapacity=" + getPassengerCapacity();
		return string;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		TransportShip that = (TransportShip) o;
		return cargoCapacity == that.cargoCapacity && passengerCapacity == that.passengerCapacity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), cargoCapacity, passengerCapacity);
	}
}
