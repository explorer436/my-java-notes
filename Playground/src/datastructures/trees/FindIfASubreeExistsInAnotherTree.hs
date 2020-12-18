import MyBinaryTree

{- |

    FIND IF A SUBTREE EXISTS IN ANOTHER TREE:

    Hi, here's your problem today. This problem was recently asked by Apple:
    
    Given 2 binary trees t and s, find if s has an equal subtree in t, where the structure and the values are the same. Return True if it exists, otherwise return False.
    
    Here's some starter code and an example:
    
    class Node:
      def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right
    
      def __repr__(self):
        return f"(Value: {self.value} Left: {self.left} Right: {self.right})"
    
    def find_subtree(s, t):
      # Fill this in.
    
    t3 = Node(4, Node(3), Node(2))
    t2 = Node(5, Node(4), Node(-1))
    t = Node(1, t2, t3)
    
    s = Node(4, Node(3), Node(2))

    Tree t:
        1
       / \
      4   5 
     / \ / \
    3  2 4 -1
    
    Tree s:
      4 
     / \
    3  2 

    
    print(find_subtree(s, t))
    True

-}

doesSubtreeExistInParentTree :: Eq a => Tree a -> Tree a -> Bool
doesSubtreeExistInParentTree t1@(Node a EmptyTree EmptyTree) t2 = t1 == t2
doesSubtreeExistInParentTree t1@(Node a l r) t2 = if a == rootValue t2 then compareTrees t1 t2
                              else doesSubtreeExistInParentTree l t2 || doesSubtreeExistInParentTree r t2
-- tests
testDoesSubtreeExistInParentTree01 = doesSubtreeExistInParentTree 
            (Node 1 
               (Node 4 
                   (Node 3 EmptyTree EmptyTree) 
                   (Node 2 EmptyTree EmptyTree)) 
               (Node 5 
                   (Node 4 EmptyTree EmptyTree) 
                   (Node (-1) EmptyTree EmptyTree)))
            (Node 4 
               (Node 3 EmptyTree EmptyTree) 
               (Node 2 EmptyTree EmptyTree))
-- true

testDoesSubtreeExistInParentTree02 = doesSubtreeExistInParentTree 
            (Node 1 
               (Node 6 
                   (Node 3 EmptyTree EmptyTree) 
                   (Node 2 EmptyTree EmptyTree)) 
               (Node 5 
                   (Node 4 EmptyTree EmptyTree) 
                   (Node (-1) EmptyTree EmptyTree)))
            (Node 4 
               (Node 3 EmptyTree EmptyTree) 
               (Node 2 EmptyTree EmptyTree))
-- false

testDoesSubtreeExistInParentTree03 = doesSubtreeExistInParentTree 
            (Node 1 
               (Node 4 
                   (Node 3 EmptyTree EmptyTree) 
                   (Node 1 EmptyTree EmptyTree)) 
               (Node 5 
                   (Node 4 
                        (Node 3 EmptyTree EmptyTree)
                        (Node 2 EmptyTree EmptyTree))
                   (Node (-1) EmptyTree EmptyTree)))
            (Node 4 
               (Node 3 EmptyTree EmptyTree) 
               (Node 2 EmptyTree EmptyTree))
-- true