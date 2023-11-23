package com.example.demo.services;

import com.example.demo.models.Page;
import com.example.demo.repos.PageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageService {

    private PageRepo repo;

    @Autowired
    public PageService(PageRepo repo) {
        this.repo = repo;
    }


    public void save(Page page) {
        repo.save(page);
    }


}
