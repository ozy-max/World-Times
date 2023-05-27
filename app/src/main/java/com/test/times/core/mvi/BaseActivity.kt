package com.test.times.core.mvi

import androidx.activity.ComponentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

abstract class BaseActivity : ComponentActivity() {

    protected fun <T : Any, F : Flow<T>> observe(flow: F, body: (T) -> Unit) {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) { flow.collect { body(it) } }
        }
    }

    protected fun <T : Any?, F : Flow<T?>> observeNullable(flow: F, body: (T?) -> Unit) {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                flow.collect { body(it) }
            }
        }
    }
}