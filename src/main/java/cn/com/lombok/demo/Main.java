package cn.com.lombok.demo;


public class Main {

    public static void main(String[] args) {
        Player player = new Player();
        System.out.println(player);
        System.out.println("goldAmount= " + player.getGoldAmount());
        System.out.println("amount= " + player.getAmount());
    }
}