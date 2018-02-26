package com.epam.spring.dao.impl;

import com.epam.spring.domain.UserAccountEntity;
import com.epam.spring.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static com.epam.spring.namespace.Constants.USERACCOUNT;

public class UserAccountDao {

    @Autowired
    private Repository repository;

    private String generatedId(UserAccountEntity userAccount) {
        return USERACCOUNT + userAccount.getId();
    }

    public void createUserAccount(UserAccountEntity userAccount) {
        repository.put(generatedId(userAccount), userAccount);
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
                return (UserAccountEntity) entry.getValue();
            }
        }

        return userAccount;
    }

    public UserAccountEntity updateUserAccount(UserAccountEntity userAccount) {
        UserAccountEntity updatedUser = null;

        if (repository.getRepository().containsKey(generatedId(userAccount))){
            updatedUser = (UserAccountEntity) repository.get(generatedId(userAccount));

            updatedUser.setUserId(userAccount.getId());

            updatedUser.setAmountOfPrepaidMoney(userAccount.getAmountOfPrepaidMoney());

            repository.put(generatedId(userAccount), userAccount);
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
