package carManufacturer;

import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

public class SystemMessages {
	
	
	/////////////////////////////
	// introduction
	///////////////////////////
	public void getIntroMsg() {
		String spaces = "                                                                ";
		JOptionPane.showInternalMessageDialog(null, "NAME: Tracy Bullock" + spaces +
				spaces + "        DATE: May 22, 2021\n\n\n\n" + 
				"                                            " +
				"               Welcome to Bullock's Auot-Clearance Application.\n\n" + 
				spaces + "                      :::::::::::::::::::::::::::::\n" +
				spaces + "                      ::  CLEARANCE  ::\n" + 
				spaces + "                      :::::::::::::::::::::::::::::\n\n" +
				"                                Build a new Custom car for only $15,000 per car, "
				+ "with the purchase of at least 3 cars.\n\n\n" +
				spaces + "                     Act fast and save big!\n\n ",
				"Personal Project", JOptionPane.PLAIN_MESSAGE);
	}

	//////////////////////
	// err msgs
	////////////////////
	public void getErrMsg(String errMsg) {
		if (errMsg.equalsIgnoreCase("err")) {
			JOptionPane.showMessageDialog(null, "\nYou must select a valid option from all of the drop boxes!      ", 
					"Error", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "\nYou must order 3 cars to get our discount!      ", 
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	///////////////////////
	// closing warning
	/////////////////////
	public void getCloseMsg(int orderCount) {
		int close = JOptionPane.showConfirmDialog(null, "\n  Your current order will be lost!\n  Would you like to close this application?        ", 
				"Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (close == JOptionPane.YES_OPTION) {
			getOutroMsg(orderCount);
		}
	}
	
	///////////////////////
	// order approval msg
	/////////////////////
	public boolean getOrderMessage(int orderCount) {
		Car newCar = new Car();
		int price = 45000 * (orderCount/3);
		newCar.setImg("approved");
		int newOrder = JOptionPane.showConfirmDialog(null, "You have just ordered " + orderCount + 
				" cars and it will cost you $" + price + ".    \nWould you like to place another order?\n ", 
				"ORDER PROCESSED", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, newCar.getImg());
		if (newOrder == JOptionPane.YES_OPTION) {
			return true;
		} else {
			return false;
		}
	}
	
	//////////////////////////
	// about me info
	////////////////////////
	public void getAboutMsg() {
		Car newCar = new Car();

		newCar.setImg("about");
		JOptionPane.showMessageDialog(null, "NAME: Tracy Bullock                                       "
				+ "\nAGE:    33    \n ", 
				"ORDER PROCESSED", JOptionPane.PLAIN_MESSAGE, newCar.getImg());
	}
	
	////////////////////
	// outro
	//////////////////
	public void getOutroMsg(int orderCount) {
		if (orderCount == 0) {
			JOptionPane.showMessageDialog(null, "\n   Thank you for considering a purchase with us.    " + 
					"\n                           Have a great day!", 
					"GOODBYE", JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "\n              Thank you for purchasing " + orderCount + 
					" cars with us!    \n" + "\n    Please come by our office to smooth out the details.    "
							+ "\n" + "\n                                  Have a great day!", 
					"GOODBYE", JOptionPane.PLAIN_MESSAGE);
		}
		System.exit(0);
	}	

}
