package com.easyhome.jrconsumer.dao;

import java.util.Map;

import com.easyhome.jrconsumer.mvp.model.entity.KeyValueModel;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;


// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig keyValueModelDaoConfig;

    private final KeyValueModelDao keyValueModelDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        keyValueModelDaoConfig = daoConfigMap.get(KeyValueModelDao.class).clone();
        keyValueModelDaoConfig.initIdentityScope(type);

        keyValueModelDao = new KeyValueModelDao(keyValueModelDaoConfig, this);

        registerDao(KeyValueModel.class, keyValueModelDao);
    }
    
    public void clear() {
        keyValueModelDaoConfig.clearIdentityScope();
    }

    public KeyValueModelDao getKeyValueModelDao() {
        return keyValueModelDao;
    }

}
