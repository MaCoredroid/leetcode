Use different value to define status. -1 means the node is out of coverage. 0 means the node is in coverage, but it can't provide coverage. 1 means that the node can provide coverage. 

Use DFS to find solution: if  one child node is out of coverage, the parent should provide coverage.