package com.github.alexsandrospecht.controller;

import com.github.alexsandrospecht.engine.ParameterDTO;
import com.github.alexsandrospecht.helpers.TransformationHelper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.github.alexsandrospecht.helpers.AlertHelper.errorAlert;
import static com.github.alexsandrospecht.helpers.AlertHelper.sucessAlert;
import static com.github.alexsandrospecht.helpers.FileHelper.chooseFile;
import static com.github.alexsandrospecht.helpers.FileHelper.selectOutputFile;


/**
 * Created by alexsandrospecht on 19/03/17.
 */
public class HomeController implements Initializable {

    private String input;
    private String template;
    private String output;

    @FXML
    private Button btn_input;

    @FXML
    private TextField tf_input;

    @FXML
    private Button btn_template;

    @FXML
    private TextField tf_template;

    @FXML
    private Button btn_output;

    @FXML
    private TextField tf_output;

    @FXML
    private Button btn_transform;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btn_input.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final File selectedFile = chooseFile(btn_input.getScene().getWindow());

                if (selectedFile != null) {
                    input = selectedFile.getAbsolutePath();
                    tf_input.setText(input);
                }
            }
        });

        btn_template.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final File selectedFile = chooseFile(btn_template.getScene().getWindow());

                if (selectedFile != null) {
                    template = selectedFile.getAbsolutePath();
                    tf_template.setText(template);
                }
            }
        });

        btn_output.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final File selectedFile = selectOutputFile(btn_output.getScene().getWindow());

                if(selectedFile != null){
                    saveFile(selectedFile);
                }

                if (selectedFile != null) {
                    output = selectedFile.getAbsolutePath();
                    tf_output.setText(output);
                }
            }
        });

        btn_transform.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (input == null || output == null || template == null) {
                    errorAlert("All parameters must be informed!");
                    return;
                }

                ParameterDTO params = new ParameterDTO(input, template, output);
                try {
                    TransformationHelper.transform(params);

                    sucessAlert("TXT to CSV performed!");
                } catch (Exception e) {
                    errorAlert(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }

    private void saveFile(File file){
        try {
            new FileWriter(file).close();
        } catch (IOException ex) {
            errorAlert(ex.getMessage());
            ex.printStackTrace();
        }
    }

}
