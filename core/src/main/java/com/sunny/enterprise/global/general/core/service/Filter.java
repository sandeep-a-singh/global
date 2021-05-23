package com.sunny.enterprise.global.general.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class Filter {
    @Autowired
    DataSource primaryDataSource;
}
