package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField enterCityField;

    @FXML
    private Button searchButton;

    @FXML
    private TextField temp;

    @FXML
    private TextField feels_like;

    @FXML
    private TextField temp_max;

    @FXML
    private TextField temp_min;

    @FXML
    private TextField pressure;

    @FXML
    void initialize() {

    }
}
