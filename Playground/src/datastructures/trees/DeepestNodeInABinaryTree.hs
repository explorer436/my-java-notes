import MyBinaryTree (Tree (..))
import MyBinarySearchTreeTraversals_BreadthFirst_ListsByLevel (listsByEachLevel)

{- |
    Hi, here's your problem today. This problem was recently asked by Google:
    
    You are given the root of a binary tree. Return the deepest node (the furthest node from the root).
    
    Example:
    
        a
       / \
      b   c
     /
    d
    
    
    The deepest node in this tree is d at depth 3.
    
    Here's a starting point:
    
    class Node(object):
      def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
    
      def __repr__(self):
        # string representation
        return self.val
    
    
    def deepest(node):
      # Fill this in.
    
    root = Node('a')
    root.left = Node('b')
    root.left.left = Node('d')
    root.right = Node('c')
    
    print deepest(root)
    # (d, 3)
-}

{- |
    (Easy)

    Good morning! Here's your coding interview problem for today.

    This problem was asked by Google.

    Given the root of a binary tree, return a deepest node. For example, in the following tree, return d.

        a
    / \
    b   c
    /
    d
-}

deepestNodes tree = last (listsByEachLevel tree)

test01 = deepestNodes (Node 'a'
                            (Node 'b'
                                  (Node 'd' EmptyTree EmptyTree)
                                  EmptyTree
                            )
                            (Node 'c' EmptyTree EmptyTree)
                      ) -- "d"

test02 = deepestNodes (Node 1
                            (Node 4
                                  (Node 3 EmptyTree EmptyTree)
                                  (Node 2 EmptyTree EmptyTree))
                            (Node 5
                                  (Node 4 EmptyTree EmptyTree)
                                  (Node (-1) EmptyTree EmptyTree))) -- [3,2,4,-1]
