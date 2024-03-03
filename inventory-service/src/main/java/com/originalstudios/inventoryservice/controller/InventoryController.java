package com.originalstudios.inventoryservice.controller;

import com.originalstudios.inventoryservice.service.InventoryService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@Data
@RequiredArgsConstructor
public class InventoryController {
private final InventoryService inventoryService;
    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean isInStock(@PathVariable("sku-code") String skuCode){
    return inventoryService.isInStock(skuCode);

    }
}
