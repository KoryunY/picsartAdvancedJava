package XML;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private static final String FILE_NAME="src\\XML\\employees.xml";
    public static void serializeXml(List<Employee> employees){
        DocumentBuilderFactory dbFactory =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = dBuilder.newDocument();
        Element rootElement = doc.createElement("employees");
        doc.appendChild(rootElement);



        for (Employee employee:employees) {
            Element temployee = doc.createElement("employee");
            rootElement.appendChild(temployee);
            Attr attr = doc.createAttribute("id");
            attr.setValue(String.valueOf(employee.getId()));
            temployee.setAttributeNode(attr);

            Element firstName = doc.createElement("firstName");
            firstName.appendChild(doc.createTextNode(employee.getFirstName()));
            temployee.appendChild(firstName);

            Element lastName = doc.createElement("lastName");
            lastName.appendChild(doc.createTextNode(employee.getLastName()));
            temployee.appendChild(lastName);

            Element location = doc.createElement("location");
            location.appendChild(doc.createTextNode(employee.getLocation()));
            temployee.appendChild(location);
        }


        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(FILE_NAME));
            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
    public static List<Employee> deSerializeXml(){
        List<Employee> employees=new ArrayList<>();
        try {
            File inputFile = new File(FILE_NAME);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("employee");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    Employee employee=new Employee(Integer.parseInt(eElement.getAttribute("id")));

                    employee.setFirstName(eElement
                            .getElementsByTagName("firstName")
                            .item(0)
                            .getTextContent());
                    employee.setLastName(eElement
                            .getElementsByTagName("lastName")
                            .item(0)
                            .getTextContent());
                    employee.setLocation(eElement
                            .getElementsByTagName("location")
                            .item(0)
                            .getTextContent());
                   employees.add(employee);
                }
            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        return employees;
    }
}
