package com.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.entity.Person;
import com.restapi.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private final PersonRepository personRepository;
	
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository=personRepository;
	}
	
	
	public List<Person> getAllPersons() {
		return personRepository.findAll();
		
	}
	

    public Optional<Person> getPersonById(Integer id) {
        return personRepository.findById(id);
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Optional<Person> updatePerson(Integer id, Person personDetails) {
        return personRepository.findById(id).map(person -> {
            person.setName(personDetails.getName());
            person.setAge(personDetails.getAge());
            return personRepository.save(person);
        });
    }

    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }
	
}
