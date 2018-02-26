package com.epam.spring.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserAccountEntity {

    private long id;
    private long amountOfPrepaidMoney;
    private long userId;

}
