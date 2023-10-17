package carManufacturer;

import javax.swing.ImageIcon;

public class Car {
	
	/////////////////////////////////
	// declare variable to be used
	///////////////////////////////
	private String[] makeOptions = new String[] {"Select Make", "BMW", "Ford", "GMC", "JEEP", "MAZDA", "PEUGEOT"};
	private String[] colorOptions = new String[] {"Select Color", "Black", "Grey", "Red", "Blue", "Orange", "Yellow", "Green", "Purple"};
	private String[] modelOptions;
	private String[] doorOptions = new String[] {"Select # Doors", "Two Door", "Four Door"};
	private ImageIcon img;
	private String make, model, color, doorCount;
	
	///////////////////////////////
	// create object for messages
	/////////////////////////////
	private SystemMessages sysMsg = new SystemMessages();
	
	
	public void setMakeOptions(String[] makeOptions) {
		this.makeOptions = makeOptions;
	}
	
	public String[] getMakeOptions() {
		return makeOptions;
	}
	
	public void setColorOptions(String[] colorOptions) {
		this.colorOptions = colorOptions;
	}
	
	public String[] getColorOptions() {
		return colorOptions;
	}
	
	public void setModelOptions(String makeSelection) {
		
		if (makeSelection.equalsIgnoreCase("BMW")) {
			this.modelOptions = new String[] {"Select Model", "X1", "X2", "X3", 
					"X4", "X5", "X6", "X7", "3 Series", "5 Series", "7 Series"};
		} else if (makeSelection.equalsIgnoreCase("Ford")) {
			this.modelOptions = new String[] {"Select Model", "Aspire", "Escort", "Explorer", 
					"Fiesta", "Focus", "Mustang", "Ranger", "Taurus"};
		} else if (makeSelection.equalsIgnoreCase("GMC")) {
			this.modelOptions = new String[] {"Select Model", "Acadia", "Canyon", "Envoy", 
					"Terrain", "Sierra", "Yukon"};
		} else if (makeSelection.equalsIgnoreCase("Jeep")) {
			this.modelOptions = new String[] {"Select Model", "Cherokee", "Comanche", "Commander", 
					"Compass", "CJ", "Grand Cherokee", "Honcho", "Patriot", "Liberty", "Trailhawk", 
					"Wrangler"};
		} else if (makeSelection.equalsIgnoreCase("Mazda")) {
			this.modelOptions = new String[] {"Select Model", "B-Series", "CX-7", "CX-9", "Mazda3", 
					"Mazda5", "Mazdaspeed3", "Millenia", "MPV", "MX-3", "MX-5", "MX-6", "Tribute", 
					"RX-7", "RX-8"};
		} else if (makeSelection.equalsIgnoreCase("Peugeot")) {
			this.modelOptions = new String[] {"Select Model", "107", "208", "308", "406", "408", 
					"508", "2008", "3008", "4007", "5008", "RCZ"};
		} else {
			this.modelOptions = new String[] {"Select Model"};
		}
	}
	
	public String[] getModelOptions() {
		return modelOptions;
	}
	
	public void setDoorOptions(String[] doorOptions) {
		this.doorOptions = doorOptions;
	}
	
	public String[] getDoorOptions() {
		return doorOptions;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getMake() {
		return make;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setColor(String color) {
		switch (color) {
		case "Black":	
		case "Grey":
		case "Red":
		case "Blue":
		case "Green":
		case "Yellow":
		case "Purple":
		case "Orange":
			this.color = color;
			break;
		default:
			break;
		}
		
	}
	
	public String getColor() {
		return color;
	}
	
	public void setDoorCount(String doorCount) {
		
		switch (doorCount) {
		case "Two Door":	
		case "Four Door":
			this.doorCount = doorCount;
			break;
		default:
			break;
		}
		
	}
	
	public String getDoorCount() {
		return doorCount;
	}

	public void setImg(String colorSelection) {
		
		if (colorSelection.equalsIgnoreCase("black")) {
			this.img = new ImageIcon(UserOrderPane_Main.class.getResource("/resources/Black.png"));
		} else if (colorSelection.equalsIgnoreCase("grey")) {
			this.img = new ImageIcon(UserOrderPane_Main.class.getResource("/resources/Grey.png"));
		} else if (colorSelection.equalsIgnoreCase("Red")) {
			this.img = new ImageIcon(UserOrderPane_Main.class.getResource("/resources/Red.png"));
		} else if (colorSelection.equalsIgnoreCase("blue")) {
			this.img = new ImageIcon(UserOrderPane_Main.class.getResource("/resources/Blue.png"));
		} else if (colorSelection.equalsIgnoreCase("green")) {
			this.img = new ImageIcon(UserOrderPane_Main.class.getResource("/resources/Green.png"));
		} else if (colorSelection.equalsIgnoreCase("orange")) {
			this.img = new ImageIcon(UserOrderPane_Main.class.getResource("/resources/Orange.png"));
		} else if (colorSelection.equalsIgnoreCase("purple")) {
			this.img = new ImageIcon(UserOrderPane_Main.class.getResource("/resources/Purple.png"));
		} else if (colorSelection.equalsIgnoreCase("yellow")) {
			this.img = new ImageIcon(UserOrderPane_Main.class.getResource("/resources/Yellow.png"));
		} else if (colorSelection.equalsIgnoreCase("about")){
			this.img = new ImageIcon(UserOrderPane_Main.class.getResource("/resources/Me.png"));
		} else {
			this.img = new ImageIcon(UserOrderPane_Main.class.getResource("/resources/approved.png"));
		}
		
	}
	
	public ImageIcon getImg() {
		return img;
	}

}
