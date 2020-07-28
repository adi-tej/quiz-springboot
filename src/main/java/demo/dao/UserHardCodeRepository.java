package demo.dao;

import demo.entity.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class UserHardCodeRepository implements UserRepository {
    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        Random random = new Random();
        IntStream.range(0, random.nextInt(1000)).forEach(n -> users.add(new User(n, getName())));
        return users.size() > 0 ? users : null;
    }

    private static String getName() {
        Random random = new Random();
        if (random.nextBoolean()) {
            return "Tom";
        } else {
            return "John";
        }
    }
}
