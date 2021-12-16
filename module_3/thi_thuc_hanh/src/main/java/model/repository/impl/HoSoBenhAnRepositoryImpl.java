package model.repository.impl;

import model.bean.BenhAn;
import model.bean.BenhNhan;
import model.repository.DBConnection;
import model.repository.HoSoBenhAnRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoSoBenhAnRepositoryImpl implements HoSoBenhAnRepository {

    private static final String SELECT_ALL_PRODUCT =
            "SELECT * FROM benh_an INNER JOIN benh_nhan ON benh_nhan.id_benh_nhan = benh_an.id_benh_an";

    private static final String UPDATE_PRODUCT =
            "UPDATE benh_an benh_an INNER JOIN benh_nhan ON benh_nhan.id_benh_nhan \n" +
                    "SET ten_benh_an = ?, ten_benh_nhan = ?, ngay_nhap_vien = ?, ngay_ra_vien = ?;";


    @Override
    public BenhAn findByIdBenhAn(int id) {
        BenhAn benhAn = new BenhAn();
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection()
                    .prepareStatement("SELECT * FROM benh_an WHERE id_benh_an = ?");
            preparedStatement.setInt(1, benhAn.getIdBenhAn());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                benhAn.setIdBenhAn(resultSet.getInt("id_benh_an"));
                benhAn.setIdBenhNhan(resultSet.getInt("id_benh_nhan"));
                benhAn.setTenBenhAn(resultSet.getString("ten_benh_an"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return benhAn;
    }

    @Override
    public void update(BenhAn benhAn) {
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection()
                    .prepareStatement(UPDATE_PRODUCT);
            preparedStatement.setString(1, benhAn.getTenBenhAn());
            preparedStatement.setString(2, benhAn.getTenBenhNhan());
            preparedStatement.setString(3, benhAn.getNgayNhapVien());
            preparedStatement.setString(4, benhAn.getNgayRaVien());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBConnection.close();
        }
    }

    @Override
    public List<BenhAn> findAll() {
        List<BenhAn> danhSachBenhAn = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = DBConnection.getConnection()
                    .prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idBenhAn = resultSet.getInt("id_benh_an");
                int idBenhNhan = resultSet.getInt("id_benh_nhan");
                String tenBenhAn = resultSet.getString("ten_benh_an");
                String tenBenhNhan = resultSet.getString("ten_benh_nhan");
                String ngayNhapVien = resultSet.getString("ngay_nhap_vien");
                String ngayRaVien = resultSet.getString("ngay_ra_vien");
                String lyDoRaVien = resultSet.getString("ly_do_ra_vien");
                danhSachBenhAn.add(new BenhAn(idBenhAn, tenBenhAn, idBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoRaVien));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBConnection.close();
        }
        return danhSachBenhAn;
    }
}
