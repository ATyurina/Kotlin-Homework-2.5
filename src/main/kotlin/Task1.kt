package ru.netology

data class Post(
    var id: Int = 0,
    var authorId: Int = 213,
    val authorName: String = "Steve",
    val content: String = "lolololoo",
    var published: Long = 2345678956,

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
    val comments: Comments = Comments(),
    val likes: Likes = Likes()
)

data class Comments(
    val count: Int = 9,
    val canPost: Boolean = true,
    val groupsCanPost: Boolean = false
)
data class Likes(
    val count: Int = 29,
    val canPublish: Boolean = true,
)
object WallService {

    private var posts = emptyArray<Post>()
    private var ident = 5

    fun add(post: Post): Post {
        posts += post.copy(id = ident)
        ident += 1
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, postIn) in posts.withIndex()) {
             if (post.id == postIn.id) {
                 posts[index] = post.copy(authorId = postIn.authorId, published = postIn.published)
                return true
            }
        }
        return false
    }
}

fun main() {
    var wall = WallService
    var postOne = Post(1)
    var postTwo = Post(1)
    var postOTree = Post(1)
    var postOFour = Post(5, authorId = 8, content = "fooo", published = 3456789)
    var postOFive = Post(6, authorId = 0, content = "pooo", published = 34567)
}


