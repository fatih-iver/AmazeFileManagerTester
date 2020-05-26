package fun.fiver.utils;

import java.io.File;

public class PathUtils {

    public static File getWorkingDirectory() {
        return new File(System.getProperty("user.dir"));
    }

    public static File getResourcesDirectory() {
        return new File(getWorkingDirectory(), "src/main/resources");
    }

    public static File getAndroidPackage() {
        return new File(getResourcesDirectory(), "amaze-file-manager-3-4-3.apk");
    }
}
