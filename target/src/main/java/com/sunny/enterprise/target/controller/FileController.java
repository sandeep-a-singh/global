package com.sunny.enterprise.target.controller;

import com.sunny.enterprise.target.model.FileBean;
import com.sunny.enterprise.target.model.FileBeanFilter;
import com.sunny.enterprise.target.service.FileBeanService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class FileController {
    private static final Logger LOGGER = LogManager.getLogger(FileController.class);
    FileBeanService fileBeanService;

    @Autowired
    FileController(FileBeanService<FileBean> fileBeanService) {
        this.fileBeanService = fileBeanService;
    }

    @PostMapping("/files")
    public List fileList(@RequestBody FileBeanFilter fileBeanFilter) {
        List fileBeans = fileBeanService.getAll(fileBeanFilter);
        LOGGER.info("{\"List\" :" + fileBeans + " }");
        return fileBeans;
    }

    @PostMapping("/add")
    public FileBean addFileBean(@RequestBody FileBean fileBean) {
        fileBeanService.add(fileBean);
        LOGGER.info("{\"Added\" :" + fileBean + " }");
        return fileBean;
    }

    @PostMapping("/delete/{id}")
    public FileBean deleteFileBean(@PathVariable("id") Long fileId) {
        FileBean fileBean = fileBeanService.delete(fileId);
        LOGGER.info("{\"Delete\" :" + fileBean + " }");
        return fileBean;
    }

    @PostMapping("/{id}")
    public FileBean getFileBean(@PathVariable("id") Long fileId) {
        Optional<FileBean> optionalFileBean = fileBeanService.get(fileId);
        if (!optionalFileBean.isPresent())
            throw new NoSuchElementException("FileBean for " + fileId + " not present");

        FileBean fileBean = optionalFileBean.get();
        LOGGER.info("{\"Get\" :" + fileBean + " }");
        return fileBean;
    }

}
