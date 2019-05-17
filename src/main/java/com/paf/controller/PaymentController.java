package com.paf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paf.model.Item;
import com.paf.model.Payment;
import com.paf.repository.ItemRepository;
import com.paf.repository.PaymentRepository;

@RestController
public class PaymentController {

  private final ItemRepository itemRepo;
  private final PaymentRepository paymentRepo;

  @Autowired
  PaymentController(ItemRepository itemRepo, PaymentRepository paymentRepo) {
    this.itemRepo = itemRepo;
    this.paymentRepo = paymentRepo;
  }

  @RequestMapping("/foobar/{id}")
  public String fooBar(@PathVariable("id") Long id) {
    //Foo foo = fooRepo.findById(id);
    //Bar bar = barRepo.findById(id);
    
    return "<input type='text' name='test' value='HELLO WORLD'>";

    //return foo.getFoo() + " " + bar.getBar() + "!";
  }

}
