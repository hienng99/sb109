package com.nvhien.inventoryservice;

import com.nvhien.inventoryservice.model.Inventory;
import com.nvhien.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("mitom");
			inventory.setQuantity(100L);

			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("xucxich");
			inventory1.setQuantity(50L);

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
		};
	}

}
