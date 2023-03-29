/*
Name: Erik Wilhelm
Project: Enhancement 2 DATA STRUCTURES AND ALGORITHMS
Class Origin: CS250
Last Modified 03/21/2023
Description: THIS WAS MY FINAL PROJECT FOR CS250 IT WAS
A PROJECT TO CREATE A "GUI" INTERFACE FOR A TRAVEL COMPANY THAT 
WOULD SCROLL THROUGH SPECIFIED VACATION LOCATIONS.
Enhancements: UPDATED SOFTWARE TO CURRENT RELEASE,
ADDED TO READABILITY AND SECURITY USING COMMENTS
CORRECTED WINDOW TO SCROLL THROUGH BUTTONS "NEXT" AND "PREVIOUS"
"MODERNIZED" WINDOW APPEARANCE 
UPDATED IMAGES AND INITIALIZED FILE STRUCTURE FOR
REFERENCE FOLDER AND CORRECTED PATHING
 */




//import java development packages
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;


public class Slide_Show_Enhancement2 extends JFrame {

	private static final long serialVersionUID = 1L;//THIS LINE WAS ADDED TO SUPRESS SERIALIZATION WARNING
													//CAUSED AT COMPILATION THIS IS CAUSED BECAUSE JFRAME IS SERIALIZABLE
	
	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JButton btnSite; //added button for browsing to selected hyperlink
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public Slide_Show_Enhancement2() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables from declared variable list to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		//edit text block color to make window more readable and user friendly
		textPane.setBackground(Color.LIGHT_GRAY);//i learned that if you are not sure what colors are available you can right click select open declaration and shows the class and variables
		textPane.setBounds(5, 470, 790, 50);
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton(); //swing button function to go back to a previous slide
		btnNext = new JButton(); //swing button function to advance to next slide
		btnSite = new JButton(); //creates the button to be placed on the pane
		lblSlide = new JLabel(); //creates the slide or frame object
		lblTextArea = new JLabel(); //creates are on slide for text

		//Setup frame attributes
		setSize(800, 600);//creates the frame of size 800 pixel wide by 600 tall
		setLocationRelativeTo(null); //if you had a specific location to enter you can place it here - useful if building web page or multi window application
		//SET TITLE FOR JFRAME, THE OUTERMOST WINDOW
		setTitle("                                     Top 5 Destinations Slide_Show_Enhancement2 - Image Credits_https://destinationdeluxe.com/top-10-wellness-retreats/");//i could not find a straight forward way to center so i used spaces
		getContentPane().setLayout(new BorderLayout(10, 50)); //places the "window pane" onto the frame building it like a layered cake
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//closes frame and window when object is selected

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
			for (int i = 1; i <= 5; i++) { //CREATES A LOOP SAYING THAT I=1 AND WILL LOOP THRU VALUE PROVIDED IN THIS CASE 5 AND i++ INCREMENTS
			lblSlide = new JLabel(); //creates the next pane or slide using Jlabel constructor
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);//places border at the center of the frame (right click CENTER for options)
		getContentPane().add(textPane, BorderLayout.NORTH); //places text at the top of the frame (right click SOUTH to open declaration for options)

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));//locates the buttons on the frame first number is horizontal and second is vertical placement
		
		//defines previous button text
		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);
		//concludes previous button action and naming
		
		//defines next button text	
		btnNext.setText("No Thanks");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);
		//concludes next button action and naming
		
		//defines web link button action and text	
		btnSite.setText("YES Please!");
		btnSite.addActionListener(new ActionListener() {

			//action method to open desktop browser and navigate to specified site
			public void actionPerformed(ActionEvent e) {
				/*portions of this method were learned from https://www.youtube.com/watch?v=BqwAvw2GgUU care of Alamgir Hossain
				this is the portion that I had to research originally i was getting an error that the .browse type was not allowed
				while researching this error i found it was very commonplace and that there were several ways to get it to work
				using a try and catch exception method was the most common correction and I found this to be the most concise and applicable to my 
				situation. this works by providing the variable information within the method rather than navigate to it and get stuck*/
				try {
					String myurl = "https://destinationdeluxe.com/top-10-wellness-retreats/"; //creates a variable called myurl and provides site as value - credit to this site is provided above
					
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(myurl)); //getter to navigate to native desktop browser and go to myurl variable location
				}
				catch (Exception e2) {  //catch must accompany the try in the method and will provide the exception as identified
					e2.printStackTrace();
				}
			}
		});
		buttonPane.add(btnSite);
		//concludes go to link action and naming
		
		
		
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 * provides to go to previous card or slide pane
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 * provides to go to next card or slide pane
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 * 
	 * Image credits for enhancement 2 Tang, V. (2018, December 28). Top 10 Wellness Retreats in the World. Destination Deluxe. 
	 * https://destinationdeluxe.com/top-10-wellness-retreats/ (Ranked destinations 1,5,6,9,10)
	 */
	private String getResizeIcon(int i) {
		String image = ""; 
		if (i==1){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Destination_1.jpg") + "'</body></html>";
		} else if (i==2){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Destination_2.jpg") + "'</body></html>";
		} else if (i==3){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Destination_3.jpg") + "'</body></html>";
		} else if (i==4){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Destination_4.jpg") + "'</body></html>";
		} else if (i==5){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Destination_5.jpg") + "'</body></html>";
		}
		return image;
	}
	
	/**
	 * Method to get the text values
	 * this provides description for each slide
	 */
	private String getTextDescription(int i) {
		String text = ""; 
		if (i==1){
			text = "<html><body><font size='5'>#1 Kamalaya, Koh Samui, Thailand.</font> <br>Spa - World Renowned for Holostic Treaments and Ancient Chinese Medicine.</body></html>";
		} else if (i==2){
			text = "<html><body><font size='5'>#2 Amanpuri, Phuket, Thailand.</font> <br>Spa - Amanpuri focuses on three key programs such as Weight Management & Transformation, Detox & Cleansing, and Mindfulness & Stress Management.</body></html>";
		} else if (i==3){
			text = "<html><body><font size='5'>#3 Fivelements, Bali, Indonesia.</font> <br>Spa - A life-changing wellness program for rejuvenation, replenishment and alignment.</body></html>";
		} else if (i==4){
			text = "<html><body><font size='5'>#4 SHA Wellness Clinic, Alicante, Spain.</font> <br>Spa - The luxe wellness retreat combines Western medical expertise and ancient Eastern alternative therapies, alongside healthy nutrition.</body></html>";
		} else if (i==5){
			text = "<html><body><font size='5'>#5 Ananda in the Himalayas, Rishikesh, India.</font> <br>Spa - Ananda is possibly the most authentic Ayurvedic luxury wellness destination in India.</body></html>";
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 * main method to execute code as provided above
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				Slide_Show_Enhancement2 ss = new Slide_Show_Enhancement2();
				ss.setVisible(true);
			}
		});
	}
}









