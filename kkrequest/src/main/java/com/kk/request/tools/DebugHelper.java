package com.kk.request.tools;

import android.content.pm.ApplicationInfo;

public class DebugHelper
{
    public static boolean isApkInDebug()
    {
        try
        {
            ApplicationInfo info = ApplicationHelper.getApplication().getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
