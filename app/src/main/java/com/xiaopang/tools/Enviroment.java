package com.xiaopang.tools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.List;

public class Enviroment {
    public static boolean checkAppInstalled(Context context, String pkgName){

        if (pkgName.isEmpty()) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> pkgInfos = packageManager.getInstalledPackages(0);
        if (pkgInfos != null) {
            for (int i = 0; i < pkgInfos.size(); i++) {
                String pkg = pkgInfos.get(i).packageName;
                if (pkg.equals(pkgName)) {
                    return true;
                }
            }
        }
        return false;
    }

}
