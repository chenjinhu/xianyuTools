package com.xiaopang.xianyu.node;

import static com.xiaopang.Constant.*;

public class TaskBase implements ITaskBase{
    public void _openPkName(String packageName) {
        AccUtils.startApplication(context, packageName);
    }
}
