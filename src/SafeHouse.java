
public class SafeHouse extends NormalLoc{

	SafeHouse(Player player) {
		super(player, "Safe House");
		
	}
	
	public boolean getLocation() {
		player.setHealthy(player.getrHealthy());
		System.out.println("You healed! ");
		System.out.println("You're in SafeHouse now. ");
		return true;
	}

}
