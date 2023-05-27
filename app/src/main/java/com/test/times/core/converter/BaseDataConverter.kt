package com.test.times.core.converter

import com.test.times.core.mvi.Resource

interface BaseDataConverter<R, D> {
    fun convert(data: R): Resource<D>
}