package mazecab;

import java.awt.Color;
import java.awt.Graphics;

public class PocionCurativa {
    int x = 200; // Posición X
    int y = 200; // Posición Y
    int ancho = 20;
    int alto = 20;

    public void paint(Graphics grafico) {
        grafico.setColor(Color.green); // Color de la poción
        grafico.fillOval(x, y, ancho, alto); // Dibuja la poción
    }

    public boolean colisiona(int personajeX, int personajeY) {
        return (personajeX < x + ancho && personajeX + 40 > x && personajeY < y + alto && personajeY + 40 > y);
    }
}