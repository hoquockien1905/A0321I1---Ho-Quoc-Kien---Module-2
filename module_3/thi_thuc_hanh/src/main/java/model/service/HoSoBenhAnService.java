package model.service;

import model.bean.BenhAn;

import java.util.List;

public interface HoSoBenhAnService {

    List<BenhAn> findAll();

    void update(BenhAn benhAn);

    BenhAn findByIdBenhAn(int id);

}
