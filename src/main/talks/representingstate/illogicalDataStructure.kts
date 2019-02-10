import java.net.URL

// allows for nonsensical values
data class MyDoorLock(val isOpen: Boolean, val isClosed: Boolean)

// things can change that shouldn't be able to change
// things can be missing that shouldn't be missing
// there can be less or more of something that is necessary
class IllogicalPerson(
    var heart: Heart?, var head: Head?,
    var arms: Set<Arm>, var legs: Set<Leg>
)

class Heart
class Head
class Arm
class Leg

class LogicalPerson(var heart: Heart, val head: Head, val arms: Pair<Arm?, Arm?>, val legs: Pair<Leg?, Leg?>)

// more realistic code...
//class ReviewPresenter {
//    private var _reviewModel: ReviewModel? = null
//    private var _isImagelessReview: Boolean = false
//
//    fun updateView(someView: View) {
//        _isImagelessReview = _reviewModel!!.getImageUrl() != null
//    }
//}

class ReviewPresenter(initialModel: ReviewModel) {
    private var reviewType: ReviewType = ReviewType.fromModel(initialModel)

    fun setModel(updatedModel: ReviewModel) {
        reviewType = ReviewType.fromModel(updatedModel)
    }
}

sealed class ReviewType {
    object Imageless : ReviewType()
    class HasImage(val imgUrl: URL) : ReviewType()

    companion object {
        fun fromModel(reviewModel: ReviewModel): ReviewType {
            val url = reviewModel.getImageUrl()

            return if (url != null) {
                HasImage(url)
            } else { Imageless }
        }
    }
}

class ReviewModel {
    fun getImageUrl(): URL? {
        return null
    }
}
