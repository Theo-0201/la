package ro.ase.cts.g1098.design.patterns.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import ro.ase.cts.g1098.design.patterns.exceptions.MissingInputArgException;
import ro.ase.cts.g1098.design.patterns.interfaces.ILogging;

public class Logger implements ILogging {
	
	//null by default
	private static Logger logger;
	
	private String filename;
	//Strings are null by default, so "" is actually a value
	private String messagePattern = "";
	private File logFile;
	
	//no default constructor, bcs we need to at least provide a file when creating a logger
	
	private Logger(String filename, String messagePattern) throws MissingInputArgException, IOException {

		if(filename == null || filename.length() < 4)
		{
			throw new MissingInputArgException();
		}
		
		this.filename = filename;
		this.messagePattern = messagePattern != null ? messagePattern : "";
		
		this.logFile = new File(this.filename);
		if(!this.logFile.exists()) {
			this.logFile.createNewFile();
		}
	}

	@Override
	//ff
	public void log(String msg) {
		String log = String.format("%s (%s) - %s", this.messagePattern, LocalDateTime.now().toString(), msg);
		try {
			FileWriter fileWriter = new FileWriter(logFile, true);
			PrintWriter printWriter = new PrintWriter(logFile);
			printWriter.println(log);
			printWriter.close();
			fileWriter.close();
		} catch (IOException e) {

		}
	}
	
	//default access level for classes in the same package
	static ILogging getLogger(String filename, String pattern) throws MissingInputArgException, IOException {
		if(logger == null) {
			logger = new Logger(filename, pattern);
		}
		return logger;
	}
	
}
