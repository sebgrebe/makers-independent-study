## Benchmark tests for different Java methods

Folder structure:
- myAlgorithms/src/Timing: Timing benchmark tests for the methods. Methods are wrapped in lambda functions so that they
  can be passed as arguments to time test.
- myAlgorithms/test/TimingTest: test for some of the methods


### Array methods
Testing four different Array methods:
* get last item
* reverse
* shuffle
* sort

I've compared these with my own methods for reverse, shuffle, and sort.

I wrote sort methods for the:
* Selection
* Insertion
* Quick
* Merge


All tests are done for different array sizes (range: 10 - 1000000).
Results can be found [here](https://docs.google.com/spreadsheets/d/1M00Ww9iaW-4b57Mz7hGL7ILT1yaOMRixbhGv9CjBdVY/edit#gid=1038009516)

### Hash methods

Comparing hash and array methods for the following tasks:
* Duplicate: Given a list of words, find all words that appear more than once.
* Most frequent words: Given a text, find which are the ten most common words.

[Results](https://docs.google.com/spreadsheets/d/1M00Ww9iaW-4b57Mz7hGL7ILT1yaOMRixbhGv9CjBdVY/edit#gid=772886254)
