package model.service;

import java.util.List;
import model.entity.Service;
import model.repository.ServiceRepository;

public class ServiceDouble {
    public static List<Service> getService(){
        return ServiceRepository.getListService();
    } 
}
