# Explain your choice of using either synchronized methods or synchronized statements

I opted for the synchronized methods because it would ensure that the critical section was locked and that multiple threads couldn't access it at the same time.

If I were to user synchronization statements, I would have more control over what parts of the method are synchronized. This would allow me to improve the performance of the threads by only synchronizing the parts that are necessary.

---

# 2 Server Threads

### Running of 2 server threads with busy-wait

| Service         | Time Taken (ms) |
| --------------- | --------------- |
| Server thread 1 | 357             |
| Server thread 2 | 357             |

### Running of 2 server threads with semaphores

| Service         | Time Taken (ms) |
| --------------- | --------------- |
| Server thread 1 | 352             |
| Server thread 2 | 352             |

### Observation

Seems as though the execution times are very similar for the server threads.

---

# 3 Server Threads

### Running of 2 server threads with semaphores

| Service         | Time Taken (ms) |
| --------------- | --------------- |
| Server thread 1 | 352             |
| Server thread 2 | 352             |

### Running of 3 server threads with semaphores

| Service         | Time Taken (ms) |
| --------------- | --------------- |
| Server thread 1 | 255             |
| Server thread 2 | 255             |
| Server thread 3 | 255             |

### Observation

There was an execution time reduction of ~100ms for the run with 3 server threads.
