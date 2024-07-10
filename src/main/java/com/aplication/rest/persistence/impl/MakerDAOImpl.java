package com.aplication.rest.persistence.impl;

import com.aplication.rest.entities.Maker;
import com.aplication.rest.persistence.IMakerDAO;
import com.aplication.rest.repository.MakerRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class MakerDAOImpl implements IMakerDAO {

    private final MakerRepository makerRepository;

    public MakerDAOImpl(MakerRepository makerRepository) {
        this.makerRepository = makerRepository;
    }

    @Override
    public List<Maker> findAll() {
        return (List<Maker>) this.makerRepository.findAll();
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return this.makerRepository.findById(id);
    }

    @Override
    public void save(Maker maker) {
        this.makerRepository.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        this.makerRepository.deleteById(id);
    }
}
