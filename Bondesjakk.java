public class Bondesjakk extends EasyGraphics {
	public static void main(String[] args){
		launch(args);
	}

	int HEIGHT = 600;
	int WIDTH = 600;
	int RADIUS = (WIDTH/6);

	public void run(){
		makeWindow("Bondesjakk", WIDTH, HEIGHT);

		drawLine((WIDTH/3),0,(WIDTH/3),HEIGHT);
		drawLine((WIDTH/3)+1,0,(WIDTH/3)+1,HEIGHT);
		drawLine((WIDTH/3*2),0,WIDTH/3*2,HEIGHT);
		drawLine((WIDTH/3*2)+1,0,(WIDTH/3*2)+1,HEIGHT);

		drawLine(0,(HEIGHT/3),WIDTH,(HEIGHT/3));
		drawLine(0,(HEIGHT/3*2),WIDTH,(HEIGHT/3*2));
		drawLine(0,(HEIGHT/3)+1,WIDTH,(HEIGHT/3)+1);
		drawLine(0,(HEIGHT/3*2)+1,WIDTH,(HEIGHT/3*2)+1);

		// X plasseringer for valg.
		int lX = (WIDTH/3)-RADIUS;
		int mX = ((WIDTH/3)+(WIDTH/3) - RADIUS);
		int rX = ((WIDTH)- RADIUS);
		// Y plassering for valg.
		int tY = (HEIGHT/3)-RADIUS;
		int mY = ((HEIGHT/3)+(HEIGHT/3) - RADIUS);
		int bY = (HEIGHT - RADIUS);

		

		int[][] valg = {
			{0, 0, 0},	// 0 er uvalgt, 1 er rød og 2 er blå.
			{0, 0, 0},
			{0, 0, 0}
		};

		drawString("1", lX, tY);
		drawString("2", mX, tY);
		drawString("3", rX, tY);
		drawString("4", lX, mY);
		drawString("5", mX, mY);
		drawString("6", rX, mY);
		drawString("7", lX, bY);
		drawString("8", mX, bY);
		drawString("9", rX, bY);

		boolean winner = false;
		int redPlayer = 1;

		while (!winner){

			int first;
			try {
			first = Integer.parseInt( getText("velg possisjon: [1-9]"));
			} catch(Exception e) {
				System.out.println("ERROR! " + e);
				first = 0;
			}

		switch(first){
			case 1:
				if(valg[0][0] == 0){
				spillerAktivitet(redPlayer, lX, tY);
				valg[0][0] = redPlayer;
				} else { 
					if ( redPlayer == 1){
						redPlayer = 2;
					} else {
						redPlayer = 1 ;
					}
				 }
				break;
			case 2:
				if(valg[0][1] == 0){
				spillerAktivitet(redPlayer, mX, tY);
				valg[0][1] = redPlayer;
				} else { 
					if ( redPlayer == 1){
						redPlayer = 2;
					} else {
						redPlayer = 1 ;
					}
				 }
				break;
			case 3:
				if(valg[0][2] == 0){
				spillerAktivitet(redPlayer, rX, tY);
				valg[0][2] = redPlayer;
				} else { 
					if ( redPlayer == 1){
						redPlayer = 2;
					} else {
						redPlayer = 1 ;
					}
				 }
				break;
			case 4:
				if(valg[1][0] == 0){
				spillerAktivitet(redPlayer, lX, mY);
				valg[1][0] = redPlayer;
				} else { 
					if ( redPlayer == 1){
						redPlayer = 2;
					} else {
						redPlayer = 1 ;
					}
				 }
				break;
			case 5:
				if(valg[1][1] == 0){
				spillerAktivitet(redPlayer, mX, mY);
				valg[1][1] = redPlayer;
				} else { 
					if ( redPlayer == 1){
						redPlayer = 2;
					} else {
						redPlayer = 1 ;
					}
				 }
				break;
			case 6:
				if(valg[1][2] == 0){
				spillerAktivitet(redPlayer, rX, mY);
				valg[1][2] = redPlayer;
				} else { 
					if ( redPlayer == 1){
						redPlayer = 2;
					} else {
						redPlayer = 1 ;
					}
				 }
				break;
			case 7:
				if(valg[2][0] == 0){
				spillerAktivitet(redPlayer, lX, bY);
				valg[2][0] = redPlayer;
				} else { 
					if ( redPlayer == 1){
						redPlayer = 2;
					} else {
						redPlayer = 1 ;
					}
				 }
				break;
			case 8:
				if(valg[2][1] == 0){
				spillerAktivitet(redPlayer, mX, bY);
				valg[2][1] = redPlayer;
				} else { 
					if ( redPlayer == 1){
						redPlayer = 2;
					} else {
						redPlayer = 1 ;
					}
				 }
				break;
			case 9:
				if(valg[2][2] == 0){
				spillerAktivitet(redPlayer, rX, bY);
				valg[2][2] = redPlayer;
				} else { 
					if ( redPlayer == 1){
						redPlayer = 2;
					} else {
						redPlayer = 1 ;
					}
				 }
				break;
			default:
				System.out.println("Du må velge mellom 1-9");

		}
		if (sjekke(valg)){
			fillCircle(WIDTH/2, HEIGHT/2, WIDTH/2);
			winner = true;
		}

		if (redPlayer == 1) {
			redPlayer = 2;
		} else if (redPlayer ==2) {
			redPlayer = 1;
		}
		
	 }



	}

	public void spillerAktivitet(int redPlayer, int x, int y){
		if (redPlayer == 1) {
			setColor(255,0,0);
			fillCircle(x,y,RADIUS);
			//
		} else if (redPlayer == 2) {
			setColor(0,0,255);
			fillCircle(x,y,RADIUS);
			//
			//
		}
	}

	public boolean sjekke(int[][] arr){
			if (arr[0][0] == arr[1][1] && arr[2][2] == arr[1][1] && arr[0][0] > 0) {
				return true;
			} else if (arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0] && arr[0][2] > 0){
				return true;
			} else if (arr[0][0] == arr[0][1] && arr[0][1] == arr[0][2] && arr[0][2] > 0){
				return true;
			} else if (arr[1][0] == arr[1][1] && arr[1][1] == arr[1][2] && arr[1][2] > 0){
				return true;
			} else if (arr[2][0] == arr[2][1] && arr[2][1] == arr[2][2] && arr[2][2] > 0){
				return true;
			} else if (arr[0][0] == arr[1][0] && arr[1][0] == arr[2][0] && arr[2][0] > 0){
				return true;
			} else if (arr[0][1] == arr[1][1] && arr[1][1] == arr[2][1] && arr[2][1] > 0){
				return true;
			} else if (arr[0][2] == arr[1][2] && arr[1][2] == arr[2][2] && arr[2][2] > 0) {
				return true;
			} else {
				return false;
			}
	}
}


	
