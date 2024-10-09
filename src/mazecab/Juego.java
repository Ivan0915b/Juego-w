package mazecab;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Juego extends JPanel {
    private static final long serialVersionUID = 1L;
    Laberinto laberinto = new Laberinto();
    Personaje personaje = new Personaje();
    public static int nivel = 1;
    private boolean colisionDetectada = false; //bandera donde indica la colision

    public Juego() {
        addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {}

            public void keyPressed(KeyEvent e) {
                personaje.teclaPresionada(e);
            }

            public void keyReleased(KeyEvent e) {}

        });
        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics grafico) {
        // Llama al método paintComponent de JPanel para limpiar la pantalla
        super.paintComponent(grafico);
        
        // Repinta el laberinto y el personaje en cada frame
        laberinto.paint(grafico);
        personaje.paint(grafico);
        
        //Comprobacion de hitbpxes de los enemigos con el laberinto
        if (!colisionDetectada && laberinto.enemigo != null && laberinto.enemigo.colisiona(personaje.x, personaje.y)) {
        	colisionDetectada = true; //cambia el estado de la bandera
        	JOptionPane.showMessageDialog(null, "¡Has sido atrapado por un enemigo!");
        	//Si te atrapan, pierdes el juego
        	System.exit(0);
        	
        }
    }

    public static int cambiarNivel() {
        return nivel++;
    }

    public static int obtieneNivel() {
        return nivel;
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "¿Estás listo?");
        JFrame miVentana = new JFrame("Juego W");
        Juego game = new Juego();
        miVentana.add(game);
        miVentana.setSize(920, 540);
        miVentana.setLocation(300, 200);
        miVentana.setVisible(true);
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            game.repaint(); // Repinta todo en cada iteración para eliminar rastros

            // Si el nivel es mayor a 3, mostrar el mensaje y cerrar el juego
            if (obtieneNivel() > 3) {
                JOptionPane.showMessageDialog(null, "¡Enhorabuena, lo lograste!");
                System.exit(0);
            }
        }
    }
 }