package com.github.alexsandrospecht;

import com.github.alexsandrospecht.engine.ParameterDTO;
import com.github.alexsandrospecht.helpers.TransformationHelper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by alexsandrospecht on 16/03/17.
 */
public class Tsv extends Application {

    /**
     * args[0] INPUT_FILE
     * args[1] TEMPLATE_FILE
     * args[2] OUTPUT_FILE
     * args[3] SEPARATOR
     */
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            Application.launch(args);
        } else {
            String input = args[0];
            String template = args[1];
            String output = args[2];
            String separator = args[3];

            ParameterDTO params = new ParameterDTO(input, template, output, separator);
            TransformationHelper.transform(params);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/pages/home.fxml"));

        primaryStage.setTitle("TSV - TXT to CSV Transformer");
        primaryStage.setScene(new Scene(root, 900, 185));
        primaryStage.show();
    }
}
