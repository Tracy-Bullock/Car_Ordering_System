package carManufacturer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.border.EtchedBorder;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ItemEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

public class UserOrderPane_Main extends JFrame {

	///////////////////////
	// declare variables
	/////////////////////
	private JPanel contentPane, pnCarAttributes, pnOrderDetails;
	private JComboBox cbMake, cbModel, cbColor, cbDoors;
	private JButton btnAddToOrder, btnReset, btnOrder;
	private JLabel lblFirstOrder, lblSecondOrder, lblThirdOrder, 
		lblFirstCarImg, lblSecondCarImg, lblThirdCarImg;
	private JMenuItem mntmResetOrder, mntmResetProgram, mntmExit, mntmAbout;
	private JMenu mnInfo;
	private int count = 1, carCount = 3, orderCount = 2;
	
	/////////////////////////////
	// create object instances
	///////////////////////////
	private Car newCar = new Car();
	private SystemMessages sysMsg = new SystemMessages();

	////////////////////////////////////////////////////////////////////
	// Launch the application.
	///////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		
		///////////////////////////
		// Customize DialogPanes
		/////////////////////////
		JDialog.setDefaultLookAndFeelDecorated(true);
		UIManager UI = new UIManager();
		UI.put("OptionPane.messageFont", new FontUIResource("Arial", Font.BOLD, 12));
		UI.put("OptionPane.background", new ColorUIResource(144,146,151));
		UI.put("OptionPane.messageForeground", new ColorUIResource(252,252,252));
		UI.put("Panel.background", new ColorUIResource(112,112,114));
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserOrderPane_Main frame = new UserOrderPane_Main();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	////////////////////////////////////////////////////////////////////
	// Create the frame.
	///////////////////////////////////////////////////////////////////
	public UserOrderPane_Main() {
		
		sysMsg.getIntroMsg();
		initComponents();
		createEvents();
		
	}
	
	////////////////////////////////////////////////////////////////////
	// This method contains all of the code for creating and
	// initializing components.
	//////////////////////////////////////////////////////////////////
	private void initComponents() {
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 814, 566);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.DARK_GRAY);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setForeground(Color.LIGHT_GRAY);
		menuBar.add(mnNewMenu);
		
		mntmResetOrder = new JMenuItem("Reset Current Order");
		mntmResetOrder.setIcon(new ImageIcon(UserOrderPane_Main.class.getResource("/resources/resetOrder.png")));
		mnNewMenu.add(mntmResetOrder);
		
		mntmResetProgram = new JMenuItem("Reset Program");
		mntmResetProgram.setIcon(new ImageIcon(UserOrderPane_Main.class.getResource("/resources/ResetProgram.png")));
		mnNewMenu.add(mntmResetProgram);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.setIcon(new ImageIcon(UserOrderPane_Main.class.getResource("/resources/closeProgram.png")));
		mnNewMenu.add(mntmExit);
		
		mnInfo = new JMenu("Info");
		mnInfo.setForeground(Color.LIGHT_GRAY);
		menuBar.add(mnInfo);
		
		mntmAbout = new JMenuItem("About Creator");
		mntmAbout.setIcon(new ImageIcon(UserOrderPane_Main.class.getResource("/resources/About1.png")));
		mnInfo.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setTitle("Bullock's Auto Manufacturer");
		setIconImage(Toolkit.getDefaultToolkit().getImage(UserOrderPane_Main.class.getResource("/resources/MechanicIcon.png")));
		
		pnCarAttributes = new JPanel();
		pnCarAttributes.setBorder(new TitledBorder(null, "Car 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnCarAttributes.setBackground(Color.LIGHT_GRAY);
		
		JPanel pnSelectCar = new JPanel();
		pnSelectCar.setBackground(new Color(0, 102, 255));
		
		JPanel pnOrderPreview = new JPanel();
		pnOrderPreview.setBackground(new Color(0, 102, 255));
		
		JLabel lblOrderView = new JLabel(" Review Order and Click Order or Reset");
		lblOrderView.setForeground(Color.WHITE);
		lblOrderView.setFont(new Font("Tahoma", Font.BOLD, 17));
		GroupLayout gl_pnOrderPreview = new GroupLayout(pnOrderPreview);
		gl_pnOrderPreview.setHorizontalGroup(
			gl_pnOrderPreview.createParallelGroup(Alignment.LEADING)
				.addGap(0, 351, Short.MAX_VALUE)
				.addGroup(gl_pnOrderPreview.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblOrderView, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnOrderPreview.setVerticalGroup(
			gl_pnOrderPreview.createParallelGroup(Alignment.LEADING)
				.addGap(0, 56, Short.MAX_VALUE)
				.addGroup(gl_pnOrderPreview.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblOrderView, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
					.addContainerGap())
		);
		pnOrderPreview.setLayout(gl_pnOrderPreview);
		
		pnOrderDetails = new JPanel();
		pnOrderDetails.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Order Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnOrderDetails.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(pnCarAttributes, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnSelectCar, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(pnOrderPreview, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(pnOrderDetails, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(pnOrderPreview, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
							.addComponent(pnOrderDetails, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(pnSelectCar, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
							.addComponent(pnCarAttributes, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		lblFirstCarImg = new JLabel("");
		
		lblFirstOrder = new JLabel("");
		
		JSeparator separator = new JSeparator();
		
		lblSecondCarImg = new JLabel("");
		
		lblSecondOrder = new JLabel("");
		
		JSeparator separator_1 = new JSeparator();
		
		lblThirdCarImg = new JLabel("");
		
		lblThirdOrder = new JLabel("");
		
		JSeparator separator_2 = new JSeparator();
		
		JLabel lblFirstCar = new JLabel("First Car:");
		
		JLabel lblSeondCar = new JLabel("Second Car:");
		
		JLabel lblThirdCar = new JLabel("Third Car:");
		
		btnOrder = new JButton("Order");
		
		btnReset = new JButton("Reset");
		
		GroupLayout gl_pnOrderDetails = new GroupLayout(pnOrderDetails);
		gl_pnOrderDetails.setHorizontalGroup(
			gl_pnOrderDetails.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnOrderDetails.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnOrderDetails.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnOrderDetails.createSequentialGroup()
							.addComponent(lblFirstCar)
							.addGap(62)
							.addGroup(gl_pnOrderDetails.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblFirstOrder, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblFirstCarImg, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)))
						.addGroup(gl_pnOrderDetails.createSequentialGroup()
							.addComponent(lblSeondCar)
							.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
							.addGroup(gl_pnOrderDetails.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblSecondOrder, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblSecondCarImg, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)))
						.addGroup(gl_pnOrderDetails.createSequentialGroup()
							.addComponent(lblThirdCar, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
							.addGroup(gl_pnOrderDetails.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblThirdOrder, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblThirdCarImg, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))))
					.addContainerGap())
				.addGroup(gl_pnOrderDetails.createSequentialGroup()
					.addGap(20)
					.addComponent(btnOrder)
					.addPreferredGap(ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
					.addComponent(btnReset)
					.addGap(24))
				.addComponent(separator, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
				.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
				.addComponent(separator_2, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
		);
		gl_pnOrderDetails.setVerticalGroup(
			gl_pnOrderDetails.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnOrderDetails.createSequentialGroup()
					.addGroup(gl_pnOrderDetails.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblFirstCar)
						.addComponent(lblFirstCarImg, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFirstOrder)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnOrderDetails.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSecondCarImg, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSeondCar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSecondOrder)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnOrderDetails.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblThirdCarImg, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblThirdCar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblThirdOrder)
					.addGap(8)
					.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
					.addGroup(gl_pnOrderDetails.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnReset)
						.addComponent(btnOrder))
					.addContainerGap())
		);
		pnOrderDetails.setLayout(gl_pnOrderDetails);
		
		cbMake = new JComboBox();
		
		cbMake.setModel(new DefaultComboBoxModel(newCar.getMakeOptions()));
		
		cbModel = new JComboBox();
		
		cbModel.setModel(new DefaultComboBoxModel(new String[] {"Select Model"}));
		
		cbColor = new JComboBox();
		cbColor.setModel(new DefaultComboBoxModel(newCar.getColorOptions()));
		
		cbDoors = new JComboBox();
		cbDoors.setModel(new DefaultComboBoxModel(newCar.getDoorOptions()));
		
		JLabel lblMake = new JLabel("Make:");
		
		JLabel lblModel = new JLabel("Model:");
		
		JLabel lblColor = new JLabel("Color:");
		
		JLabel lblDoors = new JLabel("Doors:");
		
		btnAddToOrder = new JButton("Add To Order");

		GroupLayout gl_pnCarAttributes = new GroupLayout(pnCarAttributes);
		gl_pnCarAttributes.setHorizontalGroup(
			gl_pnCarAttributes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnCarAttributes.createSequentialGroup()
					.addGroup(gl_pnCarAttributes.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnCarAttributes.createSequentialGroup()
							.addGap(121)
							.addComponent(btnAddToOrder))
						.addGroup(gl_pnCarAttributes.createSequentialGroup()
							.addGap(88)
							.addGroup(gl_pnCarAttributes.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_pnCarAttributes.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblMake)
									.addComponent(lblModel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblColor))
								.addComponent(lblDoors))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnCarAttributes.createParallelGroup(Alignment.LEADING, false)
								.addComponent(cbDoors, 0, 112, Short.MAX_VALUE)
								.addComponent(cbColor, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(cbModel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(cbMake, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(95, Short.MAX_VALUE))
		);
		gl_pnCarAttributes.setVerticalGroup(
			gl_pnCarAttributes.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnCarAttributes.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_pnCarAttributes.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbMake, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMake))
					.addGap(42)
					.addGroup(gl_pnCarAttributes.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbModel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblModel))
					.addGap(44)
					.addGroup(gl_pnCarAttributes.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblColor))
					.addGap(43)
					.addGroup(gl_pnCarAttributes.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbDoors, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDoors))
					.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
					.addComponent(btnAddToOrder)
					.addGap(49))
		);
		pnCarAttributes.setLayout(gl_pnCarAttributes);
		
		JLabel lblSelectCar = new JLabel("Select The Car Attributes and Click add");
		lblSelectCar.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSelectCar.setForeground(Color.WHITE);
		GroupLayout gl_pnSelectCar = new GroupLayout(pnSelectCar);
		gl_pnSelectCar.setHorizontalGroup(
			gl_pnSelectCar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnSelectCar.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSelectCar, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnSelectCar.setVerticalGroup(
			gl_pnSelectCar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnSelectCar.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSelectCar, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
					.addContainerGap())
		);
		pnSelectCar.setLayout(gl_pnSelectCar);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	////////////////////////////////////////////////////////////////////
	// This method contains all of the code for creating events.
	///////////////////////////////////////////////////////////////////
	private void createEvents() {
		
		btnAddToOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String colorCheck = (String)cbColor.getSelectedItem();
				String makeCheck = (String)cbMake.getSelectedItem();
				String modelCheck = (String)cbModel.getSelectedItem();
				String doorCheck = (String)cbDoors.getSelectedItem();
				Boolean selectionCheck = false;
				switch (count) {
					case 1:
						if (colorCheck.equalsIgnoreCase("Select Color")) {
							sysMsg.getErrMsg("err");
						} else {
							newCar.setColor(colorCheck);
							if (makeCheck.equalsIgnoreCase("select make")) {
								sysMsg.getErrMsg("err");
							} else {
								newCar.setMake(makeCheck);
								if (modelCheck.equalsIgnoreCase("select model")) {
									sysMsg.getErrMsg("err");
								} else {
									newCar.setModel(modelCheck);
									if (doorCheck.equalsIgnoreCase("Select # Doors")) {
										sysMsg.getErrMsg("err");
									} else {
										newCar.setDoorCount(doorCheck);
										lblFirstOrder.setText(newCar.getColor() + " "  + cbDoors.getSelectedItem() + 
												" "  + cbMake.getSelectedItem() + " "  + cbModel.getSelectedItem());
										newCar.setImg((String) cbColor.getSelectedItem());
										lblFirstCarImg.setIcon(newCar.getImg());
										resetSelectionPane();
										selectionCheck = true;
									}
								}
							}
						}
						break;
					case 2:
						if (colorCheck.equalsIgnoreCase("Select Color")) {
							sysMsg.getErrMsg("err");
						} else {
							newCar.setColor(colorCheck);
							if (makeCheck.equalsIgnoreCase("select make")) {
								sysMsg.getErrMsg("err");
							} else {
								newCar.setMake(makeCheck);
								if (modelCheck.equalsIgnoreCase("select model")) {
									sysMsg.getErrMsg("err");
								} else {
									newCar.setModel(modelCheck);
									if (doorCheck.equalsIgnoreCase("Select # Doors")) {
										sysMsg.getErrMsg("err");
									} else {
										lblSecondOrder.setText(newCar.getColor() + " "  + cbDoors.getSelectedItem() + 
												" "  + cbMake.getSelectedItem() + " "  + cbModel.getSelectedItem());
										newCar.setImg((String) cbColor.getSelectedItem());
										lblSecondCarImg.setIcon(newCar.getImg());
										resetSelectionPane();
										selectionCheck = true;
									}
								}
							}
						}
						break;
					case 3:
						if (colorCheck.equalsIgnoreCase("Select Color")) {
							sysMsg.getErrMsg("err");
						} else {
							newCar.setColor(colorCheck);
							if (makeCheck.equalsIgnoreCase("select make")) {
								sysMsg.getErrMsg("err");
							} else {
								newCar.setMake(makeCheck);
								if (modelCheck.equalsIgnoreCase("select model")) {
									sysMsg.getErrMsg("err");
								} else {
									newCar.setModel(modelCheck);
									if (doorCheck.equalsIgnoreCase("Select # Doors")) {
										sysMsg.getErrMsg("err");
									} else {
										lblThirdOrder.setText(newCar.getColor() + " " + cbDoors.getSelectedItem() + 
												" "  + cbMake.getSelectedItem() + " "  + cbModel.getSelectedItem());
										newCar.setImg((String) cbColor.getSelectedItem());
										lblThirdCarImg.setIcon(newCar.getImg());
										resetSelectionPane();
										cbMake.setEnabled(false);
										cbModel.setEnabled(false);
										cbColor.setEnabled(false);
										cbDoors.setEnabled(false);
										btnAddToOrder.setEnabled(false);
										selectionCheck = false;
									}
								}
							}
						}
						break;
					default:
						
						break;
				}
				if (selectionCheck == true) {
					count++;
					pnCarAttributes.setBorder(new TitledBorder(null, "Car " + count, TitledBorder.LEADING, TitledBorder.TOP, null, null));
				}
				
				
			}
		});
		
		cbMake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				newCar.setModelOptions((String) cbMake.getSelectedItem());
				cbModel.setModel(new DefaultComboBoxModel(newCar.getModelOptions()));
				
			}
		});
		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetOrderDetailsPane();
				resetSelectionPane();
			}
		});
		
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblThirdOrder.getText().isBlank()) {
					sysMsg.getErrMsg("orderErr");
				} else if (sysMsg.getOrderMessage(carCount) == true) {
					resetOrderDetailsPane();
					resetSelectionPane();
					pnOrderDetails.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), 
							new Color(160, 160, 160)), "Order " + orderCount + " Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
					orderCount++;
					carCount *= 2;
				} else {
					sysMsg.getOutroMsg(carCount);
				}
			}
		});
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e){
			       sysMsg.getCloseMsg(carCount-3);
			 }
		});
		
		mntmResetOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetOrderDetailsPane();
				resetSelectionPane();
			}
		});
		
		mntmResetProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetOrderDetailsPane();
				resetSelectionPane();
				carCount = 3;
				orderCount = 1;
				pnOrderDetails.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), 
						new Color(160, 160, 160)), "Order " + orderCount + " Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			}
		});
		
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sysMsg.getCloseMsg(carCount-3);
			}
		});
		
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sysMsg.getAboutMsg();
			}
		});
	}
	
	////////////////////////////////////
	// method to reset order pane
	//////////////////////////////////
	private void resetOrderDetailsPane() {
		lblFirstOrder.setText("");
		lblFirstCarImg.setIcon(null);
		lblSecondOrder.setText("");
		lblSecondCarImg.setIcon(null);
		lblThirdOrder.setText("");
		lblThirdCarImg.setIcon(null);
		count = 1;
		pnCarAttributes.setBorder(new TitledBorder(null, "Car " + count, TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}
	
	////////////////////////////////////
	// method to reset selection pane
	//////////////////////////////////
	private void resetSelectionPane() {
		
		cbMake.setModel(new DefaultComboBoxModel(newCar.getMakeOptions()));
		cbModel.setModel(new DefaultComboBoxModel(new String[] {"Select Model"}));
		cbColor.setModel(new DefaultComboBoxModel(newCar.getColorOptions()));
		cbDoors.setModel(new DefaultComboBoxModel(new String[] {"Select # Doors", "Two Door", "Four Door"}));
		cbMake.setEnabled(true);
		cbModel.setEnabled(true);
		cbColor.setEnabled(true);
		cbDoors.setEnabled(true);
		btnAddToOrder.setEnabled(true);
		
	}
}
