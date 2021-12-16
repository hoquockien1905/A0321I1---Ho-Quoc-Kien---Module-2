package model.repository;

import model.bean.BenhAn;

import java.util.List;

public interface HoSoBenhAnRepository {

    List<BenhAn> findAll();

    void update(BenhAn benhAn);

    BenhAn findByIdBenhAn(int id);
}
