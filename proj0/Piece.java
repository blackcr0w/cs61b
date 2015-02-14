/** 
 *  @author Jack Zhao
 */

public class Piece{

	public boolean captureFlag;
	public boolean isFire;
	public Board b;
	public int x, y;
	public String type;
	public static Piece nowPiece;


	public Piece(boolean isFire, Board b, int x, int y, String type) {
		this.isFire = isFire; //// not sure if should test isFire here
		this.b = b;
		this.x = x;
		this.y = y;
		this.type = type;
	}

	public boolean isFire() {
		if (this.isFire == true)
		return true;
		else return false;
	}

	public int side() {
		if (this.isFire == true)
		return 0;
		else return 1;
	}

	public boolean isKing() {
		if (((this.isFire) && (this.y == 7))||((!this.isFire) && (this.y == 0))) 
			return true;
		else return false;
	}

	public boolean isBomb() {
		if (this.type == "bomb")
			return true;
		else return false;
	}

	public boolean isShield() {
		if (this.type == "shield")
			return true;
		else return false;
	}

	/* public void move(int x, int y) { //// booleanPieces[][] and pieces[][] not modified ??
		int i = nowPiece.x;
		int j = nowPiece.y;
		booleanPieces[nowPiece.x][nowPiece.y] = false;
		nowPiece.x = x;
		nowPiece.y = y;
		booleanPieces[x][y] = true;
		pieces[x][y] = nowPiece;
		if (nowPiece.hasCaptured) {
			if (nowPiece.type != "bomb") {
				booleanPieces[(x + i) / 2][(y + j) / 2] = false;
			}
			else {
				for (int i0 = -1; i0 < 2; i0 += 1) {
					for (int j0 = -1; j0 < 2; J0 +=1) {
						booleanPieces[x + i0][y + j0] = false;
					}
				}
			}
		}


	}*/

	/* Returns whether or not this Piece has captured another piece this turn. */
	public boolean hasCaptured() { //// not sure
		if (true) 
			return true;
		else return false;
	}

	/* Called at the end of each turn on the Piece that moved. 
	 * Makes sure the piece's hasCaptured() value returns to false. */
	public void doneCapturing() { //// not sure 
		if (this.hasCaptured()) {
			captureFlag = false;
		}
	}
}