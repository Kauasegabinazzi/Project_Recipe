package com.example.projectrecipes.models


data class Product (
        val name: String,
        val description: String)

data class User(val username: String, val passwordHash: String)
data class UsersList(val users: List<User>)