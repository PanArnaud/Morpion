import java.awt.Color;
import java.awt.Graphics;

public class Case {
	int x, y;
	Joueur Contenu = Joueur.VIDE;
	
	public Case(int x, int y){
		if(x > 0){
			this.x = (x * 100) + (10 * x);
		}else{
			this.x = x;
		}
		if(y > 0){
			this.y = (y * 100) + (10 * y);
		}else{
			this.y = y;
		}
	}
	
	public Joueur getContenu(){
		return this.Contenu;
	}
	
	public void setContenu(Joueur j){
		this.Contenu = j;
	}
	
	public boolean Contient(int x, int y){
		if((x >= this.x && y >= this.y) && (x <= this.x+100 && y <= this.y+100)){
			return true;
		}else{
			return false;
		}
	}
	
	public void draw(Graphics g){
		if(this.getContenu() == Joueur.CROIX){
			g.setColor(Color.BLUE);
			g.drawLine(x+30, y+30, x+60, y+60);
			g.drawLine(x+60, y+30, x+30, y+60);
		}
		if(this.getContenu() == Joueur.ROND){
			g.setColor(Color.RED);
			g.drawOval(x+15, y+15, 60, 60);
		}
	}
}
