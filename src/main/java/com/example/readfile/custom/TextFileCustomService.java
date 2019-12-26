package com.example.readfile.custom;

import com.example.readfile.service.ReadFileService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class TextFileCustomService extends ReadFileService {
    @Override
    public List getRecords(String fileName) throws IOException {
        Resource resource = new ClassPathResource(fileName);
        InputStream inputStream = resource.getInputStream();
        StringBuilder resultStringBuilder = new StringBuilder();

        List list = new ArrayList();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
//                System.out.println(line);
                resultStringBuilder.append(line).append("\n");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
//        System.out.println(resultStringBuilder);
        return list;
    }

    @Override
    public List getRecordsInInputStream(InputStream inputStream) throws IOException, JAXBException {

        List list = new ArrayList();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    @Override
    public InputStream readFile(String filename) {
        return null;
    }
}
