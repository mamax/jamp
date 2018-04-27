package com.epam.spring.dao.impl;

import com.epam.spring.domain.UserAccountEntity;
import com.epam.spring.model.UserAccount;
import com.epam.spring.repository.Repository;

import org.springframework.beans.factory.annotation.Autowired;

import static com.epam.spring.namespace.Constants.USERACCOUNT;

public class UserAccountDao {

    @Autowired
    private Repository repository;

    private String generatedUserAccountId(long id) {
        return USERACCOUNT + Long.toString(id);
    }

    public void addUserAccount(UserAccount userAccount) {
        repository.put(generatedUserAccountId(userAccount.getId()), userAccount);
    }

    public boolean deleteUserAccountById(long userId) {
        return repository.delete(generatedUserAccountId(userId));
    }

    public UserAccountEntity getUserAccountById(long id) {
        return (UserAccountEntity) repository.getById(
          generatedUserAccountId(id));
    }

    public UserAccount updateUserAccount(UserAccount userAccount) {
        UserAccount updatedUser = null;

        if (repository.getRepository().containsKey(
          generatedUserAccountId(userAccount.getId()))){
            updatedUser = (UserAccountEntity) repository.get(
              generatedUserAccountId(userAccount.getId()));

            updatedUser.setUserId(userAccount.getId());

            updatedUser.setAmountOfPrepaidMoney(userAccount.getAmountOfPrepaidMoney());

            repository.put(generatedUserAccountId(userAccount.getId()), userAccount);
        }
        return updatedUser;
    }

    public UserAccount getUserAccountByUserId(long userId) {
        return (UserAccountEntity) repository.getById(generatedUserAccountId(userId));
    }
}
