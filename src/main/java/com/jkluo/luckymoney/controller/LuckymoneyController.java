package com.jkluo.luckymoney.controller;

import com.jkluo.luckymoney.Repository.LuckymoneyRepository;
import com.jkluo.luckymoney.entity.Luckymoney;
import com.jkluo.luckymoney.service.LuckymoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckymoneyController {

    @Autowired
    LuckymoneyRepository luckymoneyRepository;
    @Autowired
    LuckymoneyService luckymoneyService;
    /**
     * 获取红包列表
     */
    @GetMapping("/luckymoneys")
    public List<Luckymoney> list(){
        return luckymoneyRepository.findAll();
    }

    /**
     * 新建一个红包
     */
    @PostMapping("/luckymoneys")
    public Luckymoney create(@RequestParam("producer") String producer,
                             @RequestParam("money")BigDecimal money){
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setProducer(producer);
        luckymoney.setMoney(money);
        return luckymoneyRepository.save(luckymoney);
    }

    /**
     * 根据id查找红包
     */
    @GetMapping ("/luckymoneys/{id}")
    public Luckymoney findById(@PathVariable("id") Integer id){
        return luckymoneyRepository.findById(id).orElse(null);
    }

    /**
     * 更新记录,领红包
     */
    @PutMapping("/luckymoneys/{id}")
    public Luckymoney update(@PathVariable("id") Integer id,
                             @RequestParam("consumer") String consumer){
        Optional<Luckymoney> optional = luckymoneyRepository.findById(id);
        if(optional.isPresent()){                    //optional.isPresent可判断是否为空对象
            Luckymoney luckymoney = optional.get();  //获取optional对象
            luckymoney.setConsumer(consumer);
            return luckymoneyRepository.save(luckymoney);
        }
        return null;
    }

    /**
     * 红包事务
     */
    @PostMapping("/luckymoneys/two")
    public void createtwo(){
        luckymoneyService.createtwo();
    }
}
