package com.epam.spring.domain;

import lombok.Data;

@Data
public class UserAccountEntity {

    private long id;
    private long amountOfPrepaidMoney;
    private long userId;

    public UserAccountEntity() {
    }

    public long getAmountOfPrepaidMoney() {
        return amountOfPrepaidMoney;
    }

    public void setAmountOfPrepaidMoney(long amountOfPrepaidMoney) {
        this.amountOfPrepaidMoney = amountOfPrepaidMoney;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

}
