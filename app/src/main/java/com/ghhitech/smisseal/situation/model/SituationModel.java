package com.ghhitech.smisseal.situation.model;

import java.util.List;

public class SituationModel implements ISituation{

    /**
     * success : true
     * list : [{"noStartTaskNum":0,"currentProjectNum":10,"todayBackDetonatorNum":0,"unusualChargePeopleNum":1,"totalTaskNum":208,"todayBackExplosiveNum":0,"todayOverTaskNum":0,"breakOffTaskNum":3,"carNum":5,"todayUseDetonatorNum":0,"depotNum":28,"todayUseExplosiveNum":0,"startingTaskNum":0,"todayReceiveExplosiveNum":0,"peopleNum":14,"expiredTaskNum":31,"todayReceiveDetonatorNum":0,"deviceNum":17,"projectNum":23,"willEndProjectNum":0,"chargePeopleNum":2,"toDayTaskNum":0,"tomorrowTaskNum":0}]
     */

    private boolean success;
    private List<ListBean> list;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * noStartTaskNum : 0
         * currentProjectNum : 10
         * todayBackDetonatorNum : 0
         * unusualChargePeopleNum : 1
         * totalTaskNum : 208
         * todayBackExplosiveNum : 0
         * todayOverTaskNum : 0
         * breakOffTaskNum : 3
         * carNum : 5
         * todayUseDetonatorNum : 0
         * depotNum : 28
         * todayUseExplosiveNum : 0
         * startingTaskNum : 0
         * todayReceiveExplosiveNum : 0
         * peopleNum : 14
         * expiredTaskNum : 31
         * todayReceiveDetonatorNum : 0
         * deviceNum : 17
         * projectNum : 23
         * willEndProjectNum : 0
         * chargePeopleNum : 2
         * toDayTaskNum : 0
         * tomorrowTaskNum : 0
         */

        private int noStartTaskNum;
        private int currentProjectNum;
        private int todayBackDetonatorNum;
        private int unusualChargePeopleNum;
        private int totalTaskNum;
        private int todayBackExplosiveNum;
        private int todayOverTaskNum;
        private int breakOffTaskNum;
        private int carNum;
        private int todayUseDetonatorNum;
        private int depotNum;
        private int todayUseExplosiveNum;
        private int startingTaskNum;
        private int todayReceiveExplosiveNum;
        private int peopleNum;
        private int expiredTaskNum;
        private int todayReceiveDetonatorNum;
        private int deviceNum;
        private int projectNum;
        private int willEndProjectNum;
        private int chargePeopleNum;
        private int toDayTaskNum;
        private int tomorrowTaskNum;

        public int getNoStartTaskNum() {
            return noStartTaskNum;
        }

        public void setNoStartTaskNum(int noStartTaskNum) {
            this.noStartTaskNum = noStartTaskNum;
        }

        public int getCurrentProjectNum() {
            return currentProjectNum;
        }

        public void setCurrentProjectNum(int currentProjectNum) {
            this.currentProjectNum = currentProjectNum;
        }

        public int getTodayBackDetonatorNum() {
            return todayBackDetonatorNum;
        }

        public void setTodayBackDetonatorNum(int todayBackDetonatorNum) {
            this.todayBackDetonatorNum = todayBackDetonatorNum;
        }

        public int getUnusualChargePeopleNum() {
            return unusualChargePeopleNum;
        }

        public void setUnusualChargePeopleNum(int unusualChargePeopleNum) {
            this.unusualChargePeopleNum = unusualChargePeopleNum;
        }

        public int getTotalTaskNum() {
            return totalTaskNum;
        }

        public void setTotalTaskNum(int totalTaskNum) {
            this.totalTaskNum = totalTaskNum;
        }

        public int getTodayBackExplosiveNum() {
            return todayBackExplosiveNum;
        }

        public void setTodayBackExplosiveNum(int todayBackExplosiveNum) {
            this.todayBackExplosiveNum = todayBackExplosiveNum;
        }

        public int getTodayOverTaskNum() {
            return todayOverTaskNum;
        }

        public void setTodayOverTaskNum(int todayOverTaskNum) {
            this.todayOverTaskNum = todayOverTaskNum;
        }

        public int getBreakOffTaskNum() {
            return breakOffTaskNum;
        }

        public void setBreakOffTaskNum(int breakOffTaskNum) {
            this.breakOffTaskNum = breakOffTaskNum;
        }

        public int getCarNum() {
            return carNum;
        }

        public void setCarNum(int carNum) {
            this.carNum = carNum;
        }

        public int getTodayUseDetonatorNum() {
            return todayUseDetonatorNum;
        }

        public void setTodayUseDetonatorNum(int todayUseDetonatorNum) {
            this.todayUseDetonatorNum = todayUseDetonatorNum;
        }

        public int getDepotNum() {
            return depotNum;
        }

        public void setDepotNum(int depotNum) {
            this.depotNum = depotNum;
        }

        public int getTodayUseExplosiveNum() {
            return todayUseExplosiveNum;
        }

        public void setTodayUseExplosiveNum(int todayUseExplosiveNum) {
            this.todayUseExplosiveNum = todayUseExplosiveNum;
        }

        public int getStartingTaskNum() {
            return startingTaskNum;
        }

        public void setStartingTaskNum(int startingTaskNum) {
            this.startingTaskNum = startingTaskNum;
        }

        public int getTodayReceiveExplosiveNum() {
            return todayReceiveExplosiveNum;
        }

        public void setTodayReceiveExplosiveNum(int todayReceiveExplosiveNum) {
            this.todayReceiveExplosiveNum = todayReceiveExplosiveNum;
        }

        public int getPeopleNum() {
            return peopleNum;
        }

        public void setPeopleNum(int peopleNum) {
            this.peopleNum = peopleNum;
        }

        public int getExpiredTaskNum() {
            return expiredTaskNum;
        }

        public void setExpiredTaskNum(int expiredTaskNum) {
            this.expiredTaskNum = expiredTaskNum;
        }

        public int getTodayReceiveDetonatorNum() {
            return todayReceiveDetonatorNum;
        }

        public void setTodayReceiveDetonatorNum(int todayReceiveDetonatorNum) {
            this.todayReceiveDetonatorNum = todayReceiveDetonatorNum;
        }

        public int getDeviceNum() {
            return deviceNum;
        }

        public void setDeviceNum(int deviceNum) {
            this.deviceNum = deviceNum;
        }

        public int getProjectNum() {
            return projectNum;
        }

        public void setProjectNum(int projectNum) {
            this.projectNum = projectNum;
        }

        public int getWillEndProjectNum() {
            return willEndProjectNum;
        }

        public void setWillEndProjectNum(int willEndProjectNum) {
            this.willEndProjectNum = willEndProjectNum;
        }

        public int getChargePeopleNum() {
            return chargePeopleNum;
        }

        public void setChargePeopleNum(int chargePeopleNum) {
            this.chargePeopleNum = chargePeopleNum;
        }

        public int getToDayTaskNum() {
            return toDayTaskNum;
        }

        public void setToDayTaskNum(int toDayTaskNum) {
            this.toDayTaskNum = toDayTaskNum;
        }

        public int getTomorrowTaskNum() {
            return tomorrowTaskNum;
        }

        public void setTomorrowTaskNum(int tomorrowTaskNum) {
            this.tomorrowTaskNum = tomorrowTaskNum;
        }
    }
}
