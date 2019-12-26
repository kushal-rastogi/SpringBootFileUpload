package com.example.readfile.controller;

import com.example.readfile.factory.GetFileFactory;
import com.example.readfile.model.User;
import com.example.readfile.service.ReadFileService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
public class FileController {

    @PostMapping(value = "/upload", consumes = "text/csv")
    public void uploadSimple(@RequestBody InputStream body) {
        System.out.println("*************  Upload Simple *******************");
    }

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public void uploadMultipart(@RequestParam("file") MultipartFile file) throws IOException, JAXBException {
        System.out.println("*************  Upload Multipart *******************");
        String fileName = file.getOriginalFilename();
        String fileExt = fileName.split("\\.")[1];

        InputStream inputStream = file.getInputStream();

        GetFileFactory getFileFactory = new GetFileFactory();
        ReadFileService readFileService = getFileFactory.readFileService(fileExt);
        List records = readFileService.getRecordsInInputStream(inputStream);
        System.out.println("List of users == ");
        records.forEach(System.out::println);

    }

    @ResponseBody
    @PostMapping(value = "/data", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public User uploadSimple(User user) {
        System.out.println("*************  Upload data *******************");
        System.out.println(user);
        return user;
    }

}
