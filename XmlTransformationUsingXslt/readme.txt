Using XSLT to transform an xml to another xml using Java
1. Create StreamSource object for the input xml file
2. Create StreamSource object for the input xslt file
3. Create StreamResult object for the output file
4. Create TransformerFactory and create an instance of Transformer object by passing the xslt streamsource object
5. Use transform method on the transformer object and pass the input stream source object and the output streamresult object
6. The final output file is created with the required transformations as per the xlst file
