package ro.ase.cts.g1098.design.patterns.interfaces;

public interface ILogging {
	
	//all methods are abstract by default
	public abstract void log(String msg);
	
	//we have a singleton for the errors files and the info files

}
