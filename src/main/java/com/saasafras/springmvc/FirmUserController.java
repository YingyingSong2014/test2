package com.saasafras.springmvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.saasafras.model.Employee;
import com.saasafras.model.Role;


@Controller
@RequestMapping("/user")
public class FirmUserController {
	
	static Map<String,Employee> hashMap = new HashMap<String,Employee>();
	static{
		// TODO Auto-generated method stub
		hashMap.put("1", new Employee("1","e1","e1",new Role("1","Amin")));
		hashMap.put("2", new Employee("2","e2","e2",new Role("2","User")));
		hashMap.put("3", new Employee("3","e3","e3",new Role("1","Amin")));
		hashMap.put("4", new Employee("4","e4","e4",new Role("1","Amin")));
		hashMap.put("5", new Employee("5","e5","e5",new Role("1","Amin")));
	}

	
	@RequestMapping("/list")
	public String getEmployeeManage(HttpServletRequest request,Model model)
			throws Throwable {
	   //ModelAndView model =new ModelAndView("userList");
	    
	   Collection<Employee> employees = hashMap.values();
	 //  employees.add(new Employee("1","yingying","song"));
	   model.addAttribute("employees", employees);
		
       return "userList";		
	}
	@RequestMapping("/getUser")
	public String getUser(Employee e,Model model)
			throws Throwable {
		//ModelAndView model =new ModelAndView("userList");
		System.out.println(e==null?null:e.getFirstName());
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(hashMap.get(e.getId()));
		model.addAttribute("employees", employees);
		
		return "userList";		
	}
	
	@RequestMapping("/submitUpdate")
	public String submitUpdate(Employee e,Model model)
			throws Throwable {
		System.out.println(e==null?null:e.getFirstName());
		e.getRole().setRoleName("1".equals(e.getRole().getRoleId())?"Admin":"User");
		hashMap.put(e.getId(), e);
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(hashMap.get(e.getId()));
		model.addAttribute("employees", employees);
		model.addAttribute("single", true);
		
		return "userList";		
	}
	
	@RequestMapping("/updateUser/{userId}")
	public String updateUser(@PathVariable String userId,Model model)
			throws Throwable {
		//ModelAndView model =new ModelAndView("userList");
		Employee employee = hashMap.get(userId);
		model.addAttribute("employee", employee);
		
		return "user";		
	}
	
	/** 
     * ²âÊÔ·µ»ØJSONÊý¾Ý 
     * @param session 
     * @return 
     * 
     * get list
     */  
    @RequestMapping(value="/test")  
    public String test(Model model){  
          
    	model.addAttribute("page", "list");
        return "crud";  
    }  
    
    /* create page
    */  
   @RequestMapping(value="/test1")  
   public String create(Model model){  
         
   	model.addAttribute("page", "create");
       return "crud";  
   }  
   
   /* create post
    */  
   @RequestMapping(value="/create")  
   public String createSubmit(Employee e,Model model){ 
	   if(e.getId()==null || e.getId().equals("")){
		   System.out.print("first:"+e.getFirstName()+";last="+e.getLastName()+";role="+e.getRole().getRoleId());
		   e.setId("12");
		   model.addAttribute("page", "update");
		   model.addAttribute("employee", e);
		   return "crud";  
	   }else{
		   List<Employee> employees = new ArrayList<Employee>();
		   employees.add(e);
		   hashMap.put(e.getId(), e);
		   model.addAttribute("employees", employees);
		   return "userList";
	   }
	  
	  
   }  
   
   @RequestMapping(value="/body")  
   @ResponseBody
   public String createJson(HttpServletResponse response) throws Exception{
	  //response.getWriter().write("ok");
	  return "ok"; 
   }
     
      

}
