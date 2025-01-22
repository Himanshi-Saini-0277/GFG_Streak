//{ Driver Code Starts
#include <iostream>
#include <sstream>
#include <string>
#include <vector>
using namespace std;

/* Linked list Node */
struct Node {
    int data;
    struct Node* next;

    Node(int x) {
        data = x;
        next = NULL;
    }
};

Node* buildList() {
    vector<int> arr;
    string input;
    getline(cin, input);
    stringstream ss(input);
    int number;
    while (ss >> number) {
        arr.push_back(number);
    }
    if (arr.empty()) {
        return NULL;
    }
    int val = arr[0];
    int size = arr.size();

    Node* head = new Node(val);
    Node* tail = head;

    for (int i = 1; i < size; i++) {
        val = arr[i];
        tail->next = new Node(val);
        tail = tail->next;
    }

    return head;
}

void printList(Node* n) {
    while (n) {
        cout << n->data << " ";
        n = n->next;
    }
    cout << endl;
}


// } Driver Code Ends
/* node for linked list:

struct Node {
    int data;
    struct Node* next;
    Node(int x) {
        data = x;
        next = NULL;
    }
};

*/

class Solution {
  public:
    Node* reverseList(Node* head) {
        Node* prev = nullptr;
        Node* current = head;
        while (current != nullptr) {
            Node* nextNode = current->next;
            current->next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    Node* addTwoLists(Node* num1, Node* num2) {
        num1 = reverseList(num1);
        num2 = reverseList(num2);

        Node* dummy = new Node(0);
        Node* current = dummy;
        int carry = 0;

        while (num1 != nullptr || num2 != nullptr || carry != 0) {
            int sum = carry;

            if (num1 != nullptr) {
                sum += num1->data;
                num1 = num1->next;
            }

            if (num2 != nullptr) {
                sum += num2->data;
                num2 = num2->next;
            }

            carry = sum / 10;
            current->next = new Node(sum % 10);
            current = current->next;
        }
        Node* result = reverseList(dummy->next);

        delete dummy;
        while (result != nullptr && result->data == 0 && result->next != nullptr) {
            Node* temp = result;
            result = result->next;
            delete temp;
        }

        return result;
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore(); // To ignore the newline character after the integer input

    while (t--) {
        Node* num1 = buildList();
        Node* num2 = buildList();
        Solution ob;
        Node* res = ob.addTwoLists(num1, num2);
        printList(res);
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends