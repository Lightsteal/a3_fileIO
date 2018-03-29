
public class FileInvalidException extends Exception {
	private String message;
	
	public FileInvalidException(String msg){
		this.message = msg;
	}
	
	public FileInvalidException(){
		this.message = "Error: Input file cannot be parsed due to missing information (i.e. month={}, title={}, etc.)";
	}
	
	public String getMessage(){
		return this.message;
	}
	
}
