module Datastructures.Trees.MyBinarySearchTree_HeightSpec where

import Test.Hspec ( describe, it, shouldBe, Spec )
import Datastructures.Trees.MyBinaryTree (Tree (..), treeHeight)

spec :: Spec
spec = do
  describe "treeHeight" $ do

    it "returns 3 when the height of the input tree is 3" $
      treeHeight numbersTree `shouldBe` 3

    it "returns 4 when the height of the input tree is 4" $
      treeHeight lettersTree `shouldBe` 4

    it "returns -1 when the input is EmptyTree" $
      treeHeight EmptyTree `shouldBe` -1

    it "returns 0 when the input tree has only one node" $
      treeHeight (Node 3 EmptyTree EmptyTree) `shouldBe` 0

numbersTree = Node 1 
                  EmptyTree
                  (Node 2 
                        EmptyTree
                        (
                            Node 5
                                 (Node 7 EmptyTree EmptyTree)
                                 (Node 6 EmptyTree EmptyTree)
                        )
                  )
{- |
      1
       \
        2
         \
          5
         / \
        7   6
-}



lettersTree = Node 'F' 
                (Node 'B' 
                  (Node 'A' EmptyTree EmptyTree) 
                  (Node 'D' 
                    (Node 'C' EmptyTree EmptyTree) 
                    (Node 'E' EmptyTree EmptyTree)
                  )
                ) 
                (Node 'G' 
                  EmptyTree 
                  (Node 'I' 
                    (Node 'H' EmptyTree EmptyTree) 
                    (Node 'J' 
                      EmptyTree 
                      (Node 'K' EmptyTree EmptyTree)
                    )
                  )
                )
{- |
                          F
                        /  \ 
                       /    \
                      /      \
                     B         G 
                    / \        \
                   /   \        \
                  A     D        I
                       / \      / \ 
                     /    \    /   \ 
                    C      E  H     J
                                     \
                                      K
-}
