package control;

import model.Logic;
import processing.core.PApplet;

public class Control {
	PApplet app;
	private Logic logica;
	
	public Control(PApplet app) {
		this.app = app;
		this.logica = new Logic(app);
	}
	
	public void CreateFigures() {
		logica.drawHumans();
	}

}
