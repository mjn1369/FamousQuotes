package apps.mjn.domain.failure

sealed class Failure(override val message: String) : Throwable() {
    class NetworkConnectionError(message: String) : Failure(message)
    class ServerError(message: String) : Failure(message)
    class HttpError(message: String) : Failure(message)
    class NotFoundError(message: String) : Failure(message)

    /** * Extend this class for feature specific failures.*/
    abstract class FeatureFailure(message: String) : Failure(message)
}