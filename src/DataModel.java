
public class DataModel {
	private int spots[];

	private String playerTurn;
	private View v;

	public DataModel(View v) {
		spots = new int[14];
		this.v = v;
		playerTurn = "playerA";
		for (int i = 0; i < 14; i++) {
			spots[i] = 4;
		}
		spots[6] = 0;
		spots[13] = 0;
	}

	public int getSpot(int index) {
		return spots[index];
	}

	public String getPlayer() {

		return playerTurn;
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

		// checking and capturing the opponent stones
		if (spots[position] == 1) {
			if (playerTurn.equals("playerA") && position >= 0 && position < 6) {
				spots[6] += spots[position] + spots[12 - position];
				spots[12 - position] = 0;
				spots[position] = 0;
			}
			if (playerTurn.equals("playerB") && position >= 7 && position < 13) {
				spots[13] += spots[position] + spots[12 - position];
				spots[12 - position] = 0;
				spots[position] = 0;
			}
		}
		/*
		 * if we want to keep going like normal mancala if (spots[position] > 1 &&
		 * position != 6 && position != 13) { return movingStone(position); }
		 */
		return position;
	}

	public void takingTurn(int position) {
		if (playerTurn.equals("Game over")) {
			return;
		}
		if (playerTurn.equals("playerA") && position >= 6) {
			return;
		}
		if (playerTurn.equals("playerB") && (position >= 13 || position <= 6)) {
			return;
		}
		int lastPosition = movingStone(position);

		int numA = 0;
		int numB = 0;
		for (int i = 0; i < 6; i++) {
			numA += spots[i];
			numB += spots[i + 7];
		}
		if (numA == 0) {
			for (int i = 0; i < 6; i++) {
				spots[i + 7] = 0;
			}
			spots[13] += numB;
			playerTurn = "Game over";
			v.repaint();
			return;
		}
		if (numB == 0) {
			for (int i = 0; i < 6; i++) {
				spots[i] = 0;
			}
			spots[6] += numA;
			playerTurn = "Game over";
			v.repaint();
			return;
		}

		// checking for player turn, and switch it
		if (lastPosition != 13 && playerTurn.equals("playerB")) {
			playerTurn = "playerA";
			v.repaint();
			return;
		}

		if (lastPosition != 6 && playerTurn.equals("playerA")) {
			playerTurn = "playerB";
			v.repaint();
			return;
		}
		v.repaint();
	}

	public void Print() {
		for (int i = 0; i < 14; i++) {
			System.out.println(i + " " + spots[i]);
		}
		System.out.println(playerTurn);
	}
	// this is just temporary to check the logic

}
