package Com.RequrmentsProject.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import Com.RequrmentsProject.Entity.User;
import Com.RequrmentsProject.Exception.UserNotFoundException;
import Com.RequrmentsProject.Service.UserService;
import Com.RequrmentsProject.ServiceImpl.EmailCode;
import Com.RequrmentsProject.payloads.UserDto;
import net.bytebuddy.utility.RandomString;

@RestController

public class FrogetController {
	
 @Autowired
 private EmailCode emailCode ;
 @Autowired
  private  UserService userService;
     
 @GetMapping("/forgot_password")
 public String showForgotPasswordForm(){
     return "forget_paasword";
 }

 @PostMapping("/forgot_password/{email}")
 public String processForgotPasswordForm(@PathVariable("email") String email,HttpServletRequest request){
     String token= RandomString.make(10);
     System.out.println("Email : "+email);
     System.out.println("Token :"+token);
     
     try {
         userService.updateResetPasswordToken(token, email);

         String resetPasswordLink = request.getScheme() + "://" + request.getServerName()+":1122/reset_passsword/"  + token;
         System.out.println(resetPasswordLink);

         sendEmails(email, resetPasswordLink);

     } catch (UserNotFoundException e) {
         
         e.printStackTrace();
     }
//model.addAttribute("pageTitle","forgot passsword");
     return "forgot_password_check_your_email";
 }

 public void sendEmails(String email, String resetPassword)
 {
     String to=email;
     String subject="Your Login Password";
     String from="mayuriy.bca2021@ssism.org";
     String massage="To reset your password, click the link below:\n"
      + resetPassword;
 
     emailCode.sendEmail(subject,massage,to,from);
 }


 @GetMapping("/reset_passsword_2")
 public String showResetPasswordForm(@Param(value="token") String token)
 {
     User user = userService.get(token);
     if(user==null){
         return "invalid token";
     }

     //model.addAttribute("toke",token);
     //model.addAttribute("pageTitle","Reset you passsword");
     return "reset_password_form";
 }

 @PostMapping("/reset_passsword/{tokens}")
 public String proccessResetPassword(@PathVariable("tokens") String tokens,HttpServletRequest request,@RequestBody UserDto userDto){//, @RequestBody UserDto userDto
     String token= request.getParameter("token");
     String password=request.getParameter("password");
     String pass=userDto.getPassword();
     User user = userService.get(tokens);
     System.out.println("user is "+user);
     if(user==null){
         return "invalid token";
     }else{
         userService.updatePassword(user, pass);
         return "you have successfuly changed your password ";
}
 
}

}
