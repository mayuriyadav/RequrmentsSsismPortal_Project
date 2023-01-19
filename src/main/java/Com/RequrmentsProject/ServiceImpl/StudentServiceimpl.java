package Com.RequrmentsProject.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Com.RequrmentsProject.App.AppConstants;
import Com.RequrmentsProject.Entity.Role;
import Com.RequrmentsProject.Entity.Student;
import Com.RequrmentsProject.Entity.User;
import Com.RequrmentsProject.Exception.ResourceNotFoundException;
import Com.RequrmentsProject.Repo.RoleRepo;
import Com.RequrmentsProject.Repo.StudentRepo;
import Com.RequrmentsProject.Repo.UserRepo;
import Com.RequrmentsProject.Service.StudentService;
import Com.RequrmentsProject.payloads.StudentDto;

@Service
public class StudentServiceimpl  implements StudentService{
    @Autowired
	private StudentRepo studentRepo ;
    @Autowired 
	private RoleRepo roleRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepo userRepo;
    @Autowired
  private ModelMapper modelMapper ;
	@Override
	public StudentDto createStudent(StudentDto studentDto) {
		User user = new User();		
		
		Student student  = this.modelMapper.map(studentDto, Student.class);
        
		user.setEmail(student.getEmail());
		String random=RandomString.make(8);
		user.setPassword(random);
		EmailCode.email(user);
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		Role role =this.roleRepo.getByid(AppConstants.STUDENT);
		user.getRole().add(role);
		this.userRepo.save(user);
		Student saveStudent =this.studentRepo.save(student);
		return this.modelMapper.map(saveStudent, StudentDto.class);
	}

	@Override
	public StudentDto updateStudent(StudentDto studentDto,String  stuId) {
		Student student = this.studentRepo.findById(stuId).orElseThrow(() -> new ResourceNotFoundException("Student","stuId",stuId));
		student.setStuId(studentDto.getStuId());
		student.setStudentName(studentDto.getStudentName());
		student.setStd(studentDto.getStd());
		student.setAddress(studentDto.getAddress());
		student.setSsismGroup(studentDto.getSsismGroup());
		student.setQualification(studentDto.getQualification());
		student.setProfileImage(studentDto.getProfileImage());
		student.setMobileNo(studentDto.getMobileNo());
		student.setLinkedinUrl(studentDto.getLinkedinUrl());
		student.setGender(studentDto.getGender());
		student.setClassYear(studentDto.getClassYear());
		student.setEnabled(studentDto.getEnabled());
		Student saveStudent = this.studentRepo.save(student);
		return this.modelMapper.map(saveStudent, StudentDto.class);
	}

	@Override
	public List<StudentDto> getAllStudent() {
		List<Student> students = this.studentRepo.findAll();
		List<StudentDto> saveStudent = students.stream().map( s ->this.modelMapper.map(s,StudentDto.class)).collect(Collectors.toList());
		return saveStudent;
	}

	@Override
	public StudentDto getbyIdStudent(String  stuId) {
		Student student = this.studentRepo.findById(stuId).orElseThrow(() -> new ResourceNotFoundException("Student","stuId",stuId));
		return this.modelMapper.map(student, StudentDto.class);
	}

}
