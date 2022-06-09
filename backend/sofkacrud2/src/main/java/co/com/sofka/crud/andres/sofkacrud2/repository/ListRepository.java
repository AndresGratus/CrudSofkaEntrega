package co.com.sofka.crud.andres.sofkacrud2.repository;



import co.com.sofka.crud.andres.sofkacrud2.entity.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ListRepository extends JpaRepository<ListEntity, Long> {
}