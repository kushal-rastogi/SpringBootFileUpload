package com.example.readfile;

import com.example.readfile.factory.GetFileFactory;
import com.example.readfile.service.ReadFileService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ReadfileApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ReadfileApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
/*
//        String fileName = "data.csv";
//        String fileName = "data.txt";
        String fileName = "user.xml";
        String fileExt = fileName.split("\\.")[1];

        GetFileFactory getFileFactory = new GetFileFactory();
        ReadFileService readFileService = getFileFactory.readFileService(fileExt);
        List records = readFileService.getRecords(fileName);
        System.out.println("List of users == ");
        records.forEach(System.out::println);*/
    }
}
