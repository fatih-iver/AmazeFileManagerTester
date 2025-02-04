package fun.fiver.utils;

import java.util.Random;

public class FileUtils {

    public static String generateFileName() {

        int leftLimit = 97;
        int rightLimit = 122;

        int targetStringLength = 6;

        Random random = new Random();

        String generatedName = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedName;
    }
}
