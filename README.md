# Look-and-Say

## Goal
Given an `iteration-count` generate and output the `look-and-say` sequence.

The sequence starts with `1`. Subsequent numbers are derived by describing the previous number in terms of consecutive digits.

To generate an entry of the sequence, examine the previous entry.

Read off the digits of the previous entry, counting the number of digits in groups of the same digit.

In human terms this is like speaking out loud how often each digit appears consecutively.

**Keep in mind:** the output becomes very long very quickly.

### Input
`iterations` - a numeric value how often the process is repeated

### Output
The head of the generated sequence after iterating by the given input.

### Constraints
 * 0 <= `iterations` <= 28
 * **Start value** = 1

### Examples
* for input `0` iterations, output `1`, i.e. the starting value)
* for input `1` iterations, output `11`, i.e. reading the previous entry `1` as `one 1`
* for input `2` iterations, output `21`, i.e. reading the previous entry `11` as `two 1s`
* for input `3` iterations, output `1211`, i.e. reading the previous entry `21` as `one 2 one 1`
* for input `4` iterations, output `111221`, i.e. reading the previous entry `1211` as `one 1 one 2 two 1`