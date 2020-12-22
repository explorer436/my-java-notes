module Datastructures.Trees.PathsFromRootToAllLeaves (paths) where

import Data.Maybe (fromJust)

import Datastructures.Trees.MyBinaryTree (Tree (..), rootValue, leftAndRightTrees)

{- |
    (Medium)
    
    Good morning! Here's your coding interview problem for today.
    
    This problem was asked by Facebook.
    
    Given a binary tree, return all paths from the root to leaves.
    
    For example, given the tree:
    
       1
      / \
     2   3
        / \
       4   5
    
    Return [[1, 2], [1, 3, 4], [1, 3, 5]].
-}

paths EmptyTree = [[]]
paths tree@(Node a left right) = helper tree [[]]

helper tree@(Node a EmptyTree EmptyTree) [list] = [list ++ [a]]
helper tree@(Node a left EmptyTree) [list] = helper left [list ++ [a]]
helper tree@(Node a EmptyTree right) [list] = helper right [list ++ [a]]
helper tree@(Node a left right) [list] = helper left [list ++ [a]] ++ helper right [list ++ [a]]

test01 = paths EmptyTree
test02 = paths (Node 'a' EmptyTree EmptyTree)
test03 = paths (Node 'a' (Node 'b' EmptyTree EmptyTree) EmptyTree)
test04 = paths (Node 'a' EmptyTree (Node 'c' EmptyTree EmptyTree))
test05 = paths (Node 'a' (Node 'b' EmptyTree EmptyTree) (Node 'c' EmptyTree EmptyTree))