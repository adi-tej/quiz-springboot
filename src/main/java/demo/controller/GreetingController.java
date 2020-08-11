package demo.controller;

import demo.entity.Greeting;
import demo.entity.User;
import demo.entity.UserTotalNumbers;
import demo.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    private UserService userService;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    
    @RequestMapping(path= "/user", method = RequestMethod.POST)
    public UserTotalNumbers seachUser(@RequestBody User user) {
        //if the param doesn't exit
        if (user.getName() == null) {
            logger.warn("Missing User Information");
            return new UserTotalNumbers("User not found", 0);
        }

        int totalNumbers = userService.getTotalNumbersForName(user.getName());
        return new UserTotalNumbers(user.getName(), totalNumbers);
    }

}
