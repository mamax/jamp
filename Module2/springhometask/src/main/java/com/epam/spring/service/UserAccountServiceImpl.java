package com.epam.spring.service;

import com.epam.spring.dao.impl.UserAccountDao;
import com.epam.spring.domain.UserAccountEntity;
import com.epam.spring.utils.Utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UserAccountServiceImpl {
    private static final Logger LOG = Logger.getLogger(UserAccountServiceImpl.class.getName());

    private UserAccountDao userAccountDao;

    public UserAccountServiceImpl(UserAccountDao userAccountDao) {
        this.userAccountDao = userAccountDao;
    }

    public void setUserAccountDao(UserAccountDao userAccountDao) {
        this.userAccountDao = userAccountDao;
    }

    public void createUserAccount(UserAccountEntity userAccount){
        if (!Utils.isUserAccountValid(userAccount)){
            LOG.log(Level.WARNING, "userAccount is not valid");
            throw new IllegalArgumentException();
        }

        LOG.log(Level.INFO,"Created user account: {}", userAccount);
        userAccountDao.addUserAccount(userAccount);
    }

    public UserAccountEntity getUserAccountById(long id){
        return userAccountDao.getUserAccountById(id);
    }

    public UserAccountEntity getUserAccountByUserId(long userId) {
        if (!Utils.isUserIdIsValid(userId)){
            LOG.log(Level.WARNING, "userId is not valid");
            throw new IllegalArgumentException();
        }
        LOG.log(Level.INFO,"Get userAccount by title: {}", userId);
        return userAccountDao.getUserAccountByUserId(userId);
    }

    public UserAccountEntity updateUserAccount(UserAccountEntity userAccount){
        if (!Utils.isUserAccountValid(userAccount)){
            LOG.log(Level.WARNING, "userAccount is not valid");
            throw new IllegalArgumentException();
        }

        LOG.log(Level.INFO,"Update userAccount: {}", userAccount);
        return userAccountDao.updateUserAccount(userAccount);
    }

    public boolean deleteUserAccount(long userId){
        if (!Utils.isUserIdIsValid(userId)){
            LOG.log(Level.WARNING, "userId is not valid");
            throw new IllegalArgumentException();
        }
        LOG.log(Level.INFO,"Deleted userAccount by userId: {}", userId);
        return userAccountDao.deleteUserAccountById(userId);
    }

}
