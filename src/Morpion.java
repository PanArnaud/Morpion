import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Morpion extends JFrame implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	Grille grille = new Grille();
	JLabel barreInfo = new JLabel("InfoBar: ");
	
	Joueur joueur;
	Etat jeu;
	
	public static void main(String[] args) {
		new Morpion();
	}
	
	public Morpion(){
		super("Morpion");
	    this.setSize(320, 360);
	    this.setLocationRelativeTo(null); 
	    this.setResizable(false);
	    
	    Container pan_main = this.getContentPane();
	    pan_main.setLayout(new BorderLayout());
	    
	    pan_main.add(grille, BorderLayout.CENTER);
	    pan_main.add(barreInfo, BorderLayout.SOUTH);
	    
	    this.setContentPane(pan_main);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
	    this.setVisible(true);
	    
	    initGame();
	    grille.addMouseListener(this);
	}
	
	public void initGame(){
		for(int i = 0; i < grille.tab_cases.length; i++){
			for(int j = 0; j < grille.tab_cases[i].length; j++){
				grille.tab_cases[i][j].Contenu = Joueur.VIDE;
			}
		}
		jeu = Etat.EN_COURS;
		joueur = Joueur.CROIX;
	}

	public void paint(Graphics g){
		super.paint(g);
		switch(jeu){
			case EN_COURS: 
				barreInfo.setForeground(Color.BLACK);
				barreInfo.setText("Tour de : " + joueur + " !");
				break;
			case CROIX_VAINQUEUR: 
				barreInfo.setForeground(Color.BLUE);
				barreInfo.setText(joueur + " remporte la partie !");
				break;
			case ROND_VAINQUEUR:
				barreInfo.setForeground(Color.RED);
				barreInfo.setText(joueur + " remporte la partie !");
				break;
			case EGALITE: 
				barreInfo.setForeground(Color.ORANGE);
				barreInfo.setText("Match nul !");
				break;
		}
		repaint();
	}
	
	public void testJeu(){
		if(!grille.testVainqueur(joueur)){
			if(!grille.testEgalite()){
				if(joueur == Joueur.CROIX){joueur = Joueur.ROND;}
				else if(joueur == Joueur.ROND){joueur = Joueur.CROIX;}
			}else{
				jeu = Etat.EGALITE;
			}
		}else{
			if(joueur == Joueur.CROIX){jeu = Etat.CROIX_VAINQUEUR;}
			if(joueur == Joueur.ROND){jeu = Etat.ROND_VAINQUEUR;}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		if(jeu == Etat.EN_COURS){
			for(int i = 0; i < grille.tab_cases.length; i++){
				for(int j = 0; j < grille.tab_cases[i].length; j++){
					if((grille.tab_cases[i][j].Contient(x, y)) && (grille.tab_cases[i][j].Contenu == Joueur.VIDE)){
						grille.tab_cases[i][j].Contenu = joueur;
						testJeu();
					}
				}
			}
		}else{
			initGame();
		}
	}


	public void mouseClicked(MouseEvent arg0) {}

	public void mouseEntered(MouseEvent arg0) {}

	public void mouseExited(MouseEvent arg0) {}

	public void mousePressed(MouseEvent arg0) {}
}
