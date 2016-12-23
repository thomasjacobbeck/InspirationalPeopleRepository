import java.sql.*;
/**
 * This class uses takes data from the InspirationalDB and uses HTMLWriter to generates a simple website.
 * This website will display the names of inspirational people and some facts about them
 * @author Tom Beck
 *
 */
public class InspirationalPeapleHTMLGeneratorApp {
	static HTMLWriter hw= new HTMLWriter("inspirationalpeople.html");
	private static Connection c=InspirationalDB.getConnection();
	public static void main(String arg[]) {
		hw.startTag("html");
		hw.startTag("body");
		writeFacts();
		hw.endTag();
		hw.endTag();
		hw.closeFile();
	}
	/**
	 * This method fills the body of the HTML file with facts from the database
	 * Ensures that each person in the datatbase has their name printed once
	 */
	public static void writeFacts() {
		try (Statement statement = c.createStatement();
				ResultSet rs = statement.executeQuery("select p.personname, f.facttext from people p, facts f where p.personid=f.personid order by p.personname")){
			String currentPerson=null;
			while(rs.next()){
				//Ensures that each person in the datatbase has their name printed once
				if(currentPerson!=(rs.getString("personname"))){
					currentPerson=rs.getString("personname");
					hw.startTag("p");
					hw.writeData("<br>");
					hw.writeData(currentPerson);
					hw.endTag();
				}
				hw.startTag("p");
				hw.writeData(rs.getString("facttext"));
				hw.writeData("<br>");
				hw.endTag();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
