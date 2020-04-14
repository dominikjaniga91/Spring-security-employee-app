package springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springdemo.model.MyUser;


@Repository
public interface MyUserRepoImpl extends JpaRepository<MyUser, Integer> {

        MyUser findByUsername(String username);

}
