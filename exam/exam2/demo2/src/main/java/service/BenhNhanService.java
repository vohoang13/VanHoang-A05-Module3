package service;

import model.BenhNhan;
import reponsitory.BenhNhanRepository;
import reponsitory.IBenhNhanRepository;

import java.util.List;

public class BenhNhanService implements IBenhNhan{
    IBenhNhanRepository iBenhNhanRepository = new BenhNhanRepository();

    @Override
    public List<BenhNhan> findAll() {
        return iBenhNhanRepository.findAll();
    }
}
