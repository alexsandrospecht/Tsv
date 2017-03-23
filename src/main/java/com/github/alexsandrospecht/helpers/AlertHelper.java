package com.github.alexsandrospecht.helpers;

import javafx.scene.control.Alert;

/**
 * Created by alexsandrospecht on 22/03/17.
 */
public class AlertHelper {

    private static void alertWithHeader(Alert.AlertType alertType, String title, String header, String content) {
        final Alert error = new Alert(alertType);
        error.setTitle(title);
        error.setHeaderText(header);
        error.setContentText(content);
        error.showAndWait();
    }

    public static void errorAlertWithHeader(String header, String content) {
        alertWithHeader(Alert.AlertType.ERROR, "Error", header, content);
    }

    public static void errorAlert(String content) {
        errorAlertWithHeader(null, content);
    }

    public static void sucessAlertWithHeader(String header, String content) {
        alertWithHeader(Alert.AlertType.INFORMATION, "Sucess", header, content);
    }

    public static void sucessAlert(String content) {
        sucessAlertWithHeader(null, content);
    }

}
