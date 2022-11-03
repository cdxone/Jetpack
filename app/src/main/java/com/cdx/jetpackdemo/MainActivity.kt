package com.cdx.jetpackdemo

import apis.amapv2.com.listviewlibrary.activity.BaseListActivty
import apis.amapv2.com.listviewlibrary.bean.ItemObject
import com.cdx.jetpackdemo.activity.BottomDrawerDemoActivity
import com.cdx.jetpackdemo.activity.DivideDemoActivity
import com.cdx.jetpackdemo.activity.ModalDrawerDemoActivity
import com.cdx.jetpackdemo.activity.ScaffoldDemoActivity

class MainActivity : BaseListActivty() {

    override fun addData(data: ArrayList<ItemObject>) {
        data.add(ItemObject("Scaffold例子", ScaffoldDemoActivity::class.java))
        data.add(ItemObject("Divide例子", DivideDemoActivity::class.java))
        data.add(ItemObject("ModalDrawer例子", ModalDrawerDemoActivity::class.java))
        data.add(ItemObject("BottomDrawer底部抽屉式导航栏", BottomDrawerDemoActivity::class.java))

    }

}