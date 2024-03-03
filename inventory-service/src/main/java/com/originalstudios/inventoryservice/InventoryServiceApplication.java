package com.originalstudios.inventoryservice;

import com.originalstudios.inventoryservice.Repository.InventoryRepository;
import com.originalstudios.inventoryservice.model.Inventory;
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
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args->{
		Inventory inventory=new Inventory();
		inventory.setSkuCode("iphone15");
		inventory.setQuantity(50);

			Inventory inventory1=new Inventory();
			inventory1.setSkuCode("Samsung s24");
			inventory1.setQuantity(0);

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
		};
	}

}
