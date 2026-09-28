Phase 1
A Queue is appropriate for a message broker because it uses FIFO order, meaning the first message added is the first message processed. This keeps messages in the order they were received. A Stack would use LIFO order, so the newest message would be processed first. This could cause older messages to wait longer and would not be ideal for a message broker.
