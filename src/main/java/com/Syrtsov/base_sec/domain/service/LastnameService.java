package com.Syrtsov.base_sec.domain.service;


import com.Syrtsov.base_sec.domain.entity.Lastname;
import com.Syrtsov.base_sec.domain.repo.LastnameRepo;
import org.springframework.stereotype.Service;

@Service
public class LastnameService {
    private LastnameRepo lastnameRepo;

    public LastnameService(LastnameRepo lastnameRepo) {
        this.lastnameRepo = lastnameRepo;
    }

    public Lastname saveIntoLastname(Lastname lastname){
        if (lastname == null) {
            return null;
        }
        Lastname fromDBlastname= lastnameRepo.findByName(lastname.getName());
        if (fromDBlastname == null)
        {
            fromDBlastname = lastnameRepo.save( lastname );
        }
        return  fromDBlastname;
    }

    public Lastname findLastnameByName (String name)
    {
        return  lastnameRepo.findByName( name );
    }
}
