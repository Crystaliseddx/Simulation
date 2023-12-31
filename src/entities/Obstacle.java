package entities;

import utility.Coordinate;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Obstacle extends Entity {
    private static final int MAX_OBSTACLES = 20;
    public static int obstaclesCounter = -1;
    private String obstacle;
    private static Map<Coordinate, Entity> obstacleMap = new HashMap<>();
    private Random random = new Random();

    public Obstacle() {
        int number = random.nextInt(3);
        if (number == 0) {
            obstacle = "\uD83C\uDF33";
        } else if (number == 1){
            obstacle = "\uD83D\uDDFB";
        } else {
            obstacle = "\uD83C\uDF32";
        }
        obstaclesCounter++;
    }

    @Override
    public String toString() {
        return obstacle;
    }

    @Override
    public Map<Coordinate, Entity> createEntity() {
        Coordinate randomCoordinate;
        while (obstaclesCounter < MAX_OBSTACLES){
            randomCoordinate = Coordinate.getRandomFreeCoordinate();
            obstacleMap.put(randomCoordinate, new Obstacle());
        }
        return obstacleMap;
    }
}
