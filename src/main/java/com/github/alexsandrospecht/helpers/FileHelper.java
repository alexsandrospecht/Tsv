package com.github.alexsandrospecht.helpers;

import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by alexsandrospecht on 23/03/17.
 */
public class FileHelper {

    public static File chooseFile(Window window) {
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.setInitialDirectory(new File("."));

        final FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        return fileChooser.showOpenDialog(window);
    }

    public static File selectOutputFile(Window window) {
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.setInitialDirectory(new File("."));
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);

        return fileChooser.showSaveDialog(window);
    }

    public static Stream<String> loadStreamFromFile(String path) throws Exception {
        final File file = new File(path);

        if (file.exists() && !file.isDirectory()) {
            return Files.lines(Paths.get(path));
        }
        throw new Exception("Invalid file path !");
    }

    public static void writeFile(String filename, StringBuilder sb) throws IOException {
        File file = new File(filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(sb.toString());
        }
    }

}
