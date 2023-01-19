package Com.RequrmentsProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Com.RequrmentsProject.Service.RoleService;
import Com.RequrmentsProject.payloads.RoleDto;


@RestController
@RequestMapping ("/api/role")
public class RoleController {
@Autowired
private RoleService roleService ;

 @PostMapping("/")
 public ResponseEntity<RoleDto>createRole(@RequestBody RoleDto roleDto){
	  RoleDto role = this.roleService.createRole(roleDto);
	  return new ResponseEntity<RoleDto>(role,HttpStatus.CREATED);
		}
}
