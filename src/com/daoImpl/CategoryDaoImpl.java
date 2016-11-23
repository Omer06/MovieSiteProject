package com.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.dao.CategoryDao;
import com.entities.Category;
import com.entities.Movie;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	private static final Logger logger = Logger.getLogger(CategoryDao.class);

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("deprecation")
	@Override
	public List<?> getList(String entityName) {
		System.out.println(entityName + " isimli tablo veritaban�ndan �ekiliyor.! ------------------------------------");
		return sessionFactory.getCurrentSession().createQuery("from " + entityName).list();
	}

	@Override
	public boolean delete(Object entity) {
		System.out.println(entity.getClass().getName()
				+ " isimli entity veritaban�ndan siliniyor.! ------------------------------------");
		sessionFactory.getCurrentSession().delete(entity);
		return true;
	}

	@Override
	public boolean saveOrUpdate(Object entity) {
		System.out.println(entity.getClass().getName()
				+ " isimli entity veritaban�ndan ekleniyor yada kay�t ediliyor.! ------------------------------------");
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
		return true;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<?> getListByDesc(String entityName , String descField) {
		System.out.println(
				entityName + " isimli tablo veritaban�ndan �ekiliyor ByDesc.! ------------------------------------");
		return sessionFactory.getCurrentSession().createQuery("from " + entityName + " ORDER BY "+ descField +" desc").list();
	}

	@Override
	public Object getEntityById(Class<?> clazz, int id) {
		System.out.println(clazz.getName() + " isimli entity'in " + id
				+ " id'li objesi veritaban�ndan �ekiliyor .! ---------------------------");
		return sessionFactory.getCurrentSession().get(clazz, id);
	}

	public List<Movie> getMovieListByCategoryId(int categoryId, int pageNo) {
		System.out.println("Category Id : " + categoryId
				+ " Ait b�t�n filmler veritaban�ndan �ekiliyor ------------------------------------------");
		ArrayList<Movie> movieList = new ArrayList<Movie>();

		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
					"from movie as m inner join m.categoryList as c where c.id = :categoryId ORDER BY m.id desc");
			query.setFirstResult((pageNo - 1) * 21);
			query.setMaxResults(21);
			query.setParameter("categoryId", categoryId);
			List entityListBundle = query.list();

			for (Object entityList : entityListBundle) {
				for (Object entitys : (Object[]) entityList) {
					if (entitys instanceof Movie) {
						movieList.add((Movie) entitys);
					}
				}
			}

			System.out.println("Categori : " + categoryId + " Total Movie : " + entityListBundle.size());

		} catch (Exception e) {
			System.out.println("CategoryDaoImpl , getMovieListByCategoryId �al���rken hata olu�tu : " + e.getMessage());
			e.printStackTrace();
		}

		return movieList;
	}

	public long countMovieOfTheCategory(int categoryId) {
		System.out.println(categoryId
				+ " id'li kategoriye ait filmler veritaban�ndan say�l�yor -----------------------------------------------------------");

		long totalMovie = 0;

		try {

			totalMovie = (Long) sessionFactory.getCurrentSession().createQuery(
					"select count(m.name) from movie as m inner join m.categoryList as c where c.id = " + categoryId)
					.iterate().next();

			System.out.println(categoryId + " id'li kategoriye ait toplam Film : " + totalMovie
					+ "  -----------------------------------------------------------------");

		} catch (Exception e) {
			System.out.println("Kategorideki toplam film say�l�rken hata olu�tu " + e.getMessage());
			e.printStackTrace();
		}

		return totalMovie;
	}

	@Override
	public Category getCategoryByName(String categoryName) {
		System.out.println(categoryName
				+ " name'li kategori �ekiliyor -----------------------------------------------------------");

		Category category = null;
		List categoryAttributeBundleWrapper = sessionFactory.getCurrentSession()
				.createQuery("select c.id , c.name from category c where c.name = '" + categoryName + "'").list();

		// Muhtemelen bir tane veri d�necek createQuery'den oda 0 ' �nc� indexde
		// ve bu istedi�imiz alanlar�n object[] tipinde olacak
		if (categoryAttributeBundleWrapper.size() >= 0) {
			Object[] categoryAttributeBundle = (Object[]) categoryAttributeBundleWrapper.get(0);// categoryAttributeBundle = i�inde bizim sorgu ile istedi�imiz alanlardan olu�an bi object[] dizisi
			for (int i = 0; i < categoryAttributeBundle.length; i++) {
				category = new Category((int) categoryAttributeBundle[i], categoryAttributeBundle[i + 1].toString());
				break;
			}
		}
		return category;
	}

}
