package model;

import processing.core.PApplet;

public class Bolas implements Runnable {

	private int posX,posY,velX,velY,dirX,dirY,r,g,b,tam;
	private PApplet app;
	public Bolas(PApplet app) {
		this.app = app;
		this.posX = (int) app.random(50,350);
		this.posY = (int) app.random(50,350);
		this.velX = (int) app.random(-2,3);
		this.velY = (int) app.random(-2,3);
		this.dirX = (int) app.random(-1,2);
		this.dirY = (int) app.random(-1,2);
		//El problema dice que quiere las bolas de 7pixeles
		this.tam = 7;
		this.r = 255;
		this.g = 0;
		this.b = 0;
	}
	
	//Metodos
	
	//Aquí estoy pintando las bolas
	public void dibujarBolas() {
		app.fill(r,g,b);
		app.ellipse(posX, posY, tam, tam);
	}
	public void mover() {
		this.posX = posX + velX*dirX;
		this.posY = posY + velY*dirY;
		//Aca estoy poniendo que si la direccion es 0, que me los ponga 1 para que no se queden quietos
		if(dirX == 0 || dirY == 0) {
			dirX = 1;
			dirY = 1;
		}
		//Aca estoy poniendo lo mismo, pero pues la velocidad si los dos estan en 0, prefiero que se mueva a esta velocidad.
		if(velX == 0 && velY == 0) {
			velX = 2;
			velY = 1;
		}
		//Aqui estoy diciendo que si llega al lienzo que reboten xd, Mi lienzo va ser 500(Horizontal) x 400(Vertical)
		if(posX >= 500 || posX <= 0) {
			this.dirX = this.dirX*-1;
		}
		if(posY >= 400 || posY <= 0) {
			this.dirY = this.dirY*-1;
		}
	}
	public void run() {
		mover();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
