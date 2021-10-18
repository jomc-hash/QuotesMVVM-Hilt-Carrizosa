package dev.cardoso.quotesmvvm.presentation.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dev.cardoso.quotesmvvm.databinding.ActivityMainBinding
import dev.cardoso.quotesmvvm.presentation.viewmodel.QuoteViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()

    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        quoteViewModel.setContext(this)
        quoteViewModel.getQuotes()
        observer()
        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }
    }


    private fun observer(){
            lifecycleScope.launch {
            quoteViewModel.quoteModel.collect {
                binding.tvQuote.text = it.quote
                binding.tvAuthor.text= it.author
            }
        }
    }

}