package com.xiaopang.node;

import static com.xiaopang.Constant.*;
import static com.xiaopang.node.AccUtils.*;

import com.xiaopang.node.AccUtils.*;
public class TaskBase implements ITaskBase{
    public void _openPkName(String packageName) {
        startApplication(context, packageName);
    }
}
