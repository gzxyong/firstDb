package firstDb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import firstDb.modal.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	

}
