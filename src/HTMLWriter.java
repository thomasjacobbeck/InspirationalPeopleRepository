import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
/**
 * This class provides tools to write a simple HTML file
 * 
 * @author Tom Beck
 *
 */
public class HTMLWriter {

	private ArrayList<String> tagList = new ArrayList<String>();
	private Path htmlPath = null;
	private File htmlFile = null;
	private PrintWriter output = null;
	
/**
 * Creates an HTMLWriter that writes everything to the file specifyied.
 * Clears the content of the file if one allready exists.
 * @param fileName The name of the file being written to.
 */
	public HTMLWriter(String fileName) {
		htmlPath = Paths.get(fileName);
		if (Files.exists(htmlPath)) {
			htmlFile = htmlPath.toFile();
			clearFile();
		} else
			try {
				Files.createFile(htmlPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			output = new PrintWriter(new BufferedWriter(new FileWriter(htmlFile)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Takes a String and surrounds it with angle brackets "&lt;sampleTagName&gt;" .
	 * Also writes the name to an Array List to be used by the endTag Method.
	 * @param tagName The name of the tag being started. 
	 */
	public void startTag(String tagName) {
		String carrotedString;
		tagList.add(tagName);
		carrotedString = "<" + tagName + ">";
		writeData(carrotedString);
	}
	/**
	 * Takes the last tag put from the tagList and generates an end tag from it. &lt;/sampleTagName&gt;
	 */
	public void endTag() {
		String carrotedEndString;
		carrotedEndString = "</" + tagList.get(tagList.size() - 1) + ">";
		tagList.remove(tagList.size() - 1);
		writeData(carrotedEndString);
	}
	/**
	 * Puts a string into the buffered writer
	 * @param content String to write
	 */
	public void writeData(String content) {
		output.print(content);
	}

	/**
	 * Clears the file of any content.
	 */
	private void clearFile() {
		try (PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(htmlFile)))) {
			output.print("");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * Flushes the buffer writer, and writes to the file.
	 * Closes the writer.
	 */
	public void closeFile(){
		output.flush();
		output.close();
	}
}
