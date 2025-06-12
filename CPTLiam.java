import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;

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
    
    static int intCard1Number = 0;
    static int intCard1Suit = 1;
    static boolean blnCard1Lock = false;
    static int intCard2Number = 0;
    static int intCard2Suit = 1;
    static boolean blnCard2Lock = false;
    static int intCard3Number = 0;
    static int intCard3Suit = 1;
    static boolean blnCard3Lock = false;
    static int intCard4Number = 0;
    static int intCard4Suit = 1;
    static boolean blnCard4Lock = false;
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
    static int intJackCount = 0;
    static int intQueenCount = 0;
    static int intKingCount = 0;
    static int intAceCount = 0; 
    
    static int intGameStage = 0;
    static boolean blnStageChange = false; 

    static int intUsedCards[] = new int[53];
    static int intUsedCount = 0;
    
    public static void main(String[] args) {
        Console con = new Console(1920, 1080);
        System.out.println("Current working directory: " + System.getProperty("user.dir"));
        con.setBackgroundColor(new Color(3, 80, 210));
        
        BufferedImage imgClub = con.loadImage("clubIcon.png");
        BufferedImage imgDiamond = con.loadImage("diamondIcon.png");
        BufferedImage imgHeart = con.loadImage("heartIcon.png");
        BufferedImage imgSpade = con.loadImage("spadeIcon.png");
        
        for (intForLooper = 1; intForLooper <= 52; intForLooper++) {
            intUsedCards[intForLooper] = 0;
        }
        
        cardUpdater(con);
        while (blnIsRunning == true) {
            cardUpdater(con);
            if (blnStageChange == true) {
                con.setBackgroundColor(new Color(3, 80, 210));
                blnStageChange = false;
            } if (blnIsJacksorBetter == true) {
				con.drawString("Jacks or Better!", 500, 900);
			}
            if (intGameStage == 0) {
				intJackCount = 0;
				intQueenCount = 0;
				intKingCount = 0;
				intAceCount = 0; 
                con.drawString("Press Enter to Shuffle Cards", 500, 800);
                con.drawString("Press the Number Keys to Lock-In Cards: (1, 2, 3, 4, 5)", 500, 900);
                con.drawString("Money: $" + intMoney, 50, 50);
            } if (intGameStage == 1) {
                con.drawString("Press Enter to Submit Cards", 500, 800);
                con.drawString("Money: $" + intMoney, 50, 50);
            } if (intGameStage == 2) {
                con.drawString("Press Enter to Start New Round", 500, 800);
                con.drawString("Money: $" + intMoney, 50, 50);
            }
            intKeyPressed = con.currentKey();
            if (intKeyPressed == 10) {
                if (blnEnterKeyCooldown == false) {
                    intGameStage = intGameStage + 1;
                    blnStageChange = true;
                    blnEnterKeyCooldown = true;
                    if (intGameStage == 1) {
                        if (blnCard1Lock == false) {
                            intCard1Number = 0; 
                            intCard1Suit = 1;
                        } if (blnCard2Lock == false) {
                            intCard2Number = 0;
                            intCard2Suit = 1;
                        } if (blnCard3Lock == false) {
                            intCard3Number = 0;
                            intCard3Suit = 1;
                        } if (blnCard4Lock == false) {
                            intCard4Number = 0;
                            intCard4Suit = 1;
                        } if (blnCard5Lock == false) {
                            intCard5Number = 0;
                            intCard5Suit = 1;
                        }
                        for (intForLooper = 1; intForLooper <= 52; intForLooper++) {
                            intUsedCards[intForLooper] = 0;
                        }
                        intUsedCount = 0;
                    } else if (intGameStage == 3) {
                        intGameStage = 0;
                        blnCard1Lock = false;
                        blnCard2Lock = false;
                        blnCard3Lock = false;
                        blnCard4Lock = false;
                        blnCard5Lock = false;
                        intCard1Number = 0;
                        intCard2Number = 0;
                        intCard3Number = 0;
                        intCard4Number = 0;
                        intCard5Number = 0;
                        intCard1Suit = 1;
                        intCard2Suit = 1;
                        intCard3Suit = 1;
                        intCard4Suit = 1;
                        intCard5Suit = 1;
                        blnIsStraight = false;
                        blnIsJacksorBetter = false;
                        intJackCheck = 0;
                        blnStraightSort = false;
                        for (intForLooper = 1; intForLooper <= 52; intForLooper++) {
                            intUsedCards[intForLooper] = 0;
                        }
                        intUsedCount = 0;
                    }
                }
            }
            if (intKeyPressed != 10) {
                blnEnterKeyCooldown = false; 
            }
            if (intGameStage == 2 && blnStraightSort == false) {
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
                
                intJackCheck = 0;
                
                // Count Jacks in hand 
                
                if (intCard1Number == 11) {
					intJackCount = intJackCount + 1;
				} if (intCard2Number == 11) {
					intJackCount = intJackCount + 1;
				} if (intCard3Number == 11) {
					intJackCount = intJackCount + 1;
				} if (intCard4Number == 11) {
					intJackCount = intJackCount + 1;
				} if (intCard5Number == 11) {
					intJackCount = intJackCount + 1;
				}
                
                // Count Queens in hand 
                if (intCard1Number == 12) {
					intQueenCount = intQueenCount + 1;
				} if (intCard2Number == 12) {
					intQueenCount = intQueenCount + 1;
				} if (intCard3Number == 12) {
					intQueenCount = intQueenCount + 1;
				} if (intCard4Number == 12) {
					intQueenCount = intQueenCount + 1;
				} if (intCard5Number == 12) {
					intQueenCount = intQueenCount + 1;
				}
				
				// Count Kings in hand 
				if (intCard1Number == 13) {
					intKingCount = intKingCount + 1;
				} if (intCard2Number == 13) {
					intKingCount = intKingCount + 1;
				} if (intCard3Number == 13) {
					intKingCount = intKingCount + 1;
				} if (intCard4Number == 13) {
					intKingCount = intKingCount + 1;
				} if (intCard5Number == 13) {
					intKingCount = intKingCount + 1; 
				}
                
                // Count Aces in hand 
                if (intCard1Number == 14) {
					intAceCount = intAceCount + 1;
				} if (intCard2Number == 14) {
					intAceCount = intAceCount + 1;
				} if (intCard3Number == 14) {
					intAceCount = intAceCount + 1;
				} if (intCard4Number == 14) {
					intAceCount = intAceCount + 1;
				} if (intCard5Number == 14) {
					intAceCount = intAceCount + 1;
				}
                
                
                if (intJackCount >= 2 || intQueenCount >= 2 || intKingCount >= 2 || intAceCount >= 2) {
                    intMoney = intMoney + 25;
                    blnIsJacksorBetter = true; 
                }
                
                int1HighNum = intCard1Number;
                int2HighNum = intCard2Number;
                int3HighNum = intCard3Number;
                int4HighNum = intCard4Number;
                int5HighNum = intCard5Number;
                for (intForLooper = 1; intForLooper <= 5; intForLooper++) {
                    if (int1HighNum > int2HighNum) {
                        intCardNumber = int1HighNum;
                        int1HighNum = int2HighNum;
                        int2HighNum = intCardNumber;
                    }
                    if (int2HighNum > int3HighNum) {
                        intCardNumber = int2HighNum;
                        int2HighNum = int3HighNum;
                        int3HighNum = intCardNumber;
                    }
                    if (int3HighNum > int4HighNum) {
                        intCardNumber = int3HighNum;
                        int3HighNum = int4HighNum;
                        int4HighNum = intCardNumber;
                    }
                    if (int4HighNum > int5HighNum) {
                        intCardNumber = int4HighNum;
                        int4HighNum = int5HighNum;
                        int5HighNum = intCardNumber;
                    }
                }
                if (int1HighNum + 1 == int2HighNum && int2HighNum + 1 == int3HighNum && 
                    int3HighNum + 1 == int4HighNum && int4HighNum + 1 == int5HighNum) {
                    con.drawString("Straight!", 500, 700);
                    intMoney = intMoney + 50;
                    blnIsStraight = true;
                }
                if (int1HighNum == 2 && int2HighNum == 3 && int3HighNum == 4 && 
                    int4HighNum == 5 && int5HighNum == 14) {
                    con.drawString("Straight!", 500, 700);
                    intMoney = intMoney + 50;
                    blnIsStraight = true;
                }
                blnStraightSort = true;
            }
            
            if (intKeyPressed == 49) {
                blnCard1Lock = !blnCard1Lock;
            }
            if (intKeyPressed == 50) {
                blnCard2Lock = !blnCard2Lock;
            }
            if (intKeyPressed == 51) {
                blnCard3Lock = !blnCard3Lock;
            }
            if (intKeyPressed == 52) {
                blnCard4Lock = !blnCard4Lock;
            }
            if (intKeyPressed == 53) {
                blnCard5Lock = !blnCard5Lock;
            }
            
            // Card 1
            con.setDrawColor(blnCard1Lock ? new Color(200, 150, 200) : new Color(255, 255, 255));
            con.fillRect(460, 530, 180, 230);
            if (intCard1Suit == 1) {
                con.drawImage(imgClub, 420, 520);
            } else if (intCard1Suit == 2) {
                con.drawImage(imgDiamond, 420, 520);
            } else if (intCard1Suit == 3) {
                con.drawImage(imgHeart, 420, 520);
            } else if (intCard1Suit == 4) {
                con.drawImage(imgSpade, 420, 520);
            }
            con.setDrawColor(new Color(0, 0, 0));
            if (intCard1Number == 1 || intCard1Number == 14) {
                con.drawString("A", 555, 550);
            } else if (intCard1Number == 11) {
                con.drawString("J", 555, 550);
            } else if (intCard1Number == 12) {
                con.drawString("Q", 555, 550);
            } else if (intCard1Number == 13) {
                con.drawString("K", 555, 550);
            } else {
                strCardNumber = Integer.toString(intCard1Number);
                con.drawString(strCardNumber, 555, 550);
            }
            
            // Card 2
            con.setDrawColor(blnCard2Lock ? new Color(200, 150, 200) : new Color(255, 255, 255));
            con.fillRect(680, 530, 180, 230);
            if (intCard2Suit == 1) {
                con.drawImage(imgClub, 640, 520);
            } else if (intCard2Suit == 2) {
                con.drawImage(imgDiamond, 640, 520);
            } else if (intCard2Suit == 3) {
                con.drawImage(imgHeart, 640, 520);
            } else if (intCard2Suit == 4) {
                con.drawImage(imgSpade, 640, 520);
            }
            con.setDrawColor(new Color(0, 0, 0));
            if (intCard2Number == 1 || intCard2Number == 14) {
                con.drawString("A", 772, 550);
            } else if (intCard2Number == 11) {
                con.drawString("J", 772, 550);
            } else if (intCard2Number == 12) {
                con.drawString("Q", 772, 550);
            } else if (intCard2Number == 13) {
                con.drawString("K", 772, 550);
            } else {
                strCardNumber = Integer.toString(intCard2Number);
                con.drawString(strCardNumber, 772, 550);
            }
            
            // Card 3
            con.setDrawColor(blnCard3Lock ? new Color(200, 150, 200) : new Color(255, 255, 255));
            con.fillRect(900, 530, 180, 230);
            if (intCard3Suit == 1) {
                con.drawImage(imgClub, 860, 520);
            } else if (intCard3Suit == 2) {
                con.drawImage(imgDiamond, 860, 520);
            } else if (intCard3Suit == 3) {
                con.drawImage(imgHeart, 860, 520);
            } else if (intCard3Suit == 4) {
                con.drawImage(imgSpade, 860, 520);
            }
            con.setDrawColor(new Color(0, 0, 0));
            if (intCard3Number == 1 || intCard3Number == 14) {
                con.drawString("A", 994, 550);
            } else if (intCard3Number == 11) {
                con.drawString("J", 994, 550);
            } else if (intCard3Number == 12) {
                con.drawString("Q", 994, 550);
            } else if (intCard3Number == 13) {
                con.drawString("K", 994, 550);
            } else {
                strCardNumber = Integer.toString(intCard3Number);
                con.drawString(strCardNumber, 994, 550);
            }
            
            // Card 4
            con.setDrawColor(blnCard4Lock ? new Color(200, 150, 200) : new Color(255, 255, 255));
            con.fillRect(1120, 530, 180, 230);
            if (intCard4Suit == 1) {
                con.drawImage(imgClub, 1080, 520);
            } else if (intCard4Suit == 2) {
                con.drawImage(imgDiamond, 1080, 520);
            } else if (intCard4Suit == 3) {
                con.drawImage(imgHeart, 1080, 520);
            } else if (intCard4Suit == 4) {
                con.drawImage(imgSpade, 1080, 520);
            }
            con.setDrawColor(new Color(0, 0, 0));
            if (intCard4Number == 1 || intCard4Number == 14) {
                con.drawString("A", 1216, 550);
            } else if (intCard4Number == 11) {
                con.drawString("J", 1216, 550);
            } else if (intCard4Number == 12) {
                con.drawString("Q", 1216, 550);
            } else if (intCard4Number == 13) {
                con.drawString("K", 1216, 550);
            } else {
                strCardNumber = Integer.toString(intCard4Number);
                con.drawString(strCardNumber, 1216, 550);
            }
            
            // Card 5
            con.setDrawColor(blnCard5Lock ? new Color(200, 150, 200) : new Color(255, 255, 255));
            con.fillRect(1340, 530, 180, 230);
            if (intCard5Suit == 1) {
                con.drawImage(imgClub, 1300, 520);
            } else if (intCard5Suit == 2) {
                con.drawImage(imgDiamond, 1300, 520);
            } else if (intCard5Suit == 3) {
                con.drawImage(imgHeart, 1300, 520);
            } else if (intCard5Suit == 4) {
                con.drawImage(imgSpade, 1300, 520);
            }
            con.setDrawColor(new Color(0, 0, 0));
            if (intCard5Number == 1 || intCard5Number == 14) {
                con.drawString("A", 1438, 550);
            } else if (intCard5Number == 11) {
                con.drawString("J", 1438, 550);
            } else if (intCard5Number == 12) {
                con.drawString("Q", 1438, 550);
            } else if (intCard5Number == 13) {
                con.drawString("K", 1438, 550);
            } else {
                strCardNumber = Integer.toString(intCard5Number);
                con.drawString(strCardNumber, 1438, 550);
            }
            
            con.repaint();
            con.sleep(50);
        }
    }
    
    static void nGen(Console con) {
        boolean blnCardUsed = true;
        int intCard = 0;
        while (blnCardUsed == true) {
            intCard = (int)(Math.random() * 52 + 1);
            if (intUsedCards[intCard] == 0) {
                blnCardUsed = false;
                intUsedCards[intCard] = 1;
                intUsedCount = intUsedCount + 1;
            }
        }
        intGenNumber = (intCard - 1) % 13 + 1;
        intGenSuit = (intCard - 1) / 13 + 1;
        con.println(intGenNumber + " " + intGenSuit);
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
