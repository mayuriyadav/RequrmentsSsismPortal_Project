package Com.RequrmentsProject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Com.RequrmentsProject.Entity.Role;

public interface RoleRepo  extends JpaRepository<Role, Integer>{

	@Query("select r from  Role r where r.id =:id")
	Role getByid(String id);
}
