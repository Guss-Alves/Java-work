package com.savetravel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.savetravel.models.Expense;
import com.savetravel.services.ExpenseService;


@RestController
@RequestMapping
public class ExpenseApi {

	@Autowired
	private ExpenseService expenseService;
	
	//GET ALL
	@RequestMapping("/api/expenses")
	public List<Expense> findAllExpenses(){
		return expenseService.allExpenses();
	}
	
	//CREATE 
	@PostMapping("/api/expenses/new")
	public Expense createExpense(@RequestParam("expenseName") String expenseName,
								 @RequestParam("vendor") String vendor,
								 @RequestParam("amount") Double amount,
								 @RequestParam("description") String description) {
		
		Expense newExpense = new Expense(expenseName, vendor, amount, description);
		return expenseService.createExpense(newExpense);
	}
	
	//FIND ONE {id}
	@GetMapping("/api/{id}/expense")
	public Expense oneExpense(@PathVariable("id") Long id) {
		return expenseService.oneExpense(id);
	}
	
	//EDIT (FIND ONE + CREATE
	@PutMapping("/api/{id}/edit")
	public Expense editExpense(@PathVariable("id") Long id,
							   @RequestParam("expenseName") String expenseName,
							   @RequestParam("vendor") String vendor,
							   @RequestParam("amount") Double amount,
							   @RequestParam("description") String description) {
	
		return expenseService.updateExpenseApi(id, expenseName, vendor, amount, description);
	
	}
	
	//DELETE
	@DeleteMapping("/api/{id}/delete")
	public void removeExpense(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
	}
	
	
	
}
