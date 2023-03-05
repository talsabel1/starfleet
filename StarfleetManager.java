package il.ac.tau.cs.sw1.ex9.starfleet;


import java.util.*;


public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		List<Spaceship> sortedFleet = new ArrayList<Spaceship>(fleet);
		Collections.sort(sortedFleet, (Comparator<Spaceship>) (s1, s2) -> {
			int f1 = s1.getFirePower();
			int f2 = s2.getFirePower();
			int c1 = s1.getCommissionYear();
			int c2 = s2.getCommissionYear();
			String n1 = s1.getName();
			String n2 = s2.getName();
			if (f1 != f2)
				return -Integer.compare(f1, f2);
			else if (c1 != c2)
				return -Integer.compare(c1, c2);
			return n1.compareTo(n2);
		});
		List<String> sortedList = new ArrayList<>();
		for (Spaceship ship : sortedFleet) {
			sortedList.add(ship.toString());
		}
		return sortedList;
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		Map<String, Integer> instances = new HashMap<>();
		for (Spaceship s : fleet){
			String className = s.getClass().getSimpleName();
			int countInstances = instances.containsKey(className) ? instances.get(className) : 0;
			instances.put(className, countInstances+1);
		}
		return instances;

	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		int totalCost = 0;
		for(Spaceship s : fleet) {
			totalCost += s.getAnnualMaintenanceCost();
		}
		return totalCost;

	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set<String> weaponNames = new HashSet<>();
		for (Spaceship s : fleet){
			if (s instanceof myAbstractFighterShip)
				for (Weapon weapons : ((myAbstractFighterShip) s).getWeapon())
					weaponNames.add(weapons.getName());
		}
		return weaponNames;

	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		int numOfCrewMembers = 0;
		for (Spaceship s : fleet){
			numOfCrewMembers += s.getCrewMembers().size();
		}
		return numOfCrewMembers;

	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		float avgAge = 0;
		float count = 0;
		for (Spaceship s : fleet) {
			for (CrewMember cm : s.getCrewMembers()) {
				if (cm instanceof Officer) {
					avgAge += cm.getAge();
					count += 1;
				}
			}
		}
		avgAge = avgAge/count;
		return avgAge;
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		Map<Officer, Spaceship> highestRankingOfficers = new HashMap<>();
		for (Spaceship s : fleet) {
			List<Officer> officers = new ArrayList<>();
			for (CrewMember cm : s.getCrewMembers()) {
				if (cm instanceof Officer)
					officers.add((Officer)cm);
			}
			Collections.sort(officers, (o1, o2) -> {
				OfficerRank r1 = o1.getRank();
				OfficerRank r2 = o2.getRank();
				return -r1.compareTo(r2);
			});
			if (!officers.isEmpty())
				highestRankingOfficers.put(officers.get(0), s);
		}
		return highestRankingOfficers;

	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		Map<OfficerRank, Integer> ranksPopularity = new HashMap<>();
		for (Spaceship s : fleet) {
			for (CrewMember cm : s.getCrewMembers()) {
				if (cm instanceof Officer) {
					OfficerRank rank = ((Officer) cm).getRank();
					int count = ranksPopularity.containsKey(rank) ? ranksPopularity.get(rank) : 0;
					ranksPopularity.put(rank, count + 1);
				}
			}
		}
		List<Map.Entry<OfficerRank, Integer>> ranksSorted = new ArrayList<>(ranksPopularity.entrySet());
		Collections.sort(ranksSorted, (o1, o2) -> {
			int instances1 = o1.getValue();
			int instances2 = o2.getValue();
			if (instances1 != instances2) {
				return Integer.compare(instances1, instances2);
			}
			OfficerRank rank1 = o1.getKey();
			OfficerRank rank2 = o2.getKey();
			return rank1.compareTo(rank2);

		});

		return ranksSorted;
	}

}
