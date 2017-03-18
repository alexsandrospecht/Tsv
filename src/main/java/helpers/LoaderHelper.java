package helpers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by alexsandrospecht on 17/03/17.
 */
public class LoaderHelper {

    public static Stream<String> loadFile(String path) throws Exception {
        final File file = new File(path);

        if (file.exists() && !file.isDirectory()) {
            return Files.lines(Paths.get(path));
        }
        throw new Exception("Invalid file path !");
    }

}
