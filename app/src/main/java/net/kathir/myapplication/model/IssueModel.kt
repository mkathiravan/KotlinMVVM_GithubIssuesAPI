package net.kathir.myapplication.model

data class IssueModel(val title:String, val number:String, val created_at:String, val user : UserInfoModel)