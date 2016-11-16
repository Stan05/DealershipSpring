package com.dealership.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dealership.web.form.UserForm;
import com.dealership.web.service.UserService;

@RequestMapping("/user")
public class UserController {

	private UserService userService;

	private Validator userFormValidator;

	private AuthenticationManager authenticationManager;

	@Autowired
	public UserController(final UserService userService, final Validator userFormValidator,
	                final AuthenticationManager authenticationManager) {
		this.userService = userService;
		this.userFormValidator = userFormValidator;
		this.authenticationManager = authenticationManager;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String processLogin(@RequestParam(value = "error", required = false) String error,
	                @RequestParam(value = "logout", required = false) String logout, Model model) {

		if ( error != null ) {
			model.addAttribute("error", "Invalid username or password!");
		}

		if ( logout != null ) {
			model.addAttribute("logout", "You've been logged out successfully.");
		}
		return "home";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String processLogout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if ( auth != null ) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/user/login?logout";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterView(Model model) {
		model.addAttribute(new UserForm());
		return "userRegister";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String proccessRegister(@Valid UserForm userForm, BindingResult errors, HttpServletRequest request) {
		userFormValidator.validate(userForm, errors);
		if ( errors.hasErrors() ) {
			return "userRegister";
		}
		userService.createUser(userForm);
		authenticateUserAndSetSession(userForm, request);
		return "redirect:/view/all";
	}

	private void authenticateUserAndSetSession(UserForm user, HttpServletRequest request) {
		String username = user.getUsername();
		String password = user.getPassword();

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
		request.getSession();
		token.setDetails(new WebAuthenticationDetails(request));

		Authentication authenticatedUser = authenticationManager.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
	}
}
