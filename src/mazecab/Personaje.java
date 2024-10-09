package mazecab;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class Personaje {
    Laberinto lab = new Laberinto();
    int x = 40;
    int y = 40;
    int ancho = 40;
    int alto = 40;
    int movimiento = 40;

    public void paint(Graphics grafico) {
        grafico.setColor(Color.blue);
        grafico.fillOval(x, y, ancho, alto);
        grafico.setColor(Color.black);
        grafico.drawOval(x, y, ancho, alto);

        // ojos
        grafico.setColor(Color.white);
        grafico.fillOval(x + 7, y + 8, 13, 13);
        grafico.fillOval(x + 21, y + 8, 13, 13);
        grafico.setColor(Color.black);
        grafico.fillOval(x + 11, y + 12, 5, 5);
        grafico.fillOval(x + 25, y + 12, 5, 5);

        // boca
        grafico.setColor(Color.black);
        grafico.fillOval(x + 7, y + 24, 27, 7);
    }

    public void teclaPresionada(KeyEvent evento) {
        int[][] laberinto = lab.obtieneLaberinto();

        if (evento.getKeyCode() == KeyEvent.VK_LEFT) { // Movimiento a la izquierda
            if (laberinto[y / 40][(x / 40) - 1] != 1) {
                x = x - movimiento;
            }
        }
        if (evento.getKeyCode() == KeyEvent.VK_RIGHT) { // Movimiento a la derecha
            if (laberinto[y / 40][(x / 40) + 1] != 1) {
                x = x + movimiento;
            }
        }
        if (evento.getKeyCode() == KeyEvent.VK_DOWN) { // Movimiento hacia abajo
            if (laberinto[(y / 40) + 1][x / 40] != 1) {
                y = y + movimiento;
            }
        }
        if (evento.getKeyCode() == KeyEvent.VK_UP) { // Movimiento hacia arriba
            if (laberinto[(y / 40) - 1][x / 40] != 1) {
                y = y - movimiento;
            }
        }

        // Si llega al final (la meta) en cualquier nivel
        if (x == 840 && y == 440) {
            if (Juego.nivel == 3) { // Si está en el nivel 3 y llega al final
                // Muestra el mensaje y cierra el juego
                JOptionPane.showMessageDialog(null, "¡Enhorabuena, lo has logrado!");
                System.exit(0);
            } else {
                // Cambia al siguiente nivel
                Juego.nivel++;
                // Reinicia la posición del personaje
                x = 40;
                y = 40;
            }
        }

        // Comprobación de hitbox con la pocion
        if (lab.pocion.colisiona(x, y)) {
            JOptionPane.showMessageDialog(null, "¡Has recogido una poción curativa!");
            // Aquí puedes incrementar la vida del personaje, por ejemplo
            // vida += 10; // Suponiendo que tienes una variable de vida
            // Reiniciar la posición de la poción
            lab.pocion.x = (int) (Math.random() * 20) * 40; // Reubicar aleatoriamente
            lab.pocion.y = (int) (Math.random() * 10) * 40; // Reubicar aleatoriamente
        }

        // Comprobación de hitbox con el enemigo
        if (lab.enemigo.colisiona(x, y)) {
            JOptionPane.showMessageDialog(null, "¡Has sido atrapado por un enemigo!");
            // Aquí puedes reducir la vida del personaje o terminar el juego
            System.exit(0);
        }
    }
}