package car.shop.controller.security;

import car.shop.entity.security.User;
import car.shop.service.security.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("/new-user")
    public String create(@RequestBody User user) {
        userService.create(user);
        return "User has been created.";
    }
}
