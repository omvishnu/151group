
public class DataModel {
	private int spots[];

	private String playerTurn;

	public DataModel() {
		spots = new int[14];

		playerTurn = "playerA";
		for (int i = 0; i < 14; i++) {
			spots[i] = 4;
		}
		spots[6] = 0;
		spots[13] = 0;
	}

	public int movingStone(int position) {
		int hand = spots[position];
		spots[position] = 0;
		while (hand != 0) {
			position++;
			if (position > 13) {
				position = 0;
			}
			// skip mancala of player A when it's B's turn
			if (position == 6 && playerTurn.equals("playerB")) {
				continue;
			}
			// skip mancala of player B when it's A's turn
			if (position == 13 && playerTurn.equals("playerA")) {
				continue;
			}
			spots[position] += 1;

			hand--;

		}
		if (spots[position] > 1 && position != 6 && position !=13) {
			return movingStone(position);
		}
		return position;
	}

	public void takingTurn(int position) {

		int lastPosition = movingStone(position);
//checking for player turn, and switch it
		if (lastPosition != 13 && playerTurn.equals("playerB")) {
			playerTurn = "playerA";
			return;
		}

		if (lastPosition != 6 && playerTurn.equals("playerA")) {
			playerTurn = "playerB";
			return;
		}

	}
	
	public void Print() {
		for(int i = 0; i < 14; i++) {
			System.out.println(i+" "+ spots[i]);
		}
		System.out.println(playerTurn);
	}
	//this is just temporary to check the logic
	public static void main(String[] args) {
		DataModel d = new DataModel();
		d.Print();
		d.takingTurn(2);
		d.Print();
		d.takingTurn(11);
		d.Print();
				
	}
}
