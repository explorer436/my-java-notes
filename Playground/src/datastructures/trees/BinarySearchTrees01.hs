module BinarySearchTrees01 where

{- |
    Why do we need Binary Search Trees in the first place?
    Because there is a need for data structures that allow both fast search and flexible updates - not just fast search or flexible updates.
    Unsorted double-linked lists support insertion and deletion in O(1) time but search takes linear time in worst case.
    Sorted arrays support binary search and logarithmic query times but at the cost of linear-time update.

    Binary search requires that we have fast access to two elements - the median elements above and below the given node.
    To combine these ideas, we need a "linked list" with two pointers per node.
    And this is the basic idea behind binary search trees.

    WE ARE GOING TO IMPLEMENT A BINARY SEARCH TREE. 

    A rooted binary tree is recursively defined as either being
    1. empty, or
    2. consisting of a node called the root, together with two rooted binary trees called the left and right subtrees, respectively.
    A binary search tree labels each node in a binary tree with a single key such that for any node labeled x, 
    all nodes in the left of the subtree of x have keys < x while 
    all nodes in the right subtree of x have keys > x.
    This search tree labeling scheme is very special.
    For any binary tree on n nodes, and any set of n keys, there is exactly one labeling that makes it a binary search tree.

    Each of the nodes can also point to two rooted binary trees called the left and right subtrees (or one, or none). 
    A cool thing about binary search trees is that we know that all the elements at the left sub-tree of, say, 5 are going to be smaller than 5. 
    Elements in its right sub-tree are going to be bigger. 
    So if we need to find if 8 is in our tree, we'd start at 5 and then because 8 is greater than 5, we'd go right. 
    We're now at 7 and because 8 is greater than 7, we go right again. 
    And we've found our element in three hops! 
    Now if this were a normal list (or a tree, but really unbalanced), it would take us seven hops instead of three to see if 8 is in there.
    
    Sets and maps from Data.Set and Data.Map are implemented using trees, 
    only instead of normal binary search trees, 
    they use balanced binary search trees, 
    which are always balanced. 
    But right now, we'll just be implementing normal binary search trees.
    
    Here's what we're going to say: 
    a tree is either an empty tree or it's an element that contains some value and two trees. 
    Sounds like a perfect fit for an algebraic data type!
-}

data Tree a = EmptyTree | Node a (Tree a) (Tree a) deriving (Show, Read, Eq) 

----------------------------------------------------------------------------------------------------

-- TODO
-- delete an element from a tree

{- |
   Finding the minimum and maximum elements in a tree:
   
   Implementing the find-minimum operation requires knowing where the minimum element is in the tree. By definition, the smallest key must reside in the left subtree of the root, since all keys in the left subtree have values less than that of the root. Therefore, the minimum element must be the leftmost descendent of the root. 
   Similarly, the maximum element must be the rightmost descendent of the root.
-}

----------------------------------------------------------------------------------------------------

{- |
    
    Next up, we're going to make a function that checks if some element is in the tree. 
    First, let's define the edge condition. 
    If we're looking for an element in an empty tree, then it's certainly not there. 
    Notice how this is the same as the edge condition when searching for elements in lists. 
    If we're looking for an element in an empty list, it's not there. 
    Anyway, if we're not looking for an element in an empty tree, then we check some things. 
    If the element in the root node is what we're looking for, great! 
    If it's not, what then? 
    Well, we can take advantage of knowing that all the left elements are smaller than the root node. 
    So if the element we're looking for is smaller than the root node, 
    check to see if it's in the left sub-tree. 
    If it's bigger, check to see if it's in the right sub-tree.
-}

treeElem :: (Ord a) => a -> Tree a -> Bool  
treeElem x EmptyTree = False  
treeElem x (Node a left right)  
    | x == a = True  
    | x < a  = treeElem x left  
    | x > a  = treeElem x right 

----------------------------------------------------------------------------------------------------
