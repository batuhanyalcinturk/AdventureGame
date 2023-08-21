import java.util.Iterator;
import java.util.Scanner;

public class Player {
	private int damage, healthy, money, rHealthy;
	private String name, cName;
	private Inventory inv;
	Scanner scan = new Scanner(System.in);

	public Player(String name) {
		this.name = name;
		this.inv = new Inventory();
	}
	
	public void selectChar() {
		switch (charMenu()) {
		case 1:
			initPlayer("Samurai", 5, 21, 15);
			break;
		case 2:
			initPlayer("Archer", 7, 18, 20);
			break;
		case 3:
			initPlayer("Knight", 8, 24, 5);
			break;
		default:
			initPlayer("Samurai", 5, 21, 15);
			break;
		}
		System.out.println("Character : " + getcName() + "   Damage : " + getDamage() + "   Health : " + getHealthy()
				+ "   Money : " + getMoney());
	}

	public int charMenu() {
		System.out.println("Select your Character : ");
		System.out.println("1- Samurai - Damage : 5   Health : 21   Money : 15");
		System.out.println("2- Archer  - Damage : 7   Health : 18   Money : 20");
		System.out.println("3- Knight  - Damage : 8   Health : 24   Money : 5");
		System.out.print("Your Choice : ");
		int chaID = scan.nextInt();

		while (chaID < 1 || chaID > 3) {
			System.out.println("Enter a valid character ");
			chaID = scan.nextInt();
		}
		return chaID;
	}
	public int getTotalDamage() {
		return this.getDamage() + this.getInv().getDamage();
	}

	public void initPlayer(String cName, int dmg, int hlthy, int mny) {
		setcName(cName);
		setDamage(dmg);
		setHealthy(hlthy);
		setMoney(mny);
		setrHealthy(hlthy);
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealthy() {
		return healthy;
	}

	public void setHealthy(int healthy) {
		this.healthy = healthy;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}

	public int getrHealthy() {
		return rHealthy;
	}

	public void setrHealthy(int rHealthy) {
		this.rHealthy = rHealthy;
	}
}
