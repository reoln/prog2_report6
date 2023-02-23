package jp.ac.uryukyu.ie.e225709;

public class Player extends Poker {

    /**
     * コンストラクタ。プレイヤー名を指定。
     * ゲームで成立した役の強さ hand を保存。
     * @param name　プレイヤー名
     */
    public Player (String name){
       setName(name);
       setHand(0);
    }
}