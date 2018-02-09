package com.epam.spring.dao.impl;

import com.epam.spring.domain.UserAccountEntity;
import com.epam.spring.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static com.epam.spring.namespace.Constants.USERACCOUNT;

public class UserAccountDao {

    @Autowired
    Repository repository;

    public void createUserAccount(UserAccountEntity userAccount) {
        repository.put(USERACCOUNT + userAccount.getId(), userAccount);
    }

    public boolean deleteUserAccountById(long userId) {
        if (repository.getRepository().containsKey(USERACCOUNT + userId)) {
            repository.delete(USERACCOUNT + userId);
            return true;
        }
        return false;
    }

    public UserAccountEntity getUserAccountById(long id) {
        UserAccountEntity userAccount = null;
        for (Map.Entry<String, Object> entry : repository.getRepository().entrySet()){
            if (entry.getKey().equals(id)){
                userAccount = (UserAccountEntity) entry.getValue();
            }
        }

        return userAccount;
    }

    public UserAccountEntity updateUserAccount(UserAccountEntity userAccount) {
        UserAccountEntity updatedUser = null;

        if (repository.getRepository().containsKey(USERACCOUNT + userAccount.getId())){
            updatedUser = (UserAccountEntity) repository.get(USERACCOUNT + userAccount.getId());

            updatedUser.setUserId(userAccount.getId());

            updatedUser.setAmountOfPrepaidMoney(userAccount.getAmountOfPrepaidMoney());

            repository.put(USERACCOUNT + userAccount.getId(), userAccount);
        }
        return updatedUser;
    }

    public UserAccountEntity getUserAccountByUserId(long userId) {
        for (Map.Entry<String, Object> entry : repository.getRepository().entrySet()){
            if (entry.getKey().startsWith(USERACCOUNT)){
                UserAccountEntity userAccountEntity = (UserAccountEntity) entry.getValue();
                if (userAccountEntity.getUserId() == userId){
                    return userAccountEntity;
                }
            }
        }
        return null;
    }
}
