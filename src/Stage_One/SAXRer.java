package Stage_One;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class SAXRer {

	public static void main(String args[]) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance(); // Create factory
		SAXParser sp = factory.newSAXParser(); // Get parser
		XMLReader reader = sp.getXMLReader(); // Get reader
		BeanListHandler handler = new BeanListHandler();
		reader.setContentHandler(handler); // Set handler
		reader.parse("src\\BookInfo.xml"); // Read file
		List<Book> list = handler.getBooks();
		System.out.println(list);
	}

}

// Seal books into Objects and store them into a LIST.
class BeanListHandler extends DefaultHandler {

	private List<Book> list = new ArrayList<Book>();
	private String currentTag;
	private Book book;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		currentTag = qName;
		if ("book".equalsIgnoreCase(currentTag)) {
			book = new Book();
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("book")) {
			list.add(book);
			book = null;
		}
		currentTag = null;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if ("name".equalsIgnoreCase(currentTag)) {
			String name = new String(ch, start, length);
			book.setName(name);
		}
		if ("author".equalsIgnoreCase(currentTag)) {
			String author = new String(ch, start, length);
			book.setAuthor(author);
		}
		if ("price".equalsIgnoreCase(currentTag)) {
			double price = Double.parseDouble(new String(ch, start, length));
			book.setPrice(price);
		}
	}

	public List<Book> getBooks() {
		return list;
	}
}