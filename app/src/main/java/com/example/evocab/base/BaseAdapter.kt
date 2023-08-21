package com.example.sourcebase.base

import android.content.SharedPreferences
import android.view.View
import androidx.recyclerview.widget.*
import com.example.evocab.base.BaseViewHolder
import com.example.evocab.model.Vocabulary
import org.koin.android.ext.android.get

import java.util.concurrent.Executors

abstract class BaseAdapter<T, VH : BaseViewHolder<T>>(diffUtil: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, VH>(
        AsyncDifferConfig.Builder(diffUtil)
            .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor())
            .build()
    ) {

    private var recyclerView: RecyclerView? = null   //RecyclerView khi mà adapter gắn vào
    private var layoutNoData: View? = null   //View hiển thị khi không có dữ liệu
    private var enableShowNoDataUI = false    //Biến xác định xem có hiển thị hay không

    //lưu tham chiếu đến recyclerView khi adapter được gắn vào recyclerView
    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }

    //Ràng buộc dữ liệu tại vị trí position với viewHolder "holder"
    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.binView(getItem(position), true)
    }

    //Bật chế độ hiểu thị layoutNoData khi danh sách rỗng
    open fun enableShowNoDataUI(layoutNoData: View) {
        enableShowNoDataUI = true
        this.layoutNoData = layoutNoData
    }

    //gửi danh sách giá trị mới và xử lý hiển thị layoutNoData khi danh sách rỗng
    override fun submitList(list: List<T>?) {
        super.submitList(list)
//        if (enableShowNoDataUI) {
//            if (list == null || list.isEmpty()) {
//                recyclerView?.hide()
//                layoutNoData?.show()
//            } else {
//                recyclerView?.show()
//                layoutNoData?.hide()
//            }
//        }
    }

    //xử lý sự kiện tải thêm khi người dùng cuộn đến cuối danh sách
    fun loadMore(recyclerView: RecyclerView?, handle: () -> Unit) {
        recyclerView?.apply {  //THực hiện khi đối tượng không null
            addOnScrollListener(   //thêm vào khi cuộn
                object : RecyclerView.OnScrollListener() {  //khi cuộn
                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {  // được gọi khi cuộn
                        super.onScrolled(recyclerView, dx, dy)
                        //lấy layoutManager của recyclerView ép kiểu về LinearLayoutManager
                        val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?
                        val sizeData = recyclerView.adapter?.itemCount?.minus(1) // tính toán chiều dài của recycl hiện tại
                        if (
                            //nếu linearlayoutmanager không null
                            linearLayoutManager != null &&
                            linearLayoutManager.findLastCompletelyVisibleItemPosition() ==
                            sizeData &&
                            sizeData != -1 //phần tử cuối của danh sách bằng phần tử cuối hiển thị và không phải -1
                        ) {
                            handle()
                        }
                    }
                }
            )
        }
    }
}