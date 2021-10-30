package com.sunny.enterprise.target.controller;

import com.sunny.enterprise.target.model.FileBeanFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/file")
public class FileController {
    private static final Logger LOGGER = LogManager.getLogger(FileController.class);

    @PostMapping("/files")
    public List<String> fileList(@RequestBody FileBeanFilter fileBeanFilter) {

    }
}
