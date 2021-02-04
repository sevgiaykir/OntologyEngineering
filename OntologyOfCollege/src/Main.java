import java.io.*;
import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.util.FileManager;

public class Main extends Object{
static final String inputFileName="C:\\Users\\asus\\eclipse-workspace\\OntologyOfCollege\\college.owl";
	
public static void main(String args[]) {
//Creating a blank model
Model model=ModelFactory.createDefaultModel();	
//Opening the owl file with file manager
InputStream in=FileManager.get().open("C:\\Users\\asus\\eclipse-workspace\\OntologyOfCollege\\college.owl");
//Verifying the file and its source
if(in==null) 
{
	throw new IllegalArgumentException(inputFileName+" dosyasý bulunamadý.");
}
//Reading the owl file
model.read(in,"college.owl");

//Creating queries
String s1="PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\n" + 
		"PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\n" + 
		"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\n" + 
		"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\n" + 
		"PREFIX ab: <http://www.semanticweb.org/asus/ontologies/2021/0/untitled-ontology-17#>\r\n" + 
		"SELECT ?Student ?Course\r\n" + 
		"	WHERE {{ ?Student ab:studies  ?Course}\r\n" + 
		"	{?Student ab:goesTo ?HighSchool}}";

String s2="PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\n" + 
		"PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\n" + 
		"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\n" + 
		"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\n" + 
		"PREFIX ab: <http://www.semanticweb.org/asus/ontologies/2021/0/untitled-ontology-17#>\r\n" + 
		"SELECT  ?Teacher ?Course\r\n" + 
		"	WHERE {	{?Teacher ab:teaches  ?Course}\r\n" + 
		"		{?Teacher ab:worksAt ?HighSchool}}\r\n";

String s3="PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\n" + 
		"PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\n" + 
		"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\n" + 
		"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\n" + 
		"PREFIX ab: <http://www.semanticweb.org/asus/ontologies/2021/0/untitled-ontology-17#>\r\n" + 
		"SELECT ?class\r\n" + 
		"	WHERE { ?class rdfs:subClassOf  ab:Person }";

String s4="PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\n" + 
		"PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\n" + 
		"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\n" + 
		"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\n" + 
		"PREFIX ab: <http://www.semanticweb.org/asus/ontologies/2021/0/untitled-ontology-17#>\r\n" + 
		"SELECT ?class\r\n" + 
		"	WHERE { ?class rdfs:subClassOf  ab:Course }";

String s5="PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\n" + 
		"PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\n" + 
		"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\n" + 
		"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\r\n" + 
		"PREFIX ab: <http://www.semanticweb.org/asus/ontologies/2021/0/untitled-ontology-17#>\r\n" + 
		"SELECT DISTINCT ?Person \r\n" + 
		"	WHERE { ?Person ab:hasStudent  ?Student}  ";

Query query1 = QueryFactory.create(s1);
QueryExecution q1 = QueryExecutionFactory.create(query1, model);
ResultSet result1 = q1.execSelect();
ResultSetFormatter.out(System.out, result1, query1);

Query query2 = QueryFactory.create(s2);
QueryExecution q2 = QueryExecutionFactory.create(query2, model);
ResultSet result2 = q2.execSelect();
ResultSetFormatter.out(System.out, result2, query2);

Query query3 = QueryFactory.create(s3);
QueryExecution q3 = QueryExecutionFactory.create(query3, model);
ResultSet result3 = q3.execSelect();
ResultSetFormatter.out(System.out, result3, query3);

Query query4 = QueryFactory.create(s4);
QueryExecution q4 = QueryExecutionFactory.create(query4, model);
ResultSet result4 = q4.execSelect();
ResultSetFormatter.out(System.out, result4, query4);

Query query5 = QueryFactory.create(s5);
QueryExecution q5 = QueryExecutionFactory.create(query5, model);
ResultSet result5 = q5.execSelect();
ResultSetFormatter.out(System.out, result5, query5); 

//Releasing resources after the queries is finished
q1.close();
q2.close();
q3.close();
q4.close();
q5.close();

} }


