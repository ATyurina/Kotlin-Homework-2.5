package ru.netology

data class Post(
    var id: Int = 0,
    var ownerId: Int = 0,
    var fromId: Int = 0,
    var createdBy: Int = 213,
    val date: Int = 12047,
    val text: String = "lolololoo",
    val replyOwnerId: Int?,
    val replyPostId: Int?,
    val friendsOnly: Boolean = true,
    val comments: Comments = Comments(),
    val copyright: Copyright = Copyright(),
    val likes: Likes = Likes(),
    val repost: Repost = Repost(),
    val views: Views = Views(),
    val postType: String = "reply",
    val postSource: String = "Information",

    val geo: Geo = Geo(),
    val signerId: Int?,
    var copyHistory: Array<String> = emptyArray(),
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val isPinned: Boolean = true,
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false,
    val donut: Donut = Donut(),
    val postponedId: Int?,



    val published: Long = 2345678956,
    val authorName: String = "Steve"
)

data class Comments(
    val count: Int = 9,
    val canPost: Boolean = true,
    val groupsCanPost: Boolean = false
)
data class Copyright(
    val id: Int = 9,
    val link: String = "url",
    val type: String = "mem"
)
data class Likes(
    val count: Int = 29,
    val canPublish: Boolean = true,
)
data class Repost(
    val count: Int = 29,
    val userReposted: Boolean = true,
)
data class Views(
    val count: Int = 29,
)
data class Geo(
    val type: String = "city",
    val coordinates: String = "234",
    val place: String = "Norm"
)
data class Donut(
    val isDonut: Boolean = false,
    val paidDuration: Int = 0,
    val placeholder: String = "LOL",
    val canPublishFreeCopy: Boolean = true,
    val editMode: String = "all"
)
object WallService {

    private var posts = emptyArray<Post>()
    private var ident = 5

    fun add(post: Post): Post {
        val postId = post.copy(id = ident)
        posts += postId
        ident += 1
        return postId
    }

    fun update(post: Post): Boolean {
        for ((index, postIn) in posts.withIndex()) {
             if (post.id == postIn.id) {
                 posts[index] = post.copy(createdBy = postIn.createdBy, published = postIn.published)
                return true
            }
        }
        return false
    }
}

fun main() {
}


