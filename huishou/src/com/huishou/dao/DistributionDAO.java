package com.huishou.dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huishou.pojo.Distribution;

/**
 * A data access object (DAO) providing persistence and search support for
 * Distribution entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.huishou.pojo.Distribution
 * @author MyEclipse Persistence Tools
 */
public class DistributionDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DistributionDAO.class);
	// property constants
	public static final String USERID = "userid";
	public static final String ADDRESS = "address";
	public static final String TELEPHONE = "telephone";
	public static final String USERNAME = "username";
	public static final String COMMUNITYID = "communityid";

	public void save(Distribution transientInstance) {
		log.debug("saving Distribution instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Distribution persistentInstance) {
		log.debug("deleting Distribution instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Distribution findById(java.lang.Integer id) {
		log.debug("getting Distribution instance with id: " + id);
		try {
			Distribution instance = (Distribution) getSession().get(
					"com.huishou.pojo.Distribution", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Distribution instance) {
		log.debug("finding Distribution instance by example");
		try {
			List results = getSession()
					.createCriteria("com.huishou.pojo.Distribution")
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
		log.debug("finding Distribution instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Distribution as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserid(Object userid) {
		return findByProperty(USERID, userid);
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

	public List findAll() {
		log.debug("finding all Distribution instances");
		try {
			String queryString = "from Distribution";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Distribution merge(Distribution detachedInstance) {
		log.debug("merging Distribution instance");
		try {
			Distribution result = (Distribution) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Distribution instance) {
		log.debug("attaching dirty Distribution instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Distribution instance) {
		log.debug("attaching clean Distribution instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}