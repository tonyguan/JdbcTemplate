package com.zhijieketang;

public abstract class TaskTemplate {

    public final void 任务() {
        // 步骤①
        烧水();
        // 步骤②
        冲泡();
        // 步骤③
        喝();
    }

    private void 烧水() {
        System.out.println("烧水...");
    }

    protected abstract void 冲泡();


    private void 喝() {
        System.out.println("喝...");
    }

}
