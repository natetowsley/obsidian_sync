//Nathan Towsley
/* The Angel Fish named Amber is returned, this is because
 * the friendliness value of 5 is higher than the other fish's
 * friendliness value of 3,
 */
package homeworkPackage;

public class Towsley_JF_7_2 {
	public static void main(String[] args) {
		Fish Amber = new Fish("Angel Fish", 5);
		Fish James = new Fish("Guppy", 3);
		
		Fish nicest = nicestFish(Amber, James);
		System.out.println("The nicest fish has a friendliness value of " + nicest.getFriendliness());
	}
	public static class Fish {
		private String typeOfFish;
		private int friendliness;
		
		public Fish() {
			typeOfFish = "Unknown";
			friendliness = 3;
		}
		public Fish(String typeOfFish, int friendliness) {
			this.typeOfFish = typeOfFish;
			this.friendliness = friendliness;
		}
		public int getFriendliness() {
			return friendliness;
		}
	}
	public static Fish nicestFish(Fish f1, Fish f2) {
		if (f1.getFriendliness() == f2.getFriendliness()) {
			System.out.println("Both fish equally friendly, null returned");
			return null;
		}
		else if (f1.getFriendliness() > f2.getFriendliness()) {
			return f1;
		}
		else
			return f2;
	}
}
