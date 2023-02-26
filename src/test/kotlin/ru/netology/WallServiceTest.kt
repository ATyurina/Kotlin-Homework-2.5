package ru.netology

import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun updateExisting() {
        val service = WallService

        service.add(Post(0, replyOwnerId = 0, replyPostId = 0, signerId = 0, postponedId = 0))
        service.add(Post(0, replyOwnerId = 0, replyPostId = 0, signerId = 0, postponedId = 0))
        service.add(Post(0, replyOwnerId = 0, replyPostId = 0, signerId = 0, postponedId = 0))

        val update = Post(5, createdBy = 8, text = "fooo", published = 3456789, replyOwnerId = 0, replyPostId = 0, signerId = 0, postponedId = 0)


        val result = service.update(update)


        assertTrue(result)
    }

    @Test
    fun updateNotExisting() {
        val service = WallService

        service.add(Post(0, replyOwnerId = 0, replyPostId = 0, signerId = 0, postponedId = 0))
        service.add(Post(0, replyOwnerId = 0, replyPostId = 0, signerId = 0, postponedId = 0))
        service.add(Post(0, replyOwnerId = 0, replyPostId = 0, signerId = 0, postponedId = 0))

        val update = Post(2, createdBy = 8, text = "fooo", published = 3456789, replyOwnerId = 0, replyPostId = 0, signerId = 0, postponedId = 0)


        val result = service.update(update)


        assertFalse(result)
    }

    @Test
    fun add() {
        val service = WallService

        val result = service.add(Post(0, replyOwnerId = 0, replyPostId = 0, signerId = 0, postponedId = 0))

        assertTrue(result.id != 0)
    }
}