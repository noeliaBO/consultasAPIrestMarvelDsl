package org.example

@kotlinx.serialization.Serializable
data class MarvelCharacterResponse(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val etag: String,
    val data: CharacterData
)

@kotlinx.serialization.Serializable
data class CharacterData(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<Character>
)

@kotlinx.serialization.Serializable
data class Character(
    val id: Int,
    val name: String,
    val description: String?,
    val modified: String,
    val thumbnail: Thumbnail,
    val resourceURI: String,
    val comics: ComicList,
    val series: SeriesList,
    val stories: StoryList,
    val events: EventList,
    val urls: List<Url>
)

@kotlinx.serialization.Serializable
data class Thumbnail(
    val path: String,
    val extension: String
)

@kotlinx.serialization.Serializable
data class ComicList(
    val available: Int,
    val collectionURI: String,
    val items: List<ComicSummary>,
    val returned: Int
)

@kotlinx.serialization.Serializable
data class ComicSummary(
    val resourceURI: String,
    val name: String
)

@kotlinx.serialization.Serializable
data class SeriesList(
    val available: Int,
    val collectionURI: String,
    val items: List<SeriesSummary>,
    val returned: Int
)

@kotlinx.serialization.Serializable
data class SeriesSummary(
    val resourceURI: String,
    val name: String
)

@kotlinx.serialization.Serializable
data class StoryList(
    val available: Int,
    val collectionURI: String,
    val items: List<StorySummary>,
    val returned: Int
)

@kotlinx.serialization.Serializable
data class StorySummary(
    val resourceURI: String,
    val name: String,
    val type: String
)

@kotlinx.serialization.Serializable
data class EventList(
    val available: Int,
    val collectionURI: String,
    val items: List<EventSummary>,
    val returned: Int
)

@kotlinx.serialization.Serializable
data class EventSummary(
    val resourceURI: String,
    val name: String
)

@kotlinx.serialization.Serializable
data class Url(
    val type: String,
    val url: String
)
