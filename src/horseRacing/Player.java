package horseRacing;

import java.util.Scanner;

public class Player {
    Scanner scanner = new Scanner(System.in);
    String name;
    int money;
    int moneyFirstTime;

    public String askAndSetName() {
        System.out.println("Игрок, введите ваше имя");
        return scanner.nextLine();
    }

    public int moneyForBet() {
        System.out.println(this.name + ", сколько денег вы  готовы ставить на все заезды?");
        return scanner.nextInt();
    }
}
