package com.avi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avi.model.Person;
import com.avi.repository.PersonRepository;

@RestController
@RequestMapping({"/person"})
public class PersonController {

	private PersonRepository repository;

	PersonController(PersonRepository personRepository) {
		this.repository = personRepository;
	}

	@GetMapping
	public List<Person> findAll(){
		return repository.findAll();
	}

	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Person> findById(@PathVariable long id){
		return repository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = {"delete/{id}"})
	public String deleteById(@PathVariable long id){
		if (repository.findById(id) != null) {
			repository.deleteById(id);
			return "Successfully deleted " + id;
		} else {
			return "Person ID does not exist in the system : " + id;
		}
	}

	@PutMapping("/put/{id}")
	public Person addOrEditPerson(@RequestBody Person newPerson, @PathVariable Long id) {
		return repository.findById(id)
				.map(person -> {
					person.setfName(newPerson.getfName());
					person.setlName(newPerson.getlName());
					return repository.save(person);
				})
				.orElseGet(() -> {
					newPerson.setId(id);
					return repository.save(newPerson);
				});
	}
	
	@GetMapping("/count")
	public long countPerson() {
		return repository.count();
	}
}
