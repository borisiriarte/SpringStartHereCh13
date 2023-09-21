package com.example.transactionapp.service;

import com.example.transactionapp.model.Account;
import com.example.transactionapp.repository.AccountRespository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {
  private final AccountRespository accountRespository;

  public TransferService(AccountRespository accountRespository) {
    this.accountRespository = accountRespository;
  }

  @Transactional
  public void transferMoney(long idSender, long idReceiver, BigDecimal amount){
    Account sender = accountRespository.findAccountById(idSender);
    Account receiver = accountRespository.findAccountById(idReceiver);

    BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
    BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

    accountRespository.changeAmount(idSender, senderNewAmount);
    accountRespository.changeAmount(idReceiver, receiverNewAmount);

    throw new RuntimeException("Oh no! Something went wrong!");
  }

  public List<Account> getAllAccounts() {
    return accountRespository.findAllAccounts();
  }
}
