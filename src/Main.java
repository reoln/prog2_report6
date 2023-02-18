import jp.ac.uryukyu.ie.e225709.*;

public class Main {
   public static void main(String[] args){

      Player player = new Player("あなた",0);
      Enemy enemy = new Enemy("相手",0);

      player.card(player);
      enemy.card(enemy);
      player.matchResult(enemy);
   }
}
 
    