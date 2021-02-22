package com.wsf.firstcodelearn.webviewtest;

import java.util.List;

class CatalogBean {


    private List<TimetableBean> timetableList;

    public List<TimetableBean> getTimetableList() {
        return timetableList;
    }

    public void setTimetableList(List<TimetableBean> timetableList) {
        this.timetableList = timetableList;
    }

    public static class TimetableListBean {
        /**
         * goodsTimetableId : 176
         * goodsId : 8
         * couseNo : 第1讲
         * couseContent : 转折+递进
         * startTime : 2020-12-19T09:00:00.000+0000
         * endTime : 2020-12-19T10:30:00.000+0000
         * projectId : null
         * subjectId : 9
         * moduleId : 16
         * teacherId : 2
         * createTime : 2021-02-03T11:44:27.000+0000
         * updateTime : 2021-02-03T11:44:27.000+0000
         * createUser : 512
         * updateUser : 512
         * versionNo : null
         * accountId : 3
         */

        private int goodsTimetableId;
        private int goodsId;
        private String couseNo;
        private String couseContent;
        private String startTime;
        private String endTime;
        private Object projectId;
        private int subjectId;
        private int moduleId;
        private int teacherId;
        private String createTime;
        private String updateTime;
        private int createUser;
        private int updateUser;
        private Object versionNo;
        private int accountId;

        public int getGoodsTimetableId() {
            return goodsTimetableId;
        }

        public void setGoodsTimetableId(int goodsTimetableId) {
            this.goodsTimetableId = goodsTimetableId;
        }

        public int getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(int goodsId) {
            this.goodsId = goodsId;
        }

        public String getCouseNo() {
            return couseNo;
        }

        public void setCouseNo(String couseNo) {
            this.couseNo = couseNo;
        }

        public String getCouseContent() {
            return couseContent;
        }

        public void setCouseContent(String couseContent) {
            this.couseContent = couseContent;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public Object getProjectId() {
            return projectId;
        }

        public void setProjectId(Object projectId) {
            this.projectId = projectId;
        }

        public int getSubjectId() {
            return subjectId;
        }

        public void setSubjectId(int subjectId) {
            this.subjectId = subjectId;
        }

        public int getModuleId() {
            return moduleId;
        }

        public void setModuleId(int moduleId) {
            this.moduleId = moduleId;
        }

        public int getTeacherId() {
            return teacherId;
        }

        public void setTeacherId(int teacherId) {
            this.teacherId = teacherId;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public int getCreateUser() {
            return createUser;
        }

        public void setCreateUser(int createUser) {
            this.createUser = createUser;
        }

        public int getUpdateUser() {
            return updateUser;
        }

        public void setUpdateUser(int updateUser) {
            this.updateUser = updateUser;
        }

        public Object getVersionNo() {
            return versionNo;
        }

        public void setVersionNo(Object versionNo) {
            this.versionNo = versionNo;
        }

        public int getAccountId() {
            return accountId;
        }

        public void setAccountId(int accountId) {
            this.accountId = accountId;
        }
    }
}
