package reponsitory;

import model.BenhNhan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhNhanRepository implements IBenhNhanRepository {
    private BaseRepository baseRepository =new BaseRepository();
    List<BenhNhan> benhNhanList = new ArrayList<>();

    private final String SELECT_ALL = "select * from benh_nhan";

    @Override
    public List<BenhNhan> findAll() {
        List<BenhNhan> benhNhans = new ArrayList<>();
        try{
            Connection connection = this.baseRepository.getConnectionJavaToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            BenhNhan benhNhan;
            while (resultSet.next()){
                benhNhan = new BenhNhan();
                benhNhan.setMaBenhNhan(resultSet.getString("id"));
                benhNhan.setTenBenhNhan(resultSet.getString("ten_benh_nhan"));
                benhNhans.add(benhNhan);
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return benhNhans;
    }
}
