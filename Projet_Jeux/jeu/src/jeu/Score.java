package jeu;

public class Score {
    
private long Score = 0;
private static Score uniqueScore;
        
///////////////  La méthode qui retourne l'unique instance (Singleton) //////////////   
public static synchronized Score getInstance() {
            if(uniqueScore==null) {
               uniqueScore = new Score();  }
            return uniqueScore;
}
    
////////////////  Modifier le score de l'unique instance ///////////////////////////     
public void setScore(long Score) {
            this.Score = Score;
}

////////////////  Récuperer le score de l'unique instance //////////////////////////     
public long getScore() {
            return Score;
}
    
    
    
    
    
    
}
