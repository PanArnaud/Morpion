import java.awt.Graphics;
import javax.swing.JPanel;

public class Grille extends JPanel{

	Case[][] tab_cases = new Case[3][3];
	
	public Grille(){
		for(int i = 0; i < tab_cases.length; i++){
			for(int j = 0; j < tab_cases[i].length; j++){
				tab_cases[i][j] = new Case(i, j);
			}
		}
	}
	
	public boolean testEgalite(){
		int count = 0;
		for(int i = 0; i < tab_cases.length; i++){
			for(int j = 0; j < tab_cases[i].length; j++){
				if(tab_cases[i][j].Contenu != Joueur.VIDE){
					count++;
				}
			}
		}
		if(count == 9){
			return true;
		}
		return false;
	}
	
	public boolean testVainqueur(Joueur j){
		for(int i = 0; i < tab_cases.length; i++){
			//Test des lignes
			if((tab_cases[i][0].getContenu() == j) && (tab_cases[i][1].getContenu() == j) && (tab_cases[i][2].getContenu() == j)){
				return true;
			}
			if((tab_cases[0][i].getContenu() == j) && (tab_cases[1][i].getContenu() == j) && (tab_cases[2][i].getContenu() == j)){
				return true;
			}
		}
		if((tab_cases[0][0].getContenu() == j) && (tab_cases[1][1].getContenu() == j) && (tab_cases[2][2].getContenu() == j)){
			return true;
		}
		if((tab_cases[0][2].getContenu() == j) && (tab_cases[1][1].getContenu() == j) && (tab_cases[2][0].getContenu() == j)){
			return true;
		}
		return false;
	}
	
	public void paint(Graphics g){
		super.paint(g);
		for(int i = 100; i < 300; i=i+100){
			g.fillRoundRect(i, 0, 10, 320, 0, 0);
			g.fillRoundRect(0, i, 320, 10, 0, 0);
		}
		for(int i = 0; i < tab_cases.length; i++){
			for(int j = 0; j < tab_cases[i].length; j++){
				tab_cases[i][j].draw(g);
			}
		}
		repaint();
	}
	
}
