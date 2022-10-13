#O(n) string building
In most languages, strings are immutable. This means concatenating a single character to a string is an O(n) operation. If you have a string that is 1 million characters long, and you want to add one more character, all 1 million characters need to be copied over to another string.

Many problems will ask you to return a string, and usually, this string will be built during the algorithm. Simple concatenation will result in an O(n^2)O(n
2
) time complexity if you are using a language where strings are immutable.

There are better ways to build strings in O(n) time. This will vary between languages - here, we'll talk about Python and Java - if you're using another language, we recommend researching the best way to build strings in your language.


##Java

* Use the StringBuilder class.
* When building the string, add the characters to the list. This is O(1) per operation.
* Once finished, convert the list to a string using StringBuilder.toString(). This is O(n).
```
public string buildString(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
        sb.append(s.charAt(i));
    }
    return sb.toString();
}
```

#Subarrays/substrings, subsequences, and subsets

##Subarrays/substrings
> As a reminder, a subarray or substring is a contiguous section of an array or string.

If a problem has explicit constraints such as:
* Sum greater than or less than k
* Limits on what is contained, such as the maximum of k unique elements or no duplicates allowed

And/or asks for:
* Minimum or maximum length
* Number of subarrays/substrings
* Max or minimum sum

Think about a sliding window. Note that not all problems with these characteristics should be solved with a sliding window, and not all sliding window problems have these characteristics. These characteristics should only be used as a general guideline.

If a problem's input is an integer array and you find yourself needing to calculate multiple subarray sums, consider building a prefix sum.

The size of a subarray between i and j (inclusive) is j - i + 1. This is also the number of subarrays that end at j, starting from i or later.

##Subsequences

> A subsequence is a portion of an array/string that keeps the same order but doesn't need to be contiguous.

> For example, subsequences of [1, 2, 3, 4] include: [1, 3], [4], [], [2, 3], but not [3, 2], [5], [4, 1].

Typically, subsequence problems are more difficult. Because this is only the first chapter, it is difficult to talk about subsequence patterns now. Subsequences will come up a lot throughout the rest of this explore card - for example, dynamic programming is used to solve a lot of subsequence problems.

From the patterns we have learned so far, the most common one associated with subsequences is two pointers when two input arrays/strings are given. Because prefix sums and sliding windows represent subarrays/substrings, they are not applicable here.

##Subsets

> A subset is any group of elements from the original array or string. The order doesn't matter and neither do the elements being beside each other. For example, given [1, 2, 3, 4], all of these are subsets: [3, 2], [4, 1, 2], [1]. Note: subsets that contain the same elements are considered the same, so [1, 2, 4] is the same subset as [4, 1, 2].

You may be thinking, what is the difference between subsequences and subsets if subsets with the same elements are considered the same? In terms of algorithm problems, this generally means that we can sort the input at the start, which will open the door to methods like two-pointers, greedy algorithms, or even a creative sliding window.

Again, since we are only on the first chapter, it is hard to talk much about subsets. We will see subsets being used in the backtracking chapter.

One thing to note is that if a problem involves subsequences, but the order of the subsequence doesn't actually matter (let's say it wants the sum of subsequences), then you can treat it the same as a subset, and once again sorting is a powerful tool.