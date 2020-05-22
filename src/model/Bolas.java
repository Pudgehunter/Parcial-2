package model;

import processing.core.PApplet;

public abstract class Bolas implements Runnable {

	protected int posX,posY,velX,velY,dirX,dirY,r,g,b,tam;
	protected PApplet app;
	protected boolean soyInfectado;
	
	public Bolas(PApplet app) {
		this.app = app;
		//El uno es para evitar ese bug raro que salen cuando salen en la posicion 0
		this.posX = (int) app.random(1,500);
		this.posY = (int) app.random(1,400);
		this.velX = (int) app.random(-2,3);
		this.velY = (int) app.random(-2,3);
		this.dirX = (int) app.random(-1,2);
		this.dirY = (int) app.random(-1,2);
		//El problema dice que quiere las bolas de 7pixeles
		this.tam = 7;
		this.r = 0;
		this.g = 255;
		this.b = 0;
	}
	
	//Metodos
	
	//Aquí estoy pintando las bolas
	public abstract void dibujarBolas();
	
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

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getDirX() {
		return dirX;
	}

	public void setDirX(int dirX) {
		this.dirX = dirX;
	}

	public int getDirY() {
		return dirY;
	}

	public void setDirY(int dirY) {
		this.dirY = dirY;
	}

	public boolean isSoyInfectado() {
		return soyInfectado;
	}

	public void setSoyInfectado(boolean soyInfectado) {
		this.soyInfectado = soyInfectado;
	}
	
	
	
}
