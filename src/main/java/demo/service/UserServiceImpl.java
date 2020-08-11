package demo.service;

import demo.dao.UserRepository;
import demo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 * @author Benny
 *
 * The implementation of UserService interface
 *
 */
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    /**
     * Get total user numbers by user name
     *
     * @param name user name
     * @return int total user numbers
     *
     */
    public int getTotalNumbersForName(String name) {

        List<User> userList = userRepository.getUsers();
        logger.info("Total User Numbers in system:" + userList.size());
        return (int)userList.stream().filter(user -> user.getName().equals(name)).count();
    }
}
