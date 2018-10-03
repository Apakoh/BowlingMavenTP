package bowling;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Spard
 */


public class Game implements MultiPlayerGame {
    
    private int currentPlayer;    
    private Map<Integer, Player> tableauPartie;
    private int nbJoueur;
    
    
    /**
	 * Démarre une nouvelle partie pour un groupe de joueurs
	 * @param playerName un tableau des noms de joueurs (il faut au moins un joueur)
	 * @return une chaîne de caractères indiquant le prochain joueur,
	 * de la forme "Prochain tir : joueur Bastide, tour n° 5, boule n° 1"
	 * @throws java.lang.Exception si le tableau est vide ou null
	 */
    
    @Override
    public String startNewGame(String[] playerName) {
        
        
        this.tableauPartie = new HashMap<>();
        this.nbJoueur = playerName.length;
        Player player;
        
        for(int i=0;i<this.nbJoueur;i++)
        {
            player = new Player(playerName[i], new SinglePlayerGame());
            tableauPartie.put(i+1, player);
        }        
              
        
        this.currentPlayer = 1;
        return this.tableauPartie.get(currentPlayer).playerName;
        
    }

    
    /**
	 * Enregistre le nombre de quilles abattues pour le joueur courant, dans le frame courant, pour la boule courante
	 * @param nombreDeQuillesAbattues : nombre de quilles abattue à ce lancer
	 * @return une chaîne de caractères indiquant le prochain joueur,
	 * de la forme "Prochain tir : joueur Bastide, tour n° 5, boule n° 1",
	 * ou bien "Partie terminée" si la partie est terminée.
	 * @throws java.lang.Exception si la partie n'est pas démarrée, ou si elle est terminée.
	 */
    
    @Override
    public String lancer(int nombreDeQuillesAbattues) {
                
        
        nextPlayer();
        return this.tableauPartie.get(currentPlayer).playerName;
    }
    
    /**
	 * Donne le score pour le joueur playerName
	 * @param playerName le nom du joueur recherché
	 * @return le score pour ce joueur
	 * @throws Exception si le playerName ne joue pas dans cette partie
	 */

    @Override
    public int scoreFor(String playerName) throws Exception {
        return 1;
    }
    
    private void nextPlayer() {
        
        if(this.currentPlayer < this.nbJoueur){
            
            this.currentPlayer++;
        
        }
        else{
            this.currentPlayer = 1;
        }
    }
    
}
