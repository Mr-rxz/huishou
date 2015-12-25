package com.huishou.dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huishou.pojo.Community;

/**
 * A data access object (DAO) providing persistence and search support for
 * Community entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.huishou.pojo.Community
 * @author MyEclipse Persistence Tools
 */
public class CommunityDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CommunityDAO.class);
	// property constants
	public static final String COMMUNITYNAME = "communityname";

	public void save(Community transientInstance) {
		log.debug("saving Community instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Community persistentInstance) {
		log.debug("deleting Community instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Community findById(java.lang.Integer id) {
		log.debug("getting Community instance with id: " + id);
		try {
			Community instance = (Community) getSession().get(
					"com.huishou.pojo.Community", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Community instance) {
		log.debug("finding Community instance by example");
		try {
			List results = getSession()
					.createCriteria("com.huishou.pojo.Community")
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
		log.debug("finding Community instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Community as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCommunityname(Object communityname) {
		return findByProperty(COMMUNITYNAME, communityname);
	}

	public List findAll() {
		log.debug("finding all Community instances");
		try {
			String queryString = "from Community";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Community merge(Community detachedInstance) {
		log.debug("merging Community instance");
		try {
			Community result = (Community) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Community instance) {
		log.debug("attaching dirty Community instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Community instance) {
		log.debug("attaching clean Community instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}