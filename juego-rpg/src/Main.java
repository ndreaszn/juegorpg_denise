import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] enemy = {"Radahn", "Malekith", "Morgott", "Godfrey", "Malenia"};
        String[] potions = {"Health potion", "Magic potion", "Damage potion", "Extreme damage potion"};
        String[] inventory = new String[10];
        String[] interact = {"normal", "normal", "normal", "dodge", "critical"};

        int inventoryCount = 0;
        boolean playAgain = true;

        while (playAgain) {

            // resets inv
            for (int i = 0; i < inventory.length; i++) {
                inventory[i] = null;
            }
            inventoryCount = 0;

            String classChosen = "";

            while (classChosen.isEmpty()) {
                System.out.println("Welcome! Choose your Class:");
                System.out.println("1. Mage");
                System.out.println("2. Warrior");
                System.out.println("3. Samurai");
                System.out.println("4. Hero");
                System.out.println("Enter your choice (1-4): ");
                int classChoice = sc.nextInt();

                switch (classChoice) {
                    case 1:
                        System.out.println("You have chosen: Mage! \uD83E\uDDD9\u200D\u2642\uFE0F");
                        classChosen = "\uD83E\uDDD9\u200D\u2642\uFE0F";
                        break;
                    case 2:
                        System.out.println("You have chosen: Warrior! \u265E");
                        classChosen = "\u265E";
                        break;
                    case 3:
                        System.out.println("You have chosen: Samurai! \u2694\uFE0F");
                        classChosen = "\u2694\uFE0F";
                        break;
                    case 4:
                        System.out.println("You have chosen: Hero! \uD83D\uDEE1\uFE0F");
                        classChosen = "\uD83D\uDEE1\uFE0F";
                        break;
                    default:
                        System.out.println("Invalid choice! Please choose a number from 1-3.");
                        System.out.println();
                        break;
                }
            }

            System.out.println("---------------------------------------");
            System.out.println("Choose a name!");
            System.out.println(classChosen + ": ");

            sc.nextLine();
            String playerName = sc.nextLine();

            boolean confirmStart = false;
            int playerHealth = 100;
            int maxHealth = 100;
            int playerMana = 50;
            int maxMana= 100;
            float damageMult = 1.0f;
            int physDamage = 15;
            int spellDamage = 35;
            int playerRunes = 0;

            while (!confirmStart) {
                System.out.println("\n---------------------------------------");
                System.out.println("Your character: " + classChosen + " " + playerName);
                System.out.println("Initial stats:");
                System.out.println("Health: " + playerHealth + "/" + maxHealth);
                System.out.println("Mana: " + playerMana + "/" + maxMana);
                System.out.println("Damage Multiplier: " + damageMult);
                System.out.println("Physical Damage: " + physDamage);
                System.out.println("Spell Damage: " + spellDamage);
                System.out.println("Runes: " + playerRunes);
                System.out.println("---------------------------------------");
                System.out.println("What would you like to do?");
                System.out.println("1. Start adventure!");
                System.out.println("2. Change class");
                System.out.println("3. Change name");
                System.out.print("Enter your choice: ");

                int preGameChoice = sc.nextInt();

                switch (preGameChoice) {
                    case 1:
                        System.out.println("\nStarting game as " + classChosen + " " + playerName + "!");
                        confirmStart = true;
                        break;
                    case 2:
                        classChosen = "";
                        while (classChosen.isEmpty()) {
                            System.out.println("Choose your Class:");
                            System.out.println("1. Mage");
                            System.out.println("2. Warrior");
                            System.out.println("3. Samurai");
                            System.out.println("4. Hero");
                            System.out.println("Enter your choice (1-4): ");
                            int classChoice = sc.nextInt();

                            switch (classChoice) {
                                case 1:
                                    System.out.println("You have chosen: Mage! \uD83E\uDDD9\u200D\u2642\uFE0F");
                                    classChosen = "\uD83E\uDDD9\u200D\u2642\uFE0F";
                                    break;
                                case 2:
                                    System.out.println("You have chosen: Warrior! \u265E");
                                    classChosen = "\u265E";
                                    break;
                                case 3:
                                    System.out.println("You have chosen: Samurai! \u2694\uFE0F");
                                    classChosen = "\u2694\uFE0F";
                                    break;
                                case 4:
                                    System.out.println("You have chosen: Hero! \uD83D\uDEE1\uFE0F");
                                    classChosen = "\uD83D\uDEE1\uFE0F";
                                    break;
                                default:
                                    System.out.println("Invalid choice! Please choose a number from 1-3.");
                                    System.out.println();
                                    break;
                            }
                        }
                        break;
                    case 3:
                        System.out.println("\nEnter a new name:");
                        sc.nextLine();
                        playerName = sc.nextLine();
                        System.out.println("Name changed to: " + playerName);
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            }

            System.out.println("\nHello, " + playerName + " ! " + classChosen + " Let's start exploring!");
            System.out.println(" ");

            System.out.println("----------------------------------------------");

            int combatNum = 0;
            boolean playerAlive = true;

            while (playerAlive) {
                combatNum++;
                String currentEnemy = enemy[random.nextInt(enemy.length)];
                int enemyHealth = random.nextInt(61) + 40 + (combatNum - 1) * 5;

            System.out.println("\nWhile walking through the fields, " + currentEnemy + " appeared before you!");
            System.out.println();

            boolean combatActive = true;
            boolean playerWon = false;

            while (combatActive) {
                // Display combat status
                System.out.println("---------------------------------------");
                System.out.println("Enemy: " + currentEnemy + " | HP: " + enemyHealth);
                System.out.println("---------------------------------------");
                System.out.println(playerName + " " + classChosen);
                System.out.println("HP: " + playerHealth + "/" + maxHealth + " | Mana: " + playerMana + "/" + maxMana);
                System.out.println("Runes: " + playerRunes + " | Damage Multiplier: " + damageMult);
                System.out.println("---------------------------------------");
                System.out.println("\nChoose your action:");
                System.out.println("1. Physical Attack");
                System.out.println("2. Magic Attack (25 Mana)");
                System.out.println("3. Use Item");
                System.out.println("4. Surrender");
                System.out.print("Enter your choice (1-4): ");

                int action = sc.nextInt();
                System.out.println();

                if (action == 1) {
                    // physical attack
                    String attack = interact[random.nextInt(interact.length)];
                    int dmg = 0;

                    switch (attack) {
                        case "normal":
                            dmg = (int) (physDamage * damageMult);
                            System.out.println("You performed a normal attack!");
                            break;
                        case "dodge":
                            System.out.println(currentEnemy + " dodged your attack!");
                            break;
                        case "critical":
                            dmg = (int) (physDamage * damageMult * 1.5);
                            System.out.println("Critical hit!!");
                            break;
                    }

                    enemyHealth -= dmg;
                    if (dmg > 0) {
                        System.out.println("You did " + dmg + " damage to " + currentEnemy + "!");
                    }
                } else if (action == 2) {
                    // magiccc
                    if (playerMana < 25) {
                        System.out.println("Not enough mana! 25 mana minimum required.");
                        continue; // i didnt even know this existed
                    }

                    playerMana -= 25;
                    int dmg = (int) (spellDamage * damageMult);
                    enemyHealth -= dmg;
                    System.out.println("You cast a magic spell!");
                    System.out.println(dmg + " damage dealt!");
                } else if (action == 3) {
                    if (inventoryCount == 0) {
                        System.out.println("Invetory empty!");
                        continue;
                    }

                    System.out.println("Your inventory:");
                    for (int i = 0; i < inventoryCount; i++) {
                        System.out.println((i + 1) + ". " + inventory[i]);
                    }
                    System.out.println("Which item? (type 0 for none)");
                    int itemChoice = sc.nextInt();

                    if (itemChoice == 0 ||itemChoice > inventoryCount) {
                        System.out.println("Action cancelled.");
                        continue;
                    }

                    String item = inventory[itemChoice - 1];

                    switch (item) {
                        case "Health potion":
                            playerHealth += 25;
                            if (playerHealth > maxHealth) playerHealth = maxHealth;
                            System.out.println("Health potion absorbed. +25 HP!");
                            break;
                        case "Magic potion":
                            playerMana += 25;
                            if (playerMana > maxMana) playerMana = maxMana;
                            System.out.println("Magic potion absorbed. +25 Mana!");
                            break;
                        case "Damage potion":
                            physDamage += 5;
                            System.out.println("Damage potion absorbed. +5 Damage!");
                            break;
                        case "Extreme Damage potion":
                            damageMult += 0.05f;
                            System.out.println("Extreme damage potion absorbed. +0.05 Damage Multiplier!");
                            break;
                    }

                    for (int i = itemChoice - 1; i < inventoryCount - 1; i++) {
                        inventory[i] = inventory[i + 1];
                    }
                    inventory[inventoryCount - 1] = null;
                    inventoryCount--;
                } else if (action == 4) {
                    System.out.println("You surrendered!");
                    playerRunes -= 5;
                    if (playerRunes < 0) {
                        playerRunes = 0;
                    }
                    combatActive = false;
                    continue;
                } else {
                    System.out.println("Invalid action.");
                    continue;
                }

                if (enemyHealth <= 0) {
                    System.out.println("---------------------------------------");
                    System.out.println("          GREAT ENEMY FELLED");
                    System.out.println("---------------------------------------");

                    String loot = potions[random.nextInt(potions.length)];
                    int runesReward = random.nextInt(5) + 1;
                    playerRunes += runesReward;

                    if (inventoryCount < 10) {
                        inventory[inventoryCount] = loot;
                        inventoryCount++;
                        System.out.println(currentEnemy + " dropped " + loot + "!");
                    } else {
                        System.out.println("Inventory too full to pick up loot.");
                    }

                    System.out.println("You received " + runesReward + " runes!");

                    int healing = random.nextInt(maxHealth - 50 - 25 + 1) + 25;
                    playerHealth += healing;
                    if (playerHealth > maxHealth) {
                        playerHealth = maxHealth;
                    }
                    System.out.println("You recovered " + healing + " HP.");

                    combatActive = false;
                    playerWon = true;
                    continue;
                }

                System.out.println(currentEnemy + "'s turn!");
                String enemyAttack = interact[random.nextInt(interact.length)];
                int enemyBaseDmg = random.nextInt(11) + 10;
                int enemyDmg = 0;

                switch (enemyAttack) {
                    case "normal":
                        enemyDmg = enemyBaseDmg;
                        System.out.println(currentEnemy + " attacks!");
                        break;
                    case "dodge":
                        System.out.println(currentEnemy + " missed the attack!");
                        break;
                    case "critical":
                        enemyDmg = enemyBaseDmg * 2;
                        System.out.println(currentEnemy + " landed a crit!!");
                        break;
                }

                playerHealth -= enemyDmg;
                if (enemyDmg > 0) {
                    System.out.println("You took " + enemyDmg + " damage.");
                }

                playerMana += 10;
                if (playerMana > maxMana) {
                    playerMana = maxMana;
                }
                System.out.println("You recovered 10 mana.");

                if (playerHealth <= 0) {
                    System.out.println("You have been defeated by " + currentEnemy + ".");
                    playerAlive = false;
                    combatActive = false;
                }

                System.out.println();

                }

            if (playerWon && playerAlive) {
                System.out.println("Celebrate win at the tavern? (YES/NO)");
                sc.nextLine();
                String enterTavern = sc.nextLine().toUpperCase();

                if (enterTavern.equals("YES")) {
                    System.out.println("Welcome to the Tavern!");
                    System.out.println("---------------------------------------");

                    String[] tavernItems = new String[3];
                    int[] tavernPrices = new int[3];

                    for (int i = 0; i < 3; i++) {
                        tavernItems[i] = potions[random.nextInt(potions.length)];
                        tavernPrices[i] = random.nextInt(5)+ 2;
                        System.out.println((i + 1) + ". " + tavernItems[i] + " - " + tavernPrices[i] + " runes");
                    }
                    System.out.println("4. Leave tavern");
                    System.out.println("---------------------------------------");
                    System.out.println("Runes: " + playerRunes);
                    System.out.println("What would you like to buy? (1-4): ");

                    int buyChoice = sc.nextInt();

                    if (buyChoice >= 1 && buyChoice <= 3) {
                        if (playerRunes >= tavernPrices[buyChoice -1]) {
                            if (inventoryCount < 10) {
                                playerRunes -= tavernPrices[buyChoice -1];
                                inventoryCount++;
                                System.out.println("You bought " + tavernItems[buyChoice -1] + "!");
                            } else {
                                System.out.println("Inventory full.");
                            }
                        } else {
                            System.out.println("Not enough runes.");
                        }
                    } else {
                        System.out.println("You left the tavern.");
                    }
                }

                System.out.println("The adventure continues!");
            }
            }

            System.out.println("---------------------------------------");
            System.out.println("              GAME OVER");
            System.out.println("---------------------------------------");
            System.out.println("Bosses defeated: " + (combatNum -1));
            System.out.println("Final runes: " + playerRunes);
            System.out.println();

            System.out.println("Do you want to play again? (YES/NO): ");
            sc.nextLine();
            String playAgainChoice = sc.nextLine().toUpperCase();

            if (playAgainChoice.equals("NO")) {
                playAgain = false;
                System.out.println("May the Golden Order shine through you, Tarnished.");
            } else {
                System.out.println("Starting anew...");
            }
        }
    }
}
