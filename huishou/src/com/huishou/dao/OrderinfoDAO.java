package com.huishou.dao;

import com.huishou.pojo.Orderinfo;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Orderinfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.huishou.pojo.Orderinfo
 * @author MyEclipse Persistence Tools
 */
public class OrderinfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(OrderinfoDAO.class);
	// property constants
	public static final String USERINFOID = "userinfoid";
	public static final String ADDRESS = "address";
	public static final String TELEPHONE = "telephone";
	public static final String USERNAME = "username";
	public static final String COMMUNITYID = "communityid";
	public static final String PERIOD = "period";
	public static final String STATE = "state";

	public void save(Orderinfo transientInstance) {
		log.debug("saving Orderinfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Orderinfo persistentInstance) {
		log.debug("deleting Orderinfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Orderinfo findById(java.lang.Integer id) {
		log.debug("getting Orderinfo instance with id: " + id);
		try {
			Orderinfo instance = (Orderinfo) getSession().get(
					"com.huishou.pojo.Orderinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Orderinfo instance) {
		log.debug("finding Orderinfo instance by example");
		try {
			List results = getSession()
					.createCriteria("com.huishou.pojo.Orderinfo")
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
		log.debug("finding Orderinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Orderinfo as model where model."
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

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByTelephone(Object telephone) {
		return findByProperty(TELEPHONE, telephone);
	}

	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List findByCommunityid(Object communityid) {
		return findByProperty(COMMUNITYID, communityid);
	}

	public List findByPeriod(Object period) {
		return findByProperty(PERIOD, period);
	}

	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findAll() {
		log.debug("finding all Orderinfo instances");
		try {
			String queryString = "from Orderinfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Orderinfo merge(Orderinfo detachedInstance) {
		log.debug("merging Orderinfo instance");
		try {
			Orderinfo result = (Orderinfo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Orderinfo instance) {
		log.debug("attaching dirty Orderinfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Orderinfo instance) {
		log.debug("attaching clean Orderinfo instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}