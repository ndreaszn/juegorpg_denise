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

            System.out.println("🗡While walking through the fields, " + currentEnemy + " appeared before you!");
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
                    
                }
            }

//            int petSnack = 5;
//            int frenchFries = 0;
//            int miniBurger = 0;
//
//            boolean actionLoop = true;
//            boolean petAlive = true;
//
//            while (actionLoop && petAlive) {
//                // to check if pet died </333
//                if (petEnergy <= 0 || petHunger <= 0 || petHappiness <= 0) {
//                    System.out.println("---------------------------------------");
//                    System.out.println("💔 OH NO! " + petChosen + " " + petName + " has died...");
//
//                    if (petEnergy <= 0) {
//                        System.out.println(petName + " ran out of energy.");
//                    }
//                    if (petHunger <= 0) {
//                        System.out.println(petName + " died of starvation.");
//                    }
//                    if (petHappiness <= 0) {
//                        System.out.println(petName + " died of sadness.");
//                    }
//
//                    System.out.println("---------------------------------------");
//                    petAlive = false;
//                    actionLoop = false;
//                    break;
//                }
//
//                int petFood = petSnack + frenchFries + miniBurger;
//
//                System.out.println("---------------------------------------");
//                System.out.println(petChosen + " " + petName);
//                System.out.println("| Energy: " + petEnergy + " | " +
//                        "Hunger: " + petHunger + " | " +
//                        "Happiness: " + petHappiness + " | " +
//                        "Money: " + petMoney + " | " +
//                        "Food: " + petFood + " | ");
//                System.out.println("---------------------------------------");
//
//                System.out.println("What do you want to do?");
//                System.out.println("1. Feed");
//                System.out.println("2. Play");
//                System.out.println("3. Sleep");
//                System.out.println("4. Store");
//                System.out.println("5. View state");
//                System.out.println("6. Exit");
//                System.out.println("Choose from 1-6: ");
//
//                int actionChosen = sc.nextInt();
//
//                switch (actionChosen) {
//                    case 1:
//                        boolean feedLoop = true;
//
//                        while (feedLoop) {
//                            System.out.println("---------------------------------------");
//                            if (petFood > 0) {
//                                System.out.println("1. Snack Treats");
//                                System.out.println("2. French fries");
//                                System.out.println("3. Mini Burger");
//                                System.out.println("4. Nothing, go back.");
//                                System.out.println("What would you like to feed " + petName + " " + petChosen + " ?");
//
//                                int foodChosen = sc.nextInt();
//
//                                if (foodChosen == 1) {
//                                    if (petSnack == 0) {
//                                        System.out.println("You don't have any Snack Treats left!");
//                                    } else {
//                                        System.out.println("Successfully fed " + petChosen + " " + petName + "!");
//                                        petHunger += 3;
//                                        petEnergy -= 1;
//                                        petSnack -= 1;
//                                        feedLoop = false;
//                                    }
//                                } else if (foodChosen == 2) {
//                                    if (frenchFries == 0) {
//                                        System.out.println("You don't have any French Fries left!");
//                                    } else {
//                                        System.out.println("Successfully fed " + petChosen + " " + petName + "!");
//                                        petHunger += 2;
//                                        petEnergy -= 1;
//                                        frenchFries -= 1;
//                                        feedLoop = false;
//                                    }
//                                } else if (foodChosen == 3) {
//                                    if (miniBurger == 0) {
//                                        System.out.println("You don't have any Mini Burgers left!");
//                                    } else {
//                                        System.out.println("Successfully fed " + petChosen + " " + petName + "!");
//                                        petHunger += 3;
//                                        petEnergy -= 1;
//                                        miniBurger -= 1;
//                                        feedLoop = false;
//                                    }
//                                } else if (foodChosen == 4) {
//                                    feedLoop = false;
//                                    break;
//                                } else {
//                                    System.out.println("Invalid choice!");
//                                }
//
//                            } else if (petFood == 0) {
//                                System.out.println("You have no food left! Buy some more in the store.");
//                                feedLoop = false;
//                            }
//                        }
//                        break;
//                    case 2:
//                        System.out.println("---------------------------------------");
//                        System.out.println("Choose a game to play!");
//                        System.out.println("1. Dices");
//                        System.out.println("2. Rock, paper, scissors");
//                        System.out.println("3. Neither, go back.");
//                        System.out.println("Enter your option:");
//
//                        int gameChosen = sc.nextInt();
//
//                        if (gameChosen == 1) {
//                            System.out.println("---------------------------------------");
//                            System.out.println("Enter 1 to throw a dice!");
//
//                            int choiceDices = sc.nextInt();
//
//                            if (choiceDices == 1) {
//                                Random random = new Random();
//                                int playerDice = random.nextInt(1, 7);
//                                int petDice = random.nextInt(1, 7);
//
//                                System.out.println("Your dice landed on: " + playerDice);
//                                System.out.println(petChosen + " " + petName + "'s landed on: " + petDice);
//
//                                if (playerDice > petDice) {
//                                    System.out.println("You win!");
//                                    petHappiness += 2;
//                                    petMoney += 3;
//                                    petEnergy -= 2;
//                                } else if (playerDice == petDice) {
//                                    System.out.println("It's a tie!");
//                                } else {
//                                    System.out.println(petChosen + " " + petName + " wins!");
//                                    petHappiness -= 1;
//                                }
//
//                            } else {
//                                System.out.println("Invalid choice!");
//                            }
//
//                        } else if (gameChosen == 2) {
//                            Random random = new Random();
//                            int num = random.nextInt(3);
//                            String pet;
//
//                            if (num == 0) {
//                                pet = "Rock";
//                            } else if (num == 1) {
//                                pet = "Paper";
//                            } else {
//                                pet = "Scissors";
//                            }
//
//                            System.out.println("---------------------------------------");
//                            System.out.println("Choose between Rock, Paper or Scissors: ");
//                            sc.nextLine();
//                            String playerOption = sc.nextLine();
//
//                            String result;
//
//                            if (pet.equalsIgnoreCase(playerOption)) {
//                                result = "Tie!";
//                            } else if (playerOption.equalsIgnoreCase("Rock") && pet.equalsIgnoreCase("Scissors")) {
//                                result = "You win!";
//                                petHappiness += 2;
//                                petMoney += 3;
//                                petEnergy -= 2;
//                            } else if (playerOption.equalsIgnoreCase("Scissors") && pet.equalsIgnoreCase("Paper")) {
//                                result = "You win!";
//                                petHappiness += 2;
//                                petMoney += 3;
//                                petEnergy -= 2;
//                            } else if (playerOption.equalsIgnoreCase("Paper") && pet.equalsIgnoreCase("Rock")) {
//                                result = "You win!";
//                                petHappiness += 2;
//                                petMoney += 3;
//                                petEnergy -= 2;
//                            } else {
//                                System.out.println("You did not enter a valid input.");
//                                result = petChosen + " " + petName + " wins!";
//                                petHappiness -= 1;
//                            }
//
//                            System.out.println("You: " + playerOption + " | " + petChosen + ": " + pet + " → " + result);
//                        } else if (gameChosen == 3) {
//                            break;
//                        } else {
//                            System.out.println("Invalid choice!");
//                        }
//                        break;
//                    case 3:
//                        System.out.println(petChosen + " " + petName + " is resting soundly...");
//                        petEnergy += 4;
//                        petHappiness -= 1;
//                        break;
//                    case 4:
//                        boolean loopStore = true;
//
//                        while (loopStore) {
//                            System.out.println("---------------------------------------");
//                            System.out.println("Welcome to BurgerPaw! \uD83D\uDC3E");
//                            System.out.println("---------------------------------------");
//                            System.out.println("You currently have: " + petMoney + " coins, would you like to buy anything?");
//                            System.out.println("1. Yes!");
//                            System.out.println("2. No, go back.");
//
//                            int choiceStore = sc.nextInt();
//
//                            if (choiceStore == 1) {
//                                System.out.println("---------------------------------------");
//                                System.out.println("1. Snack Treats ................ 1 \uD83E\uDE99");
//                                System.out.println("2. French Fries ................ 2 \uD83E\uDE99");
//                                System.out.println("3. Mini Burger ................ 3 \uD83E\uDE99");
//
//                                System.out.println("Which one would you like to order?");
//
//                                int foodChosen = sc.nextInt();
//
//                                if (foodChosen == 1) {
//                                    if (petMoney >= 1) {
//                                        System.out.println("Successfully bought 1 Snack Treat!");
//                                        petSnack += 1;
//                                        petMoney -= 1;
//                                    } else {
//                                        System.out.println("You don't have enough money!");
//                                    }
//                                } else if (foodChosen == 2) {
//                                    if (petMoney >= 2) {
//                                        System.out.println("Successfully bought 1 bag of French Fries!");
//                                        frenchFries += 1;
//                                        petMoney -= 2;
//                                    } else {
//                                        System.out.println("You don't have enough money!");
//                                    }
//                                } else if (foodChosen == 3) {
//                                    if (petMoney >= 3) {
//                                        System.out.println("Successfully bought 1 Mini Burger!");
//                                        miniBurger += 1;
//                                        petMoney -= 3;
//                                    } else {
//                                        System.out.println("You don't have enough money!");
//                                    }
//                                } else {
//                                    System.out.println("Invalid choice!");
//                                }
//                            } else if (choiceStore == 2) {
//                                loopStore = false;
//                            } else {
//                                System.out.println("Invalid choice!");
//                            }
//                        }
//                        break;
//                    case 5:
//                        System.out.println("---------------------------------------");
//                        if (petHappiness > 7 && petHunger > 4 && petEnergy > 5) {
//                            System.out.println(petChosen + " " + petName + " is happy and active!");
//                        } else if (petHunger <= 3) {
//                            System.out.println(petChosen + " " + petName + " is hungry! Feed " + petName + "!");
//                        } else if (petEnergy <= 3) {
//                            System.out.println(petChosen + " " + petName + " is sleepy! Put " + petName + " to bed!");
//                        } else if (petHappiness <= 3) {
//                            System.out.println(petChosen + " " + petName + " is sad :( Play with " + petName + "!");
//                        } else if (petEnergy > 7 && petHunger < 5) {
//                            System.out.println(petChosen + " " + petName + " is hyperactive!");
//                        } else if (petHappiness <= 3 && petHunger <= 3 && petEnergy <= 3) {
//                            System.out.println(petChosen + " " + petName + " is in his last hours...");
//                        } else {
//                            System.out.println(petChosen + " " + petName + " is doing okay.");
//                        }
//                        break;
//                    case 6:
//                        System.out.println("Exiting program...");
//                        actionLoop = false;
//                        playAgain = false;
//                        break;
//                    default:
//                        System.out.println("Invalid choice! Please choose a number from 1-6.");
//                        break;
//                }
//            }

            // crear otro tamagotchi if dead :')
            if (!petAlive) {
                System.out.println("Would you like to create a new Tamagotchi?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                System.out.print("Enter your choice: ");

                int newPetChoice = sc.nextInt();

                if (newPetChoice == 1) {
                    System.out.println("\n\n");
                    playAgain = true;
                } else {
                    System.out.println("Thanks for playing! Goodbye!");
                    playAgain = false;
                }
            }
        }

    }
}
