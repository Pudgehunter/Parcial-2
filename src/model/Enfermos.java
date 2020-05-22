package model;

import processing.core.PApplet;

public class Enfermos extends Bolas{
	public Enfermos(PApplet app){
		super(app);
	}
	
	public void dibujarBolas() {
		this.r = 255;
		this.g = 0;
		this.b = 0;
		app.fill(r,g,b);
		app.ellipse(posX, posY, tam, tam);
		this.soyInfectado = true;
	}
}
