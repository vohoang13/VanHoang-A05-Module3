package reponsitory;

import model.BenhAn;
import model.BenhNhan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhAnRepository implements IBenhAnRepository{
    private BaseRepository baseRepository = new BaseRepository();

    private final String FIND_ID = "select * from benh_an where id_ba like ?";
    private final String SELECT_ALL = "select * from benh_an";

    private final String UPDATE = "update benh_an set ngay_ra_vien = ?, ly_do = ? where id_ba like ?";

    private final String DELETE = "delete from benh_an where id_ba like ?";

    List<BenhAn> benhAnList = new ArrayList<>();



    @Override
    public List<BenhAn> findAll() {
        List<BenhAn> benhAns = new ArrayList<>();
        try{
            Connection connection = this.baseRepository.getConnectionJavaToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            BenhAn benhAn;
            while (resultSet.next()){
                benhAn = new BenhAn();
                benhAn.setMaBenhAn(resultSet.getString("id_ba"));
                benhAn.setMaBenhNhan(resultSet.getString("id_bn"));
                benhAn.setNgayNhapVien(resultSet.getString("ngay_nhap_vien"));
                benhAn.setNgayRaVien(resultSet.getString("ngay_ra_vien"));
                benhAn.setLyDo(resultSet.getString("ly_do"));
                benhAns.add(benhAn);
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return benhAns;
    }

    @Override
    public BenhAn findById(String maBenhAn) {
        BenhAn benhAn = new BenhAn();
        try{
            Connection connection = this.baseRepository.getConnectionJavaToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ID);
            preparedStatement.setString(1,"%" + maBenhAn + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                benhAn.setMaBenhAn(resultSet.getString("id_ba"));
                benhAn.setMaBenhNhan(resultSet.getString("id_bn"));
                benhAn.setNgayNhapVien(resultSet.getString("ngay_nhap_vien"));
                benhAn.setNgayRaVien(resultSet.getString("ngay_ra_vien"));
                benhAn.setLyDo(resultSet.getString("ly_do"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return benhAn;
    }

    @Override
    public void update(BenhAn benhAn) {
        try {
            Connection connection = this.baseRepository.getConnectionJavaToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1,benhAn.getNgayRaVien());
            preparedStatement.setString(2,benhAn.getLyDo());
            preparedStatement.setString(3,benhAn.getMaBenhAn());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String maBenhAn) {
        try {
            Connection connection = this.baseRepository.getConnectionJavaToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setString(1, maBenhAn);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
