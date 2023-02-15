package reponsitory;

import model.BenhAn;
import model.BenhNhan;

import java.util.List;

public interface IBenhAnRepository {

    public List<BenhAn> findAll();

    public BenhAn findById(String maBenhAn);

    public void update(BenhAn benhAn);

    public void delete(String maBenhAn);
}
