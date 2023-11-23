package com.example.demo.repos;


import com.example.demo.models.Page;


import com.example.demo.models.User;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageRepo extends CrudRepository<Page,Integer> {

      List<Page> findByAdminId(Integer user);



}
