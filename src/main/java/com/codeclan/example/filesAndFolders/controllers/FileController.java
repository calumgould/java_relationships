package com.codeclan.example.filesAndFolders.controllers;

import com.codeclan.example.filesAndFolders.models.File;
import com.codeclan.example.filesAndFolders.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FileController {

    @Autowired
    private FileRepository fileRepository;


    @GetMapping(value = "/files")
    public ResponseEntity<List<File>> getAllFiles(){
        List<File> foundFiles = fileRepository.findAll();
        return new ResponseEntity<>(foundFiles, HttpStatus.OK);
    }

    @GetMapping(value = "/files/{id}")
    public Optional<File> getFile(@PathVariable Long id){
        return fileRepository.findById(id);
    }

    @PostMapping(value = "/files")
    public ResponseEntity<File> createFile(@RequestBody File file){
        fileRepository.save(file);
        return new ResponseEntity<>(file, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/files/{id}")
    public ResponseEntity<File> updateFile(@RequestBody File file, @PathVariable Long id){
        fileRepository.save(file);
        return new ResponseEntity<>(file, HttpStatus.CREATED);
    }

}
