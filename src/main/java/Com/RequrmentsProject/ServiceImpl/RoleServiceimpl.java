package Com.RequrmentsProject.ServiceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.RequrmentsProject.Entity.Role;
import Com.RequrmentsProject.Repo.RoleRepo;
import Com.RequrmentsProject.Service.RoleService;
import Com.RequrmentsProject.payloads.RoleDto;

@Service
public class RoleServiceimpl implements RoleService {
	
	@Autowired
       private RoleRepo roleRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public RoleDto createRole(RoleDto roleDto) {
		Role role= this.modelMapper.map(roleDto, Role.class);
		Role  saveRole = this.roleRepo.save(role);
		return this.modelMapper.map(saveRole, RoleDto.class);
	}
}
