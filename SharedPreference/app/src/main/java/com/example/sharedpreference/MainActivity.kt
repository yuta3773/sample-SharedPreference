package com.example.sharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import com.example.sharedpreference.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var gsonDate = GsonDate()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //デフォルトの共有プリファレンスを習得
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        //共有プリファレンス習得した値を代入
        val input = pref.getString("INPUT_TITLE", "")
        gsonDate = Gson().fromJson<GsonDate>(input, GsonDate::class.java) as GsonDate

        //値の表示
        binding.editTitle.setText(gsonDate.title)
        binding.editDeadline.setText(gsonDate.deadline)

        //タップされた時にリスナーをセット
        binding.button.setOnClickListener {
            //入力された文字を代入
            gsonDate.title = binding.editTitle.text.toString()
            gsonDate.deadline = binding.editDeadline.text.toString()
            onSaveTapped() }
    }
    //保存処理
    private fun onSaveTapped() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val str = Gson().toJson(gsonDate)
        pref.edit {
            putString("INPUT_TITLE", str)
            .commit()
        }
    }
}