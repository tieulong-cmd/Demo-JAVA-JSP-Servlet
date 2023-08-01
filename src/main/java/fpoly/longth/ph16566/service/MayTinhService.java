package fpoly.longth.ph16566.service;

import fpoly.longth.ph16566.entity.MayTinh;

import java.util.List;

public interface MayTinhService {

    Boolean update(MayTinh mayTinh);

    Boolean add(MayTinh mayTinh);

    MayTinh getOne(String maParam);

    void delete(MayTinh mayTinh);

    List<MayTinh> getAll();
}
