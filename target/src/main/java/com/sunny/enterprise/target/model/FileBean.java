package com.sunny.enterprise.target.model;

import java.io.Serializable;

public class FileBean implements Serializable {
    Long fileId;
    String fileName;
    String agencyAccountNo;
    String agencyAccountName;
    boolean isDebit;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getAgencyAccountNo() {
        return agencyAccountNo;
    }

    public void setAgencyAccountNo(String agencyAccountNo) {
        this.agencyAccountNo = agencyAccountNo;
    }

    public String getAgencyAccountName() {
        return agencyAccountName;
    }

    public void setAgencyAccountName(String agencyAccountName) {
        this.agencyAccountName = agencyAccountName;
    }

    public boolean isDebit() {
        return isDebit;
    }

    public void setDebit(boolean debit) {
        isDebit = debit;
    }

    @Override
    public String toString() {
        return "{" +
                "fileId=" + fileId +
                ", fileName='" + fileName + '\'' +
                ", agencyAccountNo='" + agencyAccountNo + '\'' +
                ", agencyAccountName='" + agencyAccountName + '\'' +
                ", isDebit=" + isDebit +
                '}';
    }
}
