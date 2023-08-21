
public class ToolStore extends NormalLoc {

	ToolStore(Player player) {
		super(player, "Shop");
	}

	public boolean getLocation() {
		System.out.println("Money : " + player.getMoney());
		System.out.println("1- Weapons ");
		System.out.println("2- Armors ");
		System.out.println("3- Exit ");
		int selTool = scan.nextInt();
		int selItemID;
		switch (selTool) {
		case 1:
			selItemID = weaponMenu();
			buyWeapon(selItemID);
			break;
		case 2:
			selItemID = armorMenu();
			buyArmor(selItemID);
			break;
		default:
			break;
		}
		return true;
	}
	
	public int armorMenu() {
		System.out.println("1- Light\t <Value : 15 - Avoid : 1>");
		System.out.println("2- Heavy \t <Value : 25 - Avoid : 3>");
		System.out.println("3- Super Heavy \t <Value : 40 - Avoid : 5>");
		System.out.println("4- Exit ");
		System.out.print("Choose the Weapon you want to buy : ");
		int selArmorID = scan.nextInt();
		return selArmorID;
	}
	public void buyArmor(int itemID) {
		int avoid = 0, price = 0;
		String aName = null;
		switch (itemID) {
		case 1:
			avoid = 1;
			aName = "Light Armor";
			price = 15;
			break;
		case 2:
			avoid = 3;
			aName = "Heavy Armor";
			price = 25;
			break;
		case 3:
			avoid = 5;
			aName = "Super Heavy Armor";
			price = 40;
			break;
		case 4:
			System.out.println("Exiting.");
			break;
		default:
			System.out.println("Invalid Transaction! ");
			break;
		}
		if (price > 0) {
			if (player.getMoney() > price) {
				player.getInv().setArmor(avoid);
				player.getInv().setaName(aName);
				player.setMoney(player.getMoney() - price);
				System.out.println("You bought a " + aName + "\tDamage to be blocked : " + player.getInv().getArmor());
				System.out.println("Remaining Money : " + player.getMoney());
			} else {
				System.out.println("Insufficient Balance");
			}
		}
	}

	public int weaponMenu() {
		System.out.println("1- Pistol\t <Value : 25 - Damage : 2>");
		System.out.println("2- Sword \t <Value : 35 - Damage : 3>");
		System.out.println("3- Rifle \t <Value : 45 - Damage : 7>");
		System.out.println("4- Exit ");
		System.out.print("Choose the Weapon you want to buy : ");
		int selWeaponID = scan.nextInt();
		return selWeaponID;
	}

	public void buyWeapon(int itemID) {
		int damage = 0, price = 0;
		String wName = null;
		switch (itemID) {
		case 1:
			damage = 2;
			wName = "Pistol";
			price = 25;
			break;
		case 2:
			damage = 3;
			wName = "Sword";
			price = 35;
			break;
		case 3:
			damage = 7;
			wName = "Rifle";
			price = 45;
			break;
		case 4:
			System.out.println("Exiting.");
			break;
		default:
			System.out.println("Invalid Transaction! ");
			break;
		}
		if (price > 0) {
			if (player.getMoney() > price) {
				player.getInv().setDamage(damage);
				player.getInv().setwName(wName);
				player.setMoney(player.getMoney() - price);
				System.out.println("You bought a " + wName + "\tPrevious Damage : " + player.getDamage()
						+ "\tCurrent Damage : " + player.getTotalDamage());
				System.out.println("Remaining Money : " + player.getMoney());
			} else {
				System.out.println("Insufficient Balance");
			}
		}
	}

}
