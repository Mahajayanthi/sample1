package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Canteen;
import com.example.demo.repository.CanteenRepository;
import com.example.demo.service.CanteenService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class CanteenController {
	@Autowired 
	private CanteenService service;
	@PostMapping("/canteens")
	public Canteen save(@RequestBody Canteen can)
	{
		Canteen a=service.save(can);
		return a;	
	}
	@RequestMapping(value = "/canteens/{id}", method = RequestMethod.GET)
    public Canteen getCanteenById(@PathVariable int id){
        Canteen e = service.getCanteenById(id);
        return e;
    }
	
	
	  @PutMapping("/canteens")
	  public ResponseEntity<Canteen> updateCanteen(@RequestBody Canteen
	  can) { Canteen canteen= service.updateCanteen(can); 
	
         canteen.setPlace(can.getPlace());
		canteen.setMailId(can.getMailId());
		canteen.setCompanyName(can.getCompanyName());
		canteen.setDate(can.getDate());
		canteen.setPhoneNo(can.getPhoneNo());
		canteen.setShopName(can.getShopName());

		final  Canteen updatedCanteen = service.save(can);

			
		return ResponseEntity.ok(updatedCanteen);
	  }
	 
	

		/*
		 * @PutMapping("/canteens/{id}") public ResponseEntity<Canteen>
		 * updateCanteen(@PathVariable(value = "id") int id,
		 * 
		 * @Valid @RequestBody Canteen employeeDetails) throws ResourceNotFoundException
		 * { Canteen employee = CanteenRepository.findById( id) .orElseThrow(() -> new
		 * ResourceNotFoundException("Employee not found for this id :: " + id));
		 * 
		 * employee.setPlace(employeeDetails.getPlace());
		 * employee.setMailId(employeeDetails.getMailId());
		 * employee.setCompanyName(employeeDetails.getCompanyName());
		 * employee.setDate(employeeDetails.getDate());
		 * employee.setPhoneNo(employeeDetails.getPhoneNo());
		 * employee.setShopName(employeeDetails.getShopName()); final Canteen
		 * updatedEmployee = CanteenRepository.save(employee); return
		 * ResponseEntity.ok(updatedEmployee); }
		 */
		  @GetMapping("/canteens") public java.util.List<Canteen> getAllCanteens(){
		  
		  java.util.List<Canteen> d = ((CanteenService) service).getAllCanteens();
		  return d; }
		  
		
		/*
		 * @DeleteMapping("/canteens/{id}") public java.util.List<Canteen>
		 * deleteCanteenById(@PathVariable int id){ java.util.List<Canteen> a =
		 * service.deleteCanteenById(id); return a; }
		 */
		  @DeleteMapping("/canteens/{id}")
		  public List<Canteen> deleteEmp(@PathVariable int id){
		  List<Canteen> empList = service.deleteCanteen(id);
		  return empList;
		  }
		
		
			/*
			 * @DeleteMapping("/canteens/{id}") private Canteen delete(@PathVariable("id")
			 * int Id) { return service.delete(Id); }
			 */
		
			/*
			 * public DemoEntity delete(int id) { repo.deleteById(id); return null; }
			 */
}


