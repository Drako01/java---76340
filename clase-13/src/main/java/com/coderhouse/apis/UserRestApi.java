package com.coderhouse.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.coderhouse.interfaces.UserRestInterface;
import com.coderhouse.models.User;

@Component
public class UserRestApi implements UserRestInterface {

	private final String BASE_URL = "https://672d3b52fd8979715641d1ff.mockapi.io/users";

	@Autowired
	private RestTemplate rt;

	@Override
	public List<User> getAllUsers() {
		try {
			@SuppressWarnings("unchecked")
			List<User> users = rt.exchange(BASE_URL, HttpMethod.GET, null, List.class).getBody();
			return users;
		} catch (Exception e) {
			throw new RuntimeException("Error, No se pueden obtener los datos del Servidor" + e.getMessage());
		}
	}

	@Override
	public User getUserById(String id) {
		try {
			String url = BASE_URL + '/' + id;
			return rt.getForObject(url, User.class);
		} catch (Exception e) {
			throw new RuntimeException("Error, No se pueden obtener los datos del Servidor" + e.getMessage());
		}
	}

	@Override
	public User addUser(User user) {
		try {
			return rt.postForObject(BASE_URL, user, User.class);
		} catch (Exception e) {
			throw new RuntimeException("Error, No se pueden obtener los datos del Servidor" + e.getMessage());
		}
	}

	@Override
	public User updateUser(User user) {
		try {
			String url = BASE_URL + '/' + user.getId();
			rt.put(url, user);
			return user;
		} catch (Exception e) {
			throw new RuntimeException("Error, No se pueden obtener los datos del Servidor" + e.getMessage());
		}
	}

	@Override
	public void deleteUserById(String id) {
		try {
			String url = BASE_URL + '/' + id;
			rt.delete(url);
		} catch (Exception e) {
			throw new RuntimeException("Error, No se pueden obtener los datos del Servidor" + e.getMessage());
		}
	}

}
