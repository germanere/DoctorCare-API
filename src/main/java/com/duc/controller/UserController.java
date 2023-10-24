package com.duc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.duc.dto.AddDoctorAccDto;
import com.duc.dto.ForgotPasswordDto;
import com.duc.dto.LoginDto;
import com.duc.dto.ResetPasswordDto;
import com.duc.dto.SearchDocterDto;
import com.duc.dto.SearchResultDto;
import com.duc.dto.UserDto;
import com.duc.dto.UserinfoDto;
import com.duc.dto.addScheldulesDto;
import com.duc.entity.Clinic;
import com.duc.entity.DoctorUser;
import com.duc.entity.Role;
import com.duc.entity.Schedule;
import com.duc.entity.User;
import com.duc.exception.InvalidCredentialsException;
import com.duc.exception.UserNotFoundException;
import com.duc.service.AuthService;
import com.duc.service.ClinicService;
import com.duc.service.DoctoruserService;
import com.duc.service.ForgotPasswordService;
import com.duc.service.SchelduleService;
import com.duc.service.UserService;
import com.duc.service.roleService;


@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private DoctoruserService doctoruserService;
	
	@Autowired
	private ClinicService clinicService;
	
	@Autowired
	private SchelduleService scheduleService;
	
	@Autowired
	private ForgotPasswordService forgotPasswordService;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private roleService roleService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody UserDto userDto){
		try {
			User newUser = new User();
            // Kiểm tra xem người dùng đã tồn tại trong cơ sở dữ liệu chưa
			if(userService.existsByEmail(newUser.getEmail())) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email đã được sử dụng");
			}
            // Lưu thông tin người dùng vào cơ sở dữ liệu
			newUser.setName(userDto.getFullname());
			newUser.setGender(userDto.getGender());
			newUser.setEmail(userDto.getEmail());
			newUser.setPhone(userDto.getPhone());
			newUser.setAddress(userDto.getAddress());
			newUser.setPassword(userDto.getPassword());
			newUser.setStatus(1);
			newUser.setCreatedAt("1/1/2023");
			Role role = roleService.getRole(2);
			newUser.setRole(role);
	        userService.saveUser(newUser);
	        // Trả về tin nhắn thành công khi đăng ký thành công
	            return ResponseEntity.ok("Đăng ký thành công!");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Đã xảy ra lỗi trong quá trình đăng ký");
		}
		
	}
	
	@PostMapping("/addscheldule")
	public ResponseEntity<String> addschel(@RequestBody addScheldulesDto ScheldulesDto) {
		try {
			Schedule schedule = new Schedule();
			schedule.setCreatedAt("3/1/2023");
			schedule.setMaxBooking("20000");
			schedule.setTime(ScheldulesDto.getTime());
			schedule.setDate("3/1/2023");
			User user = userService.FindUserById(ScheldulesDto.getIduser());
			if(schedule.getUsers()!=null) {
				schedule.setUsers(user);
				scheduleService.saveschedule(schedule);
			}
				
				User newuser = new User();
				newuser.setName(ScheldulesDto.getName());
				newuser.setAddress(ScheldulesDto.getAddress());
				newuser.setPhone(ScheldulesDto.getPhone());
				newuser.setGender(ScheldulesDto.getGender());
				newuser.setEmail(ScheldulesDto.getEmail());
				newuser.setCreatedAt("10/2/2023");
				newuser.setStatus(1);
				newuser.setPassword("abc123123");
				Role role = roleService.getRole(2);
				newuser.setRole(role);
				userService.saveUser(newuser);
			schedule.setStatus(1);	
			schedule.setUsers(user);
			scheduleService.saveschedule(schedule);
			return ResponseEntity.ok("Đã thêm lịch khám thành công!");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Đã xảy ra lỗi trong quá trình đăng ký lịch");
		}
	}
	
	@PostMapping("/admin/adddoc")
	public ResponseEntity<String> addacountdoctor(@RequestBody AddDoctorAccDto accDto) {
		try { 
			User doctorUser = new User();
			if(userService.existsByEmail(doctorUser.getEmail()) ) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email đã được sử dụng");
			}
			doctorUser.setName(accDto.getNamedoctor());
			doctorUser.setAddress(accDto.getAddress());
			doctorUser.setEmail(accDto.getEmail());
			doctorUser.setGender(accDto.getGender());
			doctorUser.setPhone(accDto.getPhone());
			doctorUser.setPassword(accDto.getPassword());
			doctorUser.setStatus(1);
			doctorUser.setCreatedAt("10/1/2023");
			Role role = roleService.getRole(1);
			doctorUser.setRole(role);
			userService.saveUser(doctorUser);
			DoctorUser doctoruser = new DoctorUser();
			doctoruser.setCreatedAt("10/1/2023");
			doctoruser.setUsers(doctorUser);
			Clinic clinic = clinicService.Findclinicbyid(accDto.getClinicid());
			doctoruser.setClinic(clinic);
			doctoruserService.savedoctor(doctoruser);
			return ResponseEntity.ok("Đã thêm tài khoản bác sĩ thành công!");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Đã xảy ra lỗi trong quá trình đăng ký tài khoản");
		}

	}
	
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto logindto) {
        try {
            String token =authService.login(logindto);
            return ResponseEntity.ok(token);
        } catch (InvalidCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        } catch (Exception e) {
        	e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi xảy ra trong quá trình đăng nhập");
        }
        
    }
    
    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword( @RequestBody ForgotPasswordDto request) {
        try {
            forgotPasswordService.sendVerificationCode(request.getEmail());
            return ResponseEntity.ok("Vui lòng kiểm tra email để lấy mã xác thực.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordDto request) {
        try {
            forgotPasswordService.resetPassword(request.getEmail(), request.getNewPassword(), request.getConfirmPassword());
            return ResponseEntity.ok("Mật khẩu đã được cập nhật thành công.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserinfoDto> getuser(@PathVariable int id) {
        User user = userService.FindUserById(id);
        if (user == null) {
            throw new UserNotFoundException("User not found!");
        }
        UserinfoDto userinfoDto = new UserinfoDto();
        userinfoDto.setAddress(user.getAddress());
        userinfoDto.setEmail(user.getEmail());
        userinfoDto.setName(user.getName());
        userinfoDto.setGender(user.getGender());
        userinfoDto.setPhone(user.getPhone());
        
        return ResponseEntity.ok(userinfoDto);
    }
    
	@GetMapping("/result-search")
	public ResponseEntity<List<SearchResultDto>> search(@RequestParam("keyword") String keyword) {
		try {
			List<SearchResultDto> resultDtos = clinicService.searesult(keyword);
			return ResponseEntity.ok(resultDtos);
		} catch (Exception e) {
			System.out.println("core dump bitch !!!");
			e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());
		}

	}
	
	@GetMapping("/doctor-search")
    public ResponseEntity<List<SearchDocterDto>> searchDoctors(@RequestParam("keyword") String keyword) {
        try {
           List<SearchDocterDto> doctors = userService.seaUsers(keyword);
            return ResponseEntity.ok(doctors);
        } catch (Exception e) {
        	e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());
        }
    }
	
}
    
    

   

