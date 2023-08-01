package fpoly.longth.ph16566.service.impl;

import fpoly.longth.ph16566.entity.MayTinh;
import fpoly.longth.ph16566.repository.MayTinhRepository;
import fpoly.longth.ph16566.service.MayTinhService;

import java.util.List;

public class MayTinhServiceImpl implements MayTinhService {
    private MayTinhRepository mayTinhRepository = new MayTinhRepository();

    @Override
    public Boolean update(MayTinh mayTinh) {
        return mayTinhRepository.update(mayTinh);
    }

    @Override
    public Boolean add(MayTinh mayTinh) {
        return mayTinhRepository.add(mayTinh);
    }

    @Override
    public MayTinh getOne(String maParam) {
        return mayTinhRepository.getOne(maParam);
    }

    @Override
    public void delete(MayTinh mayTinh) {
        mayTinhRepository.delete(mayTinh);
    }

    @Override
    public List<MayTinh> getAll() {
        return mayTinhRepository.getAll();
    }
}
