package mx.santander.fiduciarioplus.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.santander.fiduciarioplus.model.profile.Profile;


@Transactional
public interface IProfileRepository extends JpaRepository<Profile, Long>{
	
//	public Optional<Profile> findByBuc(String buc);

}
