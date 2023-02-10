package com.saurabh.LibraryManagementSystem.controller;

import com.saurabh.LibraryManagementSystem.model.LMS;
import com.saurabh.LibraryManagementSystem.service.LMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/LMS/")
public class LMSController {

    @Autowired
    private LMSService service;

    @GetMapping("libraries") // get all ✅
    public List<LMS> getAllLibraries(){
        return service.getAllLibraries();
    }

    @GetMapping("library/name/{name}") // get by name ✅
    public LMS getLibrary(@PathVariable String name){
        return service.getLibrary(name);
    }

    @PostMapping("add") // Adding new Libraries ✅
    public String addLibrary(@RequestBody LMS library){
        return service.addLibrary(library);
    }

    @PutMapping("update/name/{name}") // update existing Library ✅
    public String updateLibrary(@RequestBody LMS library, @PathVariable String name){
        return service.updateLibrary(library, name);
    }

    @DeleteMapping("delete/name/{name}") // delete Library ✅
    public String deleteLibrary(@PathVariable String name){
        return service.deleteLibrary(name);
    }
}
