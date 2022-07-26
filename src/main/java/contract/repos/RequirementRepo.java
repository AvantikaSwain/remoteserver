package contract.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import contract.models.Requirement;

@Repository
public interface RequirementRepo extends JpaRepository<Requirement, String> {

}
