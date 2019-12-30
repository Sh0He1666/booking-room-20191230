package mrs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import mrs.domain.service.user.ReservationUserDetailsService;

/**
 * フォーム認証に関するコンフィグクラス
 * @author shoheitokumaru
 *
 */
@Configuration
//Spring SecurityのWeb連携機能(CSRF対策など)を有効にする
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	ReservationUserDetailsService userDetailsService;
	
	//パスワードのエンコードアルゴリズムを指定
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/js/**", "/css/**").permitAll() ///jsと/css以下のアクセスは常に許可 "permitAll()"
		.antMatchers("/**").authenticated() //上記以外のアクセスは認証を要求 "authenticated()"
		.and() //
		.formLogin()
		.loginPage("/loginForm") //ログイン画面
		.loginProcessingUrl("/login") //認証URL
		.usernameParameter("username") //ユーザー名
		.passwordParameter("password") //パスワード
		.defaultSuccessUrl("/rooms",true) //認証成功時の遷移先URL
		.failureUrl("/loginForm?error=true").permitAll(); //認証失敗時の遷移先URL
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
}
