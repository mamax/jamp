package com.epam.spring.domain;

import com.epam.spring.model.UserAccount;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserAccountEntity implements UserAccount{

    private long id;
    private long amountOfPrepaidMoney;
    private long userId;

}
