package demo.service;

import java.util.List;
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
		System.out.println("user total size:" + list.size()+", " + list);
		List<User> resultList = list.stream().filter(user -> name.equals(user.getName())).collect(Collectors.toList());
		System.out.println("user results:" + resultList.size() + ", result list:" + resultList);
		return resultList.size();
	}

}
