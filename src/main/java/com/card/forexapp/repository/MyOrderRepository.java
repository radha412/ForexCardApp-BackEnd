package com.card.forexapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.card.forexapp.entity.MyOrder;

public interface MyOrderRepository extends JpaRepository<MyOrder,Long> {

}
