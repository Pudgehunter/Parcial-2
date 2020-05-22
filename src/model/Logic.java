package model;

import java.util.LinkedList;

import processing.core.PApplet;

public class Logic {

	private PApplet app;
	private LinkedList<Bolas> bolas;
	private String[] virus;
	private int cantidadPersona;
	private boolean infectado;
	private int personasSanas;
	private int personasInfectadas;
	private int personasRecuperadas;
	
	public Logic(PApplet app) {
		this.app = app;
		this.bolas = new LinkedList<Bolas>();
		//import virus.txt
		this.virus = app.loadStrings("../Datos/virus.txt");
		this.infectado = false;
		//createHumans();
		cantidadHumanos();
	}
	public void cantidadHumanos() {
		for (int i = 0; i < virus.length; i++) {
			String[] virusPartidos = virus[i].split(":");
			int personasVirus = Integer.parseInt(virusPartidos[1]);
			//No sabia como hacer que las cosas se separen, entonces cree 3 clases nuevas hijas de las bolas para poder separarlo
			if(virusPartidos[0].contentEquals("sanas")) {
					int cantidadSanas = personasVirus;
					for (int j = 0; j < cantidadSanas; j++) {
						this.bolas.add(new Sanas(app));
					}
					//para que funcione afuera
					personasSanas = cantidadSanas;
			}
			if(virusPartidos[0].contentEquals("infectadas")) {
				int cantidadEnfermos = personasVirus;
				for (int j = 0; j < cantidadEnfermos; j++) {
					this.bolas.add(new Enfermos(app));
				}
				//para que funcione afuera
				personasInfectadas = cantidadEnfermos;
			}
			if(virusPartidos[0].contentEquals("recuperadas")) {
				int cantidadSanos = personasVirus;
				for (int j = 0; j < cantidadSanos; j++) {
					this.bolas.add(new Recuperados(app));
				}
				//para sacarlo
				personasRecuperadas = cantidadSanos;
			}
			this.cantidadPersona = personasSanas+personasInfectadas+personasRecuperadas;
		}
	}
	
	//crear humanos "prueba"
//	public void createHumans() {
//		for (int i = 0; i <= cantidadPersona; i++) {
//		this.bolas.add(new Sanas(app));
//		}
//	}
	
	//Aca estoy dibujandolos no más pero no hay ninguna acción aún.
	public void drawHumans() {
		for (int i = 0; i < cantidadPersona; i++) {
			new Thread(this.bolas.get(i)).start();
			this.bolas.get(i).dibujarBolas();
			
			for (int j = 0; j < cantidadPersona; j++) {
				//Conocer la distancia entre una bola y el otro... necesitaria los getters
				float humanosDistancia = PApplet.dist(bolas.get(i).getPosX(),
						bolas.get(i).getPosY(),
						bolas.get(j).getPosX(),
						bolas.get(j).getPosY());
				//Aca hago la magia de las distancias xd
				if(humanosDistancia >= 3) {
					//desde aqui se daña todo el codigo ._.
					bolas.get(i).setDirX(bolas.get(i).getDirX()*-1);
					bolas.get(i).setDirY(bolas.get(i).getDirY()*-1);
				}
			}
		}
	}
}
