package Com.RequrmentsProject.Exception;

public class ResourceNotFoundException extends RuntimeException{

	private String sourceName;
	private String fieldName;
	private String fieldValue;
	public ResourceNotFoundException(String sourceName, String fieldName, String fieldValue) {
		super(String.format("%s Not Found With This %s - %s ",sourceName,fieldName,fieldValue));
		this.sourceName = sourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	

}
