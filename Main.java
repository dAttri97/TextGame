package part1;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random rad = new Random();
		

		//Enemy Characteristics
		String enemies[] = {"Dragon","Assassin","Snake","Knight","Zombie","Vampire","Skeleton","Giant",
				"Spider","Ape","Monster","Nazi","SandMan","DoctorDoom","Hulk","Kratos","HellBoy","Valkyr"};
		int maxEnemyHealth = 500;
		int maxEnemyAttack = 25;
		
		//Player Characteristic
		int health = 100;
		int attack = 50;
		int numHealthPotions = 3;
		int HealthPotionHeal = 25;
		
		boolean running = true;
		
		System.out.println("WELCOME TO THE DUNGEON");
		
		GAME:
			while(running) {
				System.out.println("----------------------------------------------");
				int enemyHealth = rad.nextInt(maxEnemyHealth);
				String enemy = enemies[rad.nextInt(enemies.length)];
				System.out.println("\t"+enemy+" has appeared with max health "+enemyHealth);
				while(enemyHealth>0) {
					System.out.println("\tYour Health: "+health+" and Potion(s) left "+numHealthPotions);
					System.out.println("\tWhat would you like to do?");
					System.out.println("\t1. Attack");
					System.out.println("\t2. Drink Health Potion");
					System.out.println("\t3. Run");
					String str = s.nextLine();
					if(str.equals("1")) {
						int att = rad.nextInt(attack);
						int eneAtt = rad.nextInt(maxEnemyAttack);
						health-=eneAtt;
						enemyHealth-=att;
						System.out.println("\t You have attacked the enemy!!!");
						System.out.println("\t The enemy has attacked back!");
						System.out.println("\t Your remaining Health:"+health);
						System.out.println("\t Enemy remaining Health:"+enemyHealth);
						if(health<1) {
							System.out.println("The "+enemy+" has Defeated You.\n\t You are DEAD");
							break;
						}
					}
					else if (str.equals("2")) {
						if(numHealthPotions>0) {
							numHealthPotions--;
							health+=HealthPotionHeal;
							System.out.println("\t You have drunk the Health Potion now your health is "+health+
									" the remaining Health Potions you have:"+numHealthPotions);
						}
						else {
							System.out.println("\t You have no Health Potions left, you need to carry on to find more");
						}
					}
					else if (str.equals("3")) {
						System.out.println("You ran away from the "+enemy+"!");
						continue GAME;
					}
					else {
						System.out.println("\t Invalid Command Try again");
					}
				}
				if(health>1) {
					System.out.println("\t The "+enemy+" is Defeated\n\t You have "+health+" health left");
					System.out.println("\t Would you like to carry ON???");
					System.out.println("\t 1.Yes, I have still have some fight left");
					System.out.println("\t 2. No, I am too tired to go on");
					String str = s.nextLine();
					while(!str.equals("1")&&!!str.equals("2")) {
						System.out.println("Invalid Command\nEnter Again");
						str=s.nextLine();
					}
					if(str.equals("1"))
						System.out.println("Your next ENEMY is......");
					if(str.equals("2")) {
						System.out.println("Bye Bye");
						break;
					}
				}
				else {
					System.out.println("You are dead,Better luck next time");
					break;
				}
				
			}
		
	}

}
