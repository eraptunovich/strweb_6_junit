package com.example.strweb_6;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class MenuService {

    @Value("${xml.file.path}") // Путь к файлу XML внедряется из конфигурации Spring
    private String xmlFilePath;

    public Menu loadMenuFromXml(String xmlFilePath) {
        try {
            Class<?>[] classesToBeBound = {Menu.class};

            // Создаем экземпляр JAXBContext с использованием статического метода newInstance
            JAXBContext jaxbContext = JAXBContext.newInstance(classesToBeBound);

            // Создаем объект Unmarshaller
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // Загружаем данные из XML файла
            File file = new File(this.xmlFilePath);
            return (Menu) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            throw new RuntimeException("Error while loading menu from XML", e);
        }
    }
}
