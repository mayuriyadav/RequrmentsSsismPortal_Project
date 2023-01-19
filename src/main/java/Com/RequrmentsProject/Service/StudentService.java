package Com.RequrmentsProject.Service;

import java.util.List;

import Com.RequrmentsProject.payloads.StudentDto;


public interface StudentService {

	StudentDto createStudent(StudentDto studentDto);
	
	StudentDto updateStudent(StudentDto studentDto,String  stuId);
	
	List< StudentDto>getAllStudent();
	
	StudentDto getbyIdStudent(String  stuId);
	
	
}
