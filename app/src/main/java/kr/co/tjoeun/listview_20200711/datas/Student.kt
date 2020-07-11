package kr.co.tjoeun.listview_20200711.datas

import java.util.*

class Student (val name: String, val address: String, val birthYear: Int)
{

    fun getKoreanAge(): Int
    {
        // 현재 년도 - 생년 + 1이 한국 나이.
        val now = Calendar.getInstance()
        // now 에는 현재 시간이 기록됨

        return now.get(Calendar.YEAR) - this.birthYear +1
    }

}