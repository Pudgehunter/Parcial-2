package model;

import processing.core.PApplet;

public class Sanas extends Bolas{
	public Sanas(PApplet app){
		super(app);
	}
	
	public void dibujarBolas() {
		this.r = 0;
		this.g = 255;
		this.b = 0;
		app.fill(r,g,b);
		app.ellipse(posX, posY, tam, tam);
		this.soyInfectado = false;
	}
}