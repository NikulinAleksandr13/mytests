package utils;

import java.util.Random;

public class NumericHelper {
    private static final Random random = new Random();

    public static int getRandomInt(int size){
        return random.nextInt(size);
    }
}
