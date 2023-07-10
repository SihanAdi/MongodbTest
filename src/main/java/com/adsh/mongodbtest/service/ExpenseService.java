package com.adsh.mongodbtest.service;

import com.adsh.mongodbtest.model.Expense;
import com.adsh.mongodbtest.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(Expense expense){
        expenseRepository.insert(expense);
    }

    public void updateExpense(Expense expense){
        Expense oldExpense = expenseRepository.findById(expense.getId())
                .orElseThrow(() -> new RuntimeException("Cannot find Expense by " + expense.getId()));

        oldExpense.setExpenseName(expense.getExpenseName());
        oldExpense.setExpenseCategory(expense.getExpenseCategory());
        oldExpense.setExpenseAmount(expense.getExpenseAmount());

        expenseRepository.save(expense);
    }

    public List<Expense> getAllExpense(){
        return expenseRepository.findAll();
    }

    public Expense getExpenseBuName(String name){
        return expenseRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Cannot find Expense by " + name));
    }

    public void deleteExpense(String id){
        expenseRepository.deleteById(id);
    }
}
