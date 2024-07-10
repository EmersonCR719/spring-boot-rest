package com.aplication.rest.service.impl;

import com.aplication.rest.entities.Maker;
import com.aplication.rest.persistence.IMakerDAO;
import com.aplication.rest.service.IMakerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MakerServiceImpl implements IMakerService {

    private IMakerDAO MakerDAO;

    public MakerServiceImpl(IMakerDAO iMakerDAO) {
        this.MakerDAO = iMakerDAO;
    }

    @Override
    public List<Maker> findAll() {
        return this.MakerDAO.findAll();
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return this.MakerDAO.findById(id);
    }

    @Override
    public void save(Maker maker) {
        this.MakerDAO.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        this.MakerDAO.deleteById(id);
    }
}
