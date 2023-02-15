package service;

import model.BenhAn;
import model.BenhNhan;

import java.util.List;

public interface IBenhAnService {
    public List<BenhAn> findAll();

    public BenhAn findById(String id);

    public void update(BenhAn benhAn);

    public void delete(String maBenhAn);
}
