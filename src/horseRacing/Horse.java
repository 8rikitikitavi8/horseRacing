package horseRacing;


import java.util.Random;

public class Horse implements Comparable<Horse> {
    Random random = new Random();
    String name;
    int id;
    double minSpeed;
    double maxSpeed;
    double stamina;
    double totalTime;
    double oneLapTime;


    public Horse(String name, double minSpeed, double maxSpeed, double stamina, int id) {
        this.name = name;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
        this.stamina = stamina;
        this.id = id;
    }

    @Override
    public int compareTo(Horse o) {
        return Double.compare(totalTime, o.totalTime);
    }

    @Override
    public String toString() {
        return  name + " номер " + id;
    }

    public double inspiration() {
        if (random.nextInt(5) == 1) {
            return 1.1;
        }
        return 1.0;
    }

    public double currentSpeed() {
        return this.minSpeed + (this.maxSpeed - this.minSpeed) * random.nextDouble();
    }

    public double lapTime(Horse horse, int lapDistance, double stamina) {
        return lapDistance / (currentSpeed() * inspiration()) * stamina;
    }



}
