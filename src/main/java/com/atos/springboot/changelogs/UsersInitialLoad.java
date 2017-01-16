package com.atos.springboot.changelogs;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.atos.springboot.models.Roles;
import com.atos.springboot.models.Users;
import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.google.common.collect.Lists;

@ChangeLog
public class UsersInitialLoad {

	private final Logger	logger	= LoggerFactory.getLogger(this.getClass());
	private MongoTemplate	mongoTemplate;

	@ChangeSet(order = "073", id = "2332", author = "kim07")
	public void initLoad(MongoTemplate mongoTemplate) throws ParseException {
		this.mongoTemplate = mongoTemplate;
		logger.info("Creating default users");

		Roles rolesAdmin = new Roles("ROLE_ADMIN");
		mongoTemplate.save(rolesAdmin);
		Roles rolesUser = new Roles("ROLE_USER");
		mongoTemplate.save(rolesUser);

		createUser("one", Users.ProductType.FREE, Lists.newArrayList(rolesAdmin));
		createUser("one-free", Users.ProductType.FREE, Lists.newArrayList(rolesUser));
		createUser("one-basic", Users.ProductType.BASIC, Lists.newArrayList(rolesUser));
		createUser("one-pro", Users.ProductType.BASIC, Lists.newArrayList(rolesUser));
		createUser("one-pro-1", Users.ProductType.BASIC, Lists.newArrayList(rolesUser));
		createUser("one-pro-2", Users.ProductType.BASIC, Lists.newArrayList(rolesUser));
		createUser("one-pro-3", Users.ProductType.BASIC, Lists.newArrayList(rolesUser));
		createUser("one-pro-4", Users.ProductType.BASIC, Lists.newArrayList(rolesUser));
		createUser("one-pro-5", Users.ProductType.BASIC, Lists.newArrayList(rolesUser));
		createUser("one-pro-6", Users.ProductType.BASIC, Lists.newArrayList(rolesUser));
		createUser("one-pro-7", Users.ProductType.BASIC, Lists.newArrayList(rolesUser));
		createUser("one-pro-8", Users.ProductType.BASIC, Lists.newArrayList(rolesUser));
		createUser("one-pro-9", Users.ProductType.BASIC, Lists.newArrayList(rolesUser));
		createUser("one-pro-10", Users.ProductType.BASIC, Lists.newArrayList(rolesUser));
		createUser("one-pro-11", Users.ProductType.BASIC, Lists.newArrayList(rolesUser));
		createUser("one-pro-12", Users.ProductType.BASIC, Lists.newArrayList(rolesUser));
	}

	private Users createUser(String username, Users.ProductType productType, List<Roles> roles) {
		Users user = new Users();
		user.setUsername(username);
		user.setRoles(roles);
		user.setPassword("$2a$10$L8eX/tMi6TThA1LKGvpMkO4ANQEfbMQeKF6zmtA2eTpiRZcc9dMFu");// password
		user.setActivated(true);
		mongoTemplate.save(user);
		return user;
	}
}
