package JaVaProjectGameCaro.HibernateUtil;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	public static SessionFactory getSessionFactory() {
		try {
			Configuration conf=new Configuration();
			conf.configure("hibernate.cfg.xml");
			return conf.buildSessionFactory();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
