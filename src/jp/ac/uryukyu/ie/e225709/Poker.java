package jp.ac.uryukyu.ie.e225709;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Poker{

    //カードを５枚配る
    public static void card(){
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
        System.out.println(card);
        Poker.suitCount(card);
    }

  //各スートがそれぞれいくつあるのか調べる
    public static void suitCount(List<String> card){
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
      Poker.handCheck(suitCount);
    }

    public static void handCheck(List<Integer>suitCount){
      if (suitCount.contains(5)){
        System.out.println("５カード！！");
      }
      if (suitCount.contains(4)){
        System.out.println("４カード！");
      }
      if (suitCount.contains(3)){
        if (suitCount.contains(2)){
          System.out.println("フルハウス");
        }else{
            System.out.println("３カード");
        }
      }
      if (suitCount.contains(2)){
        if (suitCount.contains(1)){
          if (suitCount.contains(0)){
            System.out.println("２ペア");
          }else{
            System.out.println("１ペア");
          }
        }
      }
    }
}