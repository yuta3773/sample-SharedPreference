package com.example.sharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import com.example.sharedpreference.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var gsonData: GsonData
    private var gsonDataList: MutableList<GsonData> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //デフォルトの共有プリファレンスを習得
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        //共有プリファレンス習得した値を代入
        val input = pref.getString("INPUT_TITLE", "")
        if (input != null) {
            gsonDataList = Gson().fromJson<MutableList<GsonData>>(input, MutableList::class.java)
        }
        //値の表示
        binding.editTitle.setText(gsonDataList.toString())
//        binding.editDeadline.setText(gsonData.deadline)

        //タップされた時にリスナーをセット
        binding.button.setOnClickListener {
            //入力された文字を代入
            gsonData = GsonData(title = binding.editTitle.text.toString(),
                                deadline = binding.editDeadline.text.toString())
            gsonDataList = mutableListOf(gsonData)
            onSaveTapped()
        }
    }
    //保存処理
    private fun onSaveTapped() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val str = Gson().toJson(gsonDataList)
        pref.edit {
            putString("INPUT_TITLE", str)
            .commit()
        }
    }
}