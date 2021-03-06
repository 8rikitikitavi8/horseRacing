package horseRacing;
/*
      Игра скачки.
-Игрок делает ставки на одну из предложенных лошадей.
-Скорость лошади случайным образом выбирается между минимальным и максимальным значением.
-У каждой лошади есть своя выносливость,поэтому скорость каждой лошади на новом круге падает по разному.
-У каждой лошади есть шанс получить на новом круге воодушевление и побежать быстрее.
-Игра проходит в реальном времени, время прохождения кругов отображается на экране в момент пересечения каждой лошадью
линии финиша круга.
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Приветствуем вас на королевских скачках!!!");
        Player player = new Player();
        HorseManager horseManager = new HorseManager();
        Game game = new Game(800,3,player,horseManager);
        game.startGame();
    }
}
