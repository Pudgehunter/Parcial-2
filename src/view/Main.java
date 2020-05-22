package view;

import control.Control;
import processing.core.PApplet;

public class Main extends PApplet {

	//Control
	Control controler;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("view.Main");
	}
	
	public void settings() {
		size(500,500);
	}
	
	public void setup() {
		this.controler = new Control(this);
	}
	public void draw() {
		background(255);
		this.controler.CreateFigures();
		this.controler.syso();
	}

}
