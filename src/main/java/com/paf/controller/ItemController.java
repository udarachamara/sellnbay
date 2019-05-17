package com.paf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paf.model.Item;
import com.paf.dao.ItemDAO;

@RestController
public class ItemController {

  private final ItemDAO itemDAO;

  @Autowired
  ItemController(ItemDAO itemDAO) {
    this.itemDAO = itemDAO;
  }

  @RequestMapping("/item/{id}")
  public ResponseEntity<Item> getItem(@PathVariable("id") Long id) {
	  
    Item item = itemDAO.findOne(id);
    
    if(item == null) {
    	return ResponseEntity.notFound().build();
    }
    
    return ResponseEntity.ok().body(item);
  }

}
