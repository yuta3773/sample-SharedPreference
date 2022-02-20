package com.example.sharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import com.example.sharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //デフォルトの共有プリファレンスを習得
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        //共有プリファレンス習得した値を代入
        val inputTitle = pref.getString("INPUT_TITLE", "")
        val inputDeadline = pref.getString("INPUT_DEADLINE", "")
        //値の表示
        binding.editTitle.setText(inputTitle)
        binding.editDeadline.setText(inputDeadline)
        //タップされた時にリスナーをセット
        binding.button.setOnClickListener { onSaveTapped() }
    }
    //保存処理
    private fun onSaveTapped() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        pref.edit {
            putString("INPUT_TITLE", binding.editTitle.text.toString())
            putString("INPUT_DEADLINE", binding.editDeadline.text.toString())
            .commit()
        }
    }
}