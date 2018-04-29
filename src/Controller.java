import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements MouseListener{
	private int pitW;
	private int pitH;
	private int mancalaW;
	private int mancalaH;
	private DataModel model;
	
	
	public Controller(int pitW, int pitH, int mancalaW, int mancalaH, DataModel model) {
		this.pitW = pitW;
		this.pitH = pitH;
		this.mancalaH = mancalaH;
		this.mancalaW = mancalaW;
		this.model = model;
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		int x = e.getX();
		int y = e.getY();
		if(x<mancalaW) {
			return;
		}
		int a = (x - mancalaW)/pitW;
		if(a >= 6) {
			return;
		}
		if(y > pitH) {
			model.takingTurn(a);
		}else {
			model.takingTurn(12-a);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
