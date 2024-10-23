package com.mycompany.mavenproject1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class PrimaryController {
    @FXML
    private TextField firstname;
    @FXML
    private TextField Age;
    @FXML
    private TextField gmail;

    public void submit(ActionEvent event) {
        String name = firstname.getText();
        String ageInput = Age.getText();
        String email = gmail.getText();

        // Validate inputs
        if (name.isEmpty()) {
            showAlert("First name is required.");
            return;
        }

        if (ageInput.isEmpty() || !ageInput.matches("\\d+")) {
            showAlert("Please enter a valid age.");
            return;
        }

        if (email.isEmpty() || !email.contains("@")) {
            showAlert("Please enter a valid email address.");
            return;
        }

        // Show pop-up with the details
        String message = "First Name: " + name + "\nAge: " + ageInput + "\nEmail: " + email;
        showAlert(message);
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Submission Details");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
