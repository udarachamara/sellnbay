package com.paf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paf.model.Foo;
import com.paf.model.Payment;
import com.paf.repository.FooRepository;
import com.paf.repository.PaymentRepository;

@RestController
public class FooBarController {

  private final FooRepository fooRepo;
  private final PaymentRepository barRepo;

  @Autowired
  FooBarController(FooRepository fooRepo, PaymentRepository barRepo) {
    this.fooRepo = fooRepo;
    this.barRepo = barRepo;
  }

  @RequestMapping("/foobar/{id}")
  public String fooBar(@PathVariable("id") Long id) {
    //Foo foo = fooRepo.findById(id);
    //Bar bar = barRepo.findById(id);
    
    return "test"+id;

    //return foo.getFoo() + " " + bar.getBar() + "!";
  }

}
