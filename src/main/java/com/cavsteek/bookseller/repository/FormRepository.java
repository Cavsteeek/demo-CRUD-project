package com.cavsteek.bookseller.repository;

import com.cavsteek.bookseller.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<Form, Long> {

}
