package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.ShoppingChart;
import com.bookstore.repository.ShoppingChartRepository;

@Service
public class ShoppingChartService {

	@Autowired
	private ShoppingChartRepository sChartRepo;
	
	public void saveShoppingChart(ShoppingChart shoppingChart) {
		
		sChartRepo.save(shoppingChart);
		
	}
	
	public List<ShoppingChart> getShoppingChart(){
		
		return sChartRepo.findAll();
		
	}
	
	public void deleteById(int id) {
		
		sChartRepo.deleteById(id);
		
	}
	
}
