package ro.teamnet.zth.api.em;

import java.util.List;
import java.util.Map;


/**
 * Created by Florin on 30.04.2015.
 */
public interface EntityManager {

	<T> Object insert(T entity);

	/**
	 *
	 * @param entity
	 * @param <T>
	 * @return
	 */
	<T> T update(T entity);

	/**
	 *
	 * @param entity
	 */
	void delete(Object entity);

	/**
	 *
	 * @param entityClass
	 * @param id
	 * @param <T>
	 * @return
	 */
	<T> T findById(Class<T> entityClass, Integer id);

	/**
	 *
	 * @param entityClass
	 * @param <T>
	 * @return
	 */
	<T> List<T> findAll(Class<T> entityClass);

	/**
	 *
	 * @param params
	 * @return
	 */
	<T> List<T> findByParams(Class<T> entityClass, Map<String, Object> params);

}
