Phase 1
A Queue is appropriate for a message broker because it uses FIFO order, meaning the first message added is the first message processed. This keeps messages in the order they were received. A Stack would use LIFO order, so the newest message would be processed first. This could cause older messages to wait longer and would not be ideal for a message broker.

Phase 2
Adding failed messages back to the end of the queue makes the system fairer because successful messages can be processed while failed messages wait their turn. A failed message does not stay at the front and block every other message. It gets another chance after the other messages have been processed.
