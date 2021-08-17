package mx.santander.fiduciarioplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.santander.fiduciarioplus.model.profile.Access;



public interface IAccessRepository extends JpaRepository<Access, Long>{

}
