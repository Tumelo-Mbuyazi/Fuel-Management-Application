package application;
	
	import javax.xml.parsers.DocumentBuilder;
	import javax.xml.parsers.DocumentBuilderFactory;
	import org.w3c.dom.*;

	import java.io.File;

	public class ReadAdminFile {

	    // Method to validate admin username and password
	    public static boolean validateAdmin(String username, String password) {
	        try {
	            File xmlFile = new File("admin.xml");
	            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder builder = factory.newDocumentBuilder();
	            Document doc = builder.parse(xmlFile);
	            doc.getDocumentElement().normalize();

	            NodeList adminList = doc.getElementsByTagName("Admin");

	            for (int i = 0; i < adminList.getLength(); i++) {
	                Node adminNode = adminList.item(i);

	                if (adminNode.getNodeType() == Node.ELEMENT_NODE) {
	                    Element adminElement = (Element) adminNode;

	                    String xmlUsername = adminElement.getElementsByTagName("Username")
	                                                     .item(0).getTextContent();
	                    String xmlPassword = adminElement.getElementsByTagName("Password")
	                                                     .item(0).getTextContent();

	                    if (xmlUsername.equals(username) && xmlPassword.equals(password)) {
	                        return true; 
	                    }
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

}
