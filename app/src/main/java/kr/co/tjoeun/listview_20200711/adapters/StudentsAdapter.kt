package kr.co.tjoeun.listview_20200711.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kr.co.tjoeun.listview_20200711.R
import kr.co.tjoeun.listview_20200711.datas.Student

class StudentsAdapter
    (val mContext: Context, val resId: Int, val mList: List<Student>) :ArrayAdapter<Student>(mContext, resId, mList)
{
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View
    {
       var tempRow = convertView

        if (tempRow == null)
        {
            tempRow = inf.inflate(R.layout.student_list_item, null)

        }

        //이코드가 실행되는 시점 => tempRow 가 null 일 가능성이 없다
        val row = tempRow!!
        //!! : 절때 널이 아닐경우

        // row의 내용을 가공해서 사용
        val nameTxt = row.findViewById<TextView>(R.id.nameTxt)
        val addressTxt = row.findViewById<TextView>(R.id.addressTxt)
        val ageTxt = row.findViewById<TextView>(R.id.ageTxt)

        // 뿌려줄 근거 데이터 가져오기
        val data = mList[position]
        nameTxt.text = data.name
        addressTxt.text = data.address
        ageTxt.text = "${data.getKoreanAge()}세"

        return row
    }
}
