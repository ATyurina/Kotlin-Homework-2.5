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

    var attachment: Array<Attachment> = Array(5) { AttachmentPhoto(); AttachmentVideo(); AttachmentAudio(); AttachmentDoc(); AttachmentPoll() },

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

interface Attachment {
    var type: String
}

class AttachmentPhoto(
    override var type: String = "photo",
    val photo: Photo = Photo()
) : Attachment

class AttachmentVideo(
    override var type: String = "video",
    val video: Video = Video()
) : Attachment

class AttachmentAudio(
    override var type: String = "audio",
    val audio: Audio = Audio()
) : Attachment

class AttachmentDoc(
    override var type: String = "doc",
    val doc: Doc = Doc()
) : Attachment

class AttachmentPoll(
    override var type: String = "poll",
    val poll: Poll = Poll()
) : Attachment

class Photo(
    val id: Int = 12,
    val albumId: Int = 976,
    val ownerId: Int = 976,
    val userId: Int = 65,
    val text: String = "kitty",
    val date: Int = 54785897,
    val sizes: Array<String> = emptyArray(),
    val width: Int = 2040,
    val height: Int = 576
)

class Video(
    val id: Int = 25,
    val ownerId: Int = 452,
    val title: String = "best friend forever",
    val description: String = "Jake and Finn",
    val duration: Int = 60,
    val image: Array<String> = emptyArray(),
    val views: Int = 2
)

class Audio(
    val id: Int = 34,
    val ownerId: Int = 239,
    val artist: String = "Blondy",
    val title: String = "Maria",
    val duration: Int = 180,
    val url: String = "https://www.youtube.com/watch?v=VoOG7LEyUJ0",
    val genreId: Int = 23
)

class Doc(
    val id: Int = 21,
    val ownerId: Int = 230,
    val title: String = "new folder",
    val size: Int = 230,
    val ext: String = "txt",
    val type: Int = 1
)

class Poll(
    val id: Int = 90,
    val ownerId: Int = 198,
    val created: Int = 924657,
    val question: String = "How you doing?",
    val votes: Int = 26843,
    val anonymous: Boolean = true
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


