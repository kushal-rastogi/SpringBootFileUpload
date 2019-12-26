package com.example.readfile.custom;

import com.example.readfile.model.User;
import com.example.readfile.service.ReadFileService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XMLFileCustomService extends ReadFileService {
    @Override
    public List getRecords(String fileName) throws IOException, JAXBException {

        List list = new ArrayList();
        Resource resource = new ClassPathResource(fileName);
        InputStream inputStream = resource.getInputStream();

        JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        User myUser = (User) jaxbUnmarshaller.unmarshal(inputStream);
        list.add(myUser);
        return list;
    }

    @Override
    public List getRecordsInInputStream(InputStream inputStream) throws IOException, JAXBException {
        List list = new ArrayList();

        JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        User myUser = (User) jaxbUnmarshaller.unmarshal(inputStream);
        list.add(myUser);
        return list;
    }

    @Override
    public InputStream readFile(String filename) {
        return null;
    }
}
