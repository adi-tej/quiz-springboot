package demo.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import demo.dao.UserRepository;
import demo.entity.User;

/**
 * 
 * @author Edward
 * For implement the UserService interface
 *
 */
public class UserServiceImpl implements UserService {
	
	private final static Logger logger = Logger.getLogger(UserServiceImpl.class.getName());


	@Autowired
	private UserRepository userRepository;

	@Override
	/**
	 * Search total numbers for a user
	 * 
	 * @param name user name
	 * @return int total number for a user
	 */
	public int getTotalNumbersForName(String name) {
		List<User> list = userRepository.getUsers();
		logger.log(Level.FINE, "user total size:" + list.size()+", " + list);
		List<User> resultList = list.stream().filter(user -> name.equals(user.getName())).collect(Collectors.toList());
		logger.log(Level.FINE, "user results:" + resultList.size() + ", result list:" + resultList);
		return resultList.size();
	}

}
