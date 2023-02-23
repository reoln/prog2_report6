package jp.ac.uryukyu.ie.e225709;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Poker{
  private String name;
  int hand;

  public void setName(String name){
    this.name = name;
  }
  public String getName(){
    return name;
  }

  public void setHand(int hand){
    this.hand = hand;
  }
  public int getHand(){
    return hand;
  }

    
    /**
     * カードを５枚配るメソッド。
     * 配られたカードは card に保存して表示する。
     * @param myself　カードが配られる人
     */
    public void card(Poker myself){
        List<String> card = new ArrayList<>();
        for (int i=0; i<5; i++){
            int j;
            j = (int)(Math.random() * 4);
            switch (j){
                case 0:
                  card.add("♠️");
                  break;
                case 1:
                  card.add("♣️");
                  break;
                case 2:
                  card.add("❤︎");
                  break;
                default:
                  card.add("♦︎");
            }
        }
        System.out.println(getName() + card);
        myself.suitCount(card, myself);
    }

  
    /**
     * 配られたカードの中に、各スートがいくつあるかを数えるメソッド。
     * 各スートの数は suitCount に保存される。
     * @param card　配られたカード
     * @param myself　そのカードを持つ人
     */
    public void suitCount(List<String> card, Poker myself){
      List<String> suit = Arrays.asList("♠️","♣️","❤︎","♦︎");
      List<Integer> suitCount = new ArrayList<>();
      for (int i=0; i<4; i++){
        int count = 0;
        for (int j=0; j<5; j++){
          if (card.get(j) == suit.get(i)){
            count += 1;
          }
        }
        suitCount.add(count);
      }
      myself.handCheck(suitCount, myself);
    }

    
    /**
     * どの役が成立しているか判定するメソッド。
     * 成立した役を表示し、その強さを hand に保存する。
     * @param suitCount　それぞれのスートの数
     * @param myself　そのカードを持つ人
     */
    public void handCheck(List<Integer>suitCount, Poker myself){
      
      if (suitCount.contains(5)){
        hand = 6;
        System.out.println("５カード！！");
      }
      if (suitCount.contains(4)){
        hand = 5;
        System.out.println("４カード！");
      }
      if (suitCount.contains(3)){
        if (suitCount.contains(2)){
          hand = 4;
          System.out.println("フルハウス");
        }else{
          hand = 3;
            System.out.println("３カード");
        }
      }
      if (suitCount.contains(2)){
        if (suitCount.contains(1)){
          if (suitCount.contains(0)){
            hand = 2;
            System.out.println("２ペア");
          }else{
            hand = 1;
            System.out.println("１ペア");
          }
        }
      }
    }
    
    /**
     * 勝敗の判定をするメソッド。
     * プレイヤーと敵の hand を比べる。
     * @param oppoment　敵
     */
    public void matchResult(Poker oppoment){
      if (hand > oppoment.getHand()){
        System.out.println(getName() + "の勝ち！");
      }else if (hand == oppoment.getHand()){
        System.out.println("引き分け");
      }else{
        System.out.println(getName() + "の負け");
      }
    }
}