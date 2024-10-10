package web.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.entity.User;
import web.repository.UserRepository;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
