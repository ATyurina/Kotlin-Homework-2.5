package ru.netology

data class Post(
    val id: Int,
    val authorId: Int,
    val authorName: String,
    val content: String,
    val published: Long,
    val likes: Int,

    val canEdit: Boolean = true,
    val postponedId: Int = 0,
    val postType: String = "reply",
    val date: Int = 12047,
    val isFavorite: Boolean = false,
    val canDelete: Boolean = true,
    val canPin: Boolean = true,
    val markedAsAds: Boolean = false,
    val isPinned: Int = 0,
    val friendsOnly: Int = 0,
)

object WallService {

    private var posts = emptyArray<Post>()

    fun add(post: Post): Array<Post> {
        posts += post
        return posts
    }

}

fun main() {
    val postOne = Post(1, 1, "autohr", "content", likes = 0, published = 0)
    val postTwo = Post(1, 1, "autohr", "content", likes = 0, published = 0)

//    val liked = post.copy(likes = post.likes + 1)
//    val (id, authorId, _, content) = post
//    println("$id, $authorId, $content")


}