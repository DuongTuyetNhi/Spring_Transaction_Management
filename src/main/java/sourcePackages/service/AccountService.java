package sourcePackages.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import sourcePackages.entities.AccountEntity;
import sourcePackages.repository.AccountRepository;

import javax.transaction.Transaction;
import javax.transaction.Transactional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public AccountService(JpaTransactionManager jpaTransactionManager) {
    }

//    private JpaTransactionManager transactionManager;
//
//    public AccountService(JpaTransactionManager transactionManager){
//        this.transactionManager = transactionManager;
//    }

    @Transactional(rollbackFor = Exception.class)
    public void transferMoney(int sourceAccountId, int targetAccountId, double amount){
        AccountEntity sourceAccount = accountRepository.findById(sourceAccountId).get();
            AccountEntity targetAccount = accountRepository.findById(targetAccountId).get();
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            accountRepository.save(sourceAccount);
            targetAccount.setBalance(targetAccount.getBalance() + amount);
            accountRepository.save(targetAccount);

        if (sourceAccount.getBalance()<0){
                throw new Exception("amount to transfer more than balance.");
            }
        targetAccount.setBalance(targetAccount.getBalance() + amount);
        accountRepository.save(targetAccount);

//        TransactionDefinition definition = new DefaultTransactionDefinition();
//        TransactionStatus status = transactionManager.getTransaction(definition);
//        try {
//            AccountEntity sourceAccount = accountRepository.findById(sourceAccountId).get();
//            AccountEntity targetAccount = accountRepository.findById(targetAccountId).get();
//            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
////            targetAccount.setBalance(targetAccount.getBalance() + amount);
//            accountRepository.save(sourceAccount);
////            accountRepository.save(targetAccount);
//
//
//            if (sourceAccount.getBalance()<0){
//                throw new Exception("amount to transfer more than balance.");
//            }
//            targetAccount.setBalance(targetAccount.getBalance() + amount);
//            accountRepository.save(targetAccount);
//
//
//            transactionManager.commit(status);
//        } catch (Exception exception){
//            transactionManager.rollback(status);
//            throw new RuntimeException(exception);
//        }
    }


}
