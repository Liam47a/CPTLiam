import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class CPTLiam {
	static boolean blnIsRunning = true;
	static int intForLooper;
		
	static int intGenNumber = 0;
	static int intGenSuit = 0;
		
	static int intNum = 0;
		
	static int intCardNumber = 0;
	static int intSuitNumber = 0;
		
	// 1st card stats
	static int intCard1Number = 0;
	static int intCard1Suit = 0;
	// 2nd card stats
	static int intCard2Number = 0;
	static int intCard2Suit = 0;
	// 3rd card stats
	static int intCard3Number = 0;
	static int intCard3Suit = 0;
	// 4th card stats
	static int intCard4Number = 0;
	static int intCard4Suit = 0;
	// 5th card stats
	static int intCard5Number = 0;
	static int intCard5Suit = 0;
		
	static int intMoney = 1000;
	
	public static void main (String[] args) {
		Console con = new Console(1920, 1080);
		System.out.println("Current working directory: " + System.getProperty("user.dir"));
		con.setBackgroundColor(new Color(3, 80, 210));
		BufferedImage imgClub = con.loadImage("clubIcon.png");
		while (blnIsRunning == true) {
			con.drawImage(imgClub, 370, 500);
			con.drawImage(imgClub, 590, 500);
			con.drawImage(imgClub, 810, 500);
			con.drawImage(imgClub, 1030, 500);
			con.drawImage(imgClub, 1250, 500);
			con.repaint();
			con.sleep(100);
		
		}
		
		while (intCard1Number == 0 || intCard2Number == 0 || intCard3Number == 0 || intCard4Number == 0 || intCard5Number == 0) {
			cardUpdater(con);
		}
	}
	static void nGen(Console con) {
		intGenNumber = (int)(Math.random() * 13 + 1); // Generates number from 1 to 13
		intGenSuit = (int)(Math.random() * 4 + 1); // Generes a suit from 1 to 4
		con.println(intGenNumber+" "+intGenSuit);
		
	}
	static void cardUpdater(Console con) {
		if (intCard1Number == 0) {
			nGen(con);
			intCard1Number = intGenNumber;
			intCard1Suit = intGenSuit;
		} else if (intCard2Number == 0) {
			nGen(con);
			intCard2Number = intGenNumber;
			intCard2Suit = intGenSuit;
		} else if (intCard3Number == 0) {
			nGen(con);
			intCard3Number = intGenNumber;
			intCard3Suit = intGenSuit;
		} else if (intCard4Number == 0) {
			nGen(con);
			intCard4Number = intGenNumber;
			intCard4Suit = intGenSuit;
		} else if (intCard5Number == 0) {
			nGen(con);
			intCard5Number = intGenNumber;
			intCard5Suit = intGenSuit;
		}
	}
}
		

