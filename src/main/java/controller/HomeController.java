package controller;

import engine.ParameterDTO;
import helpers.TransformationHelper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Resource File");
                fileChooser.setInitialDirectory(new File("."));

                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);

                File selectedFile = fileChooser.showOpenDialog(btn_input.getScene().getWindow());

                if (selectedFile != null) {
                    input = selectedFile.getAbsolutePath();
                    tf_input.setText(input);
                }
            }
        });

        btn_template.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Resource File");
                fileChooser.setInitialDirectory(new File("."));

                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);

                File selectedFile = fileChooser.showOpenDialog(btn_template.getScene().getWindow());

                if (selectedFile != null) {
                    template = selectedFile.getAbsolutePath();
                    tf_template.setText(template);
                }
            }
        });

        btn_output.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Resource File");
                fileChooser.setInitialDirectory(new File("."));
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
                fileChooser.getExtensionFilters().add(extFilter);

                //Show save file dialog
                File selectedFile = fileChooser.showSaveDialog(btn_output.getScene().getWindow());

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
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                if (input == null || output == null || template == null) {
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("All parameters must be informed!");
                    alert.showAndWait();
                    return;
                }

                ParameterDTO params = new ParameterDTO(input, template, output);
                try {
                    TransformationHelper.transform(params);

                    alert.setTitle("Sucess");
                    alert.setHeaderText(null);
                    alert.setContentText("TXT to CSV performed!");
                    alert.showAndWait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void saveFile(File file){
        try {
            new FileWriter(file).close();
        } catch (IOException ex) {
        }
    }

}
