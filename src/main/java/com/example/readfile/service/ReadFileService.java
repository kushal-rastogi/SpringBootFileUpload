package com.example.readfile.service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public abstract class ReadFileService {

    public abstract List getRecords(String fileName) throws IOException, JAXBException;

    public abstract List getRecordsInInputStream(InputStream inputStream) throws IOException, JAXBException;

    public abstract InputStream readFile(String filename);
}
