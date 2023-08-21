import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	Scanner scan = new Scanner(System.in);

	public void login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the Adventure Game ");
		System.out.print("Enter your name before start the game : ");
		String playerName = scan.nextLine();
		player = new Player(playerName);
		player.selectChar();
		start();
	}

	public void start() {
		while (true) {
			System.out.println();
			System.out.println("=====================================");
			System.out.println();
			System.out.println("1. Safehouse\t-->  No enemy");
			System.out.println("2. Cave \t-->  You may encounter Zombies! ");
			System.out.println("3. Forest\t-->  You may encounter Vampires!");
			System.out.println("4. River\t-->  You may encounter Bears!");
			System.out.println("5. Store\t-->  You can buy Weapons and Armor here!");
			System.out.print("Choose location you want to go : ");
			int selLoc = scan.nextInt();
			while (selLoc < 0 || selLoc > 5) {
				System.out.print("Choose a valid location : ");
				selLoc = scan.nextInt();
			}

			switch (selLoc) {
			case 1:
				location = new SafeHouse(player);
				break;
			case 2:
				location = new Cave(player);
				break;
			case 3:
				location = new Forest(player);
				break;
			case 4:
				location = new River(player);
				break;
			case 5:
				location = new ToolStore(player);
				break;
			default:
				location = new SafeHouse(player);

			}
			if(location.getClass().getName().equals("SafeHouse")) {
				if(player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()) {
					System.out.println("Congratulations. You finished the game! ");
					break;
				}
			}
			if (!location.getLocation()) {
				System.out.println("Game Over! ");
				break;
			}
		}
	}
}
