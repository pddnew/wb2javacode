package br.com.dsasoft.ft.ws.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.dsasoft.ft.ws.model.Expense;

@Repository
public interface ExpenseRepository extends MongoRepository<Expense, String> {

}
