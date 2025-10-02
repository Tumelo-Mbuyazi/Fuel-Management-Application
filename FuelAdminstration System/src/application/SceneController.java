package application;

import application.ReadAdminFile;

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
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class SceneController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    //  FuelPage components 
    @FXML
    private TextField litresField;  
    @FXML
    private ComboBox<String> brandBox;
    @FXML
    private ComboBox<String> modelBox;
    @FXML
    private ComboBox<String> fuelTypeBox;
    @FXML
    private Label fuelTankLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Label fuelPriceLabel;

    //  PaymentPage components 
    @FXML
    private Label carSummaryLabel;   
    @FXML
    private TextField discountField; 
    @FXML
    private Label finalAmountLabel; 

    //  Login
    @FXML
    private TextField usernameField;       // CoverPage username
    @FXML
    private PasswordField loginPasswordField; // CoverPage password
    @FXML
    private TextField nameField;           // Registration name
    @FXML
    private PasswordField passwordField;   // Registration password
    @FXML
    private CheckBox cbAdmin;  // Admin checkbox (checked = Admin, uncheckef = not-admin)

    // Store data
    private String selectedBrand;
    private String selectedModel;
    private String selectedFuelType;
    private int tankLitres;
    private double pricePerLitre;
    private double litresChosen; 

    // Registered users 
    private static final Map<String, String> registeredUsers = new HashMap<>();

    // Car + Fuel Data
    private final Map<String, Map<String, Integer>> carDataDetailed = new HashMap<>();
    private final double petrolPricePerLitre = 23.50;
    private final double dieselPricePerLitre = 21.80;

    //  Scene Switching 
    public void SwitchToScene1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CarReg.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToScene2(ActionEvent event) throws IOException {
        if (litresField != null) {
            String litresText = litresField.getText();
            if (litresText == null || litresText.isEmpty()) {
                litresChosen = tankLitres;
            } else {
                try {
                    litresChosen = Double.parseDouble(litresText);
                } catch (NumberFormatException e) {
                    litresChosen = tankLitres;
                }
            }
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Payment.fxml"));
        root = loader.load();

        SceneController controller = loader.getController();
        controller.loadPaymentSummary(selectedBrand, selectedModel, selectedFuelType, tankLitres, pricePerLitre, litresChosen);

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

        SceneController controller = loader.getController();
        controller.setupFuelPage();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void SwitchToScene7(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminDashboard.fxml"));
        root = loader.load();

        SceneController controller = loader.getController();
        controller.setupFuelPage();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //  Fuel Page 
    protected void setupFuelPage() {
        Map<String, Integer> toyota = new HashMap<>();
        toyota.put("Corolla", 50);
        toyota.put("Hilux", 80);
        toyota.put("Fortuner", 70);
        carDataDetailed.put("Toyota", toyota);

        Map<String, Integer> vw = new HashMap<>();
        vw.put("Polo", 45);
        vw.put("Golf", 55);
        vw.put("Tiguan", 65);
        carDataDetailed.put("Volkswagen", vw);

        Map<String, Integer> bmw = new HashMap<>();
        bmw.put("3 Series", 59);
        bmw.put("5 Series", 66);
        bmw.put("X5", 83);
        carDataDetailed.put("BMW", bmw);

        Map<String, Integer> merc = new HashMap<>();
        merc.put("C-Class", 66);
        merc.put("E-Class", 80);
        merc.put("GLA", 50);
        carDataDetailed.put("Mercedes-Benz", merc);

        Map<String, Integer> ford = new HashMap<>();
        ford.put("Ranger", 80);
        ford.put("Fiesta", 42);
        ford.put("Focus", 55);
        carDataDetailed.put("Ford", ford);

        brandBox.getItems().addAll(carDataDetailed.keySet());
        fuelTypeBox.getItems().addAll("Petrol", "Diesel");

        brandBox.setOnAction(e -> {
            String b = brandBox.getValue();
            modelBox.getItems().clear();
            if (b != null) modelBox.getItems().addAll(carDataDetailed.get(b).keySet());
        });
        modelBox.setOnAction(e -> calculateFuelCost());
        fuelTypeBox.setOnAction(e -> calculateFuelCost());
    }

    private void calculateFuelCost() {
        selectedBrand = brandBox.getValue();
        selectedModel = modelBox.getValue();
        selectedFuelType = fuelTypeBox.getValue();

        if (selectedBrand != null && selectedModel != null && selectedFuelType != null) {
            tankLitres = carDataDetailed.get(selectedBrand).get(selectedModel);
            pricePerLitre = selectedFuelType.equals("Diesel") ? dieselPricePerLitre : petrolPricePerLitre;
            double totalCost = tankLitres * pricePerLitre;

            fuelTankLabel.setText("Fuel Tank: " + tankLitres + " L");
            fuelPriceLabel.setText(String.format("Current %s Price: R%.2f / L", selectedFuelType, pricePerLitre));
            priceLabel.setText(String.format("Full Tank Price (%s): R%.2f", selectedFuelType, totalCost));
        }
    }

    // Payment Page 
    protected void loadPaymentSummary(String brand, String model, String fuelType, int tankLitres, double pricePerLitre, double litresChosen) {
        this.selectedBrand = brand;
        this.selectedModel = model;
        this.selectedFuelType = fuelType;
        this.tankLitres = tankLitres;
        this.pricePerLitre = pricePerLitre;
        this.litresChosen = litresChosen;

        if (carSummaryLabel != null) {
            double total = litresChosen * pricePerLitre;
            carSummaryLabel.setText(
                String.format("Brand: %s\nModel: %s\nFuel: %s\nLitres: %.2f (Tank: %d L)\nPrice/L: R%.2f\nTotal: R%.2f",
                    brand, model, fuelType, litresChosen, tankLitres, pricePerLitre, total)
            );
        }
    }

    @FXML
    private void confirmPayment(ActionEvent event) {
        try {
            double discount = discountField.getText().isEmpty() ? 0 : Double.parseDouble(discountField.getText());
            double total = litresChosen * pricePerLitre;
            double finalAmount = total - discount;

            finalAmountLabel.setText(String.format("R%.2f", finalAmount));

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Payment Summary");
            alert.setHeaderText("Fuel Purchase Summary");
            alert.setContentText(
                String.format("Car: %s %s\nFuel: %s\nLitres: %.2f\nPrice/L: R%.2f\nDiscount: R%.2f\nFinal Amount: R%.2f",
                    selectedBrand, selectedModel, selectedFuelType, litresChosen, pricePerLitre, discount, finalAmount)
            );
            alert.showAndWait();

        } catch (NumberFormatException e) {
            new Alert(AlertType.ERROR, "Invalid discount entered!").showAndWait();
        }
    }

    //Login part
    @FXML
    private void login(ActionEvent event) throws IOException {
        String username = usernameField.getText().trim();
        String password = loginPasswordField.getText().trim();
        boolean isAdmin = cbAdmin.isSelected();

       if (!isAdmin) {
        if(username.isEmpty() || password.isEmpty()) {
            new Alert(AlertType.ERROR, "Please enter username and password!").showAndWait();
            return;
        }

        if(registeredUsers.containsKey(username) && registeredUsers.get(username).equals(password)) {
            SwitchToScene6(event);
        } else {
            new Alert(AlertType.ERROR, "Invalid username or password!").showAndWait();
        }
       }
       else {
    	   if(username.isEmpty() || password.isEmpty()) {
               new Alert(AlertType.ERROR, "Please enter username and password!").showAndWait();
               return;
           }

           if(ReadAdminFile.validateAdmin(username, password)) {
               SwitchToScene7(event);
           } else {
               new Alert(AlertType.ERROR, "Invalid username or password!").showAndWait();
           }
       }
    }

    // Registration
    @FXML
    private void registerUser(ActionEvent event) throws IOException {
        String username = nameField.getText().trim();
        String password = passwordField.getText().trim();

        if(username.isEmpty() || password.isEmpty()) {
            new Alert(AlertType.ERROR, "Username and password cannot be empty!").showAndWait();
            return;
        }

        if(registeredUsers.containsKey(username)) {
            new Alert(AlertType.ERROR, "Username already exists!").showAndWait();
            return;
        }

        registeredUsers.put(username, password);
        new Alert(AlertType.INFORMATION, "Registration successful!").showAndWait();

        // Return to login page
        SwitchToScene3(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}  