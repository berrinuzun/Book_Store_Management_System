package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.entity.ShoppingChart;

@Repository
public interface ShoppingChartRepository extends JpaRepository<ShoppingChart, Integer> {

}
