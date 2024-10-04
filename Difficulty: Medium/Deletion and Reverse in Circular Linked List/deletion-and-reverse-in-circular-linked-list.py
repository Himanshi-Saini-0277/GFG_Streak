#User function Template for python3
'''
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

'''
class Solution:
    def reverse(self, head):
        prv=head
        cur=head.next
        while 1:
            tmp=cur.next
            cur.next=prv
            prv=cur
            cur=tmp
            if prv==head:
                break
        return head.next

    def deleteNode(self, head, key):
        prv=head
        cur=prv.next
        while cur!=head:
            prv=cur
            cur=cur.next
        while 1:
            if cur.data==key:
                prv.next=cur.next
                if cur==head:
                    head=head.next
                del cur
                break
            prv=cur
            cur=cur.next
            if cur==head:
                break
        return head


#{ 
 # Driver Code Starts
class Node:

    def __init__(self, data):
        self.data = data
        self.next = None


def printList(head):
    if head is None:
        print("empty")
        return

    temp = head
    while True:
        print(temp.data, end=" ")
        temp = temp.next
        if temp == head:
            break
    print()


if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        arr = list(map(int, input().split()))
        key = int(input())

        head = Node(arr[0])
        tail = head
        for i in range(1, len(arr)):
            tail.next = Node(arr[i])
            tail = tail.next
        tail.next = head  # Make the list circular

        ob = Solution()
        head = ob.deleteNode(head, key)
        head = ob.reverse(head)
        printList(head)

# } Driver Code Ends