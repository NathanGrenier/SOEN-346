# Change the size of the network buffers from 10 to 20 and explain why (if any) there is a significant difference in the running times.

### Running time with buffer size of 10

| Service                      | Time Taken (ms) |
| ---------------------------- | --------------- |
| Client receiving application | 19              |
| client sending application   | 18              |
| Server thread                | 31              |

### Running time with buffer size of 20

| Service                      | Time Taken (ms) |
| ---------------------------- | --------------- |
| Client receiving application | 16              |
| client sending application   | 18              |
| Server thread                | 29              |

### Explanation
