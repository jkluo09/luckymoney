package com.jkluo.luckymoney.Repository;

import com.jkluo.luckymoney.entity.Luckymoney;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LuckymoneyRepository extends JpaRepository<Luckymoney,Integer> {
}
