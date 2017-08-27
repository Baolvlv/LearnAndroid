package com.example.bwx.checkpermissionincode;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by bwx on 2016/10/27.
 */
public class Hello {
    public  static  final String PERMEISSION_SAY_HELLO ="com.example.bwx.checkpermissionincode.permission.SAY_HELLO";
    public static void sayHello(Context context)
    {
        //检查是否具有访问权限
        int checkResult = context.checkCallingOrSelfPermission(PERMEISSION_SAY_HELLO);
        //结果只有两个值：PERMISSION_GRANTED（允许访问），PERMISSION_DENIED拒绝访问
        if(checkResult != PackageManager.PERMISSION_GRANTED)
        {
            //抛出安全异常
            throw new SecurityException("执行sayHello方法需要有com.example.bwx.checkpermissionincode.permission.SAY_HELLO权限");

        }

        System.out.println("hello bss");
    }
}
