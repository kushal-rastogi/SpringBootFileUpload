package com.example.readfile.factory;

import com.example.readfile.custom.CSVFileCustomService;
import com.example.readfile.custom.TextFileCustomService;
import com.example.readfile.custom.XMLFileCustomService;
import com.example.readfile.service.ReadFileService;

public class GetFileFactory {

    public ReadFileService readFileService(String fileType) {
        if (fileType.equalsIgnoreCase("txt")) {
            return new TextFileCustomService();
        } else if (fileType.equalsIgnoreCase("csv")) {
            return new CSVFileCustomService();
        } else if (fileType.equalsIgnoreCase("xml")) {
            return new XMLFileCustomService();
        }
        return null;
    }
}
