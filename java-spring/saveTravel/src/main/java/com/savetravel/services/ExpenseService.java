package com.savetravel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.savetravel.models.Expense;
import com.savetravel.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepo;

	//constructor
	public ExpenseService(ExpenseRepository expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
	//find all the expenses
	public List<Expense> allExpenses(){
		return expenseRepo.findAll();
	}
	
	//create
	public Expense createExpense(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	//FIND ONE
	public Expense oneExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepo.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    } 
	
	 //UPDATE ONE 
	public Expense updateExpense( Expense expense ) {
			return expenseRepo.save(expense);
		}
	
    //UPDATE ONE FOR API WITHOUT USING THE MODEL MODEL
	public Expense updateExpenseApi(Long id, String expenseName, String vendor, Double amount, String description ) {
		Expense foundExpense = this.oneExpense(id);
		foundExpense.setExpenseName(expenseName);
		foundExpense.setVendor(vendor);
		foundExpense.setAmount(amount);
		foundExpense.setDescription(description);
		
		return expenseRepo.save(foundExpense);
	}
	
	//DELETE 
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
		
	}
		
	
}
