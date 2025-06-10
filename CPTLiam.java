import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class CPTLiam {
	static boolean blnIsRunning = true;
	static int intForLooper;
		
	static int intGenNumber = 0;
	static int intGenSuit = 0;
	
	static int int1HighNum = 0;
	static int int2HighNum = 0;
	static int int3HighNum = 0;
	static int int4HighNum = 0;
	static int int5HighNum = 0;
		
	static int intCardNumber = 0;
	static int intSuitNumber = 0;
	static int intNum = 1;
	static int intNum2 = 1;
	static int intHighNumber = 0; 
		
	// 1st card stats
	static int intCard1Number = 0;
	static int intCard1Suit = 1;
	static boolean blnCard1Lock = false;
	// 2nd card stats
	static int intCard2Number = 0;
	static int intCard2Suit = 1;
	static boolean blnCard2Lock = false;
	// 3rd card stats
	static int intCard3Number = 0;
	static int intCard3Suit = 1;
	static boolean blnCard3Lock = false;
	// 4th card stats
	static int intCard4Number = 0;
	static int intCard4Suit = 1;
	static boolean blnCard4Lock = false;
	// 5th card stats
	static int intCard5Number = 0;
	static int intCard5Suit = 1;
	static boolean blnCard5Lock = false;
	
	static String strCardNumber = "";
		
	static int intMoney = 1000;
	
	static int intKeyPressed;
	
	static boolean blnEnterKeyCooldown = false;
	
	static boolean blnStraightSort = false;
	
	static boolean blnIsStraight = false; 
	static boolean blnIsJacksorBetter = false; 
	static int intJackCheck = 0;
	
	// Tracks the stage of the game 
	static int intGameStage = 0;
	
	// Allows for attributes to be applied only once when 
	// the game stage changes and not constantly 
	static boolean blnStageChange = false; 
	
	public static void main (String[] args) {
		Console con = new Console(1920, 1080);
		System.out.println("Current working directory: " + System.getProperty("user.dir"));
		con.setBackgroundColor(new Color(3, 80, 210));
		
		// Load images ------------------------------------------------
		
		BufferedImage imgClub = con.loadImage("clubIcon.png");
		BufferedImage imgDiamond = con.loadImage("diamondIcon.png");
		BufferedImage imgHeart = con.loadImage("heartIcon.png");
		BufferedImage imgSpade = con.loadImage("spadeIcon.png");
		
		// ------------------------------------------------------------
		
		
		cardUpdater(con);
		// Core game loop
		while (blnIsRunning == true) {
			cardUpdater(con);
			if (blnStageChange == true) { // Refresh the scene 
				con.println("changing!");
				con.setBackgroundColor(new Color(3, 80, 210));
				blnStageChange = false;
			}
			if (intGameStage == 0) { // If cards not shuffled
				con.drawString("Press Enter to Shuffle Cards", 500, 800);
				con.drawString("Press the Number Keys to Lock-In Cards: (1, 2, 3, 4, 5)", 500, 900);
			} if (intGameStage == 1) { // If cards not submitted
				con.drawString("Press Enter to Submit Cards", 500, 800);
			}
			intKeyPressed = con.currentKey();
			con.println(intKeyPressed);
			if (intKeyPressed == 10) {
				// If enter key pressed
				if (blnEnterKeyCooldown == false) {
					intGameStage = intGameStage + 1;
					con.println("Stage: "+intGameStage);
					blnStageChange = true;
					if (intGameStage == 0) { // If no reshuffles have occured yet, enable the shuffle process
						con.println("working 47!");
						if (blnCard1Lock == false) {
							intCard1Number = 0; 
						} if (blnCard2Lock == false) {
							intCard2Number = 0;
						} if (blnCard3Lock == false) {
							intCard3Number = 0;
						} if (blnCard4Lock == false) {
							intCard4Number = 0;
						} if (blnCard5Lock == false) {
							intCard5Number = 0;
						}
					}
				}
				// This helps the enter key only get triggered once when the user holds it down
				blnEnterKeyCooldown = true;
			}
			if (intKeyPressed != 10) {
			// This gives back enter key functionalitiy to the user, after they have let go out it
				blnEnterKeyCooldown = false; 
			}
			if (intGameStage == 2 && blnStraightSort == false) {
				con.println("Not done!");
				// Final stage of the game, will now check what card 
				// combinations the player has and will reward them accordingly
				
				/*

				Card Combinations
				
				Royal Flush
				* status: No

				Straight Flush
				* status: No

				Four of a Kind
				* status: No

				Full House
				* status: No

				Flush
				* status: No

				Straight
				* status: Work in Progress

				Three of a Kind
				* status: No

				Two Pair
				* status: No

				Jacks or Better
				* status: Work in Progress
			
				*/

				
				if (intCard1Number == 1) {
					intCard1Number = 14; 
				} if (intCard2Number == 1) {
					intCard2Number = 14; 
				} if (intCard3Number == 1) {
					intCard3Number = 14;
				} if (intCard4Number == 1) {
					intCard4Number = 14;
				} if (intCard5Number == 1) {
					intCard5Number = 14; 
				}
				
				/* Jacks or Better
				if (intCard1Number > 10) {
					intJackCheck = intJackCheck + 1;
				} if (intCard2Number > 10) {
					intJackCheck = intJackCheck + 1;
				} if (intCard3Number > 10) {
					intJackCheck = intJackCheck + 1;
				} if (intCard4Number > 10) {
					intJackCheck = intJackCheck + 1;
				} if (intCard5Number > 10) {
					intJackCheck = intJackCheck + 1;
				}
				if (intJackCheck >= 2) {
					con.println("JACK!");
					blnIsJacksorBetter = true; 
				}
				*/
				
				
				// Straight
				if (blnStraightSort == false) {
					if (intNum == 1) {
						intCardNumber = intCard1Number;
					} else if (intNum == 2) {
						intCardNumber = intCard2Number;
					} else if (intNum == 3) {
						intCardNumber = intCard3Number;
					} else if (intNum == 4) {
						intCardNumber = intCard4Number;
					} else if (intNum == 5) {
						intCardNumber = intCard5Number;
						intNum = 0; 
						intNum2 = intNum2 + 1;
					}
					if (intCardNumber > intHighNumber) {
						if (intNum2 == 1) {
							int1HighNum = intNum2;
						} else if (intNum2 == 2) {
							int2HighNum = intNum2;
						} else if (intNum2 == 3) {
							int3HighNum = intNum2;
						} else if (intNum == 4) {
							int4HighNum = intNum2;
						} else if (intNum == 5) {
							int5HighNum = intNum2;
						}
					}
    
					// Sorting (greatest to least)
					if (int1HighNum > int2HighNum && int2HighNum > int3HighNum && 
					int3HighNum > int4HighNum && int4HighNum > int5HighNum) {
						blnStraightSort = true;
						con.println("Sorted successfully!");
						intCard1Number = int1HighNum;
						intCard2Number = int2HighNum;
						intCard3Number = int3HighNum;
						intCard4Number = int4HighNum;
						intCard5Number = int5HighNum;
						if (int1HighNum == int2HighNum - 1 && int2HighNum == int3HighNum - 1 && int3HighNum == int4HighNum - 1 && int4HighNum == int5HighNum - 1) {
							// Straight
							con.println("Straight!");
							blnIsStraight = true;
						} else if (int5HighNum > 10 && int4HighNum > 10) {
							// Jacks or Better
							con.println("Jacks or Better!");
							blnIsJacksorBetter = true; 
						}
					}
				}
			}
						
		if (intKeyPressed == 49) {
			// If key 1 pressed, lock Card 1
			blnCard1Lock = true;
		}
		if (intKeyPressed == 50) {
			// If key 2 pressed, lock Card 2
			blnCard2Lock = true;
		}
		if (intKeyPressed == 51) {
			// If key 3 pressed, lock Card 3
			blnCard3Lock = true;
		}
		if (intKeyPressed == 52) {
			// If key 4 pressed, lock Card 4
			blnCard4Lock = true;
		}
		if (intKeyPressed == 53) {
			// If key 5 pressed, lock Card 5 
			blnCard5Lock = true;
		}
		// Card 1
		con.setDrawColor(new Color(255, 255, 255));
		con.fillRect(410, 510, 180, 230);
			
		// Suit Visuals
			
		if (intCard1Suit == 1) {
			con.drawImage(imgClub, 370, 500);
		} else if (intCard1Suit == 2) {
			con.drawImage(imgDiamond, 370, 500);
		} else if (intCard1Suit == 3) {
			con.drawImage(imgHeart, 370, 500);
		} else if (intCard1Suit == 4) {
			con.drawImage(imgSpade, 370, 500);
		}
			
		// Number Visuals
			
		con.setDrawColor(new Color(0, 0, 0));
		if (intCard1Number == 1 || intCard1Number == 14) { // Ace
			con.drawString("A", 555, 525);
		} else if (intCard1Number == 11) { // Jack
			con.drawString("J", 555, 525);
		} else if (intCard1Number == 12) { // Queen
			con.drawString("Q", 555, 525);
		} else if (intCard1Number == 13) { // King
			con.drawString("K", 555, 525);
		} else { // Numbers 2-10 
			strCardNumber = Integer.toString(intCard1Number);
			con.drawString(strCardNumber, 555, 525);
		}
		// Card 2
		con.setDrawColor(new Color(255, 255, 255));
		con.fillRect(630, 510, 180, 230);
		if (intCard2Suit == 1) {
			con.drawImage(imgClub, 590, 500);
		} else if (intCard2Suit == 2) {
			con.drawImage(imgDiamond, 590, 500);
		} else if (intCard2Suit == 3) {
			con.drawImage(imgHeart, 590, 500);
		} else if (intCard2Suit == 4) {
			con.drawImage(imgSpade, 590, 500);
		}
			
		// Number Visuals (+222)
			
		con.setDrawColor(new Color(0, 0, 0));
		if (intCard2Number == 1 || intCard2Number == 14) { // Ace
			con.drawString("A", 772, 525);
		} else if (intCard2Number == 11) { // Jack
			con.drawString("J", 772, 525);
		} else if (intCard2Number == 12) { // Queen
			con.drawString("Q", 772, 525);
		} else if (intCard2Number == 13) { // King
			con.drawString("K", 772, 525);
		} else { // Numbers 2-10 
			strCardNumber = Integer.toString(intCard2Number);
			con.drawString(strCardNumber, 780, 525);
		}
		// Card 3
		con.setDrawColor(new Color(255, 255, 255));
		con.fillRect(850, 510, 180, 230);
		if (intCard3Suit == 1) {
			con.drawImage(imgClub, 810, 500);
		} else if (intCard3Suit == 2) {
			con.drawImage(imgDiamond, 810, 500);
		} else if (intCard3Suit == 3) {
			con.drawImage(imgHeart, 810, 500);
		} else if (intCard3Suit == 4) {
			con.drawImage(imgSpade, 810, 500);
		}
			
		// Number Visuals (+222)
			
		con.setDrawColor(new Color(0, 0, 0));
		if (intCard3Number == 1 || intCard3Number == 14) { // Ace
			con.drawString("A", 994, 525);
		} else if (intCard3Number == 11) { // Jack
			con.drawString("J", 994, 525);
		} else if (intCard3Number == 12) { // Queen
			con.drawString("Q", 994, 525);
		} else if (intCard3Number == 13) { // King
			con.drawString("K", 994, 525);
		} else { // Numbers 2-10 
			strCardNumber = Integer.toString(intCard3Number);
			con.drawString(strCardNumber, 994, 525);
		}
			
		// Card 4
		con.setDrawColor(new Color(255, 255, 255));
		con.fillRect(1070, 510, 180, 230);
		if (intCard4Suit == 1) {
			con.drawImage(imgClub, 1030, 500);
		} else if (intCard4Suit == 2) {
			con.drawImage(imgDiamond, 1030, 500);
		} else if (intCard4Suit == 3) {
			con.drawImage(imgHeart, 1030, 500);
		} else if (intCard4Suit == 4) {
			con.drawImage(imgSpade, 1030, 500);
		}
			
		// Number Visuals (+222)
			
		con.setDrawColor(new Color(0, 0, 0));
		if (intCard4Number == 1 || intCard4Number == 14) { // Ace
			con.drawString("A", 1216, 525);
		} else if (intCard4Number == 11) { // Jack
			con.drawString("J", 1216, 525);
		} else if (intCard4Number == 12) { // Queen
			con.drawString("Q", 1216, 525);
		} else if (intCard4Number == 13) { // King
			con.drawString("K", 1216, 525);
		} else { // Numbers 2-10 
			strCardNumber = Integer.toString(intCard4Number);
			con.drawString(strCardNumber, 1216, 525);
		}
			
		// Card 5
		con.setDrawColor(new Color(255, 255, 255));
		con.fillRect(1290, 510, 180, 230);
		if (intCard5Suit == 1) {
			con.drawImage(imgClub, 1250, 500);
		} else if (intCard5Suit == 2) {
			con.drawImage(imgDiamond, 1250, 500);
		} else if (intCard5Suit == 3) {
			con.drawImage(imgHeart, 1250, 500);
		} else if (intCard5Suit == 4) {
			con.drawImage(imgSpade, 1250, 500);
		}
			
		// Number Visuals (+222)
			
		con.setDrawColor(new Color(0, 0, 0));
		if (intCard5Number == 1 || intCard5Number == 14) { // Ace
			con.drawString("A", 1438, 525);
		} else if (intCard5Number == 11) { // Jack
			con.drawString("J", 1438, 525);
		} else if (intCard5Number == 12) { // Queen
			con.drawString("Q", 1438, 525);
		} else if (intCard5Number == 13) { // King
			con.drawString("K", 1438, 525);
		} else { // Numbers 2-10 
			strCardNumber = Integer.toString(intCard5Number);
			con.drawString(strCardNumber, 1438, 525);
		}
			
		// [-----]
		con.repaint();
		con.sleep(50);
		}
	}
	static void nGen(Console con) {
	con.println("generating!");
	intGenNumber = (int)(Math.random() * 13 + 1); // Generates number from 1 to 13
	intGenSuit = (int)(Math.random() * 4 + 1); // Generes a suit from 1 to 4
	con.println(intGenNumber+" "+intGenSuit);
	}
	static void cardUpdater(Console con) {
		if (intCard1Number == 0) {
			nGen(con);
			intCard1Number = intGenNumber;
			intCard1Suit = intGenSuit;
		} if (intCard2Number == 0) {
			nGen(con);
			intCard2Number = intGenNumber;
			intCard2Suit = intGenSuit;
		} if (intCard3Number == 0) {
			nGen(con);
			intCard3Number = intGenNumber;
			intCard3Suit = intGenSuit;
		} if (intCard4Number == 0) {
			nGen(con);
			intCard4Number = intGenNumber;
			intCard4Suit = intGenSuit;
		} if (intCard5Number == 0) {
			nGen(con);
			intCard5Number = intGenNumber;
			intCard5Suit = intGenSuit;
		}
	}
}
		

