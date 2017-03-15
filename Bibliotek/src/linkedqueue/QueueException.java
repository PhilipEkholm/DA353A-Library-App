package linkedqueue;

/**
*	QueueException
*
*	An exception written for handling different runtime-exceptions
*	that can occur in Queue implementations.
*/

public class QueueException extends RuntimeException {
    public QueueException() {}
    public QueueException( String message ) {
        super( message );
    }
}
