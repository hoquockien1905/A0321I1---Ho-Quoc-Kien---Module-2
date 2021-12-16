package model.service.impl;

import model.bean.BenhAn;
import model.repository.HoSoBenhAnRepository;
import model.repository.impl.HoSoBenhAnRepositoryImpl;
import model.service.HoSoBenhAnService;

import java.util.List;

public class HoSoBenhAnServiceImpl implements HoSoBenhAnService {

    HoSoBenhAnRepository hoSoBenhAnRepository = new HoSoBenhAnRepositoryImpl();

    @Override
    public List<BenhAn> findAll() {
        return hoSoBenhAnRepository.findAll();
    }

    @Override
    public BenhAn findByIdBenhAn(int id) {
        return hoSoBenhAnRepository.findByIdBenhAn(id);
    }

    @Override
    public void update(BenhAn benhAn) {
        hoSoBenhAnRepository.update(benhAn);
    }
}
