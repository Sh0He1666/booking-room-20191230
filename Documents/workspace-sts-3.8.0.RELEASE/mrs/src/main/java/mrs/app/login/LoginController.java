package mrs.app.login;

import org.springframework.web.bind.annotation.RequestMapping;

public class LoginController {
	@RequestMapping("loginForm")
	String loginForm() {
		return "login/loginForm";
	}
}
