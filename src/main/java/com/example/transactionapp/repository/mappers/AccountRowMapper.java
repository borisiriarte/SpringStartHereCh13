package com.example.transactionapp.repository.mappers;

import com.example.transactionapp.model.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper< Account > {
  @Override
  public Account mapRow(ResultSet r, int i) throws SQLException {
    Account account = new Account();
    account.setId(r.getInt("id"));
    account.setName(r.getString("name"));
    account.setAmount(r.getBigDecimal("amount"));

    return account;
  }
}
