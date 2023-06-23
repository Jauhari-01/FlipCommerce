package com.example.FlipCommerce.repository;

import com.example.FlipCommerce.models.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {
    @Query(value = "select id from order_info order by total_value desc limit 5", nativeQuery = true)
    List<Integer> top5OrdersWithHighestOrderValue();

    @Query(value = "select id from order_info order by id desc limit 5", nativeQuery = true)
    List<Integer> top5RecentlyOrders();
}
