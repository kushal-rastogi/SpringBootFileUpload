package com.example.readfile.custom;

import com.example.readfile.model.User;
import com.example.readfile.service.ReadFileService;
import com.opencsv.CSVReader;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class CSVFileCustomService extends ReadFileService {
    @Override
    public List getRecords(String fileName) throws IOException {

        List<User> list = new ArrayList<>();
        CSVReader csvReader = new CSVReader(new FileReader(fileName));
        String[] line;
        while ((line = csvReader.readNext()) != null) {
            User user = new User();
            user.setFirstName(line[0]);
            user.setLastName(line[1]);
            user.setAddress(line[2]);
            user.setPincode(line[3]);
            list.add(user);
        }
        csvReader.close();
        return list;
    }

    @Override
    public List getRecordsInInputStream(InputStream inputStream) throws IOException, JAXBException {
        List<User> list = new ArrayList<>();
//        CSVReader csvReader = new CSVReader(new FileReader(String.valueOf(inputStream)));
        CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream));
        String[] line;
        while ((line = csvReader.readNext()) != null) {
            User user = new User();
            user.setFirstName(line[0]);
            user.setLastName(line[1]);
            user.setAddress(line[2]);
            user.setPincode(line[3]);
            list.add(user);
        }
        csvReader.close();
        return list;    }

    @Override
    public InputStream readFile(String filename) {
        return null;
    }
}
