package com.jkluo.luckymoney.service;

import com.jkluo.luckymoney.Repository.LuckymoneyRepository;
import com.jkluo.luckymoney.entity.Luckymoney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class LuckymoneyService {

    @Autowired
    LuckymoneyRepository luckymoneyRepository;

    @Transactional
    public void createtwo(){
        Luckymoney luckymoney1 = new Luckymoney();
        luckymoney1.setProducer("jkl");
        luckymoney1.setMoney(new BigDecimal(520));
        luckymoneyRepository.save(luckymoney1);

        Luckymoney luckymoney2 = new Luckymoney();
        luckymoney2.setProducer("jkl");
        luckymoney2.setMoney(new BigDecimal(1314));
        luckymoneyRepository.save(luckymoney2);

    }
}
