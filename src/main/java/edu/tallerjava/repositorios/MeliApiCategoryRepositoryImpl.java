package edu.tallerjava.repositorios;

import edu.tallerjava.dto.MeliCategory;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class MeliApiCategoryRepositoryImpl implements MeliApiCategoryRepository{
    public List<MeliCategory> findAll(){
        List<MeliCategory> results = new LinkedList<>();
        for(int i = 0; i < 30; i++){
            results.add(new MeliCategory());
        }
        return results;
    }
}
