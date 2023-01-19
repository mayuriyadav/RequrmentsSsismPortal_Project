package Com.RequrmentsProject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import Com.RequrmentsProject.Entity.Student;

public interface StudentRepo extends  JpaRepository<Student , String  > {

}
