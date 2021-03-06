package com.kubrynski.data.model;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jkubrynski@gmail.com
 * @since 2013-10-22
 */
@Entity
@NamedQuery(name = "Company.legacyNamedQuery", query = "select c from Company c where c.users.size > ?1")
public class Company extends AbstractEntity {

	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<User> users = new HashSet<User>();

	@OneToMany(cascade = CascadeType.ALL)
	private Set<Project> projects = new HashSet<Project>();

	@ElementCollection
	private Set<String> technolgies = new HashSet<String>();

	public Company() {
	}

	public Company(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public void addUser(User user) {
		user.setCompany(this);
		users.add(user);
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public Set<String> getTechnolgies() {
		return technolgies;
	}

	public void setTechnolgies(Set<String> technolgies) {
		this.technolgies = technolgies;
	}

	public void addProject(Project project) {
		projects.add(project);
		project.setCompany(this);
	}
}
