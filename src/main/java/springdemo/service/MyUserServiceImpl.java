package springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springdemo.model.MyUser;
import springdemo.repository.MyUserRepoImpl;

@Service
public class MyUserServiceImpl implements MyUserService {

    private final MyUserRepoImpl repository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MyUserServiceImpl(MyUserRepoImpl repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(MyUser user) {
        System.out.println(" save method ");
        System.out.println(" password " + user.getPassword());
        System.out.println(" username " + user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println(" password encoded " + user.getPassword());
        repository.save(user);
    }
}
