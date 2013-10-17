/**
 * Error which is thrown when a file is inaccessible for any reason.
 * @author TobalJackson
 *
 */
public class FileInaccessible extends Exception {
	public FileInaccessible(String errorDesc){
		super(errorDesc);	
	}
}
