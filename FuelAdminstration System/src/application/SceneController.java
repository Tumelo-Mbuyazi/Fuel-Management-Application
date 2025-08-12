package application;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SceneController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    // FuelPage components
    @FXML
    private ComboBox<String> brandBox;

    @FXML
    private ComboBox<String> modelBox;

    @FXML
    private Label fuelTankLabel;

    @FXML
    private Label priceLabel;

    // Detailed car data: Brand -> Model -> {FuelTank, Price}
    private final Map<String, Map<String, String[]>> carDataDetailed = new HashMap<>();

    // ================== Scene Switching ==================

    public void SwitchToScene1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CarReg.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Payment.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToScene3(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CoverPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToScene4(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToScene5(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Forgot Password.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToScene6(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FuelPage.fxml"));
        root = loader.load();

        // Get the controller of FuelPage (this class)
        SceneController controller = loader.getController();
        controller.setupFuelPage(); // Fill dropdowns

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // ================== Fuel Page Logic ==================
    private void setupFuelPage() {
        // Toyota
        Map<String, String[]> toyota = new HashMap<>();
        toyota.put("Corolla", new String[]{"50 L", "R1,200"});
        toyota.put("Hilux", new String[]{"80 L", "R1,900"});
        toyota.put("Fortuner", new String[]{"70 L", "R1,750"});
        carDataDetailed.put("Toyota", toyota);

        // Volkswagen
        Map<String, String[]> vw = new HashMap<>();
        vw.put("Polo", new String[]{"45 L", "R1,050"});
        vw.put("Golf", new String[]{"55 L", "R1,280"});
        vw.put("Tiguan", new String[]{"65 L", "R1,500"});
        carDataDetailed.put("Volkswagen", vw);

        // BMW
        Map<String, String[]> bmw = new HashMap<>();
        bmw.put("3 Series", new String[]{"59 L", "R1,350"});
        bmw.put("5 Series", new String[]{"66 L", "R1,550"});
        bmw.put("X5", new String[]{"83 L", "R1,950"});
        carDataDetailed.put("BMW", bmw);

        // Mercedes-Benz
        Map<String, String[]> merc = new HashMap<>();
        merc.put("C-Class", new String[]{"66 L", "R1,520"});
        merc.put("E-Class", new String[]{"80 L", "R1,850"});
        merc.put("GLA", new String[]{"50 L", "R1,300"});
        carDataDetailed.put("Mercedes-Benz", merc);

        // Ford
        Map<String, String[]> ford = new HashMap<>();
        ford.put("Ranger", new String[]{"80 L", "R1,900"});
        ford.put("Fiesta", new String[]{"42 L", "R980"});
        ford.put("Focus", new String[]{"55 L", "R1,280"});
        carDataDetailed.put("Ford", ford);

        // Populate brands
        brandBox.getItems().addAll(carDataDetailed.keySet());

        // When brand changes → update models
        brandBox.setOnAction(e -> {
            String selectedBrand = brandBox.getValue();
            modelBox.getItems().clear();
            if (selectedBrand != null) {
                modelBox.getItems().addAll(carDataDetailed.get(selectedBrand).keySet());
            }
        });

        // When model changes → show details
        modelBox.setOnAction(e -> {
            String selectedBrand = brandBox.getValue();
            String selectedModel = modelBox.getValue();
            if (selectedBrand != null && selectedModel != null) {
                String[] details = carDataDetailed.get(selectedBrand).get(selectedModel);
                fuelTankLabel.setText("Fuel Tank: " + details[0]);
                priceLabel.setText("Full Tank Price: " + details[1]);
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Runs for any page using this controller
    }
}
