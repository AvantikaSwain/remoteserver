package contract.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import contract.models.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, String> {

	
}
