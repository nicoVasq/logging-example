package at.htl.service;

import at.htl.entity.Guitar;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GuitarService {

    public void save(Guitar guitar) throws Exception{

        if(!guitar.getBrand().equals("")){
            //Save entity
            //...
        }
        else{
           throw new Exception("Guitar Brand required ");
        }

    }

}
