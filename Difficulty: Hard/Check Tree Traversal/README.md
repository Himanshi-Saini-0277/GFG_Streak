<h2><a href="https://www.geeksforgeeks.org/problems/check-tree-traversal--141628/1">Check Tree Traversal</a></h2><h3>Difficulty Level : Difficulty: Hard</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given Preorder, Inorder and Postorder traversals of some tree of size <strong>N</strong>. The task is to check if they are all of the same tree or not.</span></p>

<p><strong><span style="font-size:18px">Example 1:</span></strong></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
N = 5
preorder[] = {1, 2, 4, 5, 3}
inorder[] = {4, 2, 5, 1, 3}
postorder[] = {4, 5, 2, 3, 1}
<strong>Output:</strong> Yes
<strong>Explanation: </strong>
All of the above three traversals 
are of the same tree.
           1
         /   \
        2     3
      /   \
     4     5</span>
</pre>

<p><strong><span style="font-size:18px">Example 2:</span></strong></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
N = 5
preorder[] = {1, 5, 4, 2, 3}
inorder[] = {4, 2, 5, 1, 3}
postorder[] = {4, 1, 2, 3, 5}
<strong>Output:</strong> No
<strong>Explanation: </strong>The three traversals can 
not be of the same tree.</span></pre>

<p><br>
<span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything. Complete the function <strong>checktree() </strong>which takes the array&nbsp;<strong>preorder[ ]</strong>, <strong>inorder[ ]</strong>, <strong>postorder[ ]</strong> and&nbsp;integer <strong>N</strong> as input parameters and returns true if the three traversals are of the same tree or not.&nbsp;</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(N<sup>2</sup>)<br>
<strong>Expected Auxiliary Space:</strong> O(N)</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ N ≤ 10<sup>3</sup></span><br>
<span style="font-size:18px">Node values are unique.</span></p>
</div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Recursion</code>&nbsp;<code>Tree</code>&nbsp;<code>Data Structures</code>&nbsp;<code>Algorithms</code>&nbsp;