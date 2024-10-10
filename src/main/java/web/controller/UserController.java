package web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.entity.User;
import web.service.UserService;
import java.util.List;

@Controller
public class UserController {
	@Autowired
	private UserService userService;


	@GetMapping
	public String listUsers(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "user_list";
	}

	@GetMapping("/users/add")
	public String showAddUserForm(Model model) {
		model.addAttribute("user", new User());
		return "user_form";
	}

	@PostMapping("/users/add")
	public String addUser(@ModelAttribute User user) {
		userService.save(user);
		return "redirect:/";
	}

	@GetMapping("/users/edit/{id}")
	public String showEditUserForm(@PathVariable int id, Model model) {
		User user = userService.findById(id);
		model.addAttribute("user", user);
		return "user_form_edit";
	}

	@PostMapping("/users/edit")
	public String editUser(@ModelAttribute User user) {
		userService.update(user);
		return "redirect:/";
	}

	@GetMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		userService.delete(id);
		return "redirect:/";
	}
}
	
