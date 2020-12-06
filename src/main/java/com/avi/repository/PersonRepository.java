package com.avi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avi.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
