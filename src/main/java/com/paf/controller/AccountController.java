package com.paf.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paf.dao.AccountDAO;
import com.paf.model.Account;
import com.paf.model.PaymentRequest;
import com.paf.model.SuccessResponse;

@RestController
public class AccountController {


	  private final AccountDAO accountDAO;

	  @Autowired
	  AccountController(AccountDAO accountDAO) {
	    this.accountDAO = accountDAO;
	  }
	  
		/* to save an account*/
		@PostMapping("/accounts")
		public Account createAccount(@Valid @RequestBody Account account) {
			return accountDAO.save(account);
		}
		
		/*get all accounts*/
		@GetMapping("/accounts")
		public List<Account> getAllAccounts(){
			return accountDAO.findAll();
		}
		
		/*check accounts*/
		@PostMapping("/accounts/makePayment")
		public SuccessResponse checkAccountsDetails(@Valid @RequestBody PaymentRequest paymentRequest){
			
			String cardNo = paymentRequest.getCardNo();
			SuccessResponse successResponse = new SuccessResponse();
			
			List<Account> accounts= accountDAO.findAll();
			for (final Account room : accounts) {
		          System.out.println(room.getCardNo());
			}
			
			successResponse.setCode(1000);
			successResponse.setStatus(true);
			successResponse.setResponseText(cardNo);
			return successResponse;
		}

		/*get account by accountid*/
		@GetMapping("/accounts/{id}")
		public ResponseEntity<Account> getAccountById(@PathVariable(value="id") Long accountid){
			
			Account account= accountDAO.findOne(accountid);
			
			if(account==null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok().body(account);
			
		}
		
		/*update an account by accountid*/
		@PutMapping("/accounts/{id}")
		public ResponseEntity<Account> updateAccount(@PathVariable(value="id") Long accountid,@Valid @RequestBody Account accountDetails){
			
			Account account=accountDAO.findOne(accountid);
			if(account==null) {
				return ResponseEntity.notFound().build();
			}
			
			account.setFname(accountDetails.getFname());
			account.setLname(accountDetails.getLname());
			account.setAccountBalance(accountDetails.getAccountBalance());
			account.setCardNo(accountDetails.getCardNo());
			account.setCvc(accountDetails.getCvc());
			account.setAccountStatus(accountDetails.getAccountStatus());
			
			Account updateAccount=accountDAO.save(account);
			return ResponseEntity.ok().body(updateAccount);
			
			
			
		}
		
		/*Delete an account*/
		@DeleteMapping("/accounts/{id}")
		public ResponseEntity<Account> deleteEmployee(@PathVariable(value="id") Long accountid){
			
			Account account = accountDAO.findOne(accountid);
			if(account==null) {
				return ResponseEntity.notFound().build();
			}
			accountDAO.delete(account);
			
			return ResponseEntity.ok().build();
			
			
		}
}
