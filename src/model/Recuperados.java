package model;

import processing.core.PApplet;

public class Recuperados extends Bolas{
	public Recuperados(PApplet app){
		super(app);
	}
	
	public void dibujarBolas() {
		this.r = 100;
		this.g = 100;
		this.b = 100;
		app.fill(r,g,b);
		app.ellipse(posX, posY, tam, tam);
		this.soyInfectado = true;
	}
}