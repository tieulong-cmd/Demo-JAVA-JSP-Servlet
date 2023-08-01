package fpoly.longth.ph16566.repository;

import fpoly.longth.ph16566.entity.MayTinh;
import fpoly.longth.ph16566.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MayTinhRepository {
    public List<MayTinh> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query<MayTinh> query = session.createQuery("FROM MayTinh", MayTinh.class);
            return query.list();
        }
    }

    public MayTinh getOne(String maParam) {
        MayTinh mayTinh = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM MayTinh WHERE ma =: maGetOne", MayTinh.class);
            query.setParameter("maGetOne", maParam);
            mayTinh = (MayTinh) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mayTinh;
    }

    public Boolean delete(MayTinh mayTinh) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(mayTinh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean add(MayTinh mayTinh) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(mayTinh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean update(MayTinh mayTinh) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(mayTinh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }
}
