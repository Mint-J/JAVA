package J2EE;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class Sax_Xml {
	
	@Test
	public void read() throws Exception {
		
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/BookInfo.xml");
		Element root = document.getRootElement();
		Element book =  (Element) root.elements("book").get(1);
		String value = book.attributeValue("ID");
		System.out.println(value);
		Element name = (Element) book.element("name");
		String nameValue = name.getText();
		System.out.println(nameValue);
	}
	
	@Test
	public void add() throws Exception {
		
		SAXReader reader = new SAXReader();
		Document document = reader.read("src//BookInfo.xml");
		Element book = document.getRootElement().elements("book").get(1);
		book.addElement("date").setText("1973-2-14");
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		
		XMLWriter writer = new XMLWriter(new FileOutputStream("src//BookInfo.xml"), format);
		writer.write(document);
		writer.close();
		
	}
	
	@Test
	public void XpathDemo() throws Exception {
		
		String ID = "8";
		
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src//BookInfo.xml"));
		Node node = document.selectSingleNode("//book[@ID='"+ ID +"']");
		if (node == null) {
			System.out.println("Error!");
		} else {
			System.out.println("Welcome!");
		}
	}
	
}
