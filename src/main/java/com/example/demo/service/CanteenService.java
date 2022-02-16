package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Canteen;
import com.example.demo.repository.CanteenRepository;

@Service
public class CanteenService {
	@Autowired
	private CanteenRepository repo;

	public Canteen save(Canteen can) {

		return repo.save(can);
	}

	public Canteen getCanteenById(int id) {
		java.util.Optional<Canteen> emp = repo.findById(id);
		if (emp.isPresent())
			return emp.get();
		else
			return new Canteen();
	}

	public java.util.List<Canteen> getAllCanteens() {
		java.util.List<Canteen> d = repo.findAll();
		return d;
	}

	public Canteen updateCanteen(Canteen can) {
		Canteen a = repo.save(can);
		return a;
	}
	/*
	 * public java.util.List<Canteen> deleteCanteen(int id) {
	 * 
	 * java.util.List<Canteen> d= repo.findAll(); return d; }
	 */
	 


	 public List<Canteen> deleteCanteen(int id) {
	 repo.deleteById(id);
	 List<Canteen> empList = repo.findAll();
	 return empList;
	 }

		/*
		 * public List<Canteen> deleteCanteenById(int id) {
		 * List<Canteen>a=repo.findById(id); return a; }
		 */

	/*
	 * public List<Canteen> deleteCanteennById(int Id) { repo.deleteCanteenById(Id);
	 * List<Canteen> b = repo.findAll(); return b; }
	 */
	/*
	 * public List<Canteen> delete(int id) {
	 * 
	 * List<Canteen> b = repo.findAll(); return b; }
	 */

	/*
	 * public List<Canteen> deleteCanteenById(int id) { List<> return null; }
	 * 
	 * 
	 * public Canteen delete(int id) {
	 * 
	 * return null; }
	 */

	/*
	 * public Canteen update(Canteen can) { return repo.save(can); }
	 */

}
