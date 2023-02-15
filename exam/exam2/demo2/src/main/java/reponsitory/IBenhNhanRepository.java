package reponsitory;

import model.BenhNhan;

import java.util.List;

public interface IBenhNhanRepository {
    public List<BenhNhan> findAll();
}
