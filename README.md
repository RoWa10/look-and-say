# Run-Length-Encoding

## Goal
Starting with a digit, count how often this digit occurs in succession.
Then repeat the same procedure for given number of `iterations`.
In human terms this is like speaking out loud how often each digit appears consecutively.

### Input
`iterations` - a numeric value how often the process is repeated

### Output
A numeric value representing a stream of occurrences and digits.

### Constraints
1 <= `iterations` <= 10  
**Start value** = 1

### Examples
Assuming the start value is `0` (**attention:** value differs from real start value for demostraton purposes) and `iteration` is 5:  
0\. iteration: `0` (reading: *one 1*)  
1\. iteration: `10` (reading: *two 1s*)  
2\. iteration: `1110` (reading: *one 2 and one 1*)  
3\. iteration: `3110` (reading: *one 1 and one two and two 1s*)  
4\. iteration: `132110` (reading: *three 1s and two 2s and one 1*)  
5\. iteration: `1113122110`  
