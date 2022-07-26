package contract.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import contract.models.AdminUser;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, String> {

}
