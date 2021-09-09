package JaVaProjectGameCaro.Model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import JaVaProjectGameCaro.HibernateUtil.HibernateUtil;

public class NguoiChoiDAO {
	public static List<NguoiChoi> getDSNguoiChoi(){
		List<NguoiChoi> dsnc=null;
		Session session=HibernateUtil.getSessionFactory().openSession();
		try {
			String sql="select nc from NguoiChoi nc";
			Query query=session.createQuery(sql);
			dsnc=query.list();
		} catch (HibernateException e) {
			// TODO: handle exception
			System.err.println(e);
		}
		finally {
			//session.flush();
			session.close();
		}
		return dsnc;
	}
	public static NguoiChoi getNguoiChoi(String tenDangNhap) {
		NguoiChoi nc=null;
		Session session=HibernateUtil.getSessionFactory().openSession();
		try {
			//nc=(NguoiChoi) session.get(NguoiChoi.class, tenDangNhap);
			String hql="select nc from NguoiChoi nc left join fetch nc.loaiXepHang where nc.tenDangNhap=:tenDangNhap";
			Query query=session.createQuery(hql);
			query.setString("tenDangNhap", tenDangNhap);
			nc=(NguoiChoi) query.uniqueResult();
		} catch (HibernateException e) {
			// TODO: handle exception
			System.err.println(e);
		}
		finally {
			//session.flush();
			session.close();
		}
		return nc;
	}
	public static boolean themNguoiChoi(NguoiChoi nc) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		if(NguoiChoiDAO.getNguoiChoi(nc.getTenDangNhap())!=null) {
			return false;
		}
		boolean kq=true;
		Transaction trans=null;
		try {
			trans=session.beginTransaction();
			session.save(nc);
			trans.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			trans.rollback();
			System.err.println(e);
			kq=false;
		}
		finally {
			session.close();
		}
		return kq;
	}
	
	public static boolean xoaNguoiChoi(NguoiChoi nc) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		if(NguoiChoiDAO.getNguoiChoi(nc.getTenDangNhap())==null) {
			return false;
		}
		boolean kq=true;
		Transaction trans=null;
		try {
			trans=session.beginTransaction();
			session.delete(nc);
			trans.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			System.out.println(e);
			trans.rollback();
			kq=false;
		}
		finally {
			//session.flush();
			session.close();
		}
		return kq;
	}
	
	public static boolean suaNguoiChoi(NguoiChoi nc) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		if(NguoiChoiDAO.getNguoiChoi(nc.getTenDangNhap())==null) {
			return false;
		}
		boolean kq=true;
		Transaction trans=null;
		try {
			trans=session.beginTransaction();
			session.update(nc);
			trans.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			trans.rollback();
			System.err.println(e);
			kq=false;
		}
		finally {
			session.close();
		}
		return kq;
	}
	
	public static List<NguoiChoi> getDSNguoiChoiTheoDiemXH(){
		List<NguoiChoi> dsnc=null;
		Session session=HibernateUtil.getSessionFactory().openSession();
		try {
			String sql="select nc from NguoiChoi nc order by diemXepHang desc";
			Query query=session.createQuery(sql);
			dsnc=query.list();
		} catch (HibernateException e) {
			// TODO: handle exception
			System.err.println(e);
		}
		finally {
			//session.flush();
			session.close();
		}
		return dsnc;
	}
		
	public static int getXHNguoiChoi(String tenDangNhap) {
		int xhNguoiChoi=-1;
		List<NguoiChoi> dsncTheoDiemXH=getDSNguoiChoiTheoDiemXH();
		for(int i=0;i<dsncTheoDiemXH.size();i++) {
			if(tenDangNhap.contentEquals(dsncTheoDiemXH.get(i).getTenDangNhap())) {
				xhNguoiChoi=i;
				break;
			}
		}
		return xhNguoiChoi+1;
	}

}
