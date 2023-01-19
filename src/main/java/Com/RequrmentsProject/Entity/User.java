package Com.RequrmentsProject.Entity;


import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="User")
@Setter
@Getter
@NoArgsConstructor
public class User  implements UserDetails{
	
	@Id
	
         private String userId =UUID.randomUUID().toString();	
         private String email;
         private String password ;
         
         @Column(name = "reset_password_token")
         private String resetPasswordToken;
        
         @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   	  @JoinTable(name="user_role",joinColumns = @JoinColumn(name = "user",referencedColumnName="userId"),
   			  inverseJoinColumns = @JoinColumn(name="role",referencedColumnName = "id"))
   	  private Set<Role> role = new HashSet<>();
         
         
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			 List<SimpleGrantedAuthority> authories=this.role.stream().map((roles)-> new SimpleGrantedAuthority(roles.getName())).collect(Collectors.toList());

		        return authories;
		}
		@Override
		public String getUsername() {
			
			return email;
		}
		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}
		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}
		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}
		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}
        		 
}
