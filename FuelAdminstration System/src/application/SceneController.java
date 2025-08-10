package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void SwitchToScene1(ActionEvent event) throws IOException {
		Parent root  =FXMLLoader.load(getClass().getResource("CarReg.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		

}
	public void SwitchToScene2(ActionEvent event) throws IOException {
		Parent root  =FXMLLoader.load(getClass().getResource("Payment.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		

}
	
	public void SwitchToScene3(ActionEvent event) throws IOException {
		Parent root  =FXMLLoader.load(getClass().getResource("CoverPage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		

}
	public void SwitchToScene4(ActionEvent event) throws IOException {
		Parent root  =FXMLLoader.load(getClass().getResource("Registration.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		

}
	public void SwitchToScene5(ActionEvent event) throws IOException {
		Parent root  =FXMLLoader.load(getClass().getResource("Forgot Password.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		

}
	public void SwitchToScene6(ActionEvent event) throws IOException {
		Parent root  =FXMLLoader.load(getClass().getResource("FuelPage.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		

}
}