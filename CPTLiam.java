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
    static int intBet = 25; 
    
    static int intKeyPressed;
    
    static boolean blnEnterKeyCooldown = false;
    
    static boolean blnStraightSort = false;
    static boolean blnFinished = false;
    
    static boolean blnIsRoyalFlush = false; 
    static boolean blnIsStraightFlush = false;
    static boolean blnIsFourKind = false;
    static boolean blnIsFullHouse = false;
    static boolean blnIsFlush = false; 
    static boolean blnIsStraight = false; 
    static boolean blnIsThreeKind = false; 
    static boolean blnIsTwoPair = false; 
    static boolean blnIsJacksorBetter = false; 
    
    static int intCardNumber = 0;
    static int intSuitNumber = 0;
    
    static int intSpadeNumber = 0;
    static int intHeartNumber = 0;
    static int intDiamondNumber = 0; 
    static int intClubNumber = 0;
    
    static int int2Count = 0;
    static int int3Count = 0;
    static int int4Count = 0;
    static int int5Count = 0;
    static int int6Count = 0;
    static int int7Count = 0;
    static int int8Count = 0;
    static int int9Count = 0;
    static int int10Count = 0;
    static int intJackCount = 0;
    static int intQueenCount = 0;
    static int intKingCount = 0;
    static int intAceCount = 0; 
    
    static int intPairCount = 0;
    static int intTripletCount = 0; 
    static int intQuadCount = 0;
    
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
			} if (blnIsRoyalFlush == true) {
				con.drawString("Royal Flush! +" + (intBet * 800) + " dollars (800x your bet)", 500, 900);
			} else if (blnIsStraightFlush == true) {
				con.drawString("Straight Flush! +" + (intBet * 50) + " dollars (50x your bet)", 500, 900);
			} else if (blnIsFourKind == true) {
				con.drawString("Four of a Kind! +" + (intBet * 25) + " dollars (25x your bet)", 500, 900);
			} else if (blnIsFullHouse == true) {
				con.drawString("Full House! +" + (intBet * 9) + " dollars (9x your bet)", 500, 900);
			} else if (blnIsFlush == true) {
				con.drawString("Flush! +" + (intBet * 6) + " dollars (6x your bet)", 500, 900);
			} else if (blnIsStraight == true) {
				con.drawString("Straight! +" + (intBet * 4) + " dollars (4x your bet)", 500, 900);
			} else if (blnIsThreeKind == true) {
				con.drawString("Three of a Kind! +" + (intBet * 3) + " dollars (3x your bet)", 500, 900);
			} else if (blnIsTwoPair == true) {
				con.drawString("Two Pair! +" + (intBet * 2) + " dollars (2x your bet)", 500, 900);
			} else if (blnIsJacksorBetter == true) {
				con.drawString("Jacks or Better! +" + (intBet * 1) + " dollars (1x your bet)", 500, 900);
			} else if (intGameStage == 2) {
				con.drawString("Nothing...you lost " + intBet + " dollars", 500, 900);
			}
            if (intGameStage == 0) {
				blnFinished = false;
				blnIsRoyalFlush = false;
				blnIsFourKind = false;
				blnIsFullHouse = false; 
				blnIsStraightFlush = false;
				blnIsFlush = false; 
				blnIsStraight = false;
				blnIsThreeKind = false; 
				blnIsJacksorBetter = false;
				blnIsTwoPair = false; 
				int2Count = 0;
				int3Count = 0;
				int4Count = 0;
				int5Count = 0;
				int6Count = 0;
				int7Count = 0;
				int8Count = 0;
				int9Count = 0;
				int10Count = 0;
				intJackCount = 0;
				intQueenCount = 0;
				intKingCount = 0;
				intAceCount = 0; 
				intPairCount = 0;
				intClubNumber = 0;
				intDiamondNumber = 0;
				intHeartNumber = 0;
				intSpadeNumber = 0; 
                con.drawString("Press Enter to Shuffle Cards", 500, 800);
                con.drawString("Press the Number Keys to Lock-In Cards: (1, 2, 3, 4, 5)", 500, 900);
                con.drawString("Money: $" + intMoney, 50, 50);
            } if (intGameStage == 1) {
                con.drawString("Press Enter to Submit Cards", 500, 800);
                con.drawString("Money: $" + intMoney, 50, 50);
            } if (intGameStage == 2) {
                con.drawString("Press Enter to Start New Round", 500, 800);
                con.drawString("Money: $" + intMoney, 50, 50);
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
				blnIsRoyalFlush = false;
				blnIsStraightFlush = false;
				blnIsFourKind = false;
				blnIsFullHouse = false;
				blnIsFlush = false;
				blnIsStraight = false;
				blnIsThreeKind = false;
				blnIsTwoPair = false;
				blnIsJacksorBetter = false;
				blnStraightSort = false;
        for (intForLooper = 1; intForLooper <= 52; intForLooper++) {
            intUsedCards[intForLooper] = 0;
        }
        intUsedCount = 0;
        intForLooper = 0;
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
                        blnStraightSort = false;
                        for (intForLooper = 1; intForLooper <= 52; intForLooper++) {
                            intUsedCards[intForLooper] = 0;
                        }
                        intUsedCount = 0;
                        intForLooper = 0; 
                    }
                }
            }
            if (intKeyPressed != 10) {
                blnEnterKeyCooldown = false; 
            }
 if (intGameStage == 2 && blnFinished == false) {
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
        
        // Reset counters
        int2Count = 0;
        int3Count = 0;
        int4Count = 0;
        int5Count = 0;
        int6Count = 0;
        int7Count = 0;
        int8Count = 0;
        int9Count = 0;
        int10Count = 0;
        intJackCount = 0;
        intQueenCount = 0;
        intKingCount = 0;
        intAceCount = 0;
        intPairCount = 0;
        intTripletCount = 0;
        intQuadCount = 0;
        intClubNumber = 0;
        intDiamondNumber = 0;
        intHeartNumber = 0;
        intSpadeNumber = 0;
        
        // Count ranks and suits for all cards
        for (intForLooper = 1; intForLooper <= 5; intForLooper++) {
            con.println("Processing card: " + intForLooper);
            if (intForLooper == 1) {
                intCardNumber = intCard1Number; 
                intSuitNumber = intCard1Suit;
            } if (intForLooper == 2) {
                intCardNumber = intCard2Number; 
                intSuitNumber = intCard2Suit;
            } if (intForLooper == 3) {
                intCardNumber = intCard3Number;
                intSuitNumber = intCard3Suit;
            } if (intForLooper == 4) {
                intCardNumber = intCard4Number; 
                intSuitNumber = intCard4Suit; 
            } if (intForLooper == 5) {
                intCardNumber = intCard5Number; 
                intSuitNumber = intCard5Suit; 
            }
            
            if (intCardNumber == 2) {
                int2Count = int2Count + 1;
                if (int2Count == 2) {
                    intPairCount = intPairCount + 1; 
                } if (int2Count == 3) {
                    intTripletCount = intTripletCount + 1;
                    intPairCount = intPairCount - 1; 
                } if (int2Count == 4) {
                    intQuadCount = intQuadCount + 1;
                    intTripletCount = intTripletCount - 1;
                }
            }
            if (intCardNumber == 3) {
                int3Count = int3Count + 1;
                if (int3Count == 2) {
                    intPairCount = intPairCount + 1; 
                } if (int3Count == 3) {
                    intTripletCount = intTripletCount + 1;
                    intPairCount = intPairCount - 1; 
                } if (int3Count == 4) {
                    intQuadCount = intQuadCount + 1;
                    intTripletCount = intTripletCount - 1;
                }
            }
            if (intCardNumber == 4) {
                int4Count = int4Count + 1;
                if (int4Count == 2) {
                    intPairCount = intPairCount + 1; 
                } if (int4Count == 3) {
                    intTripletCount = intTripletCount + 1;
                    intPairCount = intPairCount - 1; 
                } if (int4Count == 4) {
                    intQuadCount = intQuadCount + 1;
                    intTripletCount = intTripletCount - 1;
                }
            }
            if (intCardNumber == 5) {
                int5Count = int5Count + 1;
                if (int5Count == 2) {
                    intPairCount = intPairCount + 1; 
                } if (int5Count == 3) {
                    intTripletCount = intTripletCount + 1;
                    intPairCount = intPairCount - 1; 
                } if (int5Count == 4) {
                    intQuadCount = intQuadCount + 1;
                    intTripletCount = intTripletCount - 1;
                }
            }
            if (intCardNumber == 6) {
                int6Count = int6Count + 1;
                if (int6Count == 2) {
                    intPairCount = intPairCount + 1; 
                } if (int6Count == 3) {
                    intTripletCount = intTripletCount + 1;
                    intPairCount = intPairCount - 1; 
                } if (int6Count == 4) {
                    intQuadCount = intQuadCount + 1;
                    intTripletCount = intTripletCount - 1;
                }
            }
            if (intCardNumber == 7) {
                int7Count = int7Count + 1;
                if (int7Count == 2) {
                    intPairCount = intPairCount + 1; 
                } if (int7Count == 3) {
                    intTripletCount = intTripletCount + 1;
                    intPairCount = intPairCount - 1; 
                } if (int7Count == 4) {
                    intQuadCount = intQuadCount + 1;
                    intTripletCount = intTripletCount - 1;
                }
            }
            if (intCardNumber == 8) {
                int8Count = int8Count + 1;
                if (int8Count == 2) {
                    intPairCount = intPairCount + 1; 
                } if (int8Count == 3) {
                    intTripletCount = intTripletCount + 1;
                    intPairCount = intPairCount - 1; 
                } if (int8Count == 4) {
                    intQuadCount = intQuadCount + 1;
                    intTripletCount = intTripletCount - 1;
                }
            }
            if (intCardNumber == 9) {
                int9Count = int9Count + 1;
                if (int9Count == 2) {
                    intPairCount = intPairCount + 1; 
                } if (int9Count == 3) {
                    intTripletCount = intTripletCount + 1;
                    intPairCount = intPairCount - 1; 
                } if (int9Count == 4) {
                    intQuadCount = intQuadCount + 1;
                    intTripletCount = intTripletCount - 1;
                }
            }
            if (intCardNumber == 10) {
                int10Count = int10Count + 1;
                if (int10Count == 2) {
                    intPairCount = intPairCount + 1; 
                } if (int10Count == 3) {
                    intTripletCount = intTripletCount + 1;
                    intPairCount = intPairCount - 1; 
                } if (int10Count == 4) {
                    intQuadCount = intQuadCount + 1;
                    intTripletCount = intTripletCount - 1;
                }
            }
            if (intCardNumber == 11) {
                intJackCount = intJackCount + 1;
                if (intJackCount == 2) {
                    intPairCount = intPairCount + 1;
                } if (intJackCount == 3) {
                    intTripletCount = intTripletCount + 1;
                    intPairCount = intPairCount - 1; 
                } if (intJackCount == 4) {
                    intQuadCount = intQuadCount + 1;
                    intTripletCount = intTripletCount - 1;
                }
            }
            if (intCardNumber == 12) {
                intQueenCount = intQueenCount + 1;
                if (intQueenCount == 2) {
                    intPairCount = intPairCount + 1;
                } if (intQueenCount == 3) {
                    intTripletCount = intTripletCount + 1;
                    intPairCount = intPairCount - 1; 
                } if (intQueenCount == 4) {
                    intQuadCount = intQuadCount + 1;
                    intTripletCount = intTripletCount - 1;
                }
            }
            if (intCardNumber == 13) {
                intKingCount = intKingCount + 1;
                if (intKingCount == 2) {
                    intPairCount = intPairCount + 1;
                } if (intKingCount == 3) {
                    intTripletCount = intTripletCount + 1;
                    intPairCount = intPairCount - 1; 
                } if (intKingCount == 4) {
                    intQuadCount = intQuadCount + 1;
                    intTripletCount = intTripletCount - 1;
                }
            }
            if (intCardNumber == 14) {
                intAceCount = intAceCount + 1;
                if (intAceCount == 2) {
                    intPairCount = intPairCount + 1;
                } if (intAceCount == 3) {
                    intTripletCount = intTripletCount + 1;
                    intPairCount = intPairCount - 1; 
                } if (intAceCount == 4) {
                    intQuadCount = intQuadCount + 1;
                    intTripletCount = intTripletCount - 1;
                }
            } 
            
            if (intSuitNumber == 1) {
                intClubNumber = intClubNumber + 1;
            } else if (intSuitNumber == 2) {
                intDiamondNumber = intDiamondNumber + 1; 
            } else if (intSuitNumber == 3) {
                intHeartNumber = intHeartNumber + 1; 
            } else if (intSuitNumber == 4) {
                intSpadeNumber = intSpadeNumber + 1; 
            }
        }
        
        // Sorting (for straights) 
        int1HighNum = intCard1Number;
        int2HighNum = intCard2Number;
        int3HighNum = intCard3Number;
        int4HighNum = intCard4Number;
        int5HighNum = intCard5Number;
        for (intForLooper = 1; intForLooper <= 4; intForLooper++) {
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
        
        blnStraightSort = true;
        
        // Flush checker 
        boolean isFlush = (intClubNumber == 5 || intDiamondNumber == 5 || intHeartNumber == 5 || intSpadeNumber == 5);
        // Royal Flush
        if (isFlush && int1HighNum == 10 && int2HighNum == 11 && int3HighNum == 12 && 
            int4HighNum == 13 && int5HighNum == 14) {
            intMoney = intMoney + intBet * 800;
            blnIsRoyalFlush = true;
        // Straight Flush
        } else if (isFlush && ((int1HighNum + 1 == int2HighNum && int2HighNum + 1 == int3HighNum && 
                                int3HighNum + 1 == int4HighNum && int4HighNum + 1 == int5HighNum) ||
                               (int1HighNum == 2 && int2HighNum == 3 && int3HighNum == 4 && 
                                int4HighNum == 5 && int5HighNum == 14))) {
            intMoney = intMoney + intBet * 50;
            blnIsStraightFlush = true;
        // Four of a Kind
        } else if (intQuadCount == 1) {
            intMoney = intMoney + intBet * 25;
            blnIsFourKind = true;
        // Full House
        } else if (intTripletCount == 1 && intPairCount == 1) {
            intMoney = intMoney + intBet * 9;
            blnIsFullHouse = true;
        // Flush
        } else if (isFlush) {
            intMoney = intMoney + intBet * 6;
            blnIsFlush = true;
        // Straight
        } else if ((int1HighNum + 1 == int2HighNum && int2HighNum + 1 == int3HighNum && 
                    int3HighNum + 1 == int4HighNum && int4HighNum + 1 == int5HighNum) ||
                   (int1HighNum == 2 && int2HighNum == 3 && int3HighNum == 4 && 
                    int4HighNum == 5 && int5HighNum == 14)) {
            intMoney = intMoney + intBet * 4;
            blnIsStraight = true;
        // Three of a Kind 
        } else if (intTripletCount == 1) {
            intMoney = intMoney + intBet * 3;
            blnIsThreeKind = true; 
        // Two Pair 
        } else if (intPairCount == 2) {
            intMoney = intMoney + intBet * 2;
            blnIsTwoPair = true; 
        // Jacks or Better
        } else if (intJackCount >= 2 || intQueenCount >= 2 || intKingCount >= 2 || intAceCount >= 2) {
            intMoney = intMoney + intBet * 1; 
            blnIsJacksorBetter = true; 
        } else {
            intMoney = intMoney - intBet; 
        }
		blnFinished = true; 
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
