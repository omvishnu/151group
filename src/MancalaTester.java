
import javax.swing.JFrame;
 class MancalaTester {
	public static void main(String[] args) {
		final int FRAME_WIDTH = 1000; 
		final int FRAME_HEIGHT = 700;
		
		
		JFrame frame = new JFrame("MANCALA BOARD"); 
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		
		View mancalaBoard = new View();
		frame.add(mancalaBoard);
		

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	
	}

}

