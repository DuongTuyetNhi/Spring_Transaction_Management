package sourcePackages.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sourcePackages.entities.AccountEntity;
@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, Integer> {

}
