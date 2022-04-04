package ro.ase.cts.g1098.design.patterns.models;

public enum LoggerType {
	
	ERROR("errors.log", "*Error*"), INFO("info.log", "<<Info>>");
	
	//bcs the loggers can t now which type of file they re logging
	private String filename;
	private String logPattern;
	
	private LoggerType(String filename, String logPattern) {
		this.filename = filename;
		this.logPattern = logPattern;
	}
	
	public String getFilename() {
		return filename;
	}

	public String getLogPattern() {
		return logPattern;
	}

}
