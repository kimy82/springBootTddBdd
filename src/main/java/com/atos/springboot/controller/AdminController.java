package com.atos.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atos.springboot.dtos.PageResult;
import com.atos.springboot.models.Users;
import com.atos.springboot.services.UserService;
import com.atos.springboot.utils.UsersSortType;

@Secured({ "ROLE_ADMIN" })
@RequestMapping("/admin")
@Controller
public class AdminController {

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String evaluatorDashboard(Model model) {
		Page<Users> usersPage = this.userService
				.findAll(new PageRequest(0, 10, getUserSort(UsersSortType.USERNAME_DESC)));
		model.addAttribute("usersPage", new PageResult<Page<Users>>(usersPage, "/admin/users-table"));

		return "admin/dashboard";
	}

	@RequestMapping(value = "/users-table/{page}/{itemsperpage}")
	public String getUsers(@PathVariable int page, @PathVariable int itemsperpage,
			@RequestParam(required = false, value = "sort") UsersSortType sort, Model model) {

		Page<Users> usersPage = this.userService.findAll(new PageRequest(page, itemsperpage, getUserSort(sort)));
		model.addAttribute("usersPage", new PageResult<Page<Users>>(usersPage, "/admin/users-table"));
		return "fragments/admin/users :: usersTabBox";
	}

	@RequestMapping(value = "/users-info/{id}")
	public String getUserInfo(@PathVariable String id, Model model) {

		Users user = this.userService.findById(id);
		model.addAttribute("user", user);

		return "fragments/admin/modal/user :: userInfo";
	}

	private Sort getUserSort(UsersSortType sortType) {
		UsersSortType finalSortType;

		if (sortType == null) {
			finalSortType = UsersSortType.USERNAME_DESC;
		} else {
			finalSortType = sortType;
		}

		Sort sorter = new Sort(Sort.Direction.ASC, "username");

		if (finalSortType == UsersSortType.USERNAME_DESC) {
			sorter = new Sort(Sort.Direction.DESC, "username");
		}

		return sorter;
	}
}
