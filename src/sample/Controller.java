package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.json.JSONObject;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField city;

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
        searchButton.setOnAction(event -> {
            String getUserCity = city.getText().trim();
            if (!getUserCity.equals("")) {
                String output = getUrlContext("https://api.openweathermap.org/data/2.5/weather?q="
                        + getUserCity
                        + "&units=metric&appid=4962504a1566e0315d15a711c70cd3b6&lang=ru");

                if (!output.isEmpty()) {
                    JSONObject obj = new JSONObject(output);
                    temp.setText(String.valueOf(obj.getJSONObject("main").getDouble("temp")));
                    feels_like.setText(String.valueOf(obj.getJSONObject("main").getDouble("feels_like")));
                    temp_min.setText(String.valueOf(obj.getJSONObject("main").getDouble("temp_min")));
                    temp_max.setText(String.valueOf(obj.getJSONObject("main").getDouble("temp_max")));
                    pressure.setText(String.valueOf(obj.getJSONObject("main").getDouble("pressure")));
                }
            }
        });
    }

    private static String getUrlContext(String urlAdress) {
        StringBuffer content = new StringBuffer();

        try {
            URL url = new URL(urlAdress);
            URLConnection connection = url.openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            while((line = br.readLine()) != null) {
                content.append(line + "\n");
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Такого город не найден!");
        }

        return content.toString();
    }
}
