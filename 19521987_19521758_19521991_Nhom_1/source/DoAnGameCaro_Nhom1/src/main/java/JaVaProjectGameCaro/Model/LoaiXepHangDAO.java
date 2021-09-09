package JaVaProjectGameCaro.Model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import JaVaProjectGameCaro.HibernateUtil.HibernateUtil;

public class LoaiXepHangDAO {
	public static LoaiXepHang getLoaiXepHang(int idXepHang){
		LoaiXepHang loaiXepHang=null;
		Session session=HibernateUtil.getSessionFactory().openSession();
		try {
			loaiXepHang=(LoaiXepHang)session.get(LoaiXepHang.class, idXepHang);
		} catch (HibernateException e) {
			// TODO: handle exception
			System.err.println(e);
		}
		finally {
			//session.flush();
			session.close();
		}
		return loaiXepHang;
	}
	
	public static List<LoaiXepHang> getDSLoaiXH(){
		List<LoaiXepHang> dsxh=null;
		Session session=HibernateUtil.getSessionFactory().openSession();
		try {
			String sql="select xh from LoaiXepHang xh";
			Query query=session.createQuery(sql);
			dsxh=query.list();
		} catch (HibernateException e) {
			// TODO: handle exception
			System.err.println(e);
		}
		finally {
			//session.flush();
			session.close();
		}
		return dsxh;
	}
	
	public static boolean suaLoaXH(LoaiXepHang xh) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		if(LoaiXepHangDAO.getLoaiXepHang(xh.getIdXepHang())==null) {
			return false;
		}
		boolean kq=true;
		Transaction trans=null;
		try {
			trans=session.beginTransaction();
			session.update(xh);
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
}
