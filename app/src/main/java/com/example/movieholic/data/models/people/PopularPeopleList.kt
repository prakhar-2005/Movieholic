package com.example.movieholic.data.models.people


import com.google.gson.annotations.SerializedName

data class PopularPeopleList(
//    @SerializedName("page")
//    val page: Int,
    @SerializedName("results")
    val popularPeople: List<PopularPeople>
//    @SerializedName("total_pages")
//    val totalPages: Int,
//    @SerializedName("total_results")
//    val totalResults: Int
)