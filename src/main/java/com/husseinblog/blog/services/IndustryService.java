package com.husseinblog.blog.services;

import com.husseinblog.blog.models.Industry;
import com.husseinblog.blog.repositories.IndustryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndustryService {
    private IndustryRepository industryRepository;

    @Autowired
    public IndustryService(IndustryRepository industryRepository){this.industryRepository=industryRepository;}

    public List<Industry> findAll(){
        return industryRepository.findAll();
    }
    public Industry findById(int industryId){
        Industry industry = industryRepository.findById(industryId).orElseThrow(() -> new EntityNotFoundException("Industry with"+industryId+" not found"));
        return industry;
    }
}
