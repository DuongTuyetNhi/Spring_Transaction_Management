package sourcePackages.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sourcePackages.config.SpringClass;
import sourcePackages.repository.AccountRepository;
import sourcePackages.service.AccountService;

import javax.activation.DataHandler;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringClass.class);
        AccountService accountService = (AccountService) context.getBean("accountService");
//        accountService.transferMoney(1, 2, 50);
//        accountService.transferMoney(1, 2, 100);
        accountService.transferMoney(1, 2, 10);
    }

}
