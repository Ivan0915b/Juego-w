package mazecab;
import java.awt.Color;
import java.awt.Graphics;

public class Laberinto {
	int[][]lab= new int [13][23];
	int fila = 0;
	int columna = 0;
	int numeroFilas=13;
	int numeroColumnas=23;
	int anchoBloque=40;
	int altoBloque= 40;
	PocionCurativa pocion = new PocionCurativa();
	Enemigo enemigo;
	
	
	public void paint(Graphics graficos) {	
		int [][]laberinto=obtieneLaberinto();
		
		for(fila=0;fila<numeroFilas;fila++) {
			for(columna=0;columna<numeroColumnas;columna++) {
			if(laberinto[fila][columna]==1) {
				if(Juego.obtieneNivel()==1){graficos.setColor(Color.darkGray);}
				if(Juego.obtieneNivel()==2){graficos.setColor(Color.pink);}
				if(Juego.obtieneNivel()>=3){graficos.setColor(Color.magenta);}
				
				graficos.fillRect(columna*40,fila*40,anchoBloque,altoBloque);
				graficos.setColor(Color.red);
				graficos.drawRect(columna*40,fila*40,anchoBloque,altoBloque);
			
			    }
			}
						
		}
		
		//Enemigo y pocion en la clase
		pocion.paint(graficos);
		if (enemigo != null) {
			enemigo.paint(graficos);
		}
		
		graficos.drawString("inicio", 5,62);
		graficos.drawString("Fin", 850, 462);
	}
	
	public int [][] obtieneLaberinto(){
		if(Juego.obtieneNivel()==1) {int laberinto[][]=
			{{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{ 1,0,0,1,0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0,1,1},
					{ 1,1,0,1,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,1,0,1,1},
					{ 1,1,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,1,0,1,1},
					{ 1,1,1,0,1,0,1,0,0,0,1,0,1,0,0,0,1,1,0,1,0,1,1},
					{ 1,1,0,0,1,0,1,0,1,1,1,0,1,0,1,0,0,0,0,1,0,1,1},
					{ 1,1,0,1,1,1,1,0,1,0,1,0,1,0,1,1,1,1,0,1,1,1,1},
					{ 1,1,0,1,0,0,0,0,1,0,0,0,1,0,0,1,1,1,0,1,0,1,1},
					{ 1,1,0,1,0,1,1,1,1,0,1,1,1,1,0,1,0,1,0,1,0,1,1},
					{ 1,1,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,1,0,1,1},
					{ 1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,1},
					{ 1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1},
					{ 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
			                        lab=laberinto;
			                        enemigo = new Enemigo (600, 40);//Coordenadas del enemigo
		}
		if(Juego.obtieneNivel()==2) {
			int laberinto[][]=
				{{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{ 1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
				{ 1,1,1,0,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1,1},
				{ 1,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,1,1},
				{ 1,1,0,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1},
				{ 1,1,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,1,1},
				{ 1,1,1,0,1,0,1,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1,1},
				{ 1,1,0,0,1,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,0,1,1},
				{ 1,1,0,1,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,0,1,1},
				{ 1,1,0,1,0,0,0,0,1,0,1,0,0,1,0,0,0,0,0,1,0,1,1},
				{ 1,1,0,1,0,1,1,1,1,1,1,1,0,1,1,1,0,1,0,1,1,1,1},
				{ 1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,1},
				{ 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
			lab=laberinto;
			enemigo = new Enemigo (200, 300);//Coords de otro enemigo
		}
		if(Juego.obtieneNivel()==3) {
			int laberinto [][]=
				{{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{ 1,0,0,0,1,0,0,0,0,0,0,1,1,1,0,0,1,1,0,0,0,1,1},
				{ 1,1,1,0,1,0,1,0,1,1,1,0,0,0,1,0,0,0,1,1,0,1,1},
				{ 1,1,0,0,0,0,1,0,0,1,0,0,1,0,1,0,1,0,0,1,0,1,1},
				{ 1,1,0,1,1,1,1,0,1,0,0,1,1,0,1,0,0,1,0,1,0,1,1},
				{ 1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,1,0,0,1,0,1,1},
				{ 1,1,1,0,1,0,1,1,1,1,0,0,0,0,1,0,0,1,0,1,0,1,1},
				{ 1,1,0,0,0,1,0,0,0,1,0,1,1,1,0,0,1,0,0,1,0,1,1},
				{ 1,1,0,1,1,0,0,1,0,1,0,0,0,0,0,1,0,0,1,1,0,1,1},
				{ 1,1,0,1,0,0,1,1,0,1,0,1,1,1,1,0,0,1,0,0,0,1,1},
				{ 1,1,0,0,0,1,1,1,0,1,0,0,0,0,0,1,0,0,0,1,0,1,1},
				{ 1,1,0,1,0,0,0,1,0,0,0,1,1,1,1,0,0,1,0,1,0,0,1},
				{ 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
			lab=laberinto;
			enemigo = new Enemigo (320, 400);//Coords del ultimo enemigo
		}
		
		
		return lab;
		
	}	                   	

}