/** 
 *  @author Jack Zhao
 */




public class Board {
	public static int N = 8;
	public static boolean[][] booleanPieces= new boolean[N][N]; //allocate space
	public static boolean booleanTurn, booleanSelect, booleanMove, booleanCapture, booleanValidmove;
    public static Piece[][] pieces = new Piece[N][N];
    public static Piece nowPiece;


    private static void drawBoard(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((i + j) % 2 == 0) StdDrawPlus.setPenColor(StdDrawPlus.GRAY);
                else                  StdDrawPlus.setPenColor(StdDrawPlus.RED);
                StdDrawPlus.filledSquare(i + .5, j + .5, .5);
                StdDrawPlus.setPenColor(StdDrawPlus.WHITE);
            }
        }
    }

    private void testBoard(){
    	System.out.println("right1");
    	System.out.println(this.pieces[0][0].type);
    	if (this.booleanPieces[1][1]) {
    		System.out.println("right2");
    	}

    	System.out.println(pieces[2][1].type);
    	int i = (pieces[0][0]).x;
    	System.out.println(i);
    }

    public Board(boolean shouldBeEmpty) { ///really important, constructor not need type define 
    	//int N = 8;
    	//boolean[][] booleanPieces = new boolean[N][N]; 
        //Piece[][] pieces = new Piece[N][N];
        for (int i = 0; i < 8; i += 1) { 
            for (int j = 0; j < 8; j += 1) {
                booleanPieces[i][j] = true; ////still bug
            }
        }

        for (int i = 0; i < 8; i++) { 
            for (int j = 0; j < 8; j++) {
                pieces[i][j] = new Piece(false, null, i, j, "noType"+ i);
                System.out.println((pieces[i][j]).x + " " + (pieces[i][j]).y);
            }
        }


    	if (shouldBeEmpty) {
    		// int N = 8;
        	StdDrawPlus.setXscale(0, N); 
        	StdDrawPlus.setYscale(0, N);
            drawBoard(N);
    	} 

    	else {
    		// int N = 8;
        	StdDrawPlus.setXscale(0, N); 
        	StdDrawPlus.setYscale(0, N);
            drawBoard(N);

			for (int i = 0; i < N - 1; i += 2 ) {
            	StdDrawPlus.picture(i + .5, 0 + .5, "img/pawn-fire.png", 1, 1);

            	}
            for (int i = 1; i < N ; i += 2 ) {
              	StdDrawPlus.picture(i + .5, 1 + .5, "img/shield-fire.png", 1, 1); 
              	}
         	for (int i = 0; i < N-1; i += 2 ) {
                StdDrawPlus.picture(i + .5, 2 + .5, "img/bomb-fire.png", 1, 1);
                //booleanPieces[i][2] = true;
                //pieces[i][2].isFire = true;
                //pieces[i][2].type = "bomb";
              	}
            for (int i = 1; i < N; i += 2 ) {
                StdDrawPlus.picture(i + .5, N - 1 + .5, "img/pawn-water.png", 1, 1);
                //booleanPieces[i][N - 1] = true;
                //pieces[i][N - 1].isFire = false;
                //pieces[i][N - 1].type = "pawn";
               	}
            for (int i = 0; i < N - 1; i += 2 ) {
               	StdDrawPlus.picture(i + .5, N - 2 + .5, "img/shield-water.png", 1, 1);
                //booleanPieces[i][N - 2] = true;
                //pieces[i][N - 2].isFire = false;
                //pieces[i][N - 2].type = "shield";                
               	}
            for (int i = 1; i < N; i += 2 ) {
               	StdDrawPlus.picture(i + .5, N - 3 + .5, "img/bomb-water.png", 1, 1);
                //booleanPieces[i][N - 3] = true;
                //pieces[i][N - 3].isFire = false;
                //pieces[i][N - 3].type = "bomb";
               	}
        }
    }

    /* Gets the piece at position (x, y) on the board, 
     * or null if there is no piece. 
     * If (x, y) are out of bounds, returns null.
     */
    public static Piece pieceAt(int x, int y) { //// not sure
    	int N  = 8;
        if (!(((x >= 0) && (x <= 7)) && (y >= 0) && (y <= 7)))
        return null;
        if (booleanPieces[x][y]) 
            return pieces[x][y];
        else return null;
    }


    public void place(Piece p, int x, int y) { //// how to decide p == null
        if (!(((x >= 0) && (x <= 7)) && (y >= 0) && (y <= 7)))
            return ;
        booleanPieces[x][y] = true;
        pieces[x][y].isFire = p.isFire;
        pieces[x][y].x = x;
        pieces[x][y].y = y;
        pieces[x][y].b = p.b;
        pieces[x][y].type = p.type;
    }    
    /*  Returns true if the square at (x, y) can be selected */
    public boolean canSelect(int x, int y) {
        if ((booleanPieces[x][y] == true) && (booleanTurn == true)) {
            if (!booleanSelect)
                return true;
            else if (!booleanMove)
                return true;
        }
        if (!booleanPieces[x][y]) {
            if (booleanSelect && (!booleanMove) && (booleanValidmove))
                return true;
            else if (booleanSelect && booleanCapture) {
                return this.canSelect(x,y);
            }

        }
        return false;
    }


    public Piece remove(int x, int y) {
        if (!(((x >= 0) && (x <= 7)) && (y >= 0) && (y <= 7))) {
        	System.out.println("Out of bound");
        	return null;
        }
        if (!booleanPieces[x][y]) {
        	System.out.println("No piece at (x, y)");
        	return null;
        }
        else {
        	booleanPieces[x][y] = false;
        	return pieces[x][y];
        }
    }

    public boolean canEndTurn() {
        if (booleanMove || nowPiece.hasCaptured()) {
            return true;
        }
        return false;
    }

    public void endTurn() {
        booleanTurn = !booleanTurn;
        booleanMove = !booleanMove;
        booleanSelect = ! booleanSelect;
        booleanValidmove = !booleanValidmove;
        booleanCapture = !booleanCapture;
    }

    public String winner() {
        int fireNumber = 0;
        int waterNumber = 0;
        for (int i = 0; i < 8; i += 1) {
            for (int j = 0; j < 8; j += 1) {
                if (booleanPieces[i][j]) {
                    if (pieces[i][j].isFire == true)
                        fireNumber += 1;
                    else waterNumber += 1;
                }
            }
        }
        if (fireNumber == 0)
            return "Water";
        if (waterNumber == 0)
            return "Fire";
        return null;
    }    

    public static void main(String[] args) {
        int N = 8;
        booleanTurn = true; //// not sure;
        booleanSelect = true;
        booleanMove = true;
        booleanValidmove = false;
        booleanCapture = false;
        //boolean[][] booleanPieces = new boolean[N][N]; 
        //Piece[][] pieces = new Piece[N][N];
        /*for (int i = 0; i < 8; i += 1) { 
            for (int j = 0; j < 8; j += 1) {
                booleanPieces[i][j] = true; ////still bug
            }
        }*/

        /*if (booleanPieces[0][0]) {
        	System.out.println("Right");
        }*/

        Piece p;
        Board b = new Board(false);
        if (b.booleanPieces[0][0]) {
        	System.out.println("right3");
        }
        /*for (int i = 0; i < 8; i++) { 
            for (int j = 0; j < 8; j++) {
                pieces[i][j] = new Piece(false, b, i, j, "noType"+ i);
                System.out.println((pieces[i][j]).x + " " + (pieces[i][j]).y);
            }
        }*/
      //  System.out.println((b.pieces[0][0]).x);
        //System.out.println(pieces[2][1].type);

        b.testBoard();


        System.out.println((b.pieceAt(0, 0)).type);



    
        /* 对于全局变量 可以在main中初始化，这样就全局有效了*/
            
    }
}



