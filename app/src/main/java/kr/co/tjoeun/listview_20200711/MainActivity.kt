package kr.co.tjoeun.listview_20200711

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kr.co.tjoeun.listview_20200711.adapters.StudentsAdapter
import kr.co.tjoeun.listview_20200711.datas.Student

class MainActivity : AppCompatActivity() {

    val mStudentList = ArrayList<Student>()


    //목록에 담긴 데이터를 뿌려주는 어댑터
    lateinit var mAdapter : StudentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAdapter = StudentsAdapter(this, R.layout.student_list_item, mStudentList)
        studentlistView.adapter = mAdapter

        mStudentList.add(Student("김문기", "경기도 남양주시", 1994))
        mStudentList.add(Student("햄벅", "경기도 ㅁㄴㅊ", 1995))
        mStudentList.add(Student("이승현", "시골", 1992))

        mAdapter.notifyDataSetChanged()

        studentlistView.setOnItemClickListener { parent, view, position, id ->
            // position 을 이용해서 클릭된 학생 받아오기.
            val clickedStudent = mStudentList[position]

            Toast.makeText(this, clickedStudent.name, Toast.LENGTH_SHORT).show()
        }

        studentlistView.setOnItemLongClickListener { parent, view, position, id ->
            //정막 삭제 할지 질문
            val alert = AlertDialog.Builder(this)
            alert.setTitle("학생 삭제")
            alert.setMessage("정말 삭제 하시겠습니까?")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->
                //오래 눌린 사람을 목록에서 삭제
                mStudentList.removeAt(position)
                //어댑터 새로고침
                mAdapter.notifyDataSetChanged()
            })
            alert.setNegativeButton("취소", null)
            alert.show()
            return@setOnItemLongClickListener true
        }
    }

}
