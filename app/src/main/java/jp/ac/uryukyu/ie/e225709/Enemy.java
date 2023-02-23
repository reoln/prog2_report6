package jp.ac.uryukyu.ie.e225709;

public class Enemy extends Poker{

    /**
     * コンストラクタ。敵の名前を指定。
     * ゲームで成立した役の強さ hand を保存。
     * @param name　敵の名前
     */
    public Enemy (String name){
        setName(name);
        setHand(0);
    }
}