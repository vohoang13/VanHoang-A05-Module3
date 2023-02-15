package service;

import model.BenhAn;
import model.BenhNhan;
import reponsitory.BenhAnRepository;
import reponsitory.IBenhAnRepository;

import java.util.List;

public class BenhAnService implements IBenhAnService{
    IBenhAnRepository iBenhAnRepository = new BenhAnRepository();



    @Override
    public List<BenhAn> findAll() {
        return iBenhAnRepository.findAll();
    }

    @Override
    public BenhAn findById(String id) {
        return iBenhAnRepository.findById(id);
    }

    @Override
    public void update(BenhAn benhAn) {
        iBenhAnRepository.update(benhAn);
    }

    @Override
    public void delete(String maBenhAn) {
        iBenhAnRepository.delete(maBenhAn);
    }
}
