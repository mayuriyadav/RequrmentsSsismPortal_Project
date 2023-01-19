package Com.RequrmentsProject.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Com.RequrmentsProject.Service.StudentService;
import Com.RequrmentsProject.payloads.StudentDto;



@RestController
@RequestMapping ("/api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	
	
	@PostMapping("/")
	public ResponseEntity<StudentDto>createStudent(@RequestBody StudentDto studentDto){
	StudentDto student = this.studentService.createStudent(studentDto);
	return new ResponseEntity<StudentDto>(student ,HttpStatus.CREATED);
	}
	
	@PutMapping("/{stdId}")
	public ResponseEntity<StudentDto> updateStudent( @RequestBody  StudentDto studentDto, @PathVariable String  stuId){
		StudentDto student  = this.studentService.updateStudent(studentDto, stuId);
		return new  ResponseEntity<StudentDto>(student,HttpStatus.OK);
	}

	@GetMapping("/{stdId}")
	
	public ResponseEntity<StudentDto> getByUserId(@PathVariable String  stdId){
		StudentDto student = this.studentService.getbyIdStudent(stdId);
		 return new ResponseEntity<StudentDto>(student ,HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<List<StudentDto>>getAllStudent(){
		
		List<StudentDto> allstudent = this.studentService.getAllStudent();
		return new ResponseEntity<List<StudentDto>>(allstudent,HttpStatus.OK);
	}
}
