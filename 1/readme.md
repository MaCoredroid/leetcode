1. Should think about whether duplicated numbers are allowed here
2. Consider whether it is a store once, being called many times, or store once, called once
3. Take advantage of hash map to lower the "looking up complexity"
4. Using brutal force to solve this problem, remember that each the second layer of loop can start from the element rather than the beginning.
5. In java, throw exception instead of return null value