# Change the size of the network buffers from 10 to 20 and explain why (if any) there is a significant difference in the running times.

### Running time with buffer size of 10

| Service                      | Time Taken (ms) |
| ---------------------------- | --------------- |
| Client receiving application | 21              |
| Client sending application   | 20              |
| Server thread                | 31              |

### Running time with buffer size of 20

| Service                      | Time Taken (ms) |
| ---------------------------- | --------------- |
| Client receiving application | 16              |
| Client sending application   | 18              |
| Server thread                | 29              |

### Explanation

By looking at the data, it seems like having a larger buffer size reduced the time it took for the threads to finish executing. This wasn't a huge gain in time saved, but there was a change nonetheless.

These performance gains are likely caused by a reduction in the number of context switches needed to process all the data. Less thread switches were needing resulting in lower system overhead performance costs (syscalls).
