package com.uabc.project.project.services;

import com.uabc.project.project.model.Cigarros;
import com.uabc.project.project.repository.CigarrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CigarrosService {

    @Autowired CigarrosRepository cigarrosrepo;

    //Agregar Papitas

    public void add(Cigarros cigarros){
        cigarrosrepo.save(cigarros);
    }

    public List<Cigarros> todos(){
        List<Cigarros> actualList = new ArrayList<Cigarros>();
        cigarrosrepo.findAll().forEach(actualList::add);
        return actualList;
    }

    public void deleteById(Long idToDelete){cigarrosrepo.deleteById(idToDelete);}
}
