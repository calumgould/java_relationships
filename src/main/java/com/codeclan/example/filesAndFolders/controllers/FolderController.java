package com.codeclan.example.filesAndFolders.controllers;

import com.codeclan.example.filesAndFolders.models.Folder;
import com.codeclan.example.filesAndFolders.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FolderController {

    @Autowired
    private FolderRepository folderRepository;


    @GetMapping(value = "/folders")
    public ResponseEntity<List<Folder>> getAllFolders(){
        List<Folder> foundFolders = folderRepository.findAll();
        return new ResponseEntity<>(foundFolders, HttpStatus.OK);
    }

    @GetMapping(value = "/folders/{id}")
    public Optional<Folder> getFolder(@PathVariable Long id){
        return folderRepository.findById(id);
    }

    @PostMapping(value = "/folders")
    public ResponseEntity<Folder> createFolder(@RequestBody Folder folder){
        folderRepository.save(folder);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/folders/{id}")
    public ResponseEntity<Folder> updateFolder(@RequestBody Folder folder, @PathVariable Long id){
        folderRepository.save(folder);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);
    }

}
