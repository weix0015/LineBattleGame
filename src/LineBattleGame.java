import java.util.Random;
import java.util.Scanner;

public class LineBattleGame {

    public static void main(String[] args) {
        Dice dice = new Dice();
        //dice.start();
        Scanner sc = new Scanner(System.in);
        int option = 0;

        // Player
        int spilleren = 10;
        int playerSkud = 2500;
        int playerBomb = 1;
        int playerBombLocation = 10;
        int playerTropper = 25;


        // Computer
        int enemy = -10;
        int computerSkud = 2500;
        int computerBomb = 1;
        int computerBombLocation = -10;
        int enemyTropper = 25;

        boolean run = true;
        while (run) {
            dice.start();
            option = sc.nextInt();
            int[] computerOption = {7, 8, 9};   // 7 = move forward 8 = move back 9 = attack
            int computerMove = 0;
            if (spilleren - enemy >= 6) {
                computerMove = 7;
            } else if (spilleren - enemy <= 6) {
                computerMove = 9;
            } else if (computerSkud == 0) {
                computerMove = 8;
            }

            else {
                computerMove = computerOption[new Random().nextInt(computerOption.length)];
            }


            // Player
            // Move Forward
            switch (option) {
                case 1:
                    int resultat = dice.rolldice();
                    if (resultat == 1 || resultat == 3 || resultat == 5) {
                        dice.forward();
                        spilleren -= 1;
                        System.out.println("Du har slået " + resultat);
                    } else {
                        spilleren -= 2;
                        System.out.println("Du har slået " + resultat);
                    }
                    if (spilleren < -10)
                        spilleren = -10;
                    System.out.println("Du er på felt " + spilleren);
                    break;

                // Player
                // Move Backward
                case 2:
                    int resultat1 = dice.rolldice();
                    playerSkud += 250;
                    if (resultat1 == 1 || resultat1 == 2) {
                        spilleren += 1;
                        System.out.println("Du slår " + resultat1);
                    } else if (resultat1 == 3 || resultat1 == 4) {
                        spilleren += 2;
                        System.out.println("Du slår " + resultat1);
                    } else if (resultat1 == 5 || resultat1 == 6) {
                        spilleren += 3;
                        System.out.println("Du slår " + resultat1);
                    }
                    if (spilleren > 10)
                        spilleren = 10;
                    System.out.println("Du er på felt " + spilleren);
                    break;

                // Player
                // Attack
                case 3:
                    int ildkræftTerning = dice.rolldice() * 100;
                    playerSkud -= dice.rolldice2() * 100;
                    if (playerSkud <= 0) {
                        System.out.println("Du har ikke nok skud");
                        playerSkud = 0;
                    }
                    System.out.println("Enemy har " + enemyTropper);
                    int distance = Math.abs(spilleren - enemy);

                    if (distance == 0) {
                        enemyTropper -= 6;
                        System.out.println("Enemy har mistet 6 tropper og har " + enemyTropper + " tilbage.");

                    } else if (distance == 1) {
                        enemyTropper -= 5;
                        System.out.println("Enemy har mistet 5 tropper og har " + enemyTropper + " tilbage.");

                    } else if (distance == 2) {
                        enemyTropper -= 4;
                        System.out.println("Enemy har mistet 4 tropper og har " + enemyTropper + " tilbage.");

                    } else if (distance == 3) {
                        enemyTropper -= 3;
                        System.out.println("Enemy har mistet 3 tropper og har " + enemyTropper + " tilbage.");

                    } else if (distance == 4) {
                        enemyTropper -= 2;
                        System.out.println("Enemy har mistet 2 tropper og har " + enemyTropper + " tilbage.");

                    } else if (distance == 5) {
                        enemyTropper -= 1;
                        System.out.println("Enemy har mistet 1 tropper og har " + enemyTropper + " tilbage.");

                    } else {
                        System.out.println("Du er for lang væk fra enemy, så du kan ikke ramme.");
                    }
                    if (enemyTropper <= 0) {
                        System.out.println("Du har vundet spillet");
                        return;
                    }

                    System.out.println("Din antal skud tilbage: " + playerSkud);
                    break;

                // Player
                // Surrender
                case 4:
                    System.out.println("Du surrender og taber spillet");
                    return;

                // Player
                // Bomb
                case 5:
                    if (spilleren < 0 && playerBomb == 1) {
                        playerBomb = 0;
                        playerBombLocation = spilleren;
                        System.out.println("Du har plantet en bombe på " + playerBombLocation);
                        System.out.println("Du har " + playerBomb + " bombe tilbage");
                    } else {
                        System.out.println("Du kan ikke plante bombe her");
                    }
                    break;

                // Player
                // Bomb activate
                case 6:
                    if (playerBombLocation < 0 && playerBomb <= -10) {
                        int bombDistance = enemy - playerBombLocation;

                        System.out.println("Bombe afstand er " + bombDistance);
                        if (bombDistance >= -6 && playerBombLocation == -10) {
                            System.out.println("Enemy har vundet spillet");
                            return;
                        } else if (bombDistance >= -6) {
                            enemyTropper -= 6;
                        } else if (bombDistance <= -6) {
                            playerTropper -= 6;
                            System.out.println("Du har mistet 6 tropper");
                        }
                    }
                    break;
                case 7:
                    boolean enemyInfront = spilleren > enemy;
                    if (enemyInfront) {
                        distance = spilleren - enemy;
                        if (distance <= 3) {
                            System.out.println("Spejder kan se fjenden er " + distance + "felter væk");
                        }
                    } else {
                        distance = enemy - spilleren;
                        if (distance <= 3) {
                        }
                    }
            }
            System.out.println();

            // Computer
            // Move Forward
            System.out.println("Enemy har trækket " + computerMove);
            if (computerMove == 7) {
                int resultat3 = dice.rolldice3();
                if (resultat3 == 1 || resultat3 == 3 || resultat3 == 5) {
                    enemy += 1;
                    System.out.println("Enemy har slået " + resultat3);
                } else {
                    enemy += 2;
                    System.out.println("Enemy har slået " + resultat3);
                }
                if (enemy >= 10) {
                    enemy = 10;
                }
            }

            // Computer
            // Move Backward
            if (computerMove == 8) {
                int resultat4 = dice.rolldice4();
                System.out.println("Enemy back " + resultat4);
                if (resultat4 == 1 || resultat4 == 2) {
                    enemy = -1;
                } else if (resultat4 == 3 || resultat4 == 4) {
                    enemy = -2;
                } else if (resultat4 == 5 || resultat4 == 6) {
                    enemy = -3;
                }
            }
            System.out.println("Modstanders position; " + enemy);

            // Computer
            // Attack
            if (computerMove == 9) {
                computerSkud -= dice.rolldice5() * 100;
                if (computerSkud <= 0) {
                    System.out.println("Du har ikke nok skud");
                    computerSkud = 0;
                }
                System.out.println("Enemy har " + playerTropper + " soldater tilbage");
                int distance = Math.abs(spilleren - enemy);
                if (distance == 0) {
                    playerTropper -= 6;
                    System.out.println("Player har mistet 6 tropper og har " + playerTropper + " tilbage.");

                } else if (distance == 1) {
                    playerTropper -= 5;
                    if (playerTropper <= 0) {
                        playerTropper = 0;
                    }
                    System.out.println("Player har mistet 5 tropper og har " + playerTropper + " tilbage.");

                } else if (distance == 2) {
                    playerTropper -= 4;
                    if (playerTropper <= 0) {
                        playerTropper = 0;
                    }
                    System.out.println("Player har mistet 4 tropper og har " + playerTropper + " tilbage.");

                } else if (distance == 3) {
                    playerTropper -= 3;
                    if (playerTropper <= 0) {
                        playerTropper = 0;
                    }
                    System.out.println("Player har mistet 3 tropper og har " + playerTropper + " tilbage.");

                } else if (distance == 4) {
                    playerTropper -= 2;
                    if (playerTropper <= 0) {
                        playerTropper = 0;
                    }
                    System.out.println("Player har mistet 2 tropper og har " + playerTropper + " tilbage.");

                } else if (distance == 5) {
                    playerTropper -= 1;
                    if (playerTropper <= 0) {
                        playerTropper = 0;
                    }
                    System.out.println("Player har mistet 1 tropper og har " + playerTropper + " tilbage.");

                } else {
                    System.out.println("Du er for lang væk fra player, så du kan ikke ramme.");
                }
            }
            System.out.println("Enemy antal skud tilbage: " + computerSkud);

            // Computer
            // Bomb
            if (computerMove == 10) {
                if (enemy < 0 && computerBomb == 1) {
                    computerBomb = 0;
                    computerBombLocation = spilleren;
                    System.out.println("Enemy har plantet en bombe på " + computerBombLocation);
                    System.out.println("Enemy har " + computerBomb + " bombe tilbage");
                } else {
                    System.out.println("Enemy kan ikke plante bombe her");
                }
                break;
            }

            // Computer
            // Bomb Activate

            if (computerBombLocation > 0 && computerBomb <= 10) {
                int bombDistance = enemy - computerBombLocation;

                System.out.println("Bombe afstand er " + bombDistance);
                if (bombDistance >= 6 && computerBombLocation == 10) {
                    System.out.println("Enemy har vundet spillet");
                    return;
                } else if (bombDistance >= 6) {
                    playerTropper -= 6;
                } else if (bombDistance <=  6) {
                    enemyTropper -= 6;
                    System.out.println("Enemy har mistet 6 tropper");
                }
            }
            System.out.println("\n");
        }
    }
}


