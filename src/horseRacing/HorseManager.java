package horseRacing;

import java.util.ArrayList;
import java.util.Collections;

public class HorseManager {
    ArrayList<Horse> horses = new ArrayList<>();

    public HorseManager() {
        horses.add(new Horse("Гамлет", 42.15, 59.07, 0.97, 1));
        horses.add(new Horse("Зевс", 40.12, 61.37, 0.96, 2));
        horses.add(new Horse("Ураган", 41.30, 60.65, 0.97, 3));
        horses.add(new Horse("Дублон", 40.12, 62.02, 0.95, 4));
//        horses.add(new Horse("Буран", 41.36, 62.59, 0.95,5));
//        horses.add(new Horse("Жнец", 40.50, 61.07, 0.96,6));
//        horses.add(new Horse("Лукас", 43.35, 63.07, 0.94,7));
//        horses.add(new Horse("Танго", 42.12, 61.98, 0.95,8));
//        horses.add(new Horse("Гранит", 41.45, 62.50, 0.95,9));
//        horses.add(new Horse("Беркут", 44.00, 61.91, 0.95,10));
    }

    public int race(ArrayList<Horse> horses, int lapDistance, int numLaps) throws InterruptedException {
        double totalTimeLast = 0;
        Game.startRace();
        for (int i = 1; i <= numLaps; i++) {
            System.out.println();
            System.out.println(i + "круг");
            System.out.println();
            for (int j = 0; j < horses.size(); j++) {
                horses.get(j).oneLapTime = horses.get(j).lapTime(horses.get(j), lapDistance, Math.pow(horses.get(j).stamina, i));
                horses.get(j).totalTime += horses.get(j).oneLapTime;
            }
            Collections.sort(horses);
            for (int j = 0; j < horses.size(); j++) {
                if (j == 0) {
                    Thread.sleep((long) (horses.get(j).totalTime - totalTimeLast) * 1000);
                } else {
                    Thread.sleep((long) (horses.get(j).totalTime - horses.get(j - 1).totalTime) * 1000);
                }
                System.out.printf("%s. Результат %d го круга = %.3f секунд.",horses.get(j).name,i,horses.get(j).oneLapTime);
                System.out.printf("   Общее время забега = %.3f секунд.",horses.get(j).totalTime);
                System.out.println();
                if (j == horses.size() - 1) {
                    totalTimeLast = horses.get(j).totalTime;
                }
            }
        }
        System.out.printf("Побеждает %s! С результатом забега %.3f  секунд.",horses.get(0).name,horses.get(0).totalTime);
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).totalTime = 0;
        }
        return horses.get(0).id;
    }

    public void showHorses() {
        System.out.println("Вот лошади, которые участвуют сегодня в скачках:");
        for (int i = 0; i < horses.size(); i++) {
            System.out.println(horses.get(i));
        }
        System.out.println();
    }

}
