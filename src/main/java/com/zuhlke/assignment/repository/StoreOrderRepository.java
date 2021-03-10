package com.zuhlke.assignment.repository;

import com.zuhlke.assignment.model.StoreOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreOrderRepository extends JpaRepository<StoreOrder, Long> {

}
