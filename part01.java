public class part01  //part16
練習

{
  
  public static void main(String[] args) throws java.io.IOException
  {
    Console.putJyosyou();           //序章を表示

    putCommand();           //コマンドを表示
    if(Player.hp==0){
      return;
    }

    //魔王を倒しに行く
    if(Player.lv<40){              //レベルが40未満の場合
      Console.putGameOver();          //ゲームオーバー画面を表示

    }else{                //レベルが40以上の場合
      Console.putGameClear();         //ゲームクリアの画面を表示
    }
  }


  /**
   * コマンドを表示します。
   * 
   * @exception IOException 入出力エラーが発生した場合
   */
  public static void putCommand() throws java.io.IOException
  {
    
    Console.put("1.すぐに魔王を倒しに行く");
    Console.put("2.修行する");
    Console.put("3.宿屋に泊まる");

    switch(inputCommand()){
      case '1':{               //1. 魔王を倒しに行く
        Console.put("魔王があらわれた！");
        break;
      }
      case '2':{          //2. 修行する
        syugyou();
        break;
      }
      case '3':{    //宿屋に泊まる
        if(Player.gold > 9.95){
          Player.hp = Player.lv;               //lvまで回復
          Player.gold -= 9.95;          
        }
        Console.putStatus();        
        putCommand();
        break;
      }
    }

  }


  /**
   * 修行する
   */
  public static void syugyou() throws java.io.IOException
  {

    //ランダム関数
        java.util.Random r = new java.util.Random();

    //敵出現
        int e = r.nextInt(9)+1;     //敵の数
        Console.put("  敵が　"+ e +"　匹、現れた！");
        String m = "(ﾟДﾟ)";
        String s = "";
        for(int i = 0; i<e; i=i+1){
          s = s + m;
        }
        Console.put(s);


    //HPを減らす
        int d = r.nextInt(8);
        Player.hp -= d;
        if(Player.hp<0){
          Player.hp = 0;
        }
        Console.put(Player.name + "　は、 "+ d +"　ポイントのダメージを受けた！");


    //レベル上昇
        Player.lv += e;
        Console.put("レベルが"+Player.lv+"になった");
        Console.putStatus();
        if(Player.hp==0){
          Console.put("GAME OVER");
        }else{
          putCommand();
        }
  }



   /**
   *改行コードが入力されたらreturnするようにしたpart08
   *
   * 入力ストリームからデータの次のバイトを読み込みます。
   * 改行コードは無視されます。
   * 
   * @return データの次のバイト　ストリームの終わりに達した場合は-1
   * @IOException 入出力エラーが発生した場合
   */
  public static int inputCommand() throws java.io.IOException
  {
    int  c = System.in.read(); //改行コード(CR又はLF)の場合
    if( c == 10 || c == 13 ){  //linux用が10、windows用が10と13
      return(inputCommand());  //10と13が改行コード
    }
    return(c);
  }
    

}  
