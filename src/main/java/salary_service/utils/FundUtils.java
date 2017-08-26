package salary_service.utils;

/**
 * Created by Miha on 26.08.2017.
 */
public class FundUtils {
    public static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        return (int)(Math.random() * ((max - min) + 1)) + min;
    }
}
