package com.codeclan.example.filesAndFolders.components;

import com.codeclan.example.filesAndFolders.models.File;
import com.codeclan.example.filesAndFolders.models.Folder;
import com.codeclan.example.filesAndFolders.models.User;
import com.codeclan.example.filesAndFolders.repositories.FileRepository;
import com.codeclan.example.filesAndFolders.repositories.FolderRepository;
import com.codeclan.example.filesAndFolders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        fileRepository.deleteAll();
        folderRepository.deleteAll();
        userRepository.deleteAll();

        User roosa = new User("Roosa");
        userRepository.save(roosa);
        User calum = new User("Calum");
        userRepository.save(calum);

        Folder hiEmmaStone = new Folder("Emma Stone", calum);
        folderRepository.save(hiEmmaStone);
        Folder picsTongue = new Folder("Pics? :p", roosa);
        folderRepository.save(picsTongue);

        File emma1 = new File("La La Land", "jpg", 2, hiEmmaStone);
        fileRepository.save(emma1);
        File emma2 = new File("EasyA", "png", 11, hiEmmaStone);
        fileRepository.save(emma2);
        File emma3 = new File("Zombieland", "psd", 24, hiEmmaStone);
        fileRepository.save(emma3);
        File emma4 = new File("Superbad", "tiff", 27, hiEmmaStone);
        fileRepository.save(emma4);

        File bear = new File("bear", "png", 27, picsTongue);
        fileRepository.save(bear);
        File seal = new File("awkwardseal", "gif", 27, picsTongue);
        fileRepository.save(seal);
        File otter = new File("otterBoi", "jpg", 27, picsTongue);
        fileRepository.save(otter);
        File tiger = new File("snowTiger", "tiff", 27, picsTongue);
        fileRepository.save(tiger);



    }


}
