package xml.transformations;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


public class XmlTransformer {

	public static void main(String[] args) throws TransformerConfigurationException {
	
		StreamSource xmlSource = new StreamSource("src/xml/transformations/input/courses.xml");
		StreamSource xsltSource = new StreamSource("src/xml/transformations/input/courses2students.xsl");
		StreamResult result = new StreamResult("src/xml/transformations/output/students.xml");
		
		
		//create a transformer factory
		TransformerFactory factory = TransformerFactory.newInstance();
				
		
		//create a transformer class
		Transformer transformer = factory.newTransformer(xsltSource);
		
		
		
		//call transform method with input and output
		try {
			System.out.println("Calling transformation");
			transformer.transform(xmlSource, result);
		} catch (TransformerException e) {
			System.out.println("exception:"+e.getMessage());
			e.printStackTrace();
		}

	}

}
