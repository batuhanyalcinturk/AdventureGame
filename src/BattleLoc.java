
public abstract class BattleLoc extends Location {
	protected Obstacle obstacle;
	protected String award;

	BattleLoc(Player player, String name, Obstacle obstacle, String award) {
		super(player);
		this.obstacle = obstacle;
		this.name = name;
		this.award = award;
	}

	public boolean getLocation() {
		int obsCount = obstacle.count();
		System.out.println("You're in the " + this.getName());
		System.out.println("Be careful! There is/are " + obsCount + " " + obstacle.getName() + " here!");
		System.out.print("<F>ight or <R>un Away : ");
		String selCase = scan.next();
		selCase = selCase.toUpperCase();
		if (selCase.equals("F")) {
			if (combat(obsCount)) {
				System.out.println("You killed all the enemies in the " + this.getName());
				if (this.award.equals("Food") && player.getInv().isFood() == false) {
					System.out.println("You won a " + this.award);
					player.getInv().setFood(true);
				} else if (this.award.equals("Water") && player.getInv().isWater() == false) {
					System.out.println("You won a " + this.award);
					player.getInv().setWater(true);
				} else if (this.award.equals("Firewood") && player.getInv().isFirewood() == false) {
					System.out.println("You won a " + this.award);
					player.getInv().setFirewood(true);

				}
				return true;
			}
			if (player.getHealthy() <= 0) {
				System.out.println("You're dead! ");
				return false;
			}
		}
		return true;
	}

	public boolean combat(int obsCount) {
		for (int i = 0; i < obsCount; i++) {
			int defObsHealth = obstacle.getHealth();
			playerStats();
			enemyStats();
			while (player.getHealthy() > 0 && obstacle.getHealth() > 0) {
				System.out.print("<H>it or <R>un : ");
				String selCase = scan.next();
				selCase = selCase.toUpperCase();
				if (selCase.equals("H")) {
					System.out.println("You hit the Enemy ");
					obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
					afterHit();
					if (obstacle.getHealth() > 0) {
						System.out.println();
						System.out.println("Enemy hit You ");
						player.setHealthy(player.getHealthy() - (obstacle.getDamage() - player.getInv().getArmor()));
						afterHit();
					}

				} else {
					break;
				}
			}

			if (obstacle.getHealth() <= 0 && player.getHealthy() > 0) {
				System.out.println("You killed the enemy");
				player.setMoney(player.getMoney() + obstacle.getAward());
				System.out.println("Current Money : " + player.getMoney());
				obstacle.setHealth(defObsHealth);
			} else {
				return false;
			}
		}
		return true;
	}

	public void playerStats() {
		System.out.println("Player Stats :\n----------------");
		System.out.println("Health : " + player.getHealthy());
		System.out.println("Damage : " + player.getTotalDamage());
		System.out.println("Money : " + player.getMoney());
		if (player.getInv().getDamage() > 0) {
			System.out.println("Weapon : " + player.getInv().getwName());
		}
		if (player.getInv().getArmor() > 0) {
			System.out.println("Armor : " + player.getInv().getaName());
		}
	}

	public void enemyStats() {
		System.out.println("\n" + obstacle.getName() + "Stats :\n----------------");
		System.out.println("Health : " + obstacle.getHealth());
		System.out.println("Damage : " + obstacle.getDamage());
		System.out.println("Award : " + obstacle.getAward());

	}

	public void afterHit() {
		System.out.println("Player Health : " + player.getHealthy());
		System.out.println("Enemy Health : " + obstacle.getHealth());
		System.out.println();
	}
}
