package com.example.paging3app.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paging3app.model.Results
import com.example.paging3app.retrofit.QuoteApi

class QuotePagingSource(val quoteApi : QuoteApi) : PagingSource<Int,Results>() {
    override fun getRefreshKey(state: PagingState<Int, Results>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Results> {
        return try {
            val position = params.key ?: 1
            val response = quoteApi.getQuotes(position)

            return LoadResult.Page(
                data = response.results,
                prevKey = if (position == 1) null else position-1,
                nextKey = if(position == response.totalPages) null else position+1
            )
        } catch (e:Exception){
            LoadResult.Error(e)
        }
    }
}