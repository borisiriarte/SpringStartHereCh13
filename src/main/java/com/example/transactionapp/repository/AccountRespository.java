package com.example.transactionapp.repository;

import com.example.transactionapp.model.Account;
import com.example.transactionapp.repository.mappers.AccountRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class AccountRespository {
  private final JdbcTemplate jdbc;

  public AccountRespository(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  public Account findAccountById(long id){
    String sql = "SELECT * FROM account WHERE id = ?";
    return jdbc.queryForObject(sql, new AccountRowMapper(), id);
  }

  public void changeAmount(long id, BigDecimal amount) {
    String sql = "UPDATE account SET amount = ? WHERE id = ?";
    jdbc.update(sql, amount, id);
  }

  public List<Account> findAllAccounts() {
    String sql = "SELECT * FROM account";
    return jdbc.query(sql, new AccountRowMapper());
  }
}
