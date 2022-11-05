package com.cdx.jetpackdemo

import apis.amapv2.com.listviewlibrary.activity.BaseListActivty
import apis.amapv2.com.listviewlibrary.bean.ItemObject
import com.cdx.jetpackdemo.activity.*

class MainActivity : BaseListActivty() {

    override fun addData(data: ArrayList<ItemObject>) {
        data.add(ItemObject("Scaffold例子", ScaffoldDemoActivity::class.java))
        data.add(ItemObject("Divide例子", DivideDemoActivity::class.java))
        data.add(ItemObject("ModalDrawer例子", ModalDrawerDemoActivity::class.java))
        data.add(ItemObject("BottomDrawer底部抽屉式导航栏", BottomDrawerDemoActivity::class.java))
        data.add(ItemObject("BottomSheetScaffold底部动作条",
            BottomSheetScaffoldDemoActivity::class.java))
        data.add(ItemObject("BackdropScaffold背景幕", BackdropScaffoldDemoActivity::class.java))
        data.add(ItemObject("LazyColumn列表", LazyColumnDemoActivity::class.java))
        data.add(ItemObject("LazyVerticalGrid列表", LazyVerticalGridDemoActivity::class.java))
        data.add(ItemObject("Text列表", TextDemoActivity::class.java))
        data.add(ItemObject("Image列表", ImageDemoActivity::class.java))
    }


}