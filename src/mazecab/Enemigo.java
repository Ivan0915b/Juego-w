package mazecab;

import java.awt.Color;
import java.awt.Graphics;

public class Enemigo {
    int x = 0; // Posición X
    int y = 0; // Posición Y
    int ancho = 40;
    int alto = 40;
    
    //constructor de posicion del enemigo
    public Enemigo(int x, int y) {
    	this.x = x;
    	this.y = y;
    	
    }
    

    public void paint(Graphics grafico) {
        grafico.setColor(Color.red); // Color del enemigo
        grafico.fillOval(x, y, ancho, alto); // Dibuja el enemigo
    }

    public boolean colisiona(int personajeX, int personajeY) {
        return (personajeX < x + ancho && personajeX + 40 > x && personajeY < y + alto && personajeY + 40 > y);
    }
}