
import java.awt.Graphics;
import javax.swing.JPanel;

/*
 * maybe i should put all the pits and mancalas in an array,
 * and then initialize them
 */
public class View extends JPanel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int PIT_WIDTH; 
	private int PIT_HEIGHT;
	
	private int MANCALA_WIDTH; 
	private int MANCALA_HEIGHT;
	
	private int horizontalSpacer;
	private int verticalSpacer;
	private DataModel model;
	
	private int x;
	private int y; 
	
	public View () {
		
		PIT_WIDTH = (int) (1000*.12);
		PIT_HEIGHT = (int) (500*.5);
		
		MANCALA_WIDTH = (int) (1000*.14);
		MANCALA_HEIGHT = (int) (500*1);
		
		horizontalSpacer = (int) (1000*.00);
		verticalSpacer = (int) (500*.00);
		model = new DataModel(this);
		this.addMouseListener(new Controller(PIT_WIDTH, PIT_HEIGHT, MANCALA_WIDTH, MANCALA_HEIGHT, model));
	}
	

	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(model.getPlayer(), 500, 600);
		
		x = horizontalSpacer;
		y = verticalSpacer;
		
		PitIcon mancalaB = new PitIcon(MANCALA_WIDTH, MANCALA_HEIGHT);	
		mancalaB.setNumberOfStones(model.getSpot(13));
		mancalaB.paintIcon(this, g, x, y);
		x += horizontalSpacer + MANCALA_WIDTH;
		
		PitIcon B6 = new PitIcon(PIT_WIDTH, PIT_HEIGHT);
		B6.setNumberOfStones(model.getSpot(12));
		B6.paintIcon(this, g, x, y);
		x += horizontalSpacer + PIT_WIDTH;
		
		
		
		PitIcon B5 = new PitIcon(PIT_WIDTH, PIT_HEIGHT);
		B5.setNumberOfStones(model.getSpot(11));
		B5.paintIcon(this, g, x, y);
		x += horizontalSpacer + PIT_WIDTH;
		
		PitIcon B4 = new PitIcon(PIT_WIDTH, PIT_HEIGHT);
		B4.setNumberOfStones(model.getSpot(10));
		B4.paintIcon(this, g, x, y);
		x += horizontalSpacer + PIT_WIDTH;
		
		PitIcon B3 = new PitIcon(PIT_WIDTH, PIT_HEIGHT);
		B3.setNumberOfStones(model.getSpot(9));
		B3.paintIcon(this, g, x, y);
		x += horizontalSpacer + PIT_WIDTH;
		
		PitIcon B2 = new PitIcon(PIT_WIDTH, PIT_HEIGHT);
		B2.setNumberOfStones(model.getSpot(8));
		B2.paintIcon(this, g, x, y);
		x += horizontalSpacer + PIT_WIDTH;
		
		PitIcon B1 = new PitIcon(PIT_WIDTH, PIT_HEIGHT);
		B1.setNumberOfStones(model.getSpot(7));
		B1.paintIcon(this, g, x, y);
		x += horizontalSpacer + PIT_WIDTH;
		
		PitIcon mancalaA = new PitIcon(MANCALA_WIDTH, MANCALA_HEIGHT);
		mancalaA.setNumberOfStones(model.getSpot(6));
		mancalaA.paintIcon(this, g, x, y);
		x = 2*horizontalSpacer + MANCALA_WIDTH;
		y = 2*verticalSpacer + PIT_HEIGHT; 
		
		PitIcon A1 = new PitIcon(PIT_WIDTH, PIT_HEIGHT);
		A1.setNumberOfStones(model.getSpot(0));
		A1.paintIcon(this, g, x, y);
		x += horizontalSpacer + PIT_WIDTH;

		PitIcon A2 = new PitIcon(PIT_WIDTH, PIT_HEIGHT);
		A2.setNumberOfStones(model.getSpot(1));
		A2.paintIcon(this, g, x, y);
		x += horizontalSpacer + PIT_WIDTH;
		
		PitIcon A3 = new PitIcon(PIT_WIDTH, PIT_HEIGHT);
		A3.setNumberOfStones(model.getSpot(2));
		A3.paintIcon(this, g, x, y);
		x += horizontalSpacer + PIT_WIDTH;
		
		PitIcon A4 = new PitIcon(PIT_WIDTH, PIT_HEIGHT);
		A4.setNumberOfStones(model.getSpot(3));
		A4.paintIcon(this, g, x, y);
		x += horizontalSpacer + PIT_WIDTH;
		
		PitIcon A5 = new PitIcon(PIT_WIDTH, PIT_HEIGHT);
		A5.setNumberOfStones(model.getSpot(4));
		A5.paintIcon(this, g, x, y);
		x += horizontalSpacer + PIT_WIDTH;
		
		PitIcon A6 = new PitIcon(PIT_WIDTH, PIT_HEIGHT);
		A6.setNumberOfStones(model.getSpot(5));
		A6.paintIcon(this, g, x, y);
				
	}	
}
