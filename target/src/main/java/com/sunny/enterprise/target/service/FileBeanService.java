package com.sunny.enterprise.target.service;

import com.sunny.enterprise.target.model.FileBean;
import com.sunny.enterprise.target.model.FileBeanFilter;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class FileBeanService<T> {
    List<T> beans = new ArrayList<>();

    FileBeanService()
    {
        for(long i=0;i < 10 ;i++)
        {
            FileBean fileBean = new FileBean();
            fileBean.setFileId(i);
            fileBean.setFileName("Filename-"+i);
            fileBean.setAgencyAccountName("AgencyAccountName-"+i);
            fileBean.setAgencyAccountNo("N"+new Random().nextLong());
            beans.add((T) fileBean);
        }
    }

    public List getAll(FileBeanFilter fileBeanFilter)
    {
        Predicate<FileBean> fileIdFilter = fileBean -> null == fileBeanFilter.getFileId() ? true : fileBeanFilter.getFileId().equals(fileBean.getFileId());
        Predicate<FileBean> fileNameFilter = fileBean -> null == fileBeanFilter.getFileName() ? true : fileBeanFilter.getFileName().equals(fileBean.getFileName());
        Predicate<FileBean> agencyAccountNameFilter = fileBean -> null == fileBeanFilter.getAgencyAccountName() ? true : fileBeanFilter.getAgencyAccountName().equals(fileBean.getAgencyAccountName());
        Predicate<FileBean> agencyAccountNoFilter = fileBean -> null == fileBeanFilter.getAgencyAccountNo() ? true : fileBeanFilter.getAgencyAccountNo().equals(fileBean.getAgencyAccountNo());


        return  beans.stream().filter(
              bean -> fileIdFilter.and(fileNameFilter).and(agencyAccountNameFilter).and(agencyAccountNoFilter).test((FileBean) bean)
        ).collect(Collectors.toList());
    }

    public boolean add( FileBean fileBean)
    {
        return beans.add((T) fileBean);
    }

    public FileBean delete(Long fileId) {
        Optional<T> optionalFileBean = get(fileId);

        if(!optionalFileBean.isPresent())
            throw new NoSuchElementException("FileBean for "+fileId+" not present");
        else
        {
            FileBean fileBean = (FileBean) optionalFileBean.get();
            beans.remove(fileBean);
            return fileBean;
        }
    }

    public Optional<T> get(Long fileId) {
        Predicate<FileBean> fileIdFilter = fileBean -> null == fileId ? true : fileId.equals(fileBean.getFileId());

        return  beans.stream().filter(
                bean -> fileIdFilter.test((FileBean) bean)
        ).findFirst();
    }

}
