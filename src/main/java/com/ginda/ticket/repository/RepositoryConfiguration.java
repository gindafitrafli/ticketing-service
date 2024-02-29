package com.ginda.ticket.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.ginda.ticket.repository"})
public class RepositoryConfiguration {
}
