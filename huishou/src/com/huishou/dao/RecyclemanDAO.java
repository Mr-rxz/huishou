package com.huishou.dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huishou.pojo.Recycleman;

/**
 * A data access object (DAO) providing persistence and search support for
 * Recycleman entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.huishou.pojo.Recycleman
 * @author MyEclipse Persistence Tools
 */
public class RecyclemanDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(RecyclemanDAO.class);
	// property constants
	public static final String USERINFOID = "userinfoid";
	public static final String COMMUNITYID = "communityid";

	public void save(Recycleman transientInstance) {
		log.debug("saving Recycleman instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Recycleman persistentInstance) {
		log.debug("deleting Recycleman instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Recycleman findById(java.lang.Integer id) {
		log.debug("getting Recycleman instance with id: " + id);
		try {
			Recycleman instance = (Recycleman) getSession().get(
					"com.huishou.pojo.Recycleman", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Recycleman instance) {
		log.debug("finding Recycleman instance by example");
		try {
			List results = getSession()
					.createCriteria("com.huishou.pojo.Recycleman")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Recycleman instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Recycleman as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserinfoid(Object userinfoid) {
		return findByProperty(USERINFOID, userinfoid);
	}

	public List findByCommunityid(Object communityid) {
		return findByProperty(COMMUNITYID, communityid);
	}

	public List findAll() {
		log.debug("finding all Recycleman instances");
		try {
			String queryString = "from Recycleman";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Recycleman merge(Recycleman detachedInstance) {
		log.debug("merging Recycleman instance");
		try {
			Recycleman result = (Recycleman) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Recycleman instance) {
		log.debug("attaching dirty Recycleman instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Recycleman instance) {
		log.debug("attaching clean Recycleman instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}