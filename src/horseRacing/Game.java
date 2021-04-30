package horseRacing;

import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    int bet;
    int sumBet;
    int lapDistance = 800;
    int numLaps = 3;
    Player player = new Player();
    HorseManager horseManager = new HorseManager();

    public void startGame() {
        player.name = player.askAndSetName();
        player.money = player.moneyForBet();
        player.moneyFirstTime = player.money;
        while (player.money > 0) {
            horseManager.showHorses();
            chooseAndBetHorse();
            try {
                checkWin();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (continueOrFinish()) {
                return;
            }
            if (player.money == 0) {
                System.out.println("К сожалению вы все проиграли, приходите в следующий раз");
            }
        }
    }

    static void startRace() throws InterruptedException {
        System.out.println("Три");
        Thread.sleep(1000);
        System.out.println("Два");
        Thread.sleep(1000);
        System.out.println("Один");
        Thread.sleep(1000);
        System.out.println("СТАРТ!!!");
    }

    public void chooseAndBetHorse() {
        System.out.println(player.name + ", выбирайте,на кого поставите ваши деньги. Укажите номер понравившейся вам лошади");
        while (true) {
            bet = scanner.nextInt();
            if (bet >= 1 && bet <= horseManager.horses.size()) {
                break;
            }
            System.out.println("Введите число от 1 до " + horseManager.horses.size());
            scanner.nextLine();
        }
        System.out.println(player.name + ", сколько готовы поставить?Если выиграете, ваша ставка умножиться на " + horseManager.horses.size());
        while (true) {
            sumBet = scanner.nextInt();
            if (sumBet >= 1 && sumBet <= player.money) {
                break;
            }
            System.out.println("Введите число от 1 до " + player.money);
            scanner.nextLine();
        }
    }

    public void checkWin() throws InterruptedException {
        if (bet == horseManager.race(horseManager.horses, lapDistance, numLaps)) {
            player.money += sumBet * horseManager.horses.size();
            System.out.println(player.name + ", поздравляю! вы выиграли " + sumBet * horseManager.horses.size() + " рублей");
            System.out.println("У вас есть " + player.money + " рублей на дальнейшие ставки");
        } else {
            player.money -= sumBet;
            System.out.println(player.name + ", к сажалению вы проиграли " + sumBet + " рублей");
            System.out.println("У вас есть " + player.money + " рублей на дальнейшие ставки");
        }
    }

    public boolean continueOrFinish() {
        System.out.println("Если хотите закончить нажмите цифру 0 или любую другую, что бы остаться");
        scanner.nextLine();
        String s = scanner.nextLine();
        if (s.equalsIgnoreCase("0")) {
            System.out.println("Рады были вас видеть!");
            if (player.moneyFirstTime > player.money) {
                System.out.println("Не расстраивайтесь, вы проиграли " + (player.moneyFirstTime - player.money) + " рублей");
            } else {
                System.out.println("Поздравляем! Ваш выирыш составил " + (player.money - player.moneyFirstTime) + " рублей");
            }
            System.out.println("Приходите к нам ещё");
            return true;
        }
        return false;
    }


}
