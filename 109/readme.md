                                         Recursion

- A good way to find the middle element: use a fast pointer and a slow pointer

  We have no index in this case, we can use this way to find the element without keep the 

  information about any node

- Error checking, when the node is null, we can't access its element

- Good way to split the linked list into left tree and right tree by setting the left tree's last node's next to null

- Convert it into an array first will faster the process of finding the middle element by 

  using the index
  
- Inorder is just quite suitable for sorted array, which runs fast and save space