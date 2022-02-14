package com.example.ivan.recyclerviewwithmultipletypes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val dataAdapter: DataAdapter by lazy {
        DataAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataAdapter.setData(getMockData())
        findViewById<RecyclerView>(R.id.recyclerView)
            .apply {
                layoutManager = LinearLayoutManager(this@MainActivity)

                /**
                 * 通过Adapter的增删改插，去刷新RecyclerView
                 * 而不是通过adapter?.notifyItemChanged，去刷新RecyclerView
                 */
                hasFixedSize()

                this.adapter = dataAdapter
            }
    }

    /**
     * 下面就是模拟不同数据结构的数据。
     * 都是来自DataModel的
     * DataModel中有多种对应不同接口的数据处理
     */
    private fun getMockData(): List<DataModel> = listOf(
        DataModel.Header(
            bgColor = resources.getColor(R.color.family_bg),
            title = "My Family"
        ),
        DataModel.Family(
            name = "Mr. Karim",
            relationship = "Father"
        ),
        DataModel.Family(
            name = "Mrs. Karim",
            relationship = "Mother"
        ),
        DataModel.Family(
            name = "Sister One",
            relationship = "Sister"
        ),
        DataModel.Family(
            name = "Sister two",
            relationship = "Sister"
        ),
        DataModel.Header(
            bgColor = resources.getColor(R.color.friend_bg),
            title = "My friends"
        ),
        DataModel.Friend(
            name = "My Friend one",
            gender = "Male"
        ),
        DataModel.Friend(
            name = "My Friend two",
            gender = "Female"
        ),
        DataModel.Friend(
            name = "My Friend three",
            gender = "Male"
        ),
        DataModel.Header(
            bgColor = resources.getColor(R.color.colleague_bg),
            title = "My colleagues"
        ),
        DataModel.Colleague(
            name = "Colleague 1",
            organization = "Org 1",
            designation = "Manager"
        ),
        DataModel.Colleague(
            name = "Colleague 2",
            organization = "Org 2",
            designation = "Software Eng"
        ),
        DataModel.Colleague(
            name = "Colleague 3",
            organization = "Org 3",
            designation = "Software Eng"
        ),
        DataModel.Colleague(
            name = "Colleague 4",
            organization = "Org 4",
            designation = "Sr Software Eng"
        ),
        DataModel.Colleague(
            name = "Colleague 5",
            organization = "Org 5",
            designation = "Sr Software Eng"
        ),
    )

}