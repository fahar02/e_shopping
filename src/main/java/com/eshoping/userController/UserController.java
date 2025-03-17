package com.eshoping.userController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eshoping.dao.CustomerDetailsDao;
import com.eshoping.entity.Customer;
import com.eshoping.service.CustomerService;
import com.eshoping.service.EmailService;

import jakarta.servlet.http.HttpServletRequest;
// @RestController is used to avoid multiple @ResponseBody anotation
@Controller
public class UserController {
	@Autowired
	CustomerService service;
	@Autowired
	private EmailService emailService;
	
@PostMapping("/registration")
@ResponseBody
public ResponseEntity<Customer> customerRegistration(@RequestBody Customer customer) {
	
	
if(customer.getName()!=null)	
	{
		
	return	service.customerRegistration(customer);
		
		
	}
	else {
		return service.customerRegistration(customer);
	}
	
//	if(customer.getName()!=null)
//		
//	{
//		try {
//		service.customerRegistration(customer);
//			
//		} catch (Exception e) {
//		return e.getMessage();
//		}
//		return "registartion successfully";
//		
//	}
//	else {
//		return "email is present already";
//	}
//	
	
}
@GetMapping("/selectCustomer")
@ResponseBody
public Customer selectCustomerDetails()
{
	
return	service.getCustomer("fahar@gmail.com","1234");
}
@PutMapping("/updateCustomer")
@ResponseBody
public String updateCustomerdetails()
{
	return "update details";
	
}

@DeleteMapping("/deleteCustomer")
@ResponseBody
public String deleteCustomerDetails()
{

	return "data deleted";
}
@GetMapping("/login/{email}/{password}")
public ResponseEntity<Customer> login(@PathVariable("email") String email,@PathVariable
		("password")String password)
{
	return service.cuslogin(email,password);
}
@GetMapping("/customerlogin")
public String customerloginin(@RequestParam String email,@RequestParam String password
		,HttpServletRequest req)
{
	
System.out.println("emailId"+email);
System.out.println("password"+password);
int otp=1000+(int)(Math.random()*(9999-1000))+1;
req.setAttribute("otp",otp);
emailService.sendTextMail(email,"for email varification","your otp is"+otp);
	return "otp send successfully";
}
@GetMapping("/otpvalidation/{otp}")
public String otpValidation(@PathVariable("otp")int otp,HttpServletRequest req)
{
	 Integer sessionOtp = (Integer) req.getSession().getAttribute("otp");

	    if (sessionOtp != null && sessionOtp == otp) {
	        return "OTP validation successful!";
	    } else {
	        return "Invalid OTP. Please try again.";
	    }
}
}
