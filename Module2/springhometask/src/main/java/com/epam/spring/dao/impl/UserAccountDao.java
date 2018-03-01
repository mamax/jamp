package com.epam.spring.dao.impl;

import com.epam.spring.domain.UserAccountEntity;
import com.epam.spring.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import static com.epam.spring.namespace.Constants.USER;
import static com.epam.spring.namespace.Constants.USERACCOUNT;

public class UserAccountDao {

    @Autowired
    private Repository repository;

    private String generatedId(long id) {
        return USERACCOUNT + Long.toString(id);
    }

    public void addUserAccount(UserAccountEntity userAccount) {
        repository.put(generatedId(userAccount.getId()), userAccount);
    }

    public boolean deleteUserAccountById(long userId) {
        return repository.delete(generatedId(userId));
    }

    public UserAccountEntity getUserAccountById(long id) {
        return (UserAccountEntity) repository.getById(generatedId(id));
    }

    public UserAccountEntity updateUserAccount(UserAccountEntity userAccount) {
        UserAccountEntity updatedUser = null;

        if (repository.getRepository().containsKey(generatedId(userAccount.getId()))){
            updatedUser = (UserAccountEntity) repository.get(generatedId(userAccount.getId()));

            updatedUser.setUserId(userAccount.getId());

            updatedUser.setAmountOfPrepaidMoney(userAccount.getAmountOfPrepaidMoney());

            repository.put(generatedId(userAccount.getId()), userAccount);
        }
        return updatedUser;
    }

    public UserAccountEntity getUserAccountByUserId(long userId) {
        return (UserAccountEntity) repository.getById(USER + Long.toString(userId));
    }
}
