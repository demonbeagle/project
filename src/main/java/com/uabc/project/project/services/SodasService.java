package com.uabc.project.project.services;

import com.uabc.project.project.model.Cigarros;
import com.uabc.project.project.model.Sodas;
import com.uabc.project.project.repository.CigarrosRepository;
import com.uabc.project.project.repository.SodasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SodasService {

    @Autowired SodasRepository sodasrepo;

    //Agregar Sodas

    public void add(Sodas sodas){

        sodasrepo.save(sodas);
    }

    public List<Sodas> todos(){
        List<Sodas> actualList = new ArrayList<Sodas>();
        sodasrepo.findAll().forEach(actualList::add);
        return actualList;
    }

    public void deleteById(Long idToDelete){sodasrepo.deleteById(idToDelete);}
}

