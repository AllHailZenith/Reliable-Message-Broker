Phase 1
A Queue is appropriate for a message broker because it uses FIFO order, meaning the first message added is the first message processed. This keeps messages in the order they were received. A Stack would use LIFO order, so the newest message would be processed first. This could cause older messages to wait longer and would not be ideal for a message broker.

Phase 2
Adding failed messages back to the end of the queue makes the system fairer because successful messages can be processed while failed messages wait their turn. A failed message does not stay at the front and block every other message. It gets another chance after the other messages have been processed.

Phase 3
A poison message starts in the main queue like any other message. When processing fails, its retry count increases and it is placed back at the rear of the queue. This gives other messages a chance to be processed. If the message reaches the maximum retry limit, it is removed from the main queue and moved to the Dead-Letter Queue. The DLQ keeps the failed message from clogging the main processing queue while still preserving the message for later inspection.
