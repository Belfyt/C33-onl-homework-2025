package homework23;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.Characters;
import java.io.FileInputStream;

public class StaxParser {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("D:/homework/new test/src/main/java/homework23/xml")) {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader = factory.createXMLEventReader(fileInputStream);

            String elementName = "";
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    elementName = startElement.getName().getLocalPart();
                } else if (event.isCharacters()) {
                    Characters characters = event.asCharacters();
                    if (!characters.isWhiteSpace() && !elementName.isEmpty()) {
                        System.out.println(elementName + ": " + characters.getData());
                    }
                } else if (event.isEndElement()) {
                    elementName = "";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}