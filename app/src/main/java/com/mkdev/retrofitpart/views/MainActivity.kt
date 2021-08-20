package com.mkdev.retrofitpart.views

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mkdev.retrofitpart.R
import com.mkdev.retrofitpart.models.QuoteModel
import com.mkdev.retrofitpart.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData(false)
        getDataButton.setOnClickListener {
            quoteTextView.text = getString(R.string.loading_quote)
            getData(true)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun getData(refresh: Boolean) {
        mainViewModel.getQuoteData(refresh).observe(this, { data ->
            data?.let {
                it.error?.let { error ->
                    logInfo("Error is " + error.message)
                    return@observe
                }
                it.code?.let { code ->
                    when (code) {
                        404 -> toast("Sorry not found! :(")
                        else -> {
                            toast("Error! Please try again..")
                        }
                    }
                    return@observe
                }

                val quote: QuoteModel? = it.posts
                quoteTextView.text = "${quote?.quoteText} \n\n- ${quote?.quoteAuthor}"
            } ?: run {
                logInfo("Handle Error")
            }
        })
    }

    private fun logInfo(msg: String) {
        Log.i("MainActivity", msg)
    }

    private fun toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}